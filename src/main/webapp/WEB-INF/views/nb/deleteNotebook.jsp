<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../header.jsp" />

<div class="container">

	<h3>
		<spring:message code="label.delete" />&nbsp;<spring:message code="label.note" />
	</h3>

	<form:form method="post" action="/nb/delete" modelAttribute="notebook" class="note">
		<form:hidden path="id" value="${notebook.id}" />

		<ol>
			<li>Delete note: ${notebook.title} ?</li>
			<c:if test="${newDefault != null}">
			<li>
				This notebook is default. Choose new default notebook
				<select name="newDefaultId">
		 			<c:forEach items="${notebooks}" var="nb">
						<c:if test="${notebook.id != nb.id}">
							<option value="${nb.id}">${nb.title}</option>
						</c:if>
					</c:forEach>
				</select>
			</li>
			</c:if>
			<li>
				<button class="btn btn-primary acion-right" type="submit" name="submit" value="nb">
					<spring:message code="label.delete" />
				</button>
	    		<button class="btn btn-primary acion-right" type="submit" name="submit" value="recursive">
	    			delete with notes
	    		</button>
			
				<a href="<c:url value="javascript:history.back()" />" class="btn btn-default">
					<spring:message code="label.cancel" />
				</a>
			</li>

		</ol>

	</form:form>

</div>

<jsp:include page="../footer.jsp" />