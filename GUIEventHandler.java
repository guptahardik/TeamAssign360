package main;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.LinkedList;

public class GUIEventHandler{
	
	private ToDoListOperations operations;
	private int possiblePriority;
	private ToDoList currentHead;
	private ToDoList deletedHead;

	public GUIEventHandler() {
		operations = new ToDoListOperations();
		possiblePriority = 1;
		currentHead = null;
		deletedHead = null;
	}
	
	public int getSize() {
		return possiblePriority - 1;
	}
	
	public ToDoList getCurrentHead() {
		return currentHead;
	}
	
	public ToDoList getDeletedHead() {
		return deletedHead;
	}
	public String getDescriptionAt(int index) {
		ToDoList tempList = currentHead;
		for(int i = 0; i < index; i++) {
			tempList = tempList.getNext();
		}
		return tempList.getDescription();
	}
	public void setCurrentHead(ToDoList head) {
		currentHead = head;
	}
	
	public void setDeletedHead(ToDoList head) {
		deletedHead = head;
	}
	
	public void setPossiblePriority(int priority) {
		possiblePriority = priority;
	}
	public boolean checkInputs(String desc, String prio, String month, String day) {
		boolean valid = false;
		if(desc.equals("")) {
			JOptionPane.showMessageDialog(null, "Update Description in empty !");
		}
		else if(prio.equals("")) {
			JOptionPane.showMessageDialog(null, "Priority not chosen !");
		}
		else if (isNumber(prio) == false){ 
			JOptionPane.showMessageDialog(null, "Priority not a number!");
		}
		else if (isNumber(month) == false){ 
			JOptionPane.showMessageDialog(null, "Month not a number!");
		}
		else if (isNumber(day) == false){ 
			JOptionPane.showMessageDialog(null, "Day not a number!");
		}
		else {
			valid = true;
		}
		return valid;
	}
	
	public boolean checkDate(int day, int month) {
		boolean valid = false;
		if (month < 0 || month > 12) {
			JOptionPane.showMessageDialog(null, "Not a valid month!");
		}
		else if (day < 0 || day > 31) {
			JOptionPane.showMessageDialog(null, "Not a valid date!");
		}
		else {
			valid = true;
		}
		return valid;
	}
	
	public boolean checkDescription(String description) {
		ToDoList tempList = currentHead;
		boolean valid = true;
		while(tempList != null) {
			if(description.equals(tempList.getDescription())){
				valid = false;
			}
			tempList = tempList.getNext();
		}
		return valid;
	}
	
	public boolean isNumber(String num) {
		boolean isNum = false;
		try { 
	        Integer.parseInt(num); 
	        isNum = true;
	    } 
		catch(NumberFormatException e) { 
	    	isNum = false;
	    } 
		return isNum;
	}
	
	//currentDescription is the description from Jlist (not new description in the textbox)
	public void updateExceptionHandler(String currentDescription, String desc, String prio, String stat, String month, String day) {
		if(checkInputs(desc, prio, month, day)){
			int priority = Integer.parseInt(prio);
			int dayNum = Integer.parseInt(day);
			int monthNum = Integer.parseInt(month);
			int statNum = 2;
			if(stat.equals("Not Started")) {
				statNum = 0;
			}
			else if(stat.contentEquals("In Progress")) {
				statNum = 1;
			}
			if(stat.contentEquals("SELECT STATUS")) {
				JOptionPane.showMessageDialog(null, "Please select a valid status!");
			}
			else if(priority >= possiblePriority) {
				JOptionPane.showMessageDialog(null, "Not a valid priority!");
			}
			else if(currentDescription.equals(desc) == false && checkDescription(desc) == false){
				JOptionPane.showMessageDialog(null, "Not a unique Description!");
			}
			else if(checkDate(dayNum, monthNum)) {
				ToDoList tempList = currentHead;
				while(currentDescription.equals(tempList.getDescription()) == false) {
					tempList = tempList.getNext();
				}
				if(statNum < tempList.getListStatus().getStatus()) {
					JOptionPane.showMessageDialog(null, "Not a valid status change!");
				}
				else {
					currentHead = operations.updateList(currentHead, deletedHead, tempList, priority, dayNum, monthNum, desc, statNum);
					if(statNum == 2) {
						deletedHead = tempList;
						possiblePriority--;
					}
				}
			}
		}
		return;
	}
		
	
	public void deleteTaskHandler(String desc) {
		ToDoList tempList = currentHead;
		JOptionPane.showMessageDialog(null, tempList.getDescription());
		while(desc.equals(tempList.getDescription()) == false) {
			tempList = tempList.getNext();
		}
		currentHead = operations.deleteList(tempList, currentHead, deletedHead);
		deletedHead = tempList;
		possiblePriority--;
		return;
	}
	
