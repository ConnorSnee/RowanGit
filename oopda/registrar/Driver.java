package registrar;


import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Driver {
	
	private static Integer crn = 40001;
	
	public static void main(String[] args) {

		// Build the objects needed to represent the registration process
		Catalog catalog = new Catalog();
		Term term = new Term("Spring 2017");  // change to the current term
		Faculty faculty = new Faculty();
		Student student = createStudent();
		ArrayList<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
				
		// Populate these objects
		generateTimeSlots(timeSlots);
		createInstructors(faculty);  // Send the faculty object to method for instructor population
		createCourses(catalog);	     // Send the catalog object to method for course population
		createSections(term, catalog, faculty, timeSlots);
		
		BannerUI ui = new BannerUI(student, term);

	}

	private static void createInstructors(Faculty faculty) {
		faculty.addInstructor(new Instructor(101, "Johnson"));
		faculty.addInstructor(new Instructor(102, "Kay"));
		faculty.addInstructor(new Instructor(103, "Xu"));
		faculty.addInstructor(new Instructor(104, "Mulligan"));
		faculty.addInstructor(new Instructor(105, "Muldoon"));
		faculty.addInstructor(new Instructor(106, "Stanzione"));
		faculty.addInstructor(new Instructor(107, "Brady"));
		faculty.addInstructor(new Instructor(108, "Sawyer"));
		faculty.addInstructor(new Instructor(109, "Brown"));
		faculty.addInstructor(new Instructor(110, "Harrison"));
		faculty.addInstructor(new Instructor(111, "Ford"));
		faculty.addInstructor(new Instructor(112, "Danzinger"));
		faculty.addInstructor(new Instructor(113, "Clarke"));
		faculty.addInstructor(new Instructor(114, "Abraham"));
		faculty.addInstructor(new Instructor(115, "Perkowski"));
		faculty.addInstructor(new Instructor(116, "Brando"));
	}
	
	private static void createCourses(Catalog catalog) {
		catalog.addCourse(new Course("ART 01.101", "Art Appreciation", Department.Art));	
		catalog.addCourse(new Course("ART 01.201", "Painting with Oils", Department.Art));
		catalog.addCourse(new Course("ART 01.202", "Painting with Water Colors", Department.Art));
		catalog.addCourse(new Course("BIOL 01.110", "Genetics", Department.Biology));
		catalog.addCourse(new Course("BIOL 04.301", "Anatomy and Physiology", Department.Biology));		
		catalog.addCourse(new Course("CHEM 01.101", "Introduction to Chemistry", Department.Chemistry));
		catalog.addCourse(new Course("CHEM 01.201", "Organic Chemistry", Department.Chemistry));
		catalog.addCourse(new Course("CHEM 01.301", "Analytical Chemistry", Department.Chemistry));
		catalog.addCourse(new Course("CSC 04.114", "Object Oriented Programming", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 04.301", "Human Computer Interaction", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 07.211", "Artificial Intelligence", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 04.370", "Software Engineering", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 04.210", "Data Structures and Algorithms", Department.Computer_Science));
		catalog.addCourse(new Course("ECON 01.101", "Microeconomics", Department.Economics));
		catalog.addCourse(new Course("HIS 01.101", "Western Civilization", Department.History));
		catalog.addCourse(new Course("HIS 01.331", "Civil Wars", Department.History));
		catalog.addCourse(new Course("MUS 01.214", "The Genres of Rock Music", Department.Music));
		catalog.addCourse(new Course("PHIL 01.111", "Ethics", Department.Philosophy));
		catalog.addCourse(new Course("PHIL 01.221", "Existentialism", Department.Philosophy));
		catalog.addCourse(new Course("PHY 02.121", "Introduction to Mechanics", Department.Physics));
		catalog.addCourse(new Course("PSY 04.114", "Abnormal Psychology", Department.Psychology));		
	}
	
	public static void generateTimeSlots(ArrayList<TimeSlot> timeSlots) {
		for (int i = 0; i < 11; i++) {
			timeSlots.add(new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(i+8, 0), LocalTime.of(i+8, 50)));
		}
		for (int i = 0; i < 11; i++) {
			timeSlots.add(new TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(i+8, 0), LocalTime.of(i+8, 50)));
		}
		for (int i = 0; i < 11; i++) {
			timeSlots.add(new TimeSlot(DayOfWeek.WEDNESDAY, LocalTime.of(i+8, 0), LocalTime.of(i+8, 50)));
		}
		for (int i = 0; i < 11; i++) {
			timeSlots.add(new TimeSlot(DayOfWeek.THURSDAY, LocalTime.of(i+8, 0), LocalTime.of(i+8, 50)));
		}
		for (int i = 0; i < 11; i++) {
			timeSlots.add(new TimeSlot(DayOfWeek.FRIDAY, LocalTime.of(i+8, 0), LocalTime.of(i+8, 50)));
		}
	}
	
	private static void createSections(Term term, Catalog catalog, Faculty faculty, ArrayList<TimeSlot> timeSlots) {
		Random rand = new Random();
		int time1;
		int time2;
		for (Course course : catalog.getCatalog()) {
			time1 = rand.nextInt(timeSlots.size());
			time2 = rand.nextInt(timeSlots.size());
			if (time1 < time2) {
				term.addSection(new TraditionalSection(crn, course,
						faculty.getInstructorAt(rand.nextInt(faculty.getSize())), 
						timeSlots.get(time1),
						timeSlots.get(time2)));
			} else {
				term.addSection(new TraditionalSection(crn, course,
						faculty.getInstructorAt(rand.nextInt(faculty.getSize())), 
						timeSlots.get(time2),
						timeSlots.get(time1)));
			}
			crn++;
			term.addSection(new HybridSection(crn, course,
					faculty.getInstructorAt(rand.nextInt(faculty.getSize())),
					timeSlots.get(rand.nextInt(timeSlots.size()))));
			crn++;
			term.addSection(new OnlineSection(crn, course,
					faculty.getInstructorAt(rand.nextInt(faculty.getSize()))));
			crn++;
		}
	}
	
	private static Student createStudent() {
		String studentName = JOptionPane.showInputDialog("Enter your name: ");
		try {
			if (studentName.equals(null)) {
				System.exit(0);
			}
		} catch (NullPointerException e1) {
			System.exit(0);
		}
		return new Student(1, studentName);
	}
	

}
