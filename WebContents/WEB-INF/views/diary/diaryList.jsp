<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<script src="${contextPath}/resources/js/diary/diaryList.js"></script>
<link rel="stylesheet"
	href="${contextPath}/resources/css/diaryStyle.css">

<style>
.holder {
	min-height: 100vh;
}
</style>

<div class="holder container">
	<div class="text-center my-3">
		<h2>Diary</h2>
		<p>오늘 하루 기록하기🎈</p>
	</div>
	<div class="text-right my-2">
		<a href="${contextPath}/diary/write" class="btn btn-outline-primary">New</a>
	</div>
	<form id="listForm">
		<div class="container bootstrap snippets bootdeys">
			<div class="row">
				<c:forEach items="${diary_list}" var="diary">
					<c:if test="${auth.id eq d.id}">
						<div class="col-md-4 col-sm-6 content-card my-3">
							<div class="card-big-shadow">
								<div class="card card-just-text" data-background="color"
									data-color="gray" data-radius="none">
									<div class="content">
										<h6 class="category">
											<b>Weather</b>&nbsp;&nbsp;${diary.weather}
										</h6>
										<h6 class="category">
											<b>Emotion</b>&nbsp;&nbsp;${diary.emotion}
										</h6>
										<br>
										<h4 class="title">
											<a href="${diary.dno}" class="d_title">${diary.writeDate}</a>
										</h4>
										<br> <b class="category">Praise</b><br>
										<p class="description">${diary.praise}</p>
										<b class="category">Thanks</b><br>
										<p class="description">${diary.thanks}</p>
									</div>
								</div>
								<!-- end card -->
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</form>

	<!-- paging -->
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