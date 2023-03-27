<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>


<style>
.holder {
	min-height: 100vh;
}
</style>

<div class="holder container">

	<div class="row">

		<div class="myToDoList">
			<h1>To Do List</h1><br>
			${recentTodo}
		</div>
		<div class="myAlbum">
			<h1>Album</h1><br>
			${recentAlbum}
		</div>
		<div class="myDiary">
			<h1>Diary</h1><br>
			${recentDiary}
		</div>

	</div>


</div>


<%@include file="layout/footer.jsp"%>