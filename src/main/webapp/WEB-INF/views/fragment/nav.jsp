<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 <!-- head 닫힘 -->
</head>
<!--  nav 바 -->
	<body id="page-top">
	        <!-- Navigation-->
	        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav" style="    background-color: black;">
	            <div class="container">
	                <a class="navbar-brand" href="/attendance/main"><img src="/images/logo/OTIUniversity.png" style="width: 100px"/></a>
	                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	                    Menu
	                    <i class="fas fa-bars ms-1"></i>
	                </button>
	                <div class="collapse navbar-collapse" id="navbarResponsive">
	                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
	                        <li class="nav-item"><a class="nav-link" href="/cause/list/1">사유서 관리</a></li>
	                        <li class="nav-item"><a class="nav-link" href="/board/list/community">커뮤니티</a></li>
	                        <li class="nav-item"><a class="nav-link" href="/board/list/reference">자료실</a></li>
	                        <li class="nav-item"><a class="nav-link" href="/member/login">로그인</a></li>
	                        <li class="nav-item"><a class="nav-link" href="<c:url value='/member/logout'/>">로그아웃</a></li>
	                    </ul>
	                </div>
	            </div>
	        </nav>
