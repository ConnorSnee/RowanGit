package registrar;


import java.util.ArrayList;

public interface Retrievable {
	
	public ArrayList<TimeSlot> getTimeSlot() throws NoTimeSlotFoundException;

}
