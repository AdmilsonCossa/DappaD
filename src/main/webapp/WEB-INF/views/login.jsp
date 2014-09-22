<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title><spring:message code="label.appname" /></title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/signin.css">
</head>
<body>

	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value="/" />"><spring:message
						code="label.appname" /></a>
			</div>
		</div>
	</div>

	<div class="container">

		<c:if test="${not empty param.error}">
			<div class="alert alert-danger"> <spring:message code="label.loginerror" />
				: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>

		<form class="form-signin" method="POST"
			action="<c:url value="/j_spring_security_check" />">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="text" name="j_username" class="form-control" > 
			<input type="password"  name="j_password"  class="form-control"> 
			<label class="checkbox"> <input type="checkbox" name="_spring_security_remember_me" value="remember-me">
				<spring:message code="label.remember" />
			</label>
			<div class="btn-block"> 
			<button class="btn btn-primary" type="submit" value="Login" >Sign in</button>
				
			<button class="btn btn-default" type="reset" value="Reset" >Reset </button>
			</div>
		</form>

	</div>
</body>
</html>