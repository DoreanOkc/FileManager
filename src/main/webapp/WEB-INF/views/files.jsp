<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
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

<a href="<c:url value="userfile" />">
	<spring:message code="label.private" />
</a>

<h3><spring:message code="label.files" /></h3>
<table width="80%" border="1" cellspacing="0" cellpadding="5">
        <tr>
            <th width="4%">№</th>
            <th width="30%"><spring:message code="label.filename" /></th>
            <th width="30%"><spring:message code="label.description" /></th>
            <th width="30%">&nbsp;</th>
        </tr>
        
        <security:authorize ifAllGranted="ROLE_ADMIN">
        <c:choose>
            <c:when test="${fileList != null}">
                <c:forEach var="file" items="${fileList}" varStatus="counter">
                    <tr>
                        <td>${counter.index + 1}</td>
                        <td>${file.filename}</td>
                        <td>${file.description}</td>
                        <td><div align="center">
                        	<a href="download/${file.id}"><spring:message code="label.download" /></a>
                        	 / <a href="editfile/${file.id}"><spring:message code="label.edit" /></a>
                             / <a href="delete/${file.id}"><spring:message code="label.delete" /></a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
        </security:authorize>
        
        <security:authorize ifAllGranted="ROLE_USER">
        <c:choose>
            <c:when test="${shareFileList != null}">
                <c:forEach var="file" items="${shareFileList}" varStatus="counter">
                    <tr>
                        <td>${counter.index + 1}</td>
                        <td>${file.filename}</td>
                        <td>${file.description}</td>
                        <td><div align="center">
                        	<a href="download/${file.id}"><spring:message code="label.download" /></a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
        </security:authorize>
</table>  

</body>
</html>