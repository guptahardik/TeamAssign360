

/**
 * The ToDoList class is the class where every list object is created using 
 * the details necessary and a list object is created.
 *
 */
public class ToDoList {

	// Parameters for a list item
	private int priority;
	private String date;
	private String description;
	private String status;
	
	// constructor for a new ToDoList object
	public ToDoList(int prio, String Date, String Descrip, String Stat){
		priority = prio;
		date = Date;
		description = Descrip;
		status = Stat;
	}
	
	//DECLARING GETTER AND SETTER METHODS
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int prio) {
		this.priority = prio;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String Date) {
		this.date = Date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String stat) {
		this.status = stat;
	}
	
	
}
