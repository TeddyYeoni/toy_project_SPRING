<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<script src="${contextPath}/resources/js/qna/qnaList.js"></script>

<style>
.holder {
  min-height: 100vh;
}
</style>

<div class="holder container">
	<div class="text-center my-3">
		<h2>Q&A</h2>
		<p>궁금한 점은 질문으로 남겨주세요🎈</p>
	</div>
	<div class="text-right my-2">
		<a href="${contextPath}/qna/add"
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
				<c:forEach items="${qna_list}" var="qna">
					<tr>
						<td>${qna.qno}</td>
						<td><a href="${qna.qno}" class="title">${qna.title}</a></td>
						<td>${qna.writer}</td>
						<td>${qna.writeDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>



	<div class="my-5">
		<ul class="pagination pagination-sm d-flex justify-content-center">
			<c:if test="${page.prev}">
				<li class="page-item"><a class="page-link"
					href="?nowPageNum=${page.startPage-1}">Previous</a></li>
			</c:if>

			<c:forEach begin="${page.startPage}" end="${page.endPage}"
				var="pageValue">
				<li class="page-item"><a class="page-link"
					href="?nowPageNum=${pageValue}">${pageValue}</a></li>
			</c:forEach>

			<c:if test="${page.next}">
				<li class="page-item"><a class="page-link"
					href="?nowPageNum=${page.endPage+1}">Next</a></li>
			</c:if>
		</ul>
	</div>

</div>

<%@ include file="../layout/footer.jsp"%>