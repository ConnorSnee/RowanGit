package registrar;


import java.util.HashMap;

/**
 * This class represents a student class
 * The student class contains specific info such as the major
 * Student is a subclass of the Person class
 * 
 * @author Connor Snee
 * @author Kevin Trinh
 */
public class Student extends Person {
	
	/**
	 * Declares String major
	 */
	private String major; 
	private HashMap<Integer, Section> currentSections;
	
	/**
	 * Declares student constructor that calls parameters from super class Person
	 * @param idIn Student ID input
	 * @param first First name of student
	 * @param middle Middle name of student
	 * @param last Last name of Student
	 * @param emailIn Student's email
	 * @param ssnIn Student's SSN
	 * @param ageIn Student's age
	 * @param majorIn Student's major
	 */
	public Student(int idIn, String first, String middle, String last,
			String emailIn, String ssnIn, int ageIn, String majorIn) {
		super(idIn, first, middle, last, emailIn, ssnIn, ageIn);
		major = majorIn;
	}
	
	public Student(int idIn, String lastName) {
		super(idIn, lastName);
		currentSections = new HashMap<Integer, Section>();
	}
	
	/**
	 * Getter for major String
	 * @return returns major of student class
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * setter for major String
	 * @param newMajor sets this class' major String as the new major passed in
	 */
	public void setMajor(String newMajor) {
		major = newMajor;
	}
	
	/**
	 * prints our major String 
	 * displays major
	 */
	public void displayAffiliation() {
		System.out.println(major);
	}
	
	public void add(Section sec) {
		currentSections.put(sec.getCRN(), sec);
	}
	
	public void drop(Section sec) {
		currentSections.remove(sec.getCRN(), sec);
	}
	
	public HashMap<Integer, Section> getSections() {
		return currentSections;
	}

}
