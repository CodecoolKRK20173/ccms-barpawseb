package things;

import java.time.LocalDate;

public class Assignment {
	String title;
	double maxPoints;
	LocalDate deadline;

	public Assignment(String title, LocalDate deadline, int maxPoints){
		this.title = title;
		this.maxPoints = maxPoints;
		LocalDate today = LocalDate.now();
        this.deadline = today.plusDays(14);
	}
	
	public Assigment(String title, double maxPoints, String deadline){
		this.title = title;
		this.maxPoints = maxPoints;
		this.deadline = LocalDate.parse(deadline); //use formatter;
	}

}