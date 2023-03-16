<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container my-5">
	<div class="text-center my-5">
		<h1>Today's To Do List✏</h1>
	</div>
	<form action="${contextPath}/todo/add" method="post">
		<b>Date</b>&nbsp;&nbsp;&nbsp;<b>${todayDate}</b>
		<h4>Check List✔</h4>
	</form>
	<div class="text-center">
		<a href="${contextPath}/todo" class="btn btn-outline-dark">Back</a>
		<button class="btn btn-outline-primary">Update</button>
	</div>

	<div class="preview"></div>
</div>

<%@include file="../layout/footer.jsp"%>