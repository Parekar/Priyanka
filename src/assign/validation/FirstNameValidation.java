package assign.validation;

import assign.interfaces.ErrorMessageCodes;

public class FirstNameValidation 
{
	public FirstNameValidation() 
	{
		super();
	}
	
	public String validateFirstName(String firstName)
	{
		if (isFieldBlankOrNull(firstName))
		{
			return ErrorMessageCodes.FIRST_NAME_IS_BLANK;
		}	
		return "";
	}
	
	private boolean isFieldBlankOrNull(String field)
	{
		if (field == null || field.trim().equals(""))
		{
			return true;
		}
		return false;
	}
}
