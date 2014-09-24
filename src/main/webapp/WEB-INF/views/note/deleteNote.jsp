<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container">

	<h3>
		<a href="../delete/${note.id}" class="label label-danger acion-right">
			<spring:message code="label.delete" />&nbsp;<spring:message code="label.note" />
		</a>
		<spring:message code="label.edit" />&nbsp;<spring:message code="label.note" />
	</h3>




	<form:form method="post" action="/delete" commandName="note" class="note">
		<form:hidden path="id" value="${note.id}" />

		<ol>
			<li>Delete note: ${note.title} ?</li>
			<li>
				<button type="submit" class="btn btn-primary acion-right" value="submit">
					<spring:message code="label.delete" />
				</button> 
				<a href="<c:url value="/" />" class="btn btn-default"><spring:message
						code="label.cancel" /></a>
			</li>


		</ol>

	</form:form>



</div>

