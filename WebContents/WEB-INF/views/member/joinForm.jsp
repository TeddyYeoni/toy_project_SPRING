<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/memberHeader.jsp"%>

<style>
.holder {
	min-height: 80vh;
}


</style>

<div class="holder container">
	<div class="my-5 join_image">
		<center>
			<img src="${contextPath}/resources/img/icon/join_icon.png">
		</center>
	</div>

	<div class="d-flex justify-content-center">
		<form class="join_form" action="${contextPath}/member/join"
			method="post">
			<div class="form-group">
				<b>ID</b><input type="text" class="form-control" name="id">
			</div>
			<div class="form-group">
				<b>PASSWORD</b><input type="password" class="form-control"
					name="pwd">
			</div>
			<div class="form-group">
				<b>NAME</b><input type="text" class="form-control" name="name">
			</div>
			<div class="form-group">
				<b>EMAIL</b><input type="email" class="form-control" name="email">
			</div>
			<div class="d-flex justify-content-center my-3">
				<a href="${contextPath}/main" class="btn btn-outline-dark mx-2">MAIN</a>
				<button class="btn btn-outline-info mx-2">JOIN</button>
			</div>
		</form>
	</div>
	<div class="preview"></div>
</div>

<%@include file="../layout/footer.jsp"%>