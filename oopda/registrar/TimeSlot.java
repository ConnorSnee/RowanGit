package registrar;


import java.time.*;

public class TimeSlot {
	
	private DayOfWeek weekday;
	private LocalTime startTime;
	private LocalTime endTime;
	
	public TimeSlot(DayOfWeek day, LocalTime start, LocalTime end) {
		weekday = day;
		startTime = start;
		endTime = end;
	}
	
	public DayOfWeek getWeekday() {
		return weekday;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	
	public LocalTime getEndTime() {
		return endTime;
	}

}
