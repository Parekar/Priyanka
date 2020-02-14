package assign.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import assign.dbaccess.FirstNameValidationException;
import assign.dbaccess.PersonalInfoBO;
import assign.dbaccess.PersonalInfoVOO;

@WebServlet("/DeletePersonalInfoServlet")
public class DeletePersonalInfoServlet extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String errors = "";
		String inFirstName = request.getParameter("firstName");
		response.setContentType("text/html");
		
		PersonalInfoBO personalInfoBO = new PersonalInfoBO();
		PersonalInfoVOO personalInfo = null;
		try
		{
		    personalInfoBO.deletePersonalInfo(inFirstName);
		}
		catch (FirstNameValidationException emve)
		{
			errors = emve.getErrorMessage();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (errors.equals(""))
		{
			response.sendRedirect("/MyMVCProject/jsp/home.jsp");	
		}
		else 
		{
			System.out.println(request.getRequestURI());
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/MyMVCProject/jsp/deletePersonalInfo.jsp");
		}
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
