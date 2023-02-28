<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<script src="${contextPath}/resources/js/board/list.js"></script>

<style>
.holder {
  min-height: 100vh;
}
</style>

<div class="holder container">
	<div class="text-center my-3">
		<h2>Board</h2>
		<p>소통할 수 있는 공간🎈</p>
	</div>
	<div class="text-right my-2">
		<a href="#"
			class="btn btn-outline-primary">New</a>
	</div>
	<form id="listForm">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>No.</th>
					<th>Title</th>
					<th>name</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${board_list}" var="b">
					<tr>
						<td>${b.bno}</td>
						<td><a href="${b.bno}" class="title">${b.title}</a></td>
						<td>${b.writer}</td>
						<td>${b.writeDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>

</div>

<%@ include file="../layout/footer.jsp"%>