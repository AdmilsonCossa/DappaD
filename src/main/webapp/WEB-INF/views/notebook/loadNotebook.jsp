<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../header.jsp" />

<div class="container">

	<h3>
		<a href="/nb-delete/${notebook.id}" class="label label-danger action-right">
			<spring:message code="label.delete" />
		</a>
		<a href="/nb-edit/${notebook.id}" class="label label-default action-right">
			<spring:message code="label.edit" />
		</a>
		<a href="/n-create" class="label label-success action-right">
			+ note
		</a>
		notes in: ${notebook.name}
	</h3>



	<c:if test="${!empty noteList}">

		<table class="table table-hover">
			<tbody>
				<c:forEach items="${noteList}" var="note">
					<tr>
						<td class="note-list-title" >
							<div class="action-right">								
								<a href="/n-edit/${note.id}" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-pencil"></span>
								</a>&nbsp;
								<a href="/n-delete/${note.id}" class="btn btn-warning btn-sm">
									<span class="glyphicon glyphicon-remove"></span>
								</a> 
							</div>
							<a class="crop" href="/n-load/${note.id}">${note.title} </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>

</div>

<jsp:include page="../footer.jsp" />
