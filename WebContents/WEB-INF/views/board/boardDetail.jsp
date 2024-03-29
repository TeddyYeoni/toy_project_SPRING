<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<script src="${contextPath}/resources/js/reply/boardReplyService.js"></script>
<script src="${contextPath}/resources/js/board/boardDetail.js"></script>

<style>
.modal-body textarea {
	width: 100%;
	height: 100px;
}

.modal-body input {
	border: none;
}
</style>

<div class="container">
	<div class="jumbotron">
		<h1>Board</h1>
	</div>
	<form id="viewForm" enctype="multipart/form-data">
		<table class="table">
			<tr>
				<th><b>No</b></th>
				<td>${board.bno}<input type="hidden" name="bno"
					value="${board.bno}"></td>
				<th><b>Views</b></th>
				<td>000</td>
			</tr>
			<tr>
				<th><b>Name</b></th>
				<td>${board.writer}</td>
				<th>Date</th>
				<td>${board.writeDate}</td>
			</tr>
			<tr>
				<th><b>Title</b></th>
				<td colspan="3"><input type="text" name="title"
					class="form-control" value="${board.title}" readonly="readonly"></td>
			</tr>
			<tr>
				<th><b>Contents</b></th>
				<td colspan="3"><textarea rows="5" cols="50" name="content"
						class="form-control" readonly="readonly">${board.content}</textarea></td>
			</tr>
			<tr class="detailView">
				<th><b>Images</b></th>
				<td colspan="3">
					<div class="my-3">
						<c:if test="${not empty board.imageFileName}">
							<div class="preview">
								<img class="originImg"
									src="${contextPath}/boardImgDisplay?imageFileName=${board.bno}/${board.imageFileName}">
							</div>
						</c:if>
						<c:if test="${empty board.imageFileName}">
							<div class="preview">
								<p>✖ 첨부된 이미지가 없어요 ✖</p>
							</div>
						</c:if>
					</div>

				</td>
			</tr>
			<tr class="modForm">
				<th><b>Images</b></th>
				<td colspan="3">
					<div class="my-3">
						<c:if test="${empty board.imageFileName}">
							<b>첨부된 파일이 없습니다</b>
							<input type="file" name="attachFile" class="form-control">
						</c:if>
						<c:if test="${not empty board.imageFileName}">
							<div>
								<span> 파일 삭제 : <input type="checkbox" name="delCheck"
									class="delCheck"></span> <input type="file" name="attachFile"
									class="form-control attachFile">
							</div>
							<img
								src="${contextPath}/boardImgDisplay?imageFileName=${board.bno}/${board.imageFileName}">
						</c:if>
					</div>
				</td>
			</tr>

			<tr>
				<td colspan="4" class="text-right">
					<button type="button" class="btn btn-outline-dark toList">
						<b>Back</b>
					</button> <c:if test="${auth.id eq board.writer}">
						<button type="button" class="btn btn-outline-success toModForm">
							<b>Edit</b>
						</button>
					</c:if> <c:if
						test="${auth.id eq board.writer or auth.grade eq 'ASTRONAUT'}">
						<button type="button" class="btn btn-outline-danger remove">
							<b>Delete</b>
						</button>
					</c:if>
				</td>
			</tr>

			<tr class="viewMode">
				<c:if test="${auth.id eq board.writer or auth.grade eq 'ASTRONAUT'}">
					<td colspan="4" class="text-right">
						<button type="button" class="btn btn-outline-primary modify">
							<b>EDIT</b>
						</button>
						<button type="button" class="btn btn-outline-primary backViewMode">
							<b>BACK</b>
						</button>
					</td>
				</c:if>
			</tr>
		</table>
	</form>

	<!-- 댓글 -->
	<c:if test="${not empty auth.id}">
		<div class="replyForm">
			<table class="table">
				<tr>
					<th colspan="2">
						<ul class="d-flex justify-content-between">
							<li>Comment🖋</li>
							<li class="form-inline">Writer <input type="text"
								class="form-control ml-2 reply_writer" value="${auth.id}"
								readonly="readonly">
							</li>
						</ul>
					</th>
				</tr>

				<tr>
					<td><textarea rows="5" class="form-control reply_content"></textarea></td>
				</tr>
				<tr class="text-right">
					<td colspan="2"><button
							class="btn btn-outline-info reply_write">
							<b>Boom</b>
						</button></td>
				</tr>
			</table>
		</div>
	</c:if>

	<!-- 댓글 목록 -->
	<div class="replyList">
		<div class="container">
			<ul class="list-group list-group-flush">
			</ul>
		</div>
	</div>

	<!-- 댓글 등록 모달 -->
	<div class="modal fade" id="feedback">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Reply💌</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body"></div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

	<!-- 댓글 삭제 모달 -->
	<div class="modal fade" id="remove_feedback">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">❌Reply❌</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body"></div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

	<!-- 댓글 수정 모달 -->
	<div class="modal fade" id="reply_modify">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">댓글 수정</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="text-right">
						<input type="hidden" class="reply_writer" value="${auth.id}"
							readonly="readonly">
					</div>
					<div>
						<b>Comment</b><br>
						<textarea rows="3" class="reply_modForm"></textarea>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-success reply_modBtn"
						data-dismiss="modal">수정</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
				</div>

			</div>
		</div>
	</div>

</div>


<%@ include file="../layout/footer.jsp"%>