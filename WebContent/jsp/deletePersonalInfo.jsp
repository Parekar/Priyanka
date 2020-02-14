<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.html"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Delete Personal Information</title>
	</head>
	<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">
		<center>
			<h2>Delete Personal Information</h2>
		</center>

		<center>
			<form method="post" action="/MyMVCProject/servlet/DeletePersonalInfoServlet">
				<table  cellpadding="0" cellspacing="0" width="50%"">
				<tr>
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">First Name</td>
					<td><input type="text" name="firstName" maxlength="50" value="" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
				<br>
				<table  width="50%">
				<tr>
					<td><input type="submit" name="save" value="Delete"/></td>
					<td width="201"><input type="reset" name="clear" value="Clear" />&nbsp;</td>
				</tr>
				</table>
				</td>
				</tr>
				</table>
			</form>
		</center>
	
	</body>
</html>
<%@include file="footer.html"%>
