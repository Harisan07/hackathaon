<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.verizon.models.*,com.verizon.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#sam1{
color:white;
font-size: 200%;

}
#sam2{
    margin: auto;
    width: 50%;
    padding: 10px;
    font-family:Lucida Console;
    color:white;
    font-size:25px;
  }
</style>
</head>
<body background="C:\Users\Administrator\Desktop\ver1.jpg">
<%
	Employee e = (Employee)session.getAttribute("user");
%>
<div id="sam2" align="center">
<h1 id="sam1">Welcome <%=e.getEmpName() %></h1></br>
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
</div>
</form>


</body>
</html>
