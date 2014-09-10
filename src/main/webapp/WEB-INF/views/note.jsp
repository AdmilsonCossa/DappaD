<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title><spring:message code="label.appname" /></title>
</head>
<body>

	<a href="<c:url value="/logout" />"> <spring:message
			code="label.logout" />
	</a>

	<h2>
		<spring:message code="label.appname" />
	</h2>

	<form:form method="post" action="add" commandName="note">

		<table>
			<tr>
				<td><form:label path="title">
						<spring:message code="label.title" />
					</form:label></td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td><form:label path="text">
						<spring:message code="label.text" />
					</form:label></td>
				<td><form:input path="text" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.addnote"/>" /></td>
			</tr>
		</table>
	</form:form>

	<h3>
		<spring:message code="label.notes" />
	</h3>
	<c:if test="${!empty noteList}">
		<table class="data">
			<tr>
				<th><spring:message code="label.title" /></th>
				<th><spring:message code="label.text" /></th>
				<th><spring:message code="label.action" /></th>
			</tr>
			<c:forEach items="${noteList}" var="note">
				<tr>
					<td>${note.title}</td>
					<td>${note.text}</td>
					<td><a href="delete/${note.id}"><spring:message
								code="label.delete" /></a>&nbsp; 
						<a href="load/${note.id}"><spring:message
								code="label.load" /></a>&nbsp; 
						<a href="edit/${note.id}"><spring:message
								code="label.edit" /></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>
