<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="cs320" uri="http://cs.calstatela.edu/cs3220stuxx/"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Morse Codify</title>
</head>
<body>
	<style>
h1 {
	font-family: 'Corben', Georgia, Times;
}
</style>
	<br>

	<div class="container">
		<h1 class="display-3">String to Morse Code</h1>
	
		<form action="MorseCode.jsp" method="post">
			Enter a string a-z (spaces includes):<br> <input type="text"
				name="message"><br> <input type="submit">
		</form>



		<p>
			This is the result of the MorseCode: <br> <cs320:morseCode input="${param.message}" />
		</p>
	</div>

</body>
</html>