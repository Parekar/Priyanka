package assign.dbaccess;

public class FirstNameValidationException extends Exception
{
	private String errorMessage;
	
	public FirstNameValidationException(String inErrorMessage)
	{
		errorMessage = inErrorMessage;
	}
	public void setErrorMessage(String inErrorMessage)
	{
		errorMessage = inErrorMessage;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}
}
