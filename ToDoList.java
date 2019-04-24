package main;

import java.time.LocalDate;

/**
 * The ToDoList class is the class where every list object is created using 
 * the details necessary and a list object is created.
 *
 */
public class ToDoList {

	// Parameters for a list item
	private int priority;
	private int dueDay;
	private int dueMonth;
	private String description;
	private Status listStatus;
	private ToDoList next;
	
	// constructor for a new ToDoList object
	public ToDoList(int prio, int Date_day, int Date_month, 
			String Descrip){
		priority = prio;
		dueDay = Date_day;
		dueMonth = Date_month;
		description = Descrip;
		listStatus = new Status();
		next = null;
	}
	
	//DECLARING GETTER AND SETTER METHODS
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int prio) {
		this.priority = prio;
	}
	
	public int getDueDay() {
		return dueDay;
	}
	
	public void setDueDay(int Date) {
		this.dueDay = Date;
	}
	
	public int getDueMonth() {
		return dueMonth;
	}
	
	public void setDueMonth(int Date) {
		this.dueMonth = Date;
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
	public void setListStatus(int status, LocalDate start, LocalDate end) {
		this.listStatus.setStatus(status);;
		this.listStatus.setDateStarted(start);
		this.listStatus.setDateFinished(end);
		//made by Hardik. Please edit if it is wrong. 
	}
	
	public ToDoList getNext() {
		return next;
	}
	
	public void setNext(ToDoList task) {
		this.next = task;
	}
	
	
}