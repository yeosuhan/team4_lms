<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/fragment/head.jsp"%>
<%@ include file="/WEB-INF/views/fragment/nav.jsp"%>


<div class="container" style="margin-top: 100px;">

	<div class="row">
		<div class="col-sm-5">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">00시간 00분 00초 근무 중</h5>
					<p class="card-text">With supporting text below as a natural
						lead-in to additional content.</p>
					<div class="row" style="background-color: green; height: 100px;">
						<div class="col-sm-6" style="background-color: yellow;">
							<%-- 					<c:if test="${checkin == false}"> --%>
							<form action="/attendance/checkin" method="POST">
								<button type="submit" class="btn btn-primary"align-content:center;">출석</button>
							</form>
							<%-- 					</c:if> --%>

							<%-- 					<c:if test="${checkout == false}"> --%>
												<form action="/attendance/checkout" method="POST">
													<button type="submit" class="btn btn-primary"align-content:center;">퇴근</button>
												</form>
							<%-- 					</c:if> --%>

						</div>
						<div class="col-sm-6" style="background-color: red;"></div>
					</div>

				</div>
			</div>
		</div>
		<div class="col-sm-2"></div>
		<div class="col-sm-5">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">외출 기록</h5>
					<p class="card-text">With supporting text below as a natural
						lead-in to additional content.</p>
					<div class="row" style="background-color: green; height: 100px;">
						<div class="col-sm-6" style="background-color: yellow;">							
							<form action="/attendance/out" method="POST">
								<button type="submit" class="btn btn-primary"align-content:center;">외출</button>
							</form>
							<form action="/attendance/out" method="POST">
								<button type="submit" class="btn btn-primary"align-content:center;">복귀</button>
							</form>
						</div>
						<div class="col-sm-6" style="background-color: red;"></div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<div id='calendar' style="margin-top: 20px;"></div>
</div>

<%@ include file="/WEB-INF/views/fragment/footer.jsp"%>

