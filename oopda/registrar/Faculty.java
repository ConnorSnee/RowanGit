package registrar;


import java.util.ArrayList;

public class Faculty {
	
	private ArrayList<Instructor> faculty;
	
	public Faculty() {
		faculty = new ArrayList<Instructor>();
	}
	
	public void addInstructor(Instructor toAdd) {
		faculty.add(toAdd);
	}
	
	public Instructor getInstructorAt(int index) {
		return faculty.get(index);
	}
	
	public int getSize() {
		return faculty.size();
	}

}
