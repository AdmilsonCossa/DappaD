<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../header.jsp" />

<div class="container">

	<div class="page-header">
		<h3>
			notes in: ${notebook.title}
			<span style="display:inline">
				<form:form method="post" action="/nb/setDflt" modelAttribute="notebook" class="action-right" style="width:400px;text-align:right">
					<form:hidden path="id" value="${notebook.id}" />
			
					<c:if test="${!notebook.isDefault() }">
						<button type="submit" class="label label-default" value="submit">
							Set as default
						</button>
					</c:if>
					<a href="/nb/${notebook.id}/add" class="label label-success">
						+ note
					</a>
					<a href="/nb/${notebook.id}/edit" class="label label-default">
						<spring:message code="label.edit" />
					</a>
					<a href="/nb/${notebook.id}/delete" class="label label-danger">
						<spring:message code="label.delete" />
					</a>
				</form:form>
			</span>
		</h3>
		
		
	</div>		

	<c:if test="${!empty notes}">

		<table class="table table-hover">
			<tbody>
				<c:forEach items="${notes}" var="note">
					<tr>
						<td class="note-list-title" >
							<div class="action-right">								
								<a href="note/${note.id}/edit" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-pencil"></span>
								</a>&nbsp;
								<a href="note/${note.id}/delete" class="btn btn-warning btn-sm">
									<span class="glyphicon glyphicon-remove"></span>
								</a> 
							</div>
							<a class="crop" href="note/${note.id}/load">${note.title} </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>

</div>

<jsp:include page="../footer.jsp" />
