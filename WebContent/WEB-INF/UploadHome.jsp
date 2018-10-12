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
<title>Not Dropbox</title>


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
			<h1 class="display-3">Not Dropbox</h1>
			<p class="lead">Upload a file.</p>
			<hr class="my-4">
			<form action="UploadController" method="post" enctype="multipart/form-data">
				Desired name for file:
				<input type="text" name="description" /> <input type="file"
					name="file" /> <input type="submit" />
			</form>
			<a href="ListUploadHome">View uploads</a>
		</div>
	</div>
</body>
</html>