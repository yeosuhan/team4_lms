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
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="<c:url value='/cal/css/bootstrap.min.css'/>">
<!-- Style -->
<link rel="stylesheet" href="<c:url value='/cal/css/style.css'/>">

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

	<div class="row">
		<div class="col-sm-5">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">00시간 00분 00초 근무 중</h5>
					<p class="card-text">With supporting text below as a natural
						lead-in to additional content.</p>
					<div class="row" style="background-color: green; height: 100px;">
						<div class="col-sm-6" style="background-color: yellow;">
							<c:if test="${checkin == true}">
								<form action="/attendance/checkin" method="POST">
									<button type="submit" class="btn btn-primary">출석</button>
								</form>
							</c:if>

							<c:if test="${checkout == true}">
								<form action="/attendance/checkout" method="POST">
									<button type="submit" class="btn btn-primary">퇴근</button>
								</form>
							</c:if>

						</div>
						<div class="col-sm-6" style="background-color: red;"></div>
					</div>

				</div>
			</div>
		</div>
		<div class="col-sm-5">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">${statistics.year}년  ${statistics.month}월 출석 통계</h4>
					<p class="card-text">총: ${statistics.attendance}/${statistics.attendance+statistics.absent+statistics.late+statistics.leave}일 </p>
					<p class="card-text">출석: ${statistics.attendance}일 / 결석: ${statistics.absent}일 / 지각: ${statistics.late}일  / 조퇴: ${statistics.leave}일</p>
				</div>
			</div>
		</div>
		<div class="col-sm-5">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">외출 기록</h5>
					<p class="card-text">${outListDto.hours}시간
						${outListDto.minutes} 분 ${outListDto.seconds}초</p>
					<div class="row" style="background-color: green; height: 100px;">
						<div class="col-sm-6" style="background-color: yellow;">
							<c:if test="${goOut == true && checkout == true}">
								<form action="/attendance/out" method="POST">
									<button type="submit" class="btn btn-primary">외출</button>
								</form>
							</c:if>
							<c:if test="${goOut == false && checkout == true}">
								<form action="/attendance/comback" method="POST">
									<button type="submit" class="btn btn-primary">복귀</button>
								</form>
							</c:if>
							<c:if test="${checkout == true}">
								<form action="/attendance/leave" method="POST">
									<button type="submit" class="btn btn-primary">조퇴</button>
								</form>
							</c:if>
						</div>
						<div class="col-sm-6" style="background-color: red;">
							<c:forEach var="outDto" items="${outListDto.outlist}">
								<div>외출시간 : ${outDto.checkIn} 복귀시간 : ${outDto.checkOut}</div>

							</c:forEach>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<div id='calendar' style="margin-top: 20px;"></div>
</div>

<%@ include file="/WEB-INF/views/fragment/footer.jsp"%>

