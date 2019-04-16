
public class ToDoListOperations {

	public void addList(int prio, String Date_start, String Date_end,
			String Descrip, int Stat) {
		
		ToDoList newListInstance = new ToDoList(prio, Date_start, Date_end,
				Descrip, Stat);
		
		// Add the newListInstance to the linked list
		// add the list object to the current and all file
		// http://www.avajava.com/tutorials/lessons/how-do-i-write-an-object-to-a-file-and-read-it-back.html
		// follow link to write object to file and retrieve it .
	}
	
	//method to delete list Node
	//add the linked list node parameter as argument
	public void deleteList() {
		
	}
	
	public void updateList(ToDoList listObj, int prio, String Date_start,
			String Date_end, String Descrip, int Stat) {
		
		listObj.setPriority(prio);
		listObj.setStartDate(Date_start);
		listObj.setEndDate(Date_end);
		listObj.setDescription(Descrip);
		listObj.setListStatus(Stat, Date_start, Date_end);
	}
	
	// IDK exactly to do here for now
	public void completeList() {
		
	}
	
	public void displayLists() {
		
	}

	public void saveLists() {
		
	}
	
	public void restoreLists() {
		
	}
}
