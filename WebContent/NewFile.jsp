<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	int a, b;	
	try {
		a = Integer.parseInt(request.getParameter("a"));
		b = Integer.parseInt(request.getParameter("b"));
	} 
%> --%>
<%! int counter = 0; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
Hello, World!
The sum of <%=request.getParameter("a") %> and <%=request.getParameter("b")%> is:

<% if (Math.random() < 0.5) { %>
		<h1>Have a great day!</h1>
	<% } else { %>
		<h1>Have a <em>lousy</em> day!</h1>
	<% }%> 
	
<%-- This page has been viewed: <%counter%> 
 --%>
<%counter++;%>
 
</body>
</html>