	public boolean addTaskHandler(String desc, String prio, String month, String day) {
		boolean added = false;
		if(checkInputs(desc, prio, month, day)){
			int priority = Integer.parseInt(prio);
			int dayNum = Integer.parseInt(day);
			int monthNum = Integer.parseInt(month);
			if(priority > possiblePriority || priority < 1) {
				JOptionPane.showMessageDialog(null, "Not a valid priority!");
			}
			else if(checkDescription(desc) == false) {
				JOptionPane.showMessageDialog(null, "Not a unique description!");
			}
			else if(checkDate(dayNum, monthNum)) {
				currentHead = operations.addList(currentHead, priority, dayNum, monthNum, desc);
				possiblePriority++;
				added = true;
			}
		}
		return added;
	}
	
	public void saveTaskHandler() throws IOException {
		operations.saveList1(currentHead);
		operations.saveList2(deletedHead);
		return;
	}
	
	public void printToFileTaskHandler() throws IOException {
		operations.printList(currentHead, deletedHead);
		return;
	}
	
	// add function for the radio button sorting
	//This is  for sorting the list
	
	public void sortPriority() {
		
		 
		ToDoList tempList = currentHead;
		ToDoList sortedHead = null, temp = null;
		for(int priority = 1; priority <= possiblePriority - 1; priority++) {
			while(tempList.getPriority() != priority) {
				tempList = tempList.getNext();
			}
			if(sortedHead==null) {
			sortedHead = tempList;
			currentHead = sortedHead;
			
			}
			else {
				//temp = tempList;
				//tempList = tempList.getNext();
				sortedHead.setNext(temp);
				sortedHead = sortedHead.getNext();
			}
			//tempList = operations.deleteList(tempList, currentHead, sortedHead);
		}
		
	}
	public void sortStatus() {
		if(currentHead == null) {
			int y = 1;
		}
		ToDoList temp = currentHead;
		 
			while(temp.getNext()!= null) {
				if(temp.getListStatus().getStatus() > temp.getNext().getListStatus().getStatus()) {
					swap(temp,temp.getNext());
				}
		temp = temp.getNext();	
			
		}
			currentHead = temp;
	}
	
	public void swap(ToDoList n1, ToDoList n2) {
		ToDoList temp = n1;
	    n1 = n2;
	    n2 = temp;
	}
	
	public String[] getSelectedTask(Object selected) {
    	String[] details = new String[5];
    	ToDoList selectedTask = null, head = currentHead;
    	while(head != null) {
    		if(head.getDescription() == selected.toString()) {
    			selectedTask = head;
    			break;
    		}
    		head = head.getNext();
    	}
    	details[0] = selectedTask.getDescription();
    	details[1] = Integer.toString(selectedTask.getDueDay());
    	details[2] = Integer.toString(selectedTask.getDueMonth());
    	details[3] = Integer.toString(selectedTask.getPriority());
    	details[4] = Integer.toString(selectedTask.getListStatus().getStatus());
    	return details;
    }
}
