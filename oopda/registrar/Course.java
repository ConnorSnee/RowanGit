package registrar;


public class Course {
	
	private String courseNumber;
	private String title;
	private Department department;
	
	public Course(String courseNumber, String title, Department department) {
		this.courseNumber = courseNumber;
		this.title = title;
		this.department = department;
	}
	
	public Department getDepartment() {
		return department;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public String getTitle() {
		return title;
	}

}
