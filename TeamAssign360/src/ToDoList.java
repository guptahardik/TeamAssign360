

/**
 * The ToDoList class is the class where every list object is created using 
 * the details necessary and a list object is created.
 *
 */
public class ToDoList {

	// Parameters for a list item
	private int priority;
	private String date_start;
	private String date_end;
	private String description;
	private Status listStatus;
	
	// constructor for a new ToDoList object
	public ToDoList(int prio, String Date_start, String Date_end, 
			String Descrip, int Stat){
		priority = prio;
		date_start = Date_start;
		date_end = Date_end;
		description = Descrip;
		listStatus = new Status(Stat, Date_start, Date_end);
	}
	
	//DECLARING GETTER AND SETTER METHODS
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int prio) {
		this.priority = prio;
	}
	
	public String getStartDate() {
		return date_start;
	}
	
	public void setStartDate(String Date) {
		this.date_start = Date;
	}
	
	public String getEndDate() {
		return date_end;
	}
	
	public void setEndDate(String Date_end) {
		this.date_end = Date_end;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public Status getListStatus() {
		return listStatus;
	}
	
	public void setListStatus(int stat, String Date_start, String Date_end) {
		this.listStatus.setStatus(stat);
		this.listStatus.setDateStarted(Date_start);
		this.listStatus.setDateFinished(Date_end);
	}
	
	
}
