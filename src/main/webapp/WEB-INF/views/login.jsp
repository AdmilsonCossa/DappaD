<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>

<jsp:include page="header.jsp" />

<div class="container">

	<c:if test="${not empty param.error}">
		<div class="alert alert-danger"> <spring:message code="label.loginerror" />
			: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<form class="form-signin" name='loginForm' 
		action="<c:url value='/j_spring_security_check' />" method='POST'>

		<h2 class="form-signin-heading">Please sign in</h2>
		
		<input type="text" name="j_username" class="form-control" > 
		<input type="password"  name="j_password"  class="form-control"> 
		<label class="checkbox"> 
			<input type="checkbox" name="_spring_security_remember_me" value="remember-me">
			<spring:message code="label.remember" />
		</label>
		
		<div class="btn-block"> 
			<button class="btn btn-primary" type="submit" value="Login" >
				Sign in
			</button>
				
			<button class="btn btn-default" type="reset" value="Reset" >
				Reset
			</button>
		</div>
		
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

</div>

<jsp:include page="footer.jsp" />