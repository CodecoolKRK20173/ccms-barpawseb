package things;

import java.time.LocalDate;

public class Assignment {
	String title;
	LocalDate deadline;
	int maxPoints;

	public Assignment(String title, LocalDate deadline, int maxPoints){
		this.title = title;
		this.deadline = deadline;
		this.maxPoints = maxPoints;
	}
}