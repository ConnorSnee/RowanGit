package registrar;


public abstract class Section implements Retrievable {
	
	private Integer crn;
	private Course course;
	private Instructor instructor;
	
	public Section(Integer crn, Course course, Instructor instructor) {
		this.crn = crn;
		this.course = course;
		this.instructor = instructor;
	}

	public Integer getCRN() {
		return crn;
	}
	
	public abstract String getSchedule();
	
	public abstract boolean validateChoice();
	
	public Course getCourse() {
		return course;
	}
	
	public Instructor getInstructor() {
		return instructor;
	}

}
