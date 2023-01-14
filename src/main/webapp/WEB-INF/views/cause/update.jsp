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
		<form action="<c:url value='/cause/update'/>" method="post"  enctype="multipart/form-data" id="wizard">
			<div class="inner">
				<div class="image-holder">
					<!-- <img src="cause_detail/images/form-wizard-1.jpg" alt="">  -->
					<img src="" id="previwew" style="width: 100px; height: 200px">
				</div>
				<div class="form-content">
					<div class="form-header">
						<h3>사유서 수정</h3>
					</div>
					<div class="form-row">
						<div class="form-holder">출석 유형</div>
						
						<div class="form-holder">
							${list.attendanceStatusString}
						</div>
					</div>
					<div class="form-row">
						<div class="form-holder">세부 유형</div>
						<div class="form-holder">
							${list.categoryString}
						</div>
					</div>
					<div class="form-row">
						<div class="form-holder">날짜</div>
						<div class="form-holder">
							${list.attendanceDate}
						</div>
					</div>
					<div class="form-row">
						<div class="form-holder">이름</div>
						<div class="form-holder">${sessionScope.membername}</div>
					</div>
					<div class="form-row">
						<div class="form-holder">내용</div>
						<div class="form-holder">
							<textarea maxlength="300" class="form-control" 
								style="resize: none; height: 70px" name="content" placeholder="${list.content}">${list.content}</textarea>
						</div>
					</div>
					<div class="form-row">
						<div class="form-holder">첨부파일</div>
						<div class="form-holder">
							<input type="file" name="file" /> 기존파일: ${list.fileName}
						</div>
					</div>
					<input type="hidden" name="causeId" value="${list.causeId}"/>
					<input type="hidden" name="fileName" value="${list.fileName}"/>
					<input type="hidden" name="fileContentType" value="${list.fileContentType}"/>
					<input type="hidden" name="fileSize" value="${list.fileSize}"/>
					<input type="hidden" name="fileData" value="${list.fileData}"/>
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
