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
<link rel="stylesheet"
	href="<c:url value='/cal/css/bootstrap.min.css'/>">
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
<style>
.card-div {
	height: 200px;
}
</style>


<%@ include file="/WEB-INF/views/fragment/nav.jsp"%>


<div class="container" style="margin-top: 60px; padding-top: 70px;">
	<div class="row" style="margin-bottom: 30px;">
		<div class="col-sm-5">
			<div class="card" style="border-radius: 20px;">
				<div class="card-body row">
					<div class="col-sm-6">
						<h5 class="card-title">${sessionScope.membername}님</h5>
						<p class="card-text">오늘 하루도 화이팅 :)</p>
					</div>
					<div class="col-sm-6"
						style="display: flex; float: left; justify-content: space-between;">
						<c:if test="${checkin == true}">
							<form action="/attendance/checkin" method="POST">
								<button type="submit" class="btn btn-primary"
									style="background-color: #000069; border-color: #000069">출석</button>
							</form>
						</c:if>
						<c:if test="${checkout == true && goOut == true}">
							<form action="/attendance/checkout" method="POST">
								<button type="submit" class="btn btn-primary"
									style="background-color: #B9062F; border-color: #B9062F">퇴근</button>
							</form>
						</c:if>
						<c:if test="${goOut == true && checkout == true}">
							<form action="/attendance/out" method="POST">
								<button type="submit" class="btn btn-primary">외출</button>
							</form>
						</c:if>
						<c:if
							test="${goOut == false && checkin == false && checkout == true}">
							<form action="/attendance/comback" method="POST">
								<button type="submit" class="btn btn-primary">복귀</button>
							</form>
						</c:if>
						<c:if test="${checkout == true && goOut == true }">
							<form action="/attendance/leave" method="POST">
								<button type="submit" class="btn btn-primary"
									style="background-color: #506EA5; border-color: #506EA5;">조퇴</button>
							</form>
						</c:if>
					</div>

					<div class="row" style="height: 100px; margin-top: 10px;">
						<div class="col-sm-6">
							<h3>출근 시간</h3>
							<h4 style="color: gray">${in}</h4>

						</div>
						<div class="col-sm-6">
							<h3>퇴근 시간</h3>
							<h4 style="color: gray">${out}</h4>
						</div>

					</div>
				</div>

			</div>
		</div>
		<div class="col-sm-4">
			<div class="card" style="border-radius: 20px;">
				<div class="card-body">
					<h4 class="card-title">${statistics.year}년
						${statistics.month}월 출석 통계</h4>
					<p class="card-text">총:
						${statistics.attendance}/${statistics.attendance+statistics.absent+statistics.late+statistics.leave}일
					</p>
					<p class="card-text">출석: ${statistics.attendance}일 | 결석:
						${statistics.absent}일 | 지각: ${statistics.late}일 | 조퇴:
						${statistics.leave}일</p>
					<div class="progress">
						<div
							class="progress-bar progress-bar-striped bg-success progress-bar-animated"
							role="progressbar"
							style="width: ${(statistics.attendance/(statistics.attendance+statistics.absent+statistics.late+statistics.leave))*100}%"
							aria-valuemin="0" aria-valuemax="100">출석</div>
						<div
							class="progress-bar progress-bar-striped bg-danger progress-bar-animated"
							role="progressbar"
							style="width: ${(statistics.absent/(statistics.attendance+statistics.absent+statistics.late+statistics.leave))*100}%"
							aria-valuemin="0" aria-valuemax="100">결석</div>
						<div
							class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
							role="progressbar"
							style="width: ${(statistics.late/(statistics.attendance+statistics.absent+statistics.late+statistics.leave))*100}%"
							aria-valuemin="0" aria-valuemax="100">지각</div>
						<div
							class="progress-bar progress-bar-striped bg-primary progress-bar-animated"
							role="progressbar"
							style="width: ${(statistics.leave/(statistics.attendance+statistics.absent+statistics.late+statistics.leave))*100}%"
							aria-valuemin="0" aria-valuemax="100">조퇴</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="card" style="border-radius: 20px;">
				<div class="card-body">
					<h5 class="card-title">외출 기록</h5>
					<p class="card-text">${outListDto.hours}시간${outListDto.minutes}
						분 ${outListDto.seconds}초</p>
					<div class="row">
						<c:forEach var="outDto" items="${outListDto.outlist}">
							<div class="col-sm-5">${outDto.checkIn}</div>
							<div class="col-sm-2">~</div>
							<div class="col-sm-5">${outDto.checkOut}</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>

		<div id='calendar' style="margin-top: 20px;"></div>
	</div>
</div>

<%@ include file="/WEB-INF/views/fragment/footer.jsp"%>