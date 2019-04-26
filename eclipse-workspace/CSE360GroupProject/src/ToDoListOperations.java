// add the list object to the current and all file
// http://www.avajava.com/tutorials/lessons/how-do-i-write-an-object-to-a-file-and-read-it-back.html
// follow link to write object to file and retrieve it .
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;


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
		ToDoList tempList = currentHead;
		if(currentHead.getDescription().equals(task.getDescription())) {
			currentHead = task.getNext();
		}
		else {
			while(task.getDescription().equals(tempList.getNext().getDescription()) == false) {
				tempList = tempList.getNext();
			}
			tempList.setNext(task.getNext());
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
		//This will take the current linked list.
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

	public void saveList1(ToDoList currentList) throws IOException {
		if(currentList == null) {
		int z =1;
		}
		else {
			BufferedWriter writer = new BufferedWriter(new FileWriter("save1.txt"));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

			while(currentList != null) {
				writer.write(currentList.getDescription());
				writer.newLine();
				writer.write(currentList.getDueDay());
				writer.newLine();
				writer.write(currentList.getDueMonth());
				writer.newLine();
				writer.write(currentList.getPriority());
				writer.newLine();
				writer.write(currentList.getListStatus().getStatus());
				writer.newLine();
				if(currentList.getListStatus().getDateStarted() == null) {
					writer.write("");
					writer.newLine();
				}
				else {
					String dateS = currentList.getListStatus().getDateStarted().format(formatter);
					writer.write(dateS);
					writer.newLine();
				}
				if(currentList.getListStatus().getDateFinished() ==  null) {
					writer.write("");
					writer.newLine();
				}
				else {
					String dateE = currentList.getListStatus().getDateFinished().format(formatter);
					writer.write(dateE);
					writer.newLine();
				}
				currentList = currentList.getNext();
			}
			writer.close();
		}
	}

	public void saveList2( ToDoList deletedList) throws IOException {
		if(deletedList == null) {
			int c =1;
		}
		else {
			BufferedWriter writer2 = new BufferedWriter(new FileWriter("save2.txt"));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

			while(deletedList != null) {
				writer2.write(deletedList.getDescription());
				writer2.newLine();
				writer2.write(deletedList.getDueDay());
				writer2.newLine();
				writer2.write(deletedList.getDueMonth());
				writer2.newLine();
				writer2.write(deletedList.getPriority());
				writer2.newLine();
				writer2.write(deletedList.getListStatus().getStatus());
				writer2.newLine();
				if(deletedList.getListStatus().getDateStarted() == null) {
					writer2.write("");
					writer2.newLine();
				}
				else {
					String dateS = deletedList.getListStatus().getDateStarted().format(formatter);
					writer2.write(dateS);
					writer2.newLine();
				}
				if(deletedList.getListStatus().getDateFinished() ==  null) {
					writer2.write("");
					writer2.newLine();
				}
				else {
					String dateE = deletedList.getListStatus().getDateFinished().format(formatter);
					writer2.write(dateE);
					writer2.newLine();
				}
				
				deletedList = deletedList.getNext();
			}
			writer2.close();
		}
	}


	public void printList(ToDoList currentList, ToDoList deletedList) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("ToDoList.txt"));
		int i = 1;
		while(currentList != null) {
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

		if(deletedList == null) {
			int x =1;
		}else {
			writer.write("DELETED/COMPLETED");
			while(deletedList != null) {
				writer.write("\n"+ i+ ": Description: "+deletedList.getDescription() + "\nDue Date: "+ deletedList.getDueMonth() + "/"
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
		}
		writer.close();
	}

	// this returns the current  task in the form of a todolist type list
	public ToDoList restoreCurrentList() throws IOException {

		//ToDoList currentList = new ToDoList(0, 0, 0, null);
		ToDoList currentList = null;
		File file = new File("save1.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader input = new BufferedReader(fileReader);
		String  line = input.readLine();
		while(line !=   null) {
			String D = line;
			int d = Integer.parseInt(input.readLine());
			int m = Integer.parseInt(input.readLine());
			int p =Integer.parseInt(input.readLine());
			int status = Integer.parseInt(input.readLine());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			LocalDate DateS = LocalDate.parse(input.readLine(), formatter);
			LocalDate DateE = LocalDate.parse(input.readLine(), formatter);
			//addElement(currentList,D,d,m,p,status,DateS,DateE);
			currentList = addElement(currentList,D,d,m,p,status,DateS,DateE);
			line = input.readLine();
		}
		input.close();
		return currentList;
	}


	// this returns the deleted  task in the form of a todolist type list
	public ToDoList restoreDeletedList() throws IOException {
		//ToDoList deletedList = new ToDoList(0, 0, 0, null);
		ToDoList deletedList = null;
		File file = new File("save2.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader input = new BufferedReader(fileReader);
		String  line = input.readLine();
		while(line !=   null) {
			String D = line;
			int d = Integer.parseInt(input.readLine());
			int m = Integer.parseInt(input.readLine());
			int p =Integer.parseInt(input.readLine());
			int status = Integer.parseInt(input.readLine());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			LocalDate DateS = LocalDate.parse(input.readLine(), formatter);
			LocalDate DateE = LocalDate.parse(input.readLine(), formatter);
			//addElement(deletedList,D,d,m,p,status,DateS,DateE);
			deletedList = addElement(deletedList,D,d,m,p,status,DateS,DateE);
			line = input.readLine();
		}
		input.close();
		return deletedList;
	}
	//This is  for the restoring  function 
	public ToDoList addElement(ToDoList list, String Description,int day, int month, int p, int s, LocalDate DateS, LocalDate DateE) {

		if(list == null) {
			ToDoList newList = new ToDoList(p,day,month,Description);
			newList.setListStatus(s, DateS,DateE);
			list = newList;
		}
		else {
			ToDoList newList  = list;
			while(newList.getNext() != null) {
				newList = newList.getNext();
			}
			ToDoList secondList = new ToDoList(p,day,month,Description);
			secondList.setListStatus(s, DateS, DateE);
			newList.setNext(secondList);
		}
		return list;
	}
}
