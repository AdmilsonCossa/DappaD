<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../header.jsp" />

<div class="container">
	<form:form method="post" action="/nb/add" commandName="notebook" class="notebook">

		<ol>
			<li><form:input path="name" maxlength="250" class="wide" /></li>
			<li>
				<input type="submit" class="btn btn-primary acion-right" value="<spring:message code="label.save"/>" /> 
				<a href="/" class="btn btn-default ">
					<spring:message code="label.cancel" />
				</a>
			</li>
		</ol>

	</form:form>
</div>

<jsp:include page="../footer.jsp" />