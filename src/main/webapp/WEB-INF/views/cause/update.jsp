<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/fragment/head.jsp" %>
<%@ include file="/WEB-INF/views/fragment/nav.jsp" %>
<fmt:setBundle basename="i18n/cause"/>

<!-- MATERIAL DESIGN ICONIC FONT -->
<link rel="stylesheet"
	href='<c:url value="/cd/fonts/material-design-iconic-font/css/material-design-iconic-font.css"/>'>

<!-- STYLE CSS -->
<link rel="stylesheet" href='<c:url value="/cd/css/style.css"/>'>
<link rel="stylesheet" href='<c:url value="/cd/css/style.css.map"/>'>
<link rel="stylesheet" href='<c:url value="/cd/css/style.scss"/>'>

<style>
.form-row2 {
	position: relative;
	width: 80%;
	margin: 20px auto;
	padding-left: 120px;
	box-sizing: border-box;
}

.form-row2 .form-holder select {
	width: 70%;
}

.form-row2 .form-holder.form-tit {
	position: absolute;
	left: 0;
	top: 0;
	width: 100px;
}

.form-row2:after {
	content: "";
	display: block;
	clear: both;
}
</style>

</head>
<body>
	<div class="wrapper_2" style="padding:200px 0 100px;">
		<form action="<c:url value='/cause/update'/>" method="post"
			enctype="multipart/form-data" id="wizard" style="width:800px; margin:0 auto;">
			<div class="inner" style="padding:40px 30px; display: block;">
				<div class="form-content2">
					<div class="form-header">
						<h3>사유서 수정</h3>
					</div>
					<div class="form-row2">
						<div class="form-holder form-tit"><fmt:message key="ATTENDANCE_STATUS"/></div>

						<div class="form-holder">${list.attendanceStatusString}</div>
					</div>
					<div class="form-row2">
						<div class="form-holder form-tit"><fmt:message key="REASON_DETAIL"/></div>
						<div class="form-holder">${list.categoryString}</div>
					</div>
					<div class="form-row2">
						<div class="form-holder form-tit"><fmt:message key="CAUSE_DATE"/></div>
						<div class="form-holder">${list.attendanceDate}</div>
					</div>
					<div class="form-row2">
						<div class="form-holder form-tit"><fmt:message key="NAME"/></div>
						<div class="form-holder">${sessionScope.membername}</div>
					</div>
					<div class="form-row2">
						<div class="form-holder form-tit"><fmt:message key="CAUSE_CONTENT"/></div>
						<div class="form-holder">
							<textarea maxlength="300" class="form-control"
								style="resize: none; height: 70px" name="content"
								placeholder="${list.content}">${list.content}</textarea>
						</div>
					</div>
					<div class="form-row2">
						<div class="form-holder form-tit"><fmt:message key="ATTACH"/></div>
						<div class="image-holder2">
							<div class="form-holder">
								<input type="file" name="file" id="file"/>
								
								<div class="image-holder2">
								 기존파일: ${list.fileName}
									<div>
										<img id="preview"/>
									</div>
								</div>
							</div>
						</div>
					</div>
					<input type="hidden" name="causeId" value="${list.causeId}" /> 
					<input type="hidden" name="fileName" value="${list.fileName}" /> 
					<input type="hidden" name="fileContentType" value="${list.fileContentType}" /> 
					<input type="hidden" name="fileSize" value="${list.fileSize}" /> 
					<input type="hidden" name="fileData" value="${list.fileData}" /> 
					
				</div>
				<div class="text-center">
					<input type="submit" class="btn btn-warning" value="<fmt:message key="SUBMIT"/>"/>
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
