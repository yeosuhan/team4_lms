<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/fragment/head.jsp" %>
<%@ include file="/WEB-INF/views/fragment/nav.jsp" %>
<fmt:setBundle basename="i18n/cause"/>
<meta name="author" content="colorlib.com">


<!-- MATERIAL DESIGN ICONIC FONT -->
<link rel="stylesheet"
	href='<c:url value="/cd/fonts/material-design-iconic-font/css/material-design-iconic-font.css"/>'>

<!-- STYLE CSS -->
<link rel="stylesheet" href='<c:url value="/cd/css/style.css"/>'>
<link rel="stylesheet" href='<c:url value="/cd/css/style.css.map"/>'>
<link rel="stylesheet" href='<c:url value="/cd/css/style.scss"/>'>

<style>

.form-row2 {
position:relative;
	width:80%;
	margin:20px auto;
	padding-left:120px;
	box-sizing:border-box;
}

.form-row2 .form-holder select{width:70%;}
.form-row2 .form-holder.form-tit{position:absolute; left:0; top:0; width:100px;}
.form-row2:after{content:""; display:block; clear:both;} 
</style>
</head>
<body>
	<div class="wrapper_2" style="padding:200px 0 100px;">
		<form action="<c:url value='/cause/write'/>" method="post"  enctype="multipart/form-data" id="wizard" style="width:800px; margin:0 auto;">
			<div class="inner" style="padding:40px 30px; display: block;">
				<div class="form-content2">
					<div class="form-header">
						<h3><fmt:message key="WRITE_CAUSE"/></h3>
					</div>
					<div class="form-row2">
						<div class="form-holder form-tit"><fmt:message key="ATTENDANCE_STATUS"/></div>
						<div class="form-holder">
							<c:choose>
								<c:when test="${attendanceId != 0}">
									<input type="hidden" name="attendanceStatus" value="${dateAndCategory.attendanceStatus}"/>
									<c:choose>
										<c:when test="${dateAndCategory.attendanceStatus} == 0">
											<div class="form-holder"><fmt:message key="ABSENT"/></div>
										</c:when>
										<c:when test="${dateAndCategory.attendanceStatus} == 2">
											<div class="form-holder"><fmt:message key="TARDY"/></div>
										</c:when>
										<c:otherwise>
											<div class="form-holder"><fmt:message key="LEAVE_EARLY"/></div>
										</c:otherwise>
									</c:choose>
									
								</c:when>
								<c:otherwise>
									<select name="attendanceStatus">
										<option value="0" selected><fmt:message key="ABSENT"/></option>
										<option value="2"><fmt:message key="TARDY"/></option>
										<option value="3"><fmt:message key="LEAVE_EARLY"/></option>
									</select>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-row2">
						<div class="form-holder form-tit"><fmt:message key="REASON_DETAIL"/></div>
						<div class="form-holder">
							<select name="categoryId">
								<c:forEach var="category" items="${categoryList}">
									<option value="${category.categoryId}" id="categoryId">${category.categoryName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-row2">
						<div class="form-holder form-tit"><fmt:message key="CAUSE_DATE"/></div>
						<div class="form-holder">
							<c:choose>
								<c:when test="${attendanceId != 0}">
									<input type="text" name="attendanceDate" style="border: none" readonly value="<fmt:formatDate pattern="yyyy-MM-dd" value="${dateAndCategory.attendanceDate}"/>"/>
								</c:when>
								<c:otherwise>
									<input type="date" name="attendanceDate" class="form-control" style="width: 80%" required/>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-row2">
						<div class="form-holder form-tit"><fmt:message key="NAME"/></div>
						<div class="form-holder">${sessionScope.membername}</div>
					</div>
					<div class="form-row2">
						<div class="form-holder form-tit"><fmt:message key="CAUSE_CONTENT"/></div>
						<div class="form-holder">
							<textarea name="content" maxlength="300" class="form-control" style="resize: none; height: 70px" required></textarea>
						</div>
					</div>
					<div class="form-row2">
						<div class="form-holder form-tit"><fmt:message key="ATTACH"/></div>
						<div class="form-holder">
							<input type="file" name="file" id="file"/>
							<div class="image-holder2">
								<div>
									<img id="preview"/>
								</div>
							</div>
						</div>
					</div>
					<div class="form-row2 text-center pl-2">
						<input type="hidden" name="memberId" value="${sessionScope.memberid}"/>
						<input type="hidden" name="attendanceId" value="${attendanceId}"/>
						<input type="submit" class="btn btn-warning" value="<fmt:message key="SUBMIT"/>"/>
					</div>
				</div>
			</div>
		</form>
	</div>

	<!-- JQUERY -->
	<script src="/cd/js/jquery-3.3.1.min.js"></script>
	<!-- JQUERY STEP -->
	<script src="/cd/js/main.js"></script>
	<!-- Template created and distributed by Colorlib -->

<%@ include file="/WEB-INF/views/fragment/footer.jsp"%>

