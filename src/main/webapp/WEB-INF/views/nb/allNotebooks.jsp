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
		<a href="/nb/new" class="label label-success action-right">
			new
		</a>
		your notebooks
	</h3>
	
	<c:if test="${!empty notebookList}">

		<table class="table table-hover">
			<tbody>
				<c:forEach items="${notebookList}" var="notebook">
					<tr>
						<td class="note-list-title" >
							<div class="action-right">								
								<a href="/nb/${notebook.id}/edit" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-pencil"></span>
								</a>&nbsp;
								<a href="/nb/${notebook.id}/delete" class="btn btn-warning btn-sm">
									<span class="glyphicon glyphicon-remove"></span>
								</a> 
							</div>
							<a class="crop" href="/nb/${notebook.id}/">${notebook.title} </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>
</div>

<jsp:include page="../footer.jsp" />