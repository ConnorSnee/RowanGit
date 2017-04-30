package registrar;


import java.util.ArrayList;

import javax.swing.JOptionPane;

public class OnlineSection extends Section {
	
	public OnlineSection(Integer crn, Course course, Instructor instructor) {
		super(crn, course, instructor);
	}

	@Override
	public String getSchedule() {
		return "Online";
	}
	
	public boolean validateChoice() {
		if (JOptionPane.showConfirmDialog(null, "Remote classes require online connectivity and good time"
				+ "management skills. Are you sure you want to register for this class?",
				"Online Registration Verification", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<TimeSlot> getTimeSlot() throws NoTimeSlotFoundException {
		throw new NoTimeSlotFoundException();
	}

}
