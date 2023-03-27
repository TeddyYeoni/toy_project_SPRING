<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>

<style>
.holder {
	min-height: 100vh;
}

body {
	width: auto;
	max-height: 100vh;
	background-image: url('${contextPath}/resources/img/moon.jpg');
	background-size: cover;
	color: silver;
}

.holder a {
	color: white;
}

.recentList {
	background-color: rgba(0, 0, 0, 0.5);
	color: white;
}

.listLink {
	float: right;
	text-decoration: underline;
}

.mainImg {
	display: flex;
	justify-content: center;
	align-items: center;
	border: 0.1px solid rgba(255, 255, 255, 0.1);
}

.imgContainer {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}
</style>

<!-- Page Content -->
<div class="holder">
	<!-- Portfolio Item Heading -->
	<h1 class="my-4 text-center">News Updates</h1>

	<!-- Portfolio Item Row -->
	<div class="row d-flex justify-content-center">

		<div class="col-md-4 recentList mx-3 my-5">
			<div class="text-center my-3">
				<h2 class="sm-b-0">Board📋</h2>
			</div>
			<c:forEach items="${recentBoard}" var="board">
				<ul>
					<li class="d-flex no-block my-3"><i
						class="fa fa-check-circle w-30px m-t-5"></i>
						<div class="title">
							<a href="${contextPath}/board/detail?bno=${board.bno}"
								class="m-b-0 font-medium p-0" data-abc="true"><h6>${board.title}</h6></a>
						</div>
						<div class="ml-auto">
							<div class="tetx-right date">
								<h7 class="text-muted m-b-0">${board.writeDate}</h7>
							</div>
						</div></li>
				</ul>
			</c:forEach>
			<div class="listLink my-4">
				<a href="${contextPath}/board">View More</a>
			</div>
		</div>

		<div class="col-md-4 recentList mx-3 my-5">
			<div class="text-center my-3">
				<h2 class="sm-b-0">Q&A🖐🏻</h2>
			</div>
			<c:forEach items="${recentQna}" var="qna">
				<ul>
					<li class="d-flex no-block my-3"><i
						class="fa fa-check-circle w-30px m-t-5"></i>
						<div class="title">
							<a href="${contextPath}/qna/detail?qno=${qna.qno}"
								class="m-b-0 font-medium p-0" data-abc="true"><h6>${qna.title}</h6></a>
						</div>
						<div class="ml-auto">
							<div class="tetx-right">
								<h7 class="text-muted m-b-0">${qna.writeDate}</h7>
							</div>
						</div></li>
				</ul>
			</c:forEach>
			<div class="listLink my-4">
				<a href="${contextPath}/qna">View More</a>
			</div>
		</div>


	</div>
	<!-- /.row -->

	<!-- Related Projects Row -->

	<div class="row d-flex justify-content-center">

		<div class="imgContainer col-md-3 col-sm-6 mb-4 ">
			<div class="mainImg">
				<c:if test="${not empty auth.id}">
					<a href="${contextPath}/todo">
				</c:if>
				<c:if test="${empty auth.id}">
					<a href="${contextPath}/member/login">
				</c:if>
				<img class="img-fluid"
					src="${contextPath}/resources/img/main/ToDoList.png" alt="">
				</a>
			</div>
			<c:if test="${not empty auth.id}">
				<div class="my-3">
					<a href="${contextPath}/todo/add" class="btn btn-outline-light">NEW</a>
				</div>
			</c:if>
		</div>

		<div class="imgContainer col-md-3 col-sm-6 mb-4">
			<div class="mainImg">
				<c:if test="${not empty auth.id}">
					<a href="${contextPath}/album">
				</c:if>
				<c:if test="${empty auth.id}">
					<a href="${contextPath}/member/login">
				</c:if>
				<img class="img-fluid"
					src="${contextPath}/resources/img/main/album.png" alt=""></a>
			</div>
			<c:if test="${not empty auth.id}">
				<div class="my-3">
					<a href="${contextPath}/album/upload" class="btn btn-outline-light">NEW</a>
				</div>
			</c:if>
		</div>

		<div class="imgContainer col-md-3 col-sm-6 mb-4">
			<div class="mainImg">
				<c:if test="${not empty auth.id}">
					<a href="${contextPath}/diary">
				</c:if>
				<c:if test="${empty auth.id}">
					<a href="${contextPath}/member/login">
				</c:if>
				<img class="img-fluid"
					src="${contextPath}/resources/img/main/diary.png" alt=""> </a>
			</div>
			<c:if test="${not empty auth.id}">
				<div class="my-3">
					<a href="${contextPath}/diary/write" class="btn btn-outline-light">NEW</a>
				</div>
			</c:if>
		</div>

	</div>
	<!-- /.row -->

</div>
<!-- /.container -->

<%@ include file="layout/footer.jsp"%>