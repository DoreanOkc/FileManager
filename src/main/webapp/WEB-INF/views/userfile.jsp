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

<div align="right"><a href="<c:url value="/logout" />">
	<spring:message code="label.logout" />
</a></div>

<a href="<c:url value="files" />">
	<spring:message code="label.shared" />
</a>
  
<h2><spring:message code="label.title" /></h2>

<form action="addfile" method="post" enctype="multipart/form-data">
        <table width="60%" border="1" cellspacing="0">
            <tr>
                <td width="35%"><spring:message code="label.filename" /></td>
                <td width="65%"><input type="file" name="file" /></td>
            </tr>
            <tr>
                <td><spring:message code="label.description" /></td>
                <td><input type="text" name="description" width="60" /></td>
            </tr>
            <tr>
				<td><spring:message code="label.openshare" /></td>
				<td><input type="checkbox" name="shared" /></td>
			</tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" name="submit" value="<spring:message code="label.addfile"/>"/></td>
            </tr>
        </table>
</form>

<h3><spring:message code="label.files" /></h3>
<table width="80%" border="1" cellspacing="0" cellpadding="5">
        <tr>
            <th width="4%">№</th>
            <th width="30%"><spring:message code="label.filename" /></th>
            <th width="30%"><spring:message code="label.description" /></th>
            <th width="30%">&nbsp;</th>
        </tr>
        <c:choose>
            <c:when test="${userFileList != null}">
                <c:forEach var="file" items="${userFileList}" varStatus="counter">
                    <tr>
                        <td>${counter.index + 1}</td>
                        <td>${file.filename}</td>
                        <td>${file.description}</td>
                        <td><div align="center">
                        	<a href="download/${file.id}"><spring:message code="label.download" /></a> /
                        	<a href="editfile/${file.id}"><spring:message code="label.edit" /></a> /
                            <a href="delete/${file.id}"><spring:message code="label.delete" /></a></div>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
</table>
</body>
</html>