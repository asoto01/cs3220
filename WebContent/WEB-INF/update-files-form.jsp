<!DOCTYPE html>
<html>

<head>
	<title>File Manager</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-file-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Not Dropbox</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>EDIT FILE</h3>
		
		<form action="FileControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="fileId" value="${THE_FILE.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>NEW FILE NAME</label></td>
						<td><input type="text" name="fileName" 
								   value="${THE_FILE.fileName}" /></td>
					</tr>

					
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="FileControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











