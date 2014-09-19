<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>
<jsp:include page="header.jsp" />

<div class="main">
	<c:if test="${!empty noteList}">
	
		<div class="data">
			<ol>
				<c:forEach items="${noteList}" var="note">
					<li>
						<div class="note-list-title">${note.title}</div>
						<div class="note-list-text">${note.text}</div>
						<div class="note-list-acion">
							<a href="delete/${note.id}"><spring:message
									code="label.delete" /></a>&nbsp; <a href="edit/${note.id}"><spring:message
									code="label.edit" /></a>
						</div>
					</li>
				</c:forEach>
			</ol>
		</div>

	</c:if>
</div>

<jsp:include page="footer.jsp" />