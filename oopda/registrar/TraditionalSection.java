package registrar;


import java.util.ArrayList;

public class TraditionalSection extends Section implements Retrievable {
	
	private ArrayList<TimeSlot> timeSlot;
	
	public TraditionalSection(Integer crn, Course course, Instructor instructor, TimeSlot time1, TimeSlot time2) {
		super(crn, course, instructor);
		timeSlot = new ArrayList<TimeSlot>(2);
		timeSlot.add(time1);
		timeSlot.add(time2);
	}
	
	public boolean validateChoice() {
		return true;
	}

	@Override
	public String getSchedule() {
		
		String timeDisplay = "";
		
		timeDisplay += timeSlot.get(0).getWeekday().toString() + ": " + timeSlot.get(0).getStartTime().toString() + "-" + timeSlot.get(0).getEndTime().toString() + ", ";
		timeDisplay += timeSlot.get(1).getWeekday().toString() + ": " + timeSlot.get(1).getStartTime().toString() + "-" + timeSlot.get(1).getEndTime().toString();
		
		return timeDisplay;
	}

	@Override
	public ArrayList<TimeSlot> getTimeSlot() {
		return timeSlot;
	}

}
