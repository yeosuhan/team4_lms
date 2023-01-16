<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/WEB-INF/views/fragment/nav.jsp"%>

<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value='/c/fonts/icomoon/style.css'/>">
<link rel="stylesheet"
	href="<c:url value='/c/css/owl.carousel.min.css'/>">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">	
	
<script src="<c:url value='/c/js/jquery-3.3.1.min.js'/>"></script>
<script src="<c:url value='/c/js/popper.min.js'/>"></script>
<script src="<c:url value='/c/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/c/js/main.js'/>"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="<c:url value='/c/css/bootstrap.min.css'/>">
<!-- Style -->
<link rel="stylesheet" href="<c:url value='/c/css/style.css'/>">


<%@ include file="/WEB-INF/views/fragment/head.jsp"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<fmt:setBundle basename="i18n/cause"/>

<div class="content" style="border-bottom: 1px gray solid;">

	<div class="container">
		<div style="border-top: 1px solid gray;">
			<h1 class="mb-5 mt-3"><fmt:message key="CAUSE_lIST"/></h1>
		</div>
		<div class="table-responsive" style="border-top: 1px solid gray">
			<br />
			<table class="table">
				<tr>
					<td align="right">
						<a href='<c:url value="/cause/write"/>'>
								<button type="button" class="btn btn-warning"><fmt:message key="WRITE_CAUSE"/></button>
						</a>
					</td>
				</tr>
			</table>
			<table class="table table-striped custom-table">
				<thead>
					<tr>
						<th scope="col"><fmt:message key="ATTENDANCE_DATE"/></th>
						<th scope="col"><fmt:message key="CAUSE_CONTENT"/></th>
						<th scope="col"><fmt:message key="CAUSE_REASON"/></th>
						<th scope="col"><fmt:message key="PROCESSING_STATUS"/></th>
						<th scope="col"><fmt:message key="APPLY_DATE"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${causeList}" var="causeListDto">
						<tr onclick="DetailList(${causeListDto.causeId})">
							<td class="column2">${causeListDto.attendanceDate}</td>
							<td class="column1">${causeListDto.content}</td>
							<td class="column3">${causeListDto.attendanceStatusString}</td>
							<td class="column4">${causeListDto.causeStatusString}</td>
							<td class="column5">${causeListDto.writeDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="text-center">
			<tag:paging totalPageCount="${totalPageCount}" nowPage="${page}"
				boardType="${boardType}"/>
		</div>
	</div>

	<div class="container">
		<!-- The Modal -->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title"><fmt:message key="REASON_APPIICATION"/></h4>
						<button type="button" class="close close_modal"
							data-dismiss="modal" aria-hidden="true">x</button>
					</div>
					<!-- Modal body -->
					<div class="modal-body">
						<div class="row mb-2">
							<div class="col-6"><fmt:message key="CAUSE_DATE"/></div>
							<div id="cd_date" class="col-6"></div>
						</div>
						<div class="row mb-2">
							<div class="col-6"><fmt:message key="NAME"/></div>
							<div id="cd_name" class="col-6"></div>
						</div>
						<div class="row mb-2">
							<div class="col-6"><fmt:message key="ATTENDANCE_STATUS"/></div>
							<div id="cd_attendance" class="col-6"></div>
						</div>
						<div class="row mb-2">
							<div class="col-6"><fmt:message key="REASON_DETAIL"/></div>
							<div id="cd_category" class="col-6"></div>
						</div>

						<div class="row mb-2">
							<div class="col-6"><fmt:message key="CAUSE_CONTENT"/></div>
							<div id="cd_content" class="col-6"></div>
						</div>

						<div class="row mb-2">
							<div class="col-6"><fmt:message key="PROCESSING_STATUS"/></div>
							<div id="cd_status" class="col-6"></div>
						</div>

						<div class="row">
							<div class="col-6"><fmt:message key="ATTACH"/></div>
							<div class="col-6">
								<div id="cd_file"></div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info" id="updateButton" value="${causeId}"><fmt:message key="UPDATE"/></button>
						<form method="post" action="/cause/delete" id="causeDelete">
							<input type="hidden" id="deleteCause" name="causeId" value="" />
							<button type="button" class="btn btn-info" id="deleteButton" value=""><fmt:message key="DELETE"/></button>
						</form>
						<button type="button" class="btn btn-info close_modal"><fmt:message key="CLOSE"/></button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/fragment/footer.jsp"%>