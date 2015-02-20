<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:if test="${!empty notebooks}">
	<li>Notebook: 
		<form:select path="nb.id">
 			<form:option value="${note.nb.id}" label="${note.nb.title}" />
 			<c:forEach items="${notebooks}" var="notebook">
				<c:if test="${notebook.id != note.nb.id }">
					<form:option value="${notebook.id}">${notebook.title}</form:option>
				</c:if>
			</c:forEach>
		</form:select></li>
</c:if>