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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<ol>
				<li><a href="<c:url value="/index" />"> <spring:message
							code="label.appname" /></a></li>
				<li><a href="<c:url value="/add" />" style="text-align: right">
						<spring:message code="label.addnote" />
				</a></li>
				<li><a href="<c:url value="/logout" />"
					style="text-align: right"> <spring:message code="label.logout" />
				</a></li>
			</ol>
		</div>