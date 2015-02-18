<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container">

	<h3>
		<spring:message code="label.delete" />&nbsp;<spring:message code="label.note" />
	</h3>

	<form:form method="post" action="/nb/delete" modelAttribute="notebook" class="note">
		<form:hidden path="id" value="${notebook.id}" />

		<ol>
			<li>Delete note: ${notebook.name} ?</li>
			<li>
				<button type="submit" class="btn btn-primary acion-right" value="submit">
					<spring:message code="label.delete" />
				</button> 
				<a href="<c:url value="javascript:history.back()" />" class="btn btn-default"><spring:message
						code="label.cancel" /></a>
			</li>


		</ol>

	</form:form>



</div>

