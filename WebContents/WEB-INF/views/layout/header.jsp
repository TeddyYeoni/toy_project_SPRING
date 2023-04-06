<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="auth" value="${sessionScope.auth}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
	const contextPath = "${contextPath}";
	let auth = {
		id : "${auth.id}",
		grade : "${auth.grade}"
	};
</script>
<script src="${contextPath}/resources/js/common.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
</head>

<style>
.navbar {
	width: auto;
	height: auto;
	background-image: url('${contextPath}/resources/img/moon.jpg');
	background-size: cover;
}

.navbar-nav {
	align-items: center;
	display: flex;
	margin: 0 auto;
	flex-direction: row;
	justify-content: center;
}

body {
	font-family: 'DungGeunMo';
}
</style>

<body>
	<div class="topBar">
		<nav class="navbar navbar-expand-sm">
			<!-- Brand/logo -->
			<a class="navbar-brand font-weight-bold text-light mx-5"
				href="${contextPath}/main">
				<h1>MY ONLY UNIVERSE🚀</h1>
			</a>
			<!-- Links -->
			<ul class="navbar-nav justify-content-center my-2">
				<c:if test="${not empty auth.id}">
					<li class="nav-item"><a
						class="nav-link font-weight-bold text-light mx-4"
						href="${contextPath}/todo"><h3>To Do List</h3></a></li>
					<li class="nav-item"><a
						class="nav-link font-weight-bold text-light mx-4"
						href="${contextPath}/album"><h3>Album</h3></a></li>
					<li class="nav-item"><a
						class="nav-link font-weight-bold text-light mx-4"
						href="${contextPath}/diary"><h3>Diary</h3></a></li>
				</c:if>
				<c:if test="${empty auth.id}">
					<li class="nav-item emptyId"><a
						class="nav-link font-weight-bold text-light mx-4" href="#"><h3>To
								Do List</h3></a></li>
					<li class="nav-item emptyId"><a
						class="nav-link font-weight-bold text-light mx-4" href="#"><h3>Album</h3></a></li>
					<li class="nav-item emptyId"><a
						class="nav-link font-weight-bold text-light mx-4" href="#"><h3>Diary</h3></a></li>
					<!-- The Modal -->
					<div class="modal fade" id="myModal">
						<div class="modal-dialog">
							<div class="modal-content" style="color: black;">

								<!-- Modal Header -->
								<div class="modal-header">
									<h4 class="modal-title">My Only Universe🚀</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>

								<!-- Modal body -->
								<div class="modal-body">로그인 후 이용해 주세요😝</div>

								<!-- Modal footer -->
								<div class="modal-footer">
									<a href="${contextPath}/member/login"
										class="btn btn-info" style="color: white;">Login</a>
									<button type="button" class="btn btn-outline-danger"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<li class="nav-item"><a
					class="nav-link font-weight-bold text-light mx-4"
					href="${contextPath}/board"><h3>Board</h3></a></li>
				<li class="nav-item"><a
					class="nav-link font-weight-bold text-light mx-4"
					href="${contextPath}/qna"><h3>Q&A</h3></a></li>
			</ul>

			<ul class="navbar-nav my-3 ml-auto">
				<c:if test="${empty auth}">
					<li class="nav-item "><a
						class="nav-link font-weight-bold text-light mx-1"
						href="${contextPath}/member/join"><h5>Join</h5></a></li>
					<li class="nav-item "><a
						class="nav-link font-weight-bold text-light mx-1"
						href="${contextPath}/member/login"><h5>Login</h5></a></li>
				</c:if>
				<c:if test="${not empty auth}">
					<li class="nav-item "><a
						class="nav-link font-weight-bold text-light mx-1"
						href="${contextPath}/mySpace"><h5>My Space🐾</h5></a></li>
					<li class="nav-item "><a
						class="nav-link font-weight-bold text-light mx-1"
						href="${contextPath}/member/logout"><h5>Logout</h5></a></li>
				</c:if>
			</ul>
		</nav>
	</div>