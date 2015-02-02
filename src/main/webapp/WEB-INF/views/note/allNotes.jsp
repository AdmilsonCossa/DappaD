<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<jsp:include page="../header.jsp" />
<div class="container">
	
	<h3>
		<a href="/node/add" class="label label-success action-right">
			new
		</a>
		all notes
	</h3>
	
	<c:if test="${!empty noteList}">

		<table class="table table-hover">
			<tbody>
				<c:forEach items="${noteList}" var="note">
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
							<a class="crop" href="note/${note.id}">${note.title} </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>
</div>

<jsp:include page="../footer.jsp" />