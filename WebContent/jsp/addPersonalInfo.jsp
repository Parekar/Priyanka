<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@include file="header.html"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Add Personal Information</title>
	</head>
	
	<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">
	
		<center>
			<%@include file="displayformerrors.jsp"%>
			<h2>Add Personal Information</h2>
		</center>
		<center>
			<form method="post" action="/MyMVCProject/servlet/addPersonalInfoServlet">
				<table  cellpadding="0" cellspacing="0" width="50%"">
					<tr>
						<td bgcolor="#FAFAF9" style="padding-left: 10px;">First Name</td>
						<td><input type="text" name="firstName" maxlength="30" value="" /></td>
					</tr>
					<tr>
						<td bgcolor="#FAFAF9" style="padding-left: 10px;">Middle Name</td>
						<td><input type="text" name="middleName" maxlength="10" value="" /></td>
					</tr>
					<tr>
						<td bgcolor="#FAFAF9" style="padding-left: 10px;">Last Name</td>
						<td><input type="text" name="lastName" maxlegth="30" value="" /></td>
					</tr>
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">
					<lable for="gender">Gender</lable>
					</td>
						<td><select name="gender">
						<option value=Male>Male</option>
						<option value=Female>Female</option>
						</select> </td>
					</tr>			
					<tr>
						<td colspan="2" align="right">
						<br>
						<table  width="50%">
							<tr>
								<td><input type="submit" name="save" value="Save"/></td>
								<td width="201"><input type="reset" name="clear" value="Clear" />&nbsp;</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
	<%@include file="footer.html"%>
</html>