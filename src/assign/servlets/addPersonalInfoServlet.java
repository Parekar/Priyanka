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

@WebServlet("/addPersonalInfoServlet")
public class addPersonalInfoServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String errors = "";
		PersonalInfoVOO personalInfoVO = new PersonalInfoVOO();
		
		personalInfoVO.setFirstName(request.getParameter("firstName"));
		personalInfoVO.setMiddleName(request.getParameter("middleName"));
		personalInfoVO.setLastName(request.getParameter("lastName"));
		personalInfoVO.setGender(request.getParameter("gender"));
		
		PersonalInfoBO personalInfoBO = new PersonalInfoBO();
		
		try
		{
		 	personalInfoBO.addPersonalInfo(personalInfoVO);
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
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/MyMVCProject/jsp/addPersonalInfo.jsp");
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException 
	{
		doGet(request, response);
	}

}
