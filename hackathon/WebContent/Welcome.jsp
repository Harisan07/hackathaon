<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.verizon.models.*,com.verizon.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Employee e = (Employee)session.getAttribute("user");
%>
<h1>Welcome <%=e.getEmpName() %></h1></br>
ID:<%=e.getEmpId() %> </br>
Mail:<%=e.getEmail() %> </br>
ManagerId:<%=e.getEmpMId() %> </br>
Location:<%=e.getLocation() %> </br>
<form action="RequestRaiser.jsp" method="post">
	<input type="submit" value="Raise request" /> 
</form>
<form action="PendingRequest" method="post">
	<input type="hidden" value="<%=e.getEmpId()%>" />
	<input type="submit" value="Pending Request"/>

</form>


</body>
</html>