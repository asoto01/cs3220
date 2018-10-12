<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Description</title>

<link rel="stylesheet" href="styles/desc-styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">


</head>

<body>
	<br>
	<h1>Description</h1>
	<div class="page">
		<table border="1"
			class="table table-bordered table-striped table-hover">
			<tr>
				<th>Id</th>
				<th>name</th>
				<th>size_bytes</th>
				<th>price</th>
				<th>rating</th>
				<th>genre</th>

			</tr>
			<tr>
				<td>${results[0].id}</td>
				<td>${results[param.index].name}</td>
				<td><c:out value="${results[param.index].size_bytes}" /></td>
				<td><c:out value="${results[param.index].price}" /></td>
				<td><c:out value="${results[param.index].rating}" /></td>
				<td><c:out value="${results[param.index].genre}" /></td>

			</tr>
		</table>

		<a href="AppSearchController">Go back</a>



	</div>




</body>

</html>