<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../header.jsp" />

<div class="container">

	<h3>
		<a href="/nb/${notebook.id}/delete" class="label label-danger action-right">
			<spring:message code="label.delete" />
		</a>
		edit : ${notebook.name}
	</h3>




	<form:form method="post" action="/nb/update" modelAttribute="notebook" class="note">
		<form:hidden path="id" value="${notebook.id}" />

		<ol>
			<li><form:input path="name" value="${notebook.title}"
					maxlength="250" class="wide" /></li>
			<li>
				<button type="submit" class="btn btn-primary acion-right" value="submit">
					<spring:message code="label.save" />
				</button> 
				<a href="javascript:history.back()" class="btn btn-default"><spring:message
						code="label.cancel" /></a>
			</li>
		</ol>

	</form:form>



</div>

<jsp:include page="../footer.jsp" />
