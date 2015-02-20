<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../header.jsp" />

<div class="container">
	<form:form action="/add" modelAttribute="note" class="note">

		<ol>
			<li><form:input path="title" maxlength="250" class="wide" /></li>
			<li><form:textarea path="text" maxlength="3000" class="wide" /></li>

			<jsp:include page="selectNb.jsp" />

			<li><input type="submit" class="btn btn-primary acion-right"
				value="<spring:message code="label.save"/>" /> <a
				href="javascript:history.back()" class="btn btn-default "> <spring:message
						code="label.cancel" />
			</a></li>
		</ol>

	</form:form>
</div>

<jsp:include page="../footer.jsp" />