package things;

import java.time.LocalDate;

public class Assigment{
	String title;
	LocalDate deadline;
	int maxPoints;

	public Assigment(String title, LocalDate deadline, int maxPoints){
		this.title = title;
		this.deadline = deadline;
		this.maxPoints = maxPoints;
	}
}