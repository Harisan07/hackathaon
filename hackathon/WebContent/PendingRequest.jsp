<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.verizon.models.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Request>	list = (ArrayList<Request>)session.getAttribute("md");
%>
<form action="AcceptServlet" method="post">
<table>
	<tr>
	<th>EmpId</th>
	<th>FromDate</th>
	<th>ToDate</th>
	<th>FromLocation</th>
	<th>ToLocation</th>
	<th>Choice</th>
	</tr>
	<%for(int i = 0; i<list.size();i++) 
{ %> 
	<tr>
		<td><%=list.get(i).getEmpId() %></td>
		<td><%=list.get(i).getFromDate() %></td>
		<td><%=list.get(i).getToDate() %></td>
		<td><%=list.get(i).getFromLocation()%></td>
		<td><%=list.get(i).getToLocation() %></td>
		<td>Accept:<input type="radio" value="<%=list.get(i).getReqNo()%>" name="responseNo<%=i%>"/></td>
	</tr>
	
<% } %>


		
</table><br>
<input type="submit" value="Confirm" />
</form>


	



</body>
</html>