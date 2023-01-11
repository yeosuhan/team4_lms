<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #A8A8A8}

.dropdown:hover .dropdown-content {
  display: block;
}

.dropdown:hover .button {
  background-color: #3e8e41;
}
</style>

<!-- head 닫힘 -->
</head>
<!--  nav 바 -->
<body id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav"
		style="background-color: black;">
		<div class="container">
			<a class="navbar-brand" <c:choose>
					<c:when test="${sessionScope.memberid eq 'admin'}">href="/admin/main"</c:when>
					<c:otherwise>href="/attendance/main"</c:otherwise>
				</c:choose>>			
			<img
				src="/images/logo/OTIUniversity.png" style="width: 100px" /></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars ms-1"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
					<c:choose>
						<c:when test="${sessionScope.memberid  eq 'admin'}">
							<li class="nav-item"><a class="nav-link"
								href="/cause/admin/list/1">사유서 관리</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link"
								href="/cause/list/1">사유서 관리</a></li>
						</c:otherwise>
					</c:choose>
					<li class="nav-item"><a class="nav-link"
						href="/board/list/community">커뮤니티</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/board/list/reference">자료실</a></li>
					<c:choose>
						<c:when test="${sessionScope.memberid  == null}">
							<li class="nav-item"><a class="nav-link"
								href="/member/login">로그인</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item">								
								<div class="dropdown">
								  <button type="button" class="btn btn-dark dropdown-toggle">${sessionScope.membername}님</button>
								  <div class="dropdown-content">
								  	  <a class="dropdown-item" href="/member/logout">로그아웃</a>
								  </div>
								</div>
							</li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</div>
	</nav>