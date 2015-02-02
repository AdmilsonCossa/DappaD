<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../header.jsp" />

<div class="container">

	<h3>
		<a href="note/${note.id}/delete" class="label label-danger acion-right">
			<spring:message code="label.delete" />&nbsp;<spring:message code="label.note" />
		</a>
		<spring:message code="label.edit" />&nbsp;<spring:message code="label.note" />
	</h3>




	<form:form method="post" action="/update" commandName="note" class="note">
		<form:hidden path="id" value="${note.id}" />

		<ol>
			<li><form:input path="title" value="${note.title}"
					maxlength="250" class="wide" /></li>
			<li><form:textarea path="text" value="${note.text}"
					maxlength="3000" class="wide" /></li>
			<li>
				<button type="submit" class="btn btn-primary acion-right" value="submit">
					<spring:message code="label.save" />
				</button> 
				<a href="../" class="btn btn-default"><spring:message
						code="label.cancel" /></a>
			</li>


		</ol>

	</form:form>



</div>

<jsp:include page="../footer.jsp" />
