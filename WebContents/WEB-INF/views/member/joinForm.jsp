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
				<b>ID</b><input type="text" class="form-control" name="id" placeholder="ID는 영어, 숫자로만 입력해주세요!">
			</div>
			<div class="form-group">
				<b>PASSWORD</b><input type="password" class="form-control"
					name="pwd" placeholder="비밀번호는 영어,숫자,특수문자 포함 8자 이상 입력해주세요!">
			</div>
			<div class="form-group">
				<b>NAME</b><input type="text" class="form-control" name="name" placeholder="이름은 2-6자로 입력해주세요!">
			</div>
			<div class="form-group">
				<b>EMAIL</b><input type="email" class="form-control" name="email" placeholder="이메일은 올바른 형식으로 입력해주세요!">
			</div>
			<div class="text-center my-3">
				<button class="btn btn-info mx-2">JOIN</button><br><br><br><br>
				<a href="${contextPath}/main" class="btn btn-dark mx-1">MAIN</a>
				<a href="${contextPath}/member/login" class="btn btn-light mx-1">LOGIN</a>
			</div>
		</form>
	</div>
	<div class="preview"></div>
</div>

<%@include file="../layout/footer.jsp"%>