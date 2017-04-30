package registrar;


import java.util.ArrayList;

public class Catalog {
	
	private ArrayList<Course> catalog;
	
	public Catalog() {
		catalog = new ArrayList<Course>();
	}
	
	public Catalog(ArrayList<Course> courses) {
		catalog = courses;
	}
	
	public void addCourse(Course newCourse) {
		catalog.add(newCourse);
	}
	
	public ArrayList<Course> getCatalog() {
		return catalog;
	}

}
