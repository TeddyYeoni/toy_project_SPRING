<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
</script>

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
			<ul class="navbar-nav mx-5 my-2">
				<li class="nav-item"><a
					class="nav-link font-weight-bold text-light mx-3"
					href="${contextPath}/todo"><h3>To Do List</h3></a></li>
				<li class="nav-item"><a
					class="nav-link font-weight-bold text-light mx-3"
					href="${contextPath}/album"><h3>Album</h3></a></li>
				<li class="nav-item"><a
					class="nav-link font-weight-bold text-light mx-3"
					href="${contextPath}/diary"><h3>Diary</h3></a></li>
				<li class="nav-item"><a
					class="nav-link font-weight-bold text-light mx-3"
					href="${contextPath}/board"><h3>Board</h3></a></li>
				<li class="nav-item"><a
					class="nav-link font-weight-bold text-light mx-3"
					href="${contextPath}/qna"><h3>Q&A</h3></a></li>
			</ul>

			<ul class="navbar-nav my-3">
				<li class="nav-item "><a
					class="nav-link font-weight-bold text-light mx-1"
					href="${contextPath}/member/join"><h5>Join</h5></a></li>
				<li class="nav-item "><a
					class="nav-link font-weight-bold text-light mx-1"
					href="${contextPath}/member/"><h5>Login</h5></a></li>
				<li class="nav-item "><a
					class="nav-link font-weight-bold text-light mx-1" href="#"><h5>
							My Space🐾</h5></a></li>
				<li class="nav-item "><a
					class="nav-link font-weight-bold text-light mx-1"
					href="${contextPath}/member/logout"><h5>Logout</h5></a></li>
			</ul>
		</nav>
	</div>