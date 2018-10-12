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
<title>Quote Page</title>


</head>
<body>
	<style>
h1, h2, h3 {
	font-family: 'Corben', Georgia, Times;
}

.container {
	margin-top: 1rem;
}
</style>
	<div class="container">
		<h1>Admin</h1>
		<a href="QuotePage">View quotes</a>

		<table border="1"
			class="table table-bordered table-striped table-hover">
			<tr>
				<th>Quotation</th>
				<th>Author</th>
				<th>Likes</th>
				<th>Dislikes</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${quotes}" var="quotes">
				<tr>

					<td>${quotes.quote}</td>
					<td><c:out value="${quotes.author}" escapeXml="true" /></td>
					<td><c:out value="${quotes.like}" /></td>
					<td><c:out value="${quotes.dislike}" /></td>
					<td><a>Edit</a> |
						<form class="form in-line" action="DeleteQuote" method="post">
							<div class="form-group">
								<button class="btn btn-primary" value="${quotes.id}" name="delete">delete</button>
							</div>
						</form></td>
				</tr>
			</c:forEach>

		</table>


		<form class="form in-line" action="AddQuote" method="post">
			<div class="form-group">
				<input class="form-control" type="text" name="quote"
					placeholder="Enter quote"> <br> <input
					class="form-control" type="text" name="author"
					placeholder="Enter author"> <br> <input
					class="form-control btn btn-primary" type="submit" value="Submit">
			</div>
		</form>


	</div>
</body>
</html>