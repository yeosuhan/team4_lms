<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/fragment/head.jsp"%>
<%@ include file="/WEB-INF/views/fragment/nav.jsp"%>

<div class="container" style="margin-top: 100px;">

	<c:if test="${checkin == false}">
		<form action="/attendance/checkin" method="POST">
			<button type="submit" class="btn btn-primary"
				style="width: 300px; height: 80px; align-content: center;">출석</button>
		</form>
	</c:if>

	<c:if test="${checkout == false}">
		<form action="/attendance/checkout" method="POST">
			<button type="submit" class="btn btn-primary"
				style="width: 300px; height: 80px; align-content: center;">퇴근</button>
		</form>
	</c:if>

	<form action="/attendance/out" method="POST">
		<button type="submit" class="btn btn-primary"
			style="width: 300px; height: 80px; align-content: center;">외출</button>
	</form>

	<form action="/attendance/out" method="POST">
		<button type="submit" class="btn btn-primary"
			style="width: 300px; height: 80px; align-content: center;">복귀</button>
	</form>

	<div id='calendar'></div>
</div>

<%@ include file="/WEB-INF/views/fragment/footer.jsp"%>

