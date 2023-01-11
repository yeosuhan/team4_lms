<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>사유서 상세보기</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="colorlib.com">


<!-- MATERIAL DESIGN ICONIC FONT -->
<link rel="stylesheet"
	href='<c:url value="/cd/fonts/material-design-iconic-font/css/material-design-iconic-font.css"/>'>

<!-- STYLE CSS -->
<link rel="stylesheet" href='<c:url value="/cd/css/style.css"/>'>
<link rel="stylesheet" href='<c:url value="/cd/css/style.css.map"/>'>
<link rel="stylesheet" href='<c:url value="/cd/css/style.scss"/>'>

</head>
<body>
	<div class="wrapper">
		<form action="<c:url value='/cause/write'/>" method="post"  enctype="multipart/form-data" id="wizard">
			<div class="inner">
				<div class="image-holder">
					<!-- <img src="cause_detail/images/form-wizard-1.jpg" alt="">  -->
					<img src="" id="previwew" style="width: 100px; height: 200px">
				</div>
				<div class="form-content">
					<div class="form-header">
						<h3>사유서 신청</h3>
					</div>
					<div class="form-row">
						<div class="form-holder">출석 유형</div>
						<div class="form-holder">
							<c:choose>
								<c:when test="${attendanceId != 0}">
									<input type="text" name="attendanceStatus" value="${dateAndCategory.attendanceStatus}"/>
								</c:when>
								<c:otherwise>
									<select name="attendanceStatus">
										<option value="0">결석</option>
										<option value="2">지각</option>
										<option value="3">조퇴</option>
									</select>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-row">
						<div class="form-holder">세부 유형</div>
						<div class="form-holder">
							<select name="categoryId">
								<c:forEach var="category" items="${categoryList}">
									<option value="${category.categoryId}" id="categoryId">${category.categoryName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-row">
						<div class="form-holder">날짜</div>
						<div class="form-holder">
							<c:choose>
								<c:when test="${attendanceId != 0}">
									<input type="text" name="attendanceDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${dateAndCategory.attendanceDate}"/>"/>
								</c:when>
								<c:otherwise>
									<input type="date" name="attendanceDate" class="form-control" />
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-row">
						<div class="form-holder">이름</div>
						<div class="form-holder">${sessionScope.membername}</div>
					</div>
					<div class="form-row">
						<div class="form-holder">내용</div>
						<div class="form-holder">
							<textarea name="content" maxlength="300"
								class="form-control" style="resize: none; height: 70px"></textarea>
						</div>
					</div>
					<div class="form-row">
						<div class="form-holder">첨부파일</div>
						<div class="form-holder">
							<input type="file" name="file" />
						</div>
					</div>
					<input type="hidden" name="memberId" value="${sessionScope.memberid}"/>
					<input type="hidden" name="attendanceId" value="${attendanceId}"/>
					<input type="submit" value="제출하기"/>
				</div>
			</div>
		</form>
	</div>

	<!-- JQUERY -->
	<script src="/cd/js/jquery-3.3.1.min.js"></script>
	<!-- JQUERY STEP -->
	<script src="/cd/js/main.js"></script>
	<!-- Template created and distributed by Colorlib -->
</body>
</html>
