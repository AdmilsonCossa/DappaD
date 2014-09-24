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
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
	
	<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>

<%
String uri = request.getRequestURI();
String pageName = uri.substring(uri.lastIndexOf("/")+1);
request.setAttribute("pageName", pageName);
%>

	<div class="navbar navbar-default navbar-fixed-top">
	
		<div class="container">
		
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value="/" />">
					<spring:message code="label.appname" />
				</a>
			</div>
			
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="${pageName eq 'home.jsp' ? 'active' : ''}">
						<a href="<c:url value="/" />">Home</a>
					</li>
					<li class="${pageName eq 'allNotes.jsp' ? 'active' : ''}">
						<a href="<c:url value="/listNotes" />">Notes</a>
					</li>
					
					<li class="${pageName eq 'allNotebooks.jsp' ? 'active' : ''}">
						<a href="<c:url value="/listNotebooks" />">Notebooks</a>
					</li>
					
					<li class="${pageName eq 'addNote.jsp' ? 'active' : ''}">
						<a href="<c:url value="/n-create" />" ><spring:message code="label.addnote" /></a>
					</li>
					<li>
						<a href="<c:url value="/logout" />"><spring:message code="label.logout" /></a>
					</li>
				</ul>
			</div>
			
		</div>
		
	</div>

	