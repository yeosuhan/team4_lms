
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/fragment/head.jsp"%>

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


<%@ include file="/WEB-INF/views/fragment/nav.jsp"%>

<header class="masthead" style="border-bottom-color: green;">
	<div class="container">
		<div class="masthead-subheading">Welcome To Our Studio!</div>
		<div class="masthead-heading text-uppercase">It's Nice To Meet
			You...</div>
		<a class="btn btn-primary btn-xl text-uppercase" href="#services">Tell
			Me More</a>
	</div>
</header>

<%@ include file="/WEB-INF/views/fragment/footer.jsp"%>