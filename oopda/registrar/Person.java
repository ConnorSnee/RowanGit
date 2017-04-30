package registrar;


import java.util.HashMap;

/**
 * This class represents an Person class
 * The Person class contains specific info such as the name, email, ssn, and age of the Person
 * The Person class also validates that the input is valid against certain preset values
 * 
 * Instructor is a subclass of the Person class
 * 
 * @author Connor Snee
 * @author Kevin Trinh
 */
public class Person {
	/**
	 * Declaration of the fields used in this class
	 */
	protected Integer id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String ssn;
	private Integer age;
	private static Integer highestAge = 0;
	
	/**
	 * Constructor for the person class that takes in multiple parameters and sets them equal to this class' fields
	 * @param idIn person ID input
	 * @param first First name of person
	 * @param middle Middle name of person
	 * @param last Last name of person
	 * @param emailIn person's email
	 * @param ssnIn person's SSN
	 * @param ageIn person's age
	 */
	public Person(int idIn, String first, String middle, String last, String emailIn, String ssnIn, int ageIn) {
		id = idIn;
		firstName = first;
		middleName = middle;
		lastName = last;
		email = emailIn;
		ssn = ssnIn;
		age = ageIn;
		if (age > highestAge) {
			highestAge = age;
		}
	}
	
	public Person(int idIn, String lastName) {
		id = idIn;
		this.lastName = lastName;
	}
	
	/**
	 * getter for Integer ID
	 * @return Student ID of person
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * getter for firstName String
	 * @return person's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * setter for firstName String, sets firstName of class to parameter passed
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * getter for middleName String
	 * @return person's middle name	
	 */
	public String getMiddleName() {
		return middleName;
	}
	
	/**
	 * setter for middleName String, sets middleName of class to parameter passed
	 * @param middleName returns the middle name of person
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	/**
	 * getter for lastName String
	 * @return returns the last name of person
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * setter for lastName STring, sets lastName of class to parameter passed
	 * @param lastName sets lastName to parameter passed
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * getter for email String
	 * @return returns email that user inputs
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * getter for ssn String
	 * @return returns this class' ssn string
	 */
	public String getSsn() {
		return ssn;
	}
	
	/**
	 * getter for age
	 * @return returns age integer
	 */
	public Integer getAge() {
		return age;
	}
	
	/**
	 * setter for age, sets this class' age Integer to the parameter passed
	 * @param age age is set to new age parameter
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	
	/**
	 * method that is used to create the full name of the person
	 * This is done by adding the firstName, middleName, and lastName Strings and spaces appropriately to print the name
	 */
	public String toString() {
		return firstName + " " + middleName + " " + lastName;
	}
	
	/**
	 * This method checks the email's domain
	 * this is done by looking for the @ symbol and printing the rest of the string after it
	 * @return this returns the emails domain starting from @ to the rest of the string
	 */
	public String getEmailDomain() {
		int i = email.indexOf('@');
		return email.substring(i + 1);
	}
	
	/**
	 * This method checks the last 4 digits of the SSN
	 * This is done by printing the rest of the string starting from the 7th spot
	 * Using .substring()
	 * @return
	 */
	public String getLast4SSN() {
		return ssn.substring(7);
	}
	
	/**
	 * Validation method to make sure the input age is old enough
	 * as long as the age is older than 16 then the method will return true
	 * @param age age parameter input by user
	 * @return returns boolean that is checked to stop or keep program going
	 */
	public static boolean validateAge(Integer age) {
		boolean valid = true;
		if (age < 16) {
			valid = false;
		}
		return valid;
	}
	
	/**
	 * Validation method to make sure the email contains a proper domain
	 * checks that there is a @___.___ 
	 * @param email String input by user that contains person's email
	 * @return  boolean that is checked to stop or keep program going
	 */
	public static boolean validateEmail(String email) {
		boolean valid = false;
		if (email.contains("@") && email.substring(email.indexOf('@')).contains(".") &&
				email.indexOf('@') == email.lastIndexOf('@')) {
			
			valid = true;
		}
		return valid;
	}
	
	/**
	 * Validation method to make sure the SSN is proper format
	 * checks to make sure that the '-' are in the correct location
	 * @param ssn the parameter passed is the ssn user is passing 
	 * @return returns boolean that is checked to stop or keep program going
	 */
	public static boolean validateSSN(String ssn) {
		boolean valid = false;
		if (ssn.length() == 11 && ssn.charAt(3) == '-' && ssn.charAt(6) == '-' && ssn.matches("[0-9-]+")) {
			valid = true;
		}
		return valid;
	}
	
	/**
	 * polymorphic dispatch methods so that subclasses can call method
	 * @return returns highestAge Variable which si defined in other classes
	 */
	public static Integer getHighestAge() {
		return highestAge;
	}
	
	/**
	 *  polymorphic dispatch methods so that subclasses can call method
	 */
	public void displayAffiliation() {
	}

}

