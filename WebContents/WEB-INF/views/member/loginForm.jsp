<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/memberHeader.jsp"%>

<style>
.holder {
  min-height: 80vh;
}
</style>

<div class="holder container">

	<div class="my-5 loginuser_image">
		<center>
			<img src="${contextPath}/resources/img/icon/login_icon.png">
		</center>
	</div>

	<div class="d-flex justify-content-center">
		<form class="login_form" action="${contextPath}/member/login"
			method="post">
			<div class="form-group">
				<b>ID</b><input type="text" class="form-control" name="id" id="id">
			</div>
			<div class="form-group">
				<b>PASSWORD</b><input type="password" class="form-control"
					name="pwd">
			</div>
			<div class="text-center my-3">
				<a href="${contextPath}/main" class="btn btn-outline-dark mx-2">Main</a>
				<a href="${contextPath}/member/joinForm" class="btn btn-outline-info mx-2">Join</a>
				<button class="btn btn-outline-success mx-2">Login</button>
			</div>
		</form>
	</div>
	<div class="preview"></div>
</div>

<%@include file="../layout/footer.jsp"%>