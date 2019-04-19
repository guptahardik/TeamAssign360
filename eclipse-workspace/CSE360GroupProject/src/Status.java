
import java.time.LocalDate;

public class Status {

	private int status;
	private LocalDate dateStarted;
	private LocalDate dateFinished;
	
	public Status() {
		status = 0;
		dateStarted = null;
		dateFinished = null;
	}
	
	public Status(int Stat, LocalDate Date_start, LocalDate Date_end) {
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
	
	public LocalDate getDateStarted() {
		return dateStarted;
	}
	
	public void setDateStarted(LocalDate Date_start) {
		this.dateStarted = Date_start;
	}
	
	public LocalDate getDateFinished() {
		return dateFinished;
	}
	
	public void setDateFinished(LocalDate Date_end) {
		this.dateFinished = Date_end;
	}
}

