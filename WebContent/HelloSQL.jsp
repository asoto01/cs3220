<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- set data source --%>
<sql:setDataSource driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu:3306/cs3220stu23?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
	user="cs3220stu23" password="UcGpJ6tM" />

<%-- query --%>
<%-- 
    <sql:query var="items" sql="SELECT * FROM items"/>
 --%>

<sql:query var="items">
    SELECT * FROM employees
</sql:query>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>JSTL SQL Example</TITLE>
</HEAD>

<table>

		<c:forEach items="${items.columnNames}" var="name">
			<c:forEach items="${row}" var="col">
				<td>${name}</td>
			</c:forEach>

		</c:forEach>

		<c:forEach items="${items.rowsByIndex}" var="row">
			<tr>
				<c:forEach items="${row}" var="col">
					<td>${col}</td>
				</c:forEach>
			</tr>
		</c:forEach>
</table>

</BODY>
</HTML>