<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<div class="main">
	<h2>
		<spring:message code="label.edit" />
		${note.title}
	</h2>


	<form:form method="post" action="../update" commandName="note"
		class="note-add">
		<form:hidden path="id" value="${note.id}" />

		<ol>
			<li><form:input path="title" value="${note.title}"
					maxlength="250" class="wide"/></li>
			<li><form:textarea path="text" value="${note.text}"
					maxlength="3000" class="wide"/></li>
			<li><input type="submit"
				value="<spring:message code="label.save"/>" /> <a href="../"><spring:message
						code="label.cancel" /></a></li>
		</ol>

	</form:form>



</div>

<jsp:include page="footer.jsp" />
