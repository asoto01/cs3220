<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>File Manager App</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

    <div id="wrapper">
        <div id="header">
            <h2>Not Dropbox</h2>
        </div>
    </div>

    <div id="container">

        <div id="content">


            <input type="button" value="Add File" 
                   onclick="window.location.href='WEB-INF/add-file-form.jsp'; return false;"
                   class="add-file-button"
            />
     <form action="FileControllerServlet" method="GET">

	<input type="hidden" name="command" value="SEARCH" />

	Search FILE: <input type="text" name="theSearchName" />

	<input type="submit" value="Search" class="add-file-button" />

</form>
<table>

                <tr>
                    <th>File Name</th>
                    
                    <th>Date</th>
                    <th>Action</th>
                </tr>

                <c:forEach var="tempFile" items="${FILE_LIST}">

                    <c:url var="tempLink" value="FileControllerServlet">
                        <c:param name="command" value="LOAD" />
                        <c:param name="fileId" value="${tempFile.id}" />
                    </c:url>

                    <!--  set up a link to delete a file -->
                    <c:url var="deleteLink" value="FileControllerServlet">
                        <c:param name="command" value="DELETE" />
                        <c:param name="fileId" value="${tempFile.id}" />
                    </c:url>
							<c:url var="downloadLink" value="FileDownloadController">
                        <c:param name="command" value="DOWNLOAD" />
                        <c:param name="fileName" value="${tempFile.fileName}" />
                    </c:url>
                    <tr>
                        <td> ${tempFile.fileName} </td>
                        
                        <td> ${tempFile.date} </td>
                        <td> 
                            <a href="${tempLink}">Update</a> 
                             | 
                            <a href="${deleteLink}"
                            onclick="if (!(confirm('Are you sure you want to delete this file?'))) return false">
                            Delete</a>
                            
                             | 
                             <a href="${downloadLink}">Download</a>
                        
                        </td>
                    </tr>

                </c:forEach>

            </table>

        </div>

    </div>
</body>


</html>


