<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<style>
.preview{
	max-width: 100px;
}

</style>

<div class="container my-5">
	<div class="text-center">
		<h1>New Photo📷</h1>
	</div>

	<form action="${contextPath}/album/upload" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="writer" value="${auth.id}">
		<div class="form-group">
			<b>File Upload</b><br> <input type="file" class="form-control"
				name="imageFileName">
		</div>
		<div class="preview"></div>
		<div class="form-group">
			<b>Title</b> <input type="text" class="form-control" name="title">
		</div>
		<div class="form-group">
			<b>Text</b><br>
			<textarea rows="10" class="form-control" name="content"></textarea>
		</div>

		<div class="text-center">
			<a href="${contextPath}/album" class="btn btn-outline-dark">Back</a>
			<button class="btn btn-outline-primary">Update</button>
		</div>
	</form>

</div>

<%@include file="../layout/footer.jsp"%>