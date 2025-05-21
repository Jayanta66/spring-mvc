<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Employee List</h1>
<table>
<tr><th>Id</th><th>Name</th><th>Band</th><th>Edit</th><th>Delete</th></tr>

<c:forEach var="emp" items="${list}">

<tr>

<td>${emp.eid}</td>
<td>${emp.ename}</td>
<td>${emp.eband}</td>
<td><a href="editemp/${emp.eid}">Edit</a></td>
<td><a href="deleteemp/${emp.eid}">Delete</a></td>
</tr>
</c:forEach>
</table>
<br>
<a href="empform">Add Employee</a>