<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="process.jsp">  
Enter Name:<input type="text" name="name" /><br/><br/>  
<input type="submit" value="go"/>  
</form>  

<h2>First JSP</h2>  
<%  
Cookie ck=new Cookie("name","abhishek");  
response.addCookie(ck);  
%>  

<h3>welcome to index page</h3>  
<%  
session.setAttribute("user","sonoo");  
%>  

<a href="process.jsp">click</a>  

</body>
</html>