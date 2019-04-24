package main;

//add the list object to the current and all file
//http://www.avajava.com/tutorials/lessons/how-do-i-write-an-object-to-a-file-and-read-it-back.html
//follow link to write object to file and retrieve it .

import java.time.LocalDate;
import java.io.*;
//printf is used in print function

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
	
	public void displayLists(ToDoList Head) {
		ToDoList newTemp = Head;
		
		if(newTemp == null) {
			System.out.println("ListEmpty");
		}
		else {
			while(newTemp.getNext() != null) {
				
				System.out.printf("\nDescription: %s", newTemp.getDescription());
				
				System.out.printf("\nDue Date: %d/%d", newTemp.getDueMonth(), newTemp.getDueMonth());
				
				System.out.printf("\nPriority: %d", newTemp.getPriority());
				
				int status  = newTemp.getListStatus().getStatus();
				
				if(status == 0) {
					
					System.out.println("Status: Not Started");
					
				}else if(status == 1) {
					
					System.out.printf("\nStatus: Started on %t ", newTemp.getListStatus().getDateStarted());
					
				}else if(status == 2) {
					
					System.out.printf("\nStatus: Completed on %t ", newTemp.getListStatus().getDateFinished());
					
				}else {
					break;
				}
				newTemp = newTemp.getNext();
			}
		}
		
	}

	

	public void saveList(ToDoList currentList, ToDoList deletedList) throws IOException {
		 BufferedWriter writer = new BufferedWriter(new FileWriter("ToDoList.txt"));
		 int i = 1;
		 while(currentList.getNext() != null) {
			 writer.write(i+ ": Description: "+currentList.getDescription() + "\nDue Date: "+ currentList.getDueMonth() + "/"
					 +currentList.getDueMonth()+"\nPriority "+ currentList.getPriority()+ "\n");
			 
			 int status  = currentList.getListStatus().getStatus();
				
				if(status == 0) {
					
					writer.write("Status: Not Started\n");
					
				}else if(status == 1) {
					
					writer.write("Status: Started on "+  currentList.getListStatus().getDateStarted()+"\n");
					
				}else if(status == 2) {
					
					System.out.printf("\nStatus: Completed on "+ currentList.getListStatus().getDateFinished()+"\n");
					
				}else {
					break;
				}
				currentList = currentList.getNext();
				i++;
		 }
		 
		 while(deletedList.getNext() != null) {
			 
			 writer.write(i+ ": Description: "+deletedList.getDescription() + "\nDue Date: "+ deletedList.getDueMonth() + "/"
					 +deletedList.getDueMonth()+"\nPriority "+ deletedList.getPriority()+ "\n");
			 
			 int status  = deletedList.getListStatus().getStatus();
				
				if(status == 0) {
					
					writer.write("Status: Not Started\n");
					
				}else if(status == 1) {
					
					writer.write("Status: Started on "+  deletedList.getListStatus().getDateStarted()+"\n");
					
				}else if(status == 2) {
					
					System.out.printf("\nStatus: Completed on "+ deletedList.getListStatus().getDateFinished()+"\n");
					
				}else {
					break;
				}
				
				deletedList = deletedList.getNext();
				i++;
				
				}
		 writer.close();
		 
		
		 
	}
	
	public void restoreList() {
		
	}
}