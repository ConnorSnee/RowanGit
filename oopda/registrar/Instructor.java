package registrar;


import java.util.HashMap;

/**
 * This class represents an Instructor class
 * The Instructor class contains specific info such as the Department of the instructor
 * Instructor is a subclass of the Person class
 * 
 * @author Connor Snee
 * @author Kevin Trinh
 */
public class Instructor extends Person {

	/**
	 * Declares String department
	 */
	private String department;
	
	/**
	 * Declares instructor constructor that calls parameters from super class Person
	 * @param idIn instructor ID input
	 * @param first First name of instructor
	 * @param middle Middle name of instructor
	 * @param last Last name of instructor
	 * @param emailIn instructor's email
	 * @param ssnIn instructor's SSN
	 * @param ageIn instructor's age
	 * @param departmentIn instructor's department
	 */
	public Instructor(int idIn, String first, String middle, String last,
			String emailIn, String ssnIn, int ageIn, String departmentIn) {
		super(idIn, first, middle, last, emailIn, ssnIn, ageIn);
		department = departmentIn;
	}
	
	public Instructor(int idIn, String lastName) {
		super(idIn, lastName);
	}

	/**
	 * Getter for department String
	 * @return returns department of instructor class
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * setter for department String
	 * @param newdepartment sets this class' department String as the new department passed in
	 */
	public void setDepartment(String newDepartment) {
		department = newDepartment;
	}
	
	/**
	 * prints our department String 
	 * displays department
	 */
	public void displayAffiliation() {
		System.out.println(department);
	}

}
