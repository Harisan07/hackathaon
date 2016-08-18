<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="RequestServlet">
From Date<input type="text" placeholder="yyyy-mm-dd" name="fmDate" /> <br>
To Date<input type="text" placeholder="yyyy-mm-dd" name="toDate" /><br>
From Location <input type="radio" name="fromlocation" value="chennai">Chennai</input><br>
	 <input type="radio" name="fromlocation" value="hyderabad">Hyderabad</input><br>
To Location <input type="radio" name="tolocation" value="chennai">Chennai</input><br>
	 <input type="radio" name="tolocation" value="hyderabad">Hyderabad</input><br> <br>
	 <input type="submit" value="Submit Form" />
</form>

</body>
</html>