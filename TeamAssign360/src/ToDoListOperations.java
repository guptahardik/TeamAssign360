
public class ToDoListOperations {

	public void addList(int prio, String Date, String Descrip, String Stat) {
		
		ToDoList newListInstance = new ToDoList(prio, Date, Descrip, Stat);
		
		// Add the newListInstance to the linked list
		// add the list object to the current and all file
		// http://www.avajava.com/tutorials/lessons/how-do-i-write-an-object-to-a-file-and-read-it-back.html
		// follow link to write object to file and retrieve it .
	}
	
	//method to delete list Node
	//add the linked list node parameter as argument
	public void deleteList() {
		
	}
	
	public void updateList(ToDoList listObj, int prio, String Date,
			String Descrip, String Stat) {
		
		listObj.setPriority(prio);
		listObj.setDate(Date);
		listObj.setDescription(Descrip);
		listObj.setStatus(Stat);
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
