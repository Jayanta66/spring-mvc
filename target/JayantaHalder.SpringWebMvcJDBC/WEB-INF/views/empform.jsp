<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Add Employee</h1>
<form:form method="post" action="save">
<table>
<tr>
<td>Name :</td>
<td><form:input path="ename"/></td>
</tr>

<tr>
<td>Band :</td>
<td><form:input path="eband"/></td>
</tr>

<tr>
<td>Submit :</td>
<td><input type="submit" value="Save"></td>
</tr>


</table>
</form:form>