<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/fragment/head.jsp" %>
<style>
	*{
		border: 1px solid black;
	}
	.wrapper{
		width: 100%;
		background-color: #F9F6F1;
	}
</style>
<%@ include file="/WEB-INF/views/fragment/nav.jsp" %>
		
		
	<!-- 여기서 우리의 코드 알아서 ` -->
	<div>
		<div class="wrapper">
			<p>관리자 페이지임</p>
			<div>
				<button>Java</button>
			</div>
			<div>
				<button>Python</button>
			</div>
			<div>
				<button>Computer Science</button>
			</div>
		</div>	
	</div>
		
<%@ include file="/WEB-INF/views/fragment/footer.jsp" %>