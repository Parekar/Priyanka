package assign.dbaccess;

import java.util.ArrayList;

import assign.validation.FirstNameValidation;

public class PersonalInfoBO 
{
	public PersonalInfoBO() 
	{
		super();
	}
	
	public PersonalInfoVOO getPersonalInfo(String infirstName) throws FirstNameValidationException, Exception
	{

		PersonalInfoVOO personalInfo = null;
		StringBuffer allMessages = new StringBuffer();
		//validation
		FirstNameValidation fnValidation = new FirstNameValidation();
		allMessages.append(fnValidation.validateFirstName(infirstName));
		if (allMessages.length() == 0)
		{
			//database insert
			PersonalInfoDBAccess personalInfoDBAccess = new PersonalInfoDBAccess();
			personalInfo = personalInfoDBAccess.getPersonalInfo(infirstName);
		}
		else
		{
			  throw new FirstNameValidationException(allMessages.toString());
		}
		return personalInfo;
	}

	public void addPersonalInfo(PersonalInfoVOO inPersonalInfoVO) throws FirstNameValidationException, Exception
	{
		StringBuffer allMessages = new StringBuffer();
		//2a: validation
		FirstNameValidation fnValidation = new FirstNameValidation();
		String errorMsg = fnValidation.validateFirstName(inPersonalInfoVO.getFirstName());
		//emailaddress
		allMessages.append(errorMsg);
		//firstname
		//errorMsg = eMailValidation.validateFirstName(inEMailAddressVO.getfName());
		//allMessages.append(errorMsg);
		//lastname
		//remaining fields
		
		
		
		//2b: no error from validation, call db component
		if (allMessages.length() == 0)
		{
			PersonalInfoDBAccess personalInfoDBAccess = new PersonalInfoDBAccess();
			personalInfoDBAccess.addpersonalInfo(inPersonalInfoVO);
		}
		//if error return to controller
		else
		{
			 FirstNameValidationException fnValidationException = new FirstNameValidationException(allMessages.toString());
			 throw fnValidationException;
		}
		return;
	}
	
	public void deletePersonalInfo(String infirstName) throws FirstNameValidationException, Exception
	{
		StringBuffer allMessages = new StringBuffer();
		PersonalInfoVOO personalInfo = null;
		FirstNameValidation fnValidation = new FirstNameValidation();
		allMessages.append(fnValidation.validateFirstName(infirstName));
		if (allMessages.length() == 0){
			PersonalInfoDBAccess peronalInfoDBAccess = new PersonalInfoDBAccess();
			peronalInfoDBAccess.deletePersonalInfo(infirstName);
		}
		else
		{
			throw new FirstNameValidationException(allMessages.toString());
		}
		return;
	}
	
	public void updatePersonalInfo(PersonalInfoVOO inPersonalInfo) throws FirstNameValidationException, Exception
	{
		StringBuffer allMessages = new StringBuffer();
		PersonalInfoVOO personalInfo = null;
		FirstNameValidation eMailValidation = new FirstNameValidation();
		allMessages.append(eMailValidation.validateFirstName(inPersonalInfo.getFirstName()));
		if (allMessages.length() == 0)
		{
			PersonalInfoDBAccess personalInfoDBAccess = new PersonalInfoDBAccess();
			personalInfoDBAccess.updatePersonalInfo(inPersonalInfo);
		}
		else
		{
			throw new FirstNameValidationException(allMessages.toString());
		}
		return;
	}
	
	
	public ArrayList getAllPersonalInfoList() throws FirstNameValidationException, Exception{
		PersonalInfoDBAccess personalInfoDBAccess = new PersonalInfoDBAccess();
		ArrayList personalInfoList = personalInfoDBAccess.getAllPersonalInfoEntries();
		return personalInfoList;
	}

	
	public static void main(String[] arg)
	{
		PersonalInfoBO personalInfoBO = new PersonalInfoBO();
		try
		{
		    personalInfoBO.getPersonalInfo("");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
