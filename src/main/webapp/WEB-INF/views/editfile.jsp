<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
</head>
<body>

<h2><spring:message code="label.editfile" /></h2>



<form method="post" action="edit" >
<input type="hidden" name="fileId" value="${fileId}" />
<table>
	<tr>
		<td align="right"><spring:message code="label.filename" /></td>
		<td><input type="text" name="filename" value="${filename}"/></td>
	</tr>
	<tr>
		<td align="right"><spring:message code="label.description" /></td>
		<td><input type="text" name="description" value="${description}"/></td>
	</tr>
	<tr>
		<td align="right"><spring:message code="label.openshare" /></td>
		<td><input type="checkbox" name="shared" value="${shared}"/></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
		<input type="submit" value="Edit" />
		<a href="<c:url value='/cancel'/>">
 		<input type="button" value="Cancel"/></a>
	</tr>
</table>
</form>
</body>
</html>