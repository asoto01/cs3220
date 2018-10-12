<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="http://fonts.googleapis.com/css?family=Corben:bold"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Nobile"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>EL Table</title>


</head>
<body>
<style>
.container {
	margin-top: 1rem;
}
</style>
	<div class="container">
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th colspan="2">Arithmetic Operators</th>
				<th colspan="2">Relational Operators</th>
			</tr>
			<tr>
				<th>Expression</th>
				<th>Result</th>
				<th>Expression</th>
				<th>Result</th>
			</tr>
			<tr align="center">
				<td><c:out value="\${3+2-1}" /></td>
				<td>${3+2-1}</td>
				<td><c:out value="\${1 &lt; 2}" escapeXml="false" /></td>
				<td>${1 < 2}</td>
			</tr>
			<tr align="center">
				<td><c:out value="\${\"1\"+2 }" /></td>
				<td>${"1"+2 }</td>
				<td><c:out value="\${'a' &lt; 'b'}" escapeXml="false" /></td>
				<td>${'a' < 'b'}</td>
			</tr>
			<tr align="center">
				<td><c:out value="\${1+2*3+3/4}" /></td>
				<td>${1+2*3+3/4}</td>
				<td><c:out value="\${2/3 &gt;= 3/2}" escapeXml="false" /></td>
				<td>${2/3 >= 3/2}</td>
			</tr>
			<tr align="center">
				<td><c:out value="\${3%2}" /></td>
				<td>${3%2}</td>
				<td><c:out value="\${3/4 == 0.75}" /></td>
				<td>${3/4 == 0.75}</td>
			</tr>
			<tr align="center">
				<td><c:out value="\${((8 div 2)mod 3)}" /></td>
				<td>${((8 div 2)mod 3)}</td>
				<td><c:out value="\${null== \"test\"}" /></td>
				<td>${null== "test"}</td>
			</tr>
			<tr>
				<th colspan="2">Logical Operators</th>
				<th colspan="2"><code>empty</code> Operator</th>
			</tr>
			<tr>
				<th>Expression</th>
				<th>Result</th>
				<th>Expression</th>
				<th>Result</th>
			</tr>
			<tr align="center">
				<td><c:out value="\${((1 &lt; 2) && (3 &lt; 4))}"
						escapeXml="false" /></td>
				<td>${((1 < 2) && (3 < 4))}</td>
				<td><c:out value="\${empty \"\"}" /></td>
				<td>${empty ""}</td>
			</tr>
			<tr align="center">
				<td><c:out value="\${((1 &lt; 2) || (3 &lt; 4))}"
						escapeXml="false" /></td>
				<td>${((1 < 2) || (3 < 4))}</td>
				<td><c:out value="\${empty null}" /></td>
				<td>${empty null}</td>
			</tr>
			<tr align="center">
				<td><c:out value="\${(!(1 &lt; 2))}" escapeXml="false" /></td>
				<td>${(!(1 < 2))}</td>
				<td><c:out value="\${empty param.blah}" /></td>
				<td>${empty param.blah}</td>
			</tr>
		</table>
	</div>
</body>


</body>
</html>