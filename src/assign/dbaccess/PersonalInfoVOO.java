package assign.dbaccess;

import java.io.*;

public class PersonalInfoVOO implements Serializable 
{
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	
	public PersonalInfoVOO() {
	}
	
	public PersonalInfoVOO(String infirstName, String inmiddleName, String inlastName, String ingender) {
		super();
		firstName = infirstName;
		middleName = inmiddleName;
		lastName = inlastName;
		gender = ingender;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}

