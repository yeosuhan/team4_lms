<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/fragment/head.jsp"%>
<!--  calendar 관련 resources-->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value='cd/fonts/icomoon/style.css'/>" />
<link href="<c:url value='/cal/fullcalendar/packages/core/main.css'/>"
	rel="stylesheet" />
<link href="<c:url value='cal/fullcalendar/packages/daygrid/main.css'/>"
	rel="stylesheet" />

<script src="<c:url value='/cal/js/jquery-3.3.1.min.js'/>"></script>
<script src="<c:url value='/cal/js/popper.min.js'/>"></script>
<script src="<c:url value='/cal/js/bootstrap.min.js'/>"></script>

<script src="<c:url value='/cal/fullcalendar/packages/core/main.js'/>"></script>
<script
	src="<c:url value='/cal/fullcalendar/packages/interaction/main.js'/>"></script>
<script
	src="<c:url value='/cal/fullcalendar/packages/daygrid/main.js'/>"></script>
<script src="<c:url value='/cal/js/main.js'/>"></script>
<script src="<c:url value='/cal/js/calendar.js'/>"></script>
<%@ include file="/WEB-INF/views/fragment/nav.jsp"%>


<div class="container" style="margin-top: 100px;">

	<div class="row" style="margin-bottom: 30px;">
		<div class="col-sm-5">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">${sessionScope.membername}님</h5>
					<p class="card-text">오늘 하루도 화이팅 :)</p>
					<div class="row" style=" height: 100px;">
						<div class="col-sm-6">
							<h3>출근 시간</h3>
							<p>${in}</p>
							
						</div>
						<div class="col-sm-6">
							<h3>퇴근 시간</h3>
							<p>${out}</p>
						</div>
						<div style="display: flex; float: left; justify-content: space-between;	">
						<%-- 							<c:if test="${checkin == true}"> --%>
							<form action="/attendance/checkin" method="POST">
								<button type="submit" class="btn btn-primary">출석</button>
							</form>
							<%-- 							</c:if> --%>

							<%-- 							<c:if test="${checkout == true}"> --%>
							<form action="/attendance/checkout" method="POST">
								<button type="submit" class="btn btn-primary">퇴근</button>
							</form>
							<%-- 							</c:if> --%>
							<%-- 							<c:if test="${goOut == true && checkout == true}"> --%>
							<form action="/attendance/out" method="POST">
								<button type="submit" class="btn btn-primary">외출</button>
							</form>
							<%-- 							</c:if> --%>
							<%-- 							<c:if test="${goOut == false && checkout == true}"> --%>
							<form action="/attendance/comback" method="POST">
								<button type="submit" class="btn btn-primary">복귀</button>
							</form>
							<%-- 							</c:if> --%>
							<%-- 							<c:if test="${checkout == true}"> --%>
							<form action="/attendance/leave" method="POST">
								<button type="submit" class="btn btn-primary">조퇴</button>
							</form>
							<%-- 							</c:if> --%></div>
					</div>

				</div>
			</div>
		</div>
		<div class="col-sm-4"></div>
		<div class="col-sm-3">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">외출 기록</h5>
					<p class="card-text">${outListDto.hours}시간
						${outListDto.minutes} 분 ${outListDto.seconds}초</p>
					<div class="row">
						<div >
							<c:forEach var="outDto" items="${outListDto.outlist}">
								<div>${outDto.checkIn}   -   ${outDto.checkOut}</div>

							</c:forEach>
					</div>

				</div>
			</div>
		</div>
	</div>

	<div id='calendar' style="margin-top: 20px;"></div>
</div>

<%@ include file="/WEB-INF/views/fragment/footer.jsp"%>

