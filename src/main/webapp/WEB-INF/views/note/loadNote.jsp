<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../header.jsp" />

<div class="container">

	<h3>
		<a href="/n-delete/${notebook.id}" class="label label-danger action-right">
			<spring:message code="label.delete" />
		</a>
		<a href="/n-edit/${notebook.id}" class="label label-default action-right">
			<spring:message code="label.edit" />
		</a>
		&nbsp;<spring:message code="label.note" />
	</h3>

	<ol>
		<li class="wide">${note.title}</li>
		<li class="wide">${note.text}</li>
		<li>
			<a href="/" class="btn btn-default"><spring:message
					code="label.cancel" /></a>
		</li>
	</ol>

</div>

<jsp:include page="../footer.jsp" />
