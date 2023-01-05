<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <%@ include file="/WEB-INF/views/fragment/head.jsp" %>
 <%@ include file="/WEB-INF/views/fragment/nav.jsp" %>

	<div class="container" style="margin-top: 100px;">
	
<!-- 	<button type="button" onclick="location.href='/attendance/in'">목록</button> -->
	
		<button type="button"  onclick="location.href='/attendance/in'" class="btn btn-primary" style="width: 300px; height: 80px; align-content: center;">출석</button>
		<button type="button" class="btn btn-primary" style="width: 300px; height: 80px; align-content: center;">퇴근</button>

	    <div id='calendar'></div>
    </div>
    
<%@ include file="/WEB-INF/views/fragment/footer.jsp" %>

