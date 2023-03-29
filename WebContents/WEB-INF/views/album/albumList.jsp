<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<script src="${contextPath}/resources/js/album/albumList.js"></script>
<style>
.holder {
	min-height: 100vh;
}

body {
	background: #f4f4f4;
}

.banner {
	background: #a770ef;
	background: -webkit-linear-gradient(to right, #a770ef, #cf8bf3, #fdb99b);
	background: linear-gradient(to right, #a770ef, #cf8bf3, #fdb99b);
}

.row img {
	height: 300px;
	width: 300px;
	object-fit: cover;
}
</style>

<div class="holder container-fluid">
	<div class="px-lg-5">
		<div class="text-center my-3">
			<h2>Album</h2>
			<p>나만의 소중한 순간 저장하기🎈</p>
		</div>
		<div class="text-right">
			<a href="${contextPath}/album/upload"
				class="btn btn-outline-success my-3 addPhotoBtn">Upload</a>
		</div>

		<div class="row">
			<c:forEach items="${album_list}" var="album">
				<input type="hidden" name="ano" value="${album.ano}">
				<!-- Gallery item -->
				<div class="col-xl-3 col-lg-4 col-md-6 mb-4">
					<div class="bg-white rounded shadow-sm">
						<div class="text-center">
							<img
								src="${contextPath}/albumImgDisplay?imageFileName=${album.ano}/${album.imageFileName}"
								alt="" class="img-fluid card-img-top">
						</div>
						<div class="p-4">
							<div
								class="badge badge-dark px-3 rounded-pill font-weight-normal"
								style="float: right;">${album.uploadDate}</div>
							<h6>
								<a href="${contextPath}/album/detail?ano=${album.ano}"
									class="text-dark">${album.title}</a>
							</h6>
							<p class="small text-muted mb-0">${album.content}</p>
						</div>
					</div>
				</div>
				<!-- End -->
			</c:forEach>

		</div>

	</div>
	<div class="py-5 text-right">
		<a href="?nowPageNum=${page.startPage-1}"
			class="btn btn-dark px-5 py-3 text-uppercase"><h5>Show me
				more</h5></a>
	</div>
</div>

<%@ include file="../layout/footer.jsp"%>