<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<script src="${contextPath}/resources/js/diary/list.js"></script>
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
		<a href="${contextPath}/diary/writeForm"
			class="btn btn-outline-primary">New</a>
	</div>
	<form id="listForm">
		<div class="container bootstrap snippets bootdeys">
			<div class="row">
				<c:forEach items="${diary_list}" var="d">
					<div class="col-md-4 col-sm-6 content-card">
						<div class="card-big-shadow">
							<div class="card card-just-text" data-background="color"
								data-color="gray" data-radius="none">
								<div class="content">
									<h6 class="category">
										<b>Weather</b>&nbsp;&nbsp;${d.weather}
									</h6>
									<h6 class="category">
										<b>Emotion</b>&nbsp;&nbsp;${d.emotion}
									</h6><br>
									<h4 class="title">
										<a href="${d.dno}" class="d_title">${d.writeDate}</a>
									</h4><br>
									<b class="category">Praise</b><br>
									<p class="description">${d.praise}</p>
									<b class="category">Thanks</b><br>
									<p class="description">${d.thanks}</p>
								</div>
							</div>
							<!-- end card -->
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>