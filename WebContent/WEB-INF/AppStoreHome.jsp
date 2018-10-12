<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Apps</title>
</head>
<body>
	<br>
	<div class="container">
		<div class="jumbotron text-center">
			<h1>App Store</h1>
			<p>Search for apps</p>
		</div>
		<form class="form in-line" action="AppSearchController" method="post">
			<div class="form-group">
				<input class="form-control" type="text" name="query"
					placeholder="Enter your search term(s)"> <br> <input
					class="form-control btn btn-primary" type="submit" value="Search">
			</div>
		</form>
		<div class="row">



			<table border="1"
				class="table table-bordered table-striped table-hover">
				<tr>
					<th>Id</th>
					<th>name</th>
					<th>size_bytes</th>
					<th>price</th>
					<th>rating</th>
					<th>genre</th>
					<th>Link</th>
				</tr>
				<c:forEach items="${results}" var="app" varStatus="appLoop">
					<tr>
						<td>${app.id}</td>
						<td><c:out value="${app.name}" escapeXml="true" /></td>
						<td><c:out value="${app.size_bytes}" /></td>
						<td><c:out value="${app.price}" /></td>
						<td><c:out value="${app.rating}" /></td>
						<td><c:out value="${app.genre}" /></td>
						<td><a href="AppDescriptionController?index=${appLoop.index}">
								Description</a></td>
					</tr>
				</c:forEach>



			</table>



		</div>

	</div>

</body>
</html>