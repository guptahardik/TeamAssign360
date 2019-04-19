// add the list object to the current and all file
// http://www.avajava.com/tutorials/lessons/how-do-i-write-an-object-to-a-file-and-read-it-back.html
// follow link to write object to file and retrieve it .

import java.time.LocalDate;

public class ToDoListOperations {

	// Create newListInstance and add it to the linked list
	//increase the priority by one of all tasks with priority greater than or equal to new tasks priority
	//***Must check for valid description and dates before this method is called***
	//***Must also add one more number to the possible priority numbers***
	public ToDoList addList(ToDoList head, int prio, int Date_day, int Date_month,
			String Descrip) {
		
		ToDoList newListInstance = new ToDoList(prio, Date_day, Date_month,Descrip);
		if(head == null) {
			head = newListInstance;
		}
		else {
			ToDoList tempList = head;
			while(tempList.getNext() != null) {
				if(tempList.getPriority() >= prio) {
					tempList.setPriority(prio + 1);
				}
				tempList = tempList.getNext();
			}
			if(tempList.getPriority() >= prio) {
				tempList.setPriority(prio + 1);
			}
			tempList.setNext(newListInstance);
		}
		return head;
	}
	
	//method to delete list Node
	//***Must delete one number from the possible priority numbers***
	public ToDoList deleteList(ToDoList task, ToDoList currentHead, ToDoList deletedHead) {
		if(currentHead.getDescription().equals(task.getDescription())) {
			currentHead = task.getNext();
		}
		else {
			while(task.getDescription().equals(currentHead.getNext().getDescription()) == false) {
				currentHead = currentHead.getNext();
			}
			currentHead.setNext(task.getNext());
		}
		//make deleted task the new head of the deleted linked list
		//***Must make sure to set head of the deleted linked list to the deleted task when this method is called***
		task.setNext(deletedHead);
		
		return currentHead;
	}
	
	//***Must check for valid description and dates before this is called***
	//*** also should probably check if status changing status to something less than it already is
	//i.e. changing from started to not started***
	//***If status changed to complete, must make sure to set head of the deleted linked list to the completed task when this method is called***
	//updates a given task in the list
	public ToDoList updateList(ToDoList head, ToDoList deletedHead, ToDoList listObj, int prio,
			int Date_day, int Date_month, String Descrip, int Stat) {
		
		//if changing the priority, shift the priority for the rest of the list
		ToDoList parseList = head;
		if(listObj.getPriority() > prio) {
			while(parseList != null) {
				if((parseList.getPriority() <= prio) && (parseList.getPriority() > listObj.getPriority())) {
					parseList.setPriority(parseList.getPriority() + 1);
				}
				parseList = parseList.getNext();
			}
		}
		else if(listObj.getPriority() < prio) {
			while(parseList != null) {
				if((parseList.getPriority() >= prio) && (parseList.getPriority() < listObj.getPriority())) {
					parseList.setPriority(parseList.getPriority() - 1);
				}
				parseList = parseList.getNext();
			}
		}
		
		listObj.setPriority(prio);
		listObj.setDueDay(Date_day);
		listObj.setDueMonth(Date_month);
		listObj.setDescription(Descrip);
		
		//if status changes to started, store date started
		//if status changes to finished, store date finished
		if(listObj.getListStatus().getStatus() != Stat) {
			LocalDate date = LocalDate.now();
			if(Stat == 1) {
				listObj.getListStatus().setDateStarted(date);
				listObj.getListStatus().setStatus(Stat);
			}
			else {
				listObj.getListStatus().setDateFinished(date);
				listObj.getListStatus().setStatus(Stat);
				head = deleteList(listObj, head, deletedHead);
			}
		}
		return head;
	}
	
	//not needed if completing task if status changed to finished
	//will implement if complete task is separate from status changing to finished
	//public ToDoList completeTask(ToDoList head, ToDoList task) {
		
	//}
	
	public void displayLists() {
		
	}

	public void saveList() {
		
	}
	
	public void restoreList() {
		
	}
}
