
public class Status {

	private int status;
	private String dateStarted;
	private String dateFinished;
	
	public Status(int Stat, String Date_start, String Date_end) {
		status = Stat;
		dateStarted = Date_start;
		dateFinished = Date_end;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int stat) {
		this.status = stat;
	}
	
	public String getDateStarted() {
		return dateStarted;
	}
	
	public void setDateStarted(String Date_start) {
		this.dateStarted = Date_start;
	}
	
	public String getDateFinished() {
		return dateFinished;
	}
	
	public void setDateFinished(String Date_end) {
		this.dateFinished = Date_end;
	}
}
