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

	<div class="row">
		<div class="col-sm-5">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">00시간 00분 00초 근무 중</h5>
					<p class="card-text">With supporting text below as a natural
						lead-in to additional content.</p>
					<div class="row" style="background-color: green; height: 100px;">
						<div class="col-sm-6" style="background-color: yellow;">
							<%-- 					<c:if test="${checkin == false}"> --%>
							<form action="/attendance/checkin" method="POST">
								<button type="submit" class="btn btn-primary"align-content:center;">출석</button>
							</form>
							<%-- 					</c:if> --%>

							<%-- 					<c:if test="${checkout == false}"> --%>
												<form action="/attendance/checkout" method="POST">
													<button type="submit" class="btn btn-primary"align-content:center;">퇴근</button>
												</form>
							<%-- 					</c:if> --%>

						</div>
						<div class="col-sm-6" style="background-color: red;"></div>
					</div>

				</div>
			</div>
		</div>
		<div class="col-sm-2"></div>
		<div class="col-sm-5">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">외출 기록</h5>
					<p class="card-text">With supporting text below as a natural
						lead-in to additional content.</p>
					<div class="row" style="background-color: green; height: 100px;">
						<div class="col-sm-6" style="background-color: yellow;">							
							<form action="" method="POST">
								<button type="submit" class="btn btn-primary"align-content:center;">외출</button>
							</form>
							<form action="" method="POST">
								<button type="submit" class="btn btn-primary"align-content:center;">복귀</button>
							</form>
							<form action="/attendance/out" method="POST">
								<button type="submit" class="btn btn-primary"align-content:center;">조퇴</button>
							</form>
						</div>
						<div class="col-sm-6" style="background-color: red;"></div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<div id='calendar' style="margin-top: 20px;"></div>
</div>

<%@ include file="/WEB-INF/views/fragment/footer.jsp"%>
