<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
</head>
<body>


<h2><spring:message code="label.adduser" /></h2>

<form:form method="post" action="add" commandName="user">

	<table>
	    <tr>
			<td><form:label path="username">
				<spring:message code="label.login" />
			</form:label></td>
			<td><form:input path="username" /></td>
		</tr>		
		<tr>
			<td><form:label path="password">
				<spring:message code="label.password" />
			</form:label></td>
			<td><form:input type="password" path="password" /></td>
		</tr>		
		<tr>
			<td><form:label path="firstname">
				<spring:message code="label.firstname" />
			</form:label></td>
			<td><form:input path="firstname" /></td>
		</tr>
		<tr>
			<td><form:label path="lastname">
				<spring:message code="label.lastname" />
			</form:label></td>
			<td><form:input path="lastname" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="label.adduser"/>" /></td>
		</tr>
	</table>
</form:form>

</body>
</html>