<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container my-5">
	<div class="text-center">
		<h1>New Board✏</h1>
	</div>

	<form action="${contextPath}/board/write" method="post"
		enctype="multipart/form-data">
		<div class="form-group">
			<b>Title</b> <input type="text" class="form-control" name="title">
		</div>
		<div class="form-group">
			<b>Writer</b><input type="text" class="form-control" name="writer">
			<!-- value="${auth.id}" readonly="readonly" -->
		</div>
		<div class="form-group">
			<b>Text</b><br>
			<textarea rows="10" class="form-control" name="content"></textarea>
		</div>
		<div class="form-group">
			<b>File Upload</b><br> <input type="file" class="form-control"
				name="attachFile">
		</div>
		<div class="text-center">
			<a href="${contextPath}/board" class="btn btn-outline-dark">Back</a>
			<button class="btn btn-outline-primary">Update</button>
		</div>
	</form>
	<div class="preview"></div>
</div>

<%@include file="../layout/footer.jsp"%>