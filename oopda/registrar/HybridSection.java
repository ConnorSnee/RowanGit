package registrar;


import java.util.ArrayList;

import javax.swing.JOptionPane;

public class HybridSection extends OnlineSection {
	
	private ArrayList<TimeSlot> timeSlot;
	
	public HybridSection(Integer crn, Course course, Instructor instructor, TimeSlot time) {
		super(crn, course, instructor);
		timeSlot = new ArrayList<TimeSlot>(1);
		timeSlot.add(time);
	}

	@Override
	public String getSchedule() {
		return timeSlot.get(0).getWeekday().toString() + ": " + timeSlot.get(0).getStartTime().toString() + "-" + timeSlot.get(0).getEndTime().toString();
	}
	
	@Override
	public boolean validateChoice() {
		if (JOptionPane.showConfirmDialog(null, "Hybrid classes require online connectivity. "
				+ "Are you sure you want to register for this class?",
				"Online Registration Verification", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<TimeSlot> getTimeSlot() {
		return timeSlot;
	}

}
