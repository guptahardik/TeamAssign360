package main;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.io.*; 
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
	
	public boolean checkInputs(String desc, String prio, String month, String day) 
	{
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
	public void updateExceptionHandler(String currentDescription, String desc, String prio, int stat, String month, String day) 
	{
		if(checkInputs(desc, prio, month, day)){
			int priority = Integer.parseInt(prio);
			int dayNum = Integer.parseInt(day);
			int monthNum = Integer.parseInt(month);
			if(priority >= possiblePriority) {
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
				if(stat < tempList.getListStatus().getStatus()) {
					JOptionPane.showMessageDialog(null, "Not a valid status change!");
				}
				else {
					currentHead = operations.updateList(currentHead, deletedHead, tempList, priority, dayNum, monthNum, desc, stat);
					if(stat == 2) {
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
		while(desc.equals(tempList.getDescription()) == false) {
			tempList = tempList.getNext();
		}
		currentHead = operations.deleteList(tempList, currentHead, deletedHead);
		deletedHead = tempList;
		possiblePriority--;
		return;
	}
	
	public boolean addTaskHandler(String desc, String prio, String month, String day) 
	{
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
	
    class Node 
    { 
        int data; 
        Node next; 
        Node(int d) {data = d; next = null; } 
    }
    public void swap(ToDoList Node1, ToDoList Node2) {
    	ToDoList temp = Node1;
    	Node1 = Node2;
    	Node2 = temp;
 
    }
    public ToDoList prioritySort(ToDoList list) {
    	while(list.getNext() == null) {
    		if(list.getPriority() > list.getNext().getPriority()) {
    			swap(list,list.getNext());
    		}
    		else {
    			break;
    		}
    		list = list.getNext();
    	}
    	
    	return list;
    }
    
}