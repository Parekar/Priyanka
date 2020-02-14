package assign.dbaccess;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class PersonalInfoDBAccess 
{
	
	public PersonalInfoDBAccess() 
	{
		super();
	}
	
	public static Connection getConnection() throws Exception
	{
		Connection dbConn = null;
	    try
	    {
			String url = "jdbc:mysql://localhost:3306/test";
			Class.forName("com.mysql.jdbc.Driver");
			String ssl = "?useSSL=false";
			dbConn = DriverManager.getConnection(url+ssl, "root", "priy");
		}
	     catch (SQLException sqle) 
	    {
		   sqle.printStackTrace();
		   throw sqle;
		}
	       catch(Exception e) 
	    {
		   e.printStackTrace();
		   throw e;
		}
	    return dbConn;
	}
	
	public static PersonalInfoVOO getPersonalInfo(String infirstName) throws Exception
	{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
        ResultSet rs = null;
	    PersonalInfoVOO personalInfo = null;

	    try
	    {
			dbConn = getConnection();
			pStmt = dbConn.prepareStatement("SELECT * FROM personalInfo WHERE firstName = ?");
			pStmt.setString(1, infirstName);
	   		rs = pStmt.executeQuery();
	
			if (rs.next()) 
			{
				personalInfo = new PersonalInfoVOO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		
				System.out.println(personalInfo.getFirstName());
		        System.out.println(personalInfo.getMiddleName());
		        System.out.println(personalInfo.getLastName());
		        System.out.println(personalInfo.getGender());
				
	   		}
		}
	    catch (SQLException sqle) 
	    {
	    	sqle.printStackTrace();
		}
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
		}
		finally 
		{
			rs.close();
			pStmt.close();
			dbConn.close();
		}
		return personalInfo;
	}
	
	public static void addpersonalInfo(PersonalInfoVOO inpersonalInfo) throws Exception
	{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsInserted = 0;

	    try
	    {
			dbConn = getConnection();
			pStmt = dbConn.prepareStatement("INSERT INTO personalInfo  VALUES (?,?,?,?)");
			
			pStmt.setString(1, inpersonalInfo.getFirstName());
			pStmt.setString(2, inpersonalInfo.getMiddleName());
			pStmt.setString(3, inpersonalInfo.getLastName());
			pStmt.setString(4, inpersonalInfo.getGender());
	  		rowsInserted = pStmt.executeUpdate();
	
			if (rowsInserted != 1) 
			{
				throw new Exception("Error in inserting the row");
	
	   		}
	    }
	    catch (SQLException sqle) 
	    {
	    	sqle.printStackTrace();
	    	throw sqle;
		}
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    	throw e;
		}
	    finally 
	    {
			pStmt.close();
			dbConn.close();
	    }
		return;
	}
	
	public static void deletePersonalInfo(String infirstName) throws Exception
	{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsDeleted = 0;

	    try
	    {
			dbConn = getConnection();
			pStmt = dbConn.prepareStatement("DELETE FROM personalInfo WHERE FirstName = ?"); 
			pStmt.setString(1, infirstName);
			
	   		rowsDeleted = pStmt.executeUpdate();
	
			if (rowsDeleted != 1) 
			{
				throw new Exception("Error in deleting the row");
	   		}
	    }
	    catch (SQLException sqle) 
	    {
	    	sqle.printStackTrace();
	    	throw sqle;
		}
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    	throw e;
		}
	    finally 
	    {
	    	pStmt.close();
			dbConn.close();
	    }
	    return;
	}
	
	public static void updatePersonalInfo(PersonalInfoVOO inpersonalInfo) throws Exception
	{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsUpdated = 0;

	    try
	    {
			dbConn = getConnection();
			pStmt = dbConn.prepareStatement("UPDATE personalInfo SET  FirstName = ?, MiddleName = ?, LastName = ?, Gender = ? where FirstName = ?");
			pStmt.setString(1, inpersonalInfo.getMiddleName());
			pStmt.setString(2, inpersonalInfo.getLastName());
			pStmt.setString(3, inpersonalInfo.getGender());
			pStmt.setString(4, inpersonalInfo.getFirstName());
					
	   		rowsUpdated = pStmt.executeUpdate();
	
			if (rowsUpdated != 1) 
			{
				throw new Exception("Error in updating the row");
	
	   		}
	    }
	    catch (SQLException sqle) 
	    {
	    	sqle.printStackTrace();
	    	throw sqle;
	    }
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    	throw e;
	    }
	    finally 
	    {
	    	pStmt.close();
			dbConn.close();
	    }
			return;
	}
	
	public static ArrayList getAllPersonalInfoEntries() throws Exception
	{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
        ResultSet rs = null;
	    ArrayList personalInfoList = new ArrayList();
	    PersonalInfoVOO personalInfo = null;

	    try
	    {
			dbConn = getConnection();
			pStmt = dbConn.prepareStatement("SELECT * FROM personalInfo");
	
	   		rs = pStmt.executeQuery();
	
			while (rs.next()) 
			{
				personalInfo = new PersonalInfoVOO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				personalInfoList.add(personalInfo);
				System.out.println(personalInfo.getFirstName());
		        System.out.println(personalInfo.getMiddleName());
		        System.out.println(personalInfo.getLastName());
		        System.out.println(personalInfo.getGender());	
	   		}
	    }
	    catch (SQLException sqle) 
	    {
		   sqle.printStackTrace();
		   throw sqle;
		}
	    catch(Exception e) 
	    {
		   e.printStackTrace();
		   throw e;
		}
	    finally 
	    {
			rs.close();
			pStmt.close();
			dbConn.close();
	    }
		return personalInfoList;
	}
	
	public static void main(String[] arg)
	{
		PersonalInfoDBAccess personalInfoDBAccess = new PersonalInfoDBAccess();
		try
		{
			personalInfoDBAccess.getPersonalInfo("");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


}
