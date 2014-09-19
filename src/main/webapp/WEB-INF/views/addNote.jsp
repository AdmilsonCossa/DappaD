<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<div class="main">
	<form:form method="post" action="addNote" commandName="note"
		class="note-add">

		<ol>
			<li><form:input path="title" maxlength="250" class="wide" /></li>
			<li><form:textarea path="text" maxlength="3000" class="wide" /></li>
			<li><input type="submit"
				value="<spring:message code="label.addnote"/>" /></li>
		</ol>

	</form:form>
</div>

<jsp:include page="footer.jsp" />