<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title><spring:message code="label.appname" /> : ${note.title}
	Edit</title>
</head>
<body>

	<a href="<c:url value="/index" />"> <spring:message
			code="label.appname" />
	</a>
	
	<a href="<c:url value="/logout" />" style="text-align: right"> <spring:message
			code="label.logout" />
	</a>
	<h2>
		${note.title}
		<spring:message code="label.edit" />
	</h2>


	<form:form method="post" action="../update" commandName="note">
		<form:input path="id" value="${note.id}" />
		<table>
			<tr>
				<td><form:label path="title">
						<spring:message code="label.title" />
					</form:label></td>
				<td><form:input path="title" value="${note.title}" /></td>
			</tr>
			<tr>
				<td><form:label path="text">
						<spring:message code="label.text" />
					</form:label></td>
				<td><form:input path="text" value="${note.text}" /></td>
			</tr>
			<tr>
				<td colspan="2"><a href="../"><spring:message
							code="label.cancel" /></a></td>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.save"/>" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
