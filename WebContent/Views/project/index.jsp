<%@page import="java.util.List"%>
<%@page import="com.supinfo.supcrowdfunder.entity.Project"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Projects</title>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>User</th>
			<th>Category</th>
			<th>Created</th>
			<th>Completed</th>
			<th>Amout to Raise</th>
			<th>Ending</th>
		<tr>
			<%
				List<Project> projects = (List<Project>) request
						.getAttribute("projects");
				for (Project project : projects) {
			%>
		
		<tr>
			<td><%=project.getName()%></td>
			<td><%=project.getDescription()%></td>
			<td><%=project.getUser().getFirstName() + " "
						+ project.getUser().getLastName()%></td>
			<td><%=project.getCategory().getName()%></td>
			<td><%=project.getCreated()%></td>
			<td><%=project.getCompletionDate()%></td>
			<td><%=project.getAmount()%></td>
			<td><%=project.getEndDate()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>