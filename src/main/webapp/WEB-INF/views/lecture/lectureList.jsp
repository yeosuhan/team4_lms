<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/fragment/head.jsp"%>
<%@ include file="/WEB-INF/views/fragment/nav.jsp"%>
<div class="content" style="border-bottom: 1px gray solid;">
	<div class="container" style="margin-top:103px;">
		<div class="row justify-content-center">
			<c:forEach var="lecture" items="${lectureList}">
			<form action="<c:url value='/lecture/${lecture.lectureId}'/>" method="post"	class="form-horizontal" style="width:100%;">
				<button type="submit" class="btn mb-1" style="background-color:#F9F6F1; width:100%;">${lecture.lectureName}</button>
			</form>
			</c:forEach>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/fragment/footer.jsp"%>