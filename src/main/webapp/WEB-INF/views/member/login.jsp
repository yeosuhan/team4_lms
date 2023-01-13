<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<title>Login 10</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="<c:url value='/m/css/style.css'/>" rel="stylesheet" />

</head>
<body class="img js-fullheight"
	style="background-image: url(<c:url value='/m/images/뿌꾸.jpg'/>);">
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section"><a href="/" style="color: #fff">OTI 대학교</a></h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
						<h3 class="mb-4 text-center">로그인 하세요</h3>
						<c:if test="${empty sessionScope.userid}">
							<form action="<c:url value='/member/login'/>" method="post"
								class="form-horizontal">
								<div class="form-group">
									<input type="text" name=memberId class="form-control" placeholder="Username"
										required style="color: #F9F6F1;">
								</div>
								<div class="form-group">
									<input id="password-field" name="password" type="password" class="form-control"
										placeholder="Password" required style="color: #F9F6F1;">
									<span toggle="#password-field"
										class="fa fa-fw fa-eye field-icon toggle-password"></span>
								</div>
								<div class="form-group">
									<button type="submit" class="form-control btn submit px-3"
										style="background-color: #F9F6F1;">LogIn</button>
								</div>
							</form>
						</c:if>
						<form>
							<div class="form-group d-md-flex">
								<div class="w-50">
									<label class="checkbox-wrap checkbox-primary">Remember
										Me <input type="checkbox" checked> <span
										class="checkmark"></span>
									</label>
								</div>
								<div class="w-50 text-md-right">
									<a href="/" style="color: #fff">Home</a>
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="<c:url value='/m/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/m/js/popper.js'/>"></script>
	<script src="<c:url value='/m/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/m/js/main.js'/>"></script>

</body>
</html>
