<!DOCTYPE html>
<html>

<head>
<title>Add File</title>

<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Not Dropbox</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add File</h3>





		<form action="FileControllerServlet" method="post"
			enctype="multipart/form-data">
			<label>File name:</label> <input type="text" name="fileName" /> <input
				type="file" name="file" /> <input type="submit" />
		</form>

		<div style="clear: both;"></div>

		<p>
			<a href="FileControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











