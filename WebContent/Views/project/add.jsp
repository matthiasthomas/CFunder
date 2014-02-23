<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf8"%>
<%@ page import="com.supinfo.supcrowdfunder.entity.Category"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add a project</title>
</head>
<body>
	<form method='post' action='../project/add'>
		<input type="text" placeholder="Name" name='name' /> 
		<input type="text" placeholder="Description" name='description' /> 
			<input type="number" placeholder="Amount" name='amount'>Amout Wanted</input> 
			<select name='category_id'>
			<%
				List<Category> categories = (List<Category>) request
						.getAttribute("categories");
			%>
			<%
				for (Category category : categories) {
			%>
			<option value='<%=category.getId()%>'><%=category.getName()%></option>
			<%
				}
			%>
		</select>
		<input type='submit' value='Add' />
	</form>
</body>
</html>