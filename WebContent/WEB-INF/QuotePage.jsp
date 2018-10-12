<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.Random"%>

<%
Random rand = new Random();
int n = rand.nextInt(2) + 1;
%>

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

.jumbotron {
	margin-top: 1rem;
}
</style>
	<div class="container">
		<div class="jumbotron">
			<h1 class="display-3">
				<c:out value="${quotes[randNum].quote}" />
			</h1>
			<p class="lead">
				<c:out value="${quotes[randNum].author}" />
			</p>
			<hr class="my-4">
			<p></p>
			<form class="form in-line" action="LikesAndDislikes" method="post">
				<div class="form-group">
					<button class="btn btn-primary" value="${randNum}" name="like">Like</button>
				</div>
				<div class="form-group">
					<button class="btn btn-primary" value="${randNum}" name="dislike">Dislike</button>
				</div>
			</form>
			<a href="AdminPage">Admin Page</a>
		</div>




	</div>
</body>
</html>