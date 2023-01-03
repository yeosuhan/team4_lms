<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>사유서 상세보기</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="author" content="colorlib.com">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="cause_detail/fonts/material-design-iconic-font/css/material-design-iconic-font.css">

		<!-- STYLE CSS -->
		<link rel="stylesheet" href="cause_detail/css/style.css">
	</head>
	<body>
		<div class="wrapper">
            <form action="" id="wizard">
        		<!-- SECTION 1 -->
                <h2></h2>
                <section>
                    <div class="inner">
                  		<!--   첫번째 작성중 화면 -->
						<div class="image-holder">
							<!-- <img src="cause_detail/images/form-wizard-1.jpg" alt="">  -->
							<img src="" id="previwew" style="width: 100px; height: 200px">
						</div>
						<div class="form-content" >
							<div class="form-header">
								<h3>사유서 신청</h3>
							</div>				
							
							<div class="form-row">
								<div class="form-holder">
									출석 유형
								</div>
								<div class="select">
									<div class="form-holder">
										<div class="select-control">선택하세요</div>
										<i class="zmdi zmdi-caret-down"></i>
									</div>
									<ul class="dropdown">
										<li rel="결석">결석</li>
										<li rel="조회">조퇴</li>
										<li rel="지각">지각</li>
									</ul>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									세부 유형
								</div>
								
								<div class="select">
									<div class="form-holder">
										<div class="select-control">선택하세요</div>
										<i class="zmdi zmdi-caret-down"></i>
									</div>
									<ul class="dropdown">
				<!-- <li rel=${category.categoryName} value="${category.categoryId}">${category.categoryName}</li> -->
										<li rel="병원">병원</li>
										<li rel="경조사">경조사</li>
										<li rel="공가">공가</li>
										<li rel="지하철연착">지하철연착</li>
										<li rel="기타" value="">기타</li>
									</ul>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									날짜
								</div>
								<div class="form-holder">
									<input type="date" class="form-control"/>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									이름
								</div>
								<div class="form-holder">
									뿌꾸
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									내용
								</div>
								<div class="form-holder">
									<textarea name="cause_content" maxlength="300" class="form-control" style=" resize: none; height: 70px"></textarea>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									첨부파일
								</div>
								<div class="form-holder">
									 <input type="file" id="cause_file" name="cause_detail_file"/>
								</div>
							</div>			
						</div>
					</div>
                </section>

				<!-- SECTION 2 -->
                <h2></h2>
                <section>
                    <div class="inner">
						<div class="image-holder">
							<img src="cause_detail/images/form-wizard-2.jpg" alt="">
						</div>
						<div class="form-content">
							<div class="form-header">
								<h3>등록 대기중</h3>
							</div>
							<p>Please fill with additional info</p>
							<div class="form-row">
								<div class="form-holder w-100">
									<input type="text" placeholder="Address" class="form-control">
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									<input type="text" placeholder="City" class="form-control">
								</div>
								<div class="form-holder">
									<input type="text" placeholder="Zip Code" class="form-control">
								</div>
							</div>

							<div class="form-row">
								<div class="select">
									<div class="form-holder">
										<div class="select-control">Your country</div>
										<i class="zmdi zmdi-caret-down"></i>
									</div>
									<ul class="dropdown">
										<li rel="United States">United States</li>
										<li rel="United Kingdom">United Kingdom</li>
										<li rel="Viet Nam">Viet Nam</li>
									</ul>
								</div>
								<div class="form-holder"></div>
							</div>
						</div>
					</div>
                </section>

                <!-- SECTION 3 -->
                <h2></h2>
                <section>
                    <div class="inner">
						<div class="image-holder">
							<img src="cause_detail/images/form-wizard-3.jpg" alt="">
						</div>
						<div class="form-content">
							<div class="form-header">
								<h3>사유서 신청완료</h3>
							</div>
							<p>Send an optional message</p>
							<div class="form-row">
								<div class="form-holder w-100">
									<textarea name="" id="" placeholder="Your messagere here!" class="form-control" style="height: 99px;"></textarea>
								</div>
							</div>
							<div class="checkbox-circle mt-24">
								<label>
									<input type="checkbox" checked>  Please accept <a href="#">terms and conditions ?</a>
									<span class="checkmark"></span>
								</label>
							</div>
						</div>
					</div>
                </section>
            </form>
		</div>

		<!-- JQUERY -->
		<script src="cause_detail/js/jquery-3.3.1.min.js"></script>

		<!-- JQUERY STEP -->
		<script src="cause_detail/js/jquery.steps.js"></script>
		<script src="cause_detail/js/main.js"></script>
		<!-- Template created and distributed by Colorlib -->
</body>
</html>
