<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/fragment/nav.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>뿌꾸 대학교 lms</title>
<!-- home -->
<link rel="icon" type="image/x-icon"
	href="<c:url value='/h/assets/favicon.ico'/>" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value='/h/css/styles.css'/>" rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="<c:url value='/h/js/scripts.js'/>"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="<c:url value='/ld/css/style.css'/>" />
<script src="<c:url value='/ld/js/jquery.min.js'/>" /></script>
<script src="<c:url value='/ld/js/popper.js'/>" /></script>
<script src="<c:url value='/ld/js/bootstrap.min.js'/>" /></script>
<script src="<c:url value='/ld/js/main.js'/>" /></script>
<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5"
					style="background-color: skyblue; border-radius: 30px;">
					<h1 class="heading-section">${lectureName}</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="content w-100">
						<div class="calendar-container">
							<div class="calendar">
								<div class="year-header">
									<span class="left-button fa fa-chevron-left" id="prev">
									</span> <span class="year" id="label"></span> <span
										class="right-button fa fa-chevron-right" id="next"> </span>
								</div>
								<table class="months-table w-100">
									<tbody>
										<tr class="months-row">
											<td class="month">Jan</td>
											<td class="month">Feb</td>
											<td class="month">Mar</td>
											<td class="month">Apr</td>
											<td class="month">May</td>
											<td class="month">Jun</td>
											<td class="month">Jul</td>
											<td class="month">Aug</td>
											<td class="month">Sep</td>
											<td class="month">Oct</td>
											<td class="month">Nov</td>
											<td class="month">Dec</td>
										</tr>
									</tbody>
								</table>

								<table class="days-table w-100">
									<tr>
										<td class="day">Sun</td>
										<td class="day">Mon</td>
										<td class="day">Tue</td>
										<td class="day">Wed</td>
										<td class="day">Thu</td>
										<td class="day">Fri</td>
										<td class="day">Sat</td>
									</tr>
								</table>
								<div class="frame">
									<table class="dates-table w-100">
										<tbody class="tbody">
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="events-container">
							<!-- 여기에 출석 테이블 들어감 -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</head>
</html>
	<%@ include file="/WEB-INF/views/fragment/footer.jsp"%>