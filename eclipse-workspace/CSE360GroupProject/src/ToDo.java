

public class ToDo {
	private String description;
	private int dueDate;
	private int priority;
	private Status status;
	private ToDo next;
	
	public ToDo(String taskDescription, int taskDueDate, int taskPriority) {
		description = taskDescription;
		dueDate = taskDueDate;
		priority = taskPriority;
		status = new Status();
		next = null;
	}
	
	public void add(ToDo head, String taskDescription, int taskDueDate, int taskPriority) {
		
	}
	
	public void delete(ToDo task) {
		
	}
	
	public void change(ToDo task, String taskDescription, int taskDueDate, int taskPriority, Status taskStatus) {
		
	}
	
	public void complete(ToDo task) {
		
	}
	
	
}
