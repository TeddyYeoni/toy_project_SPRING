<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<script src="${contextPath}/resources/js/reply/boardReplyService.js"></script>
<script src="${contextPath}/resources/js/board/boardDetail.js"></script>

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
			<tr>
				<th><b>Images</b></th>
				<td colspan="3"><input type="file" name="imageFileName"
					class="form-control viewMode">
					<div class="my-3">
						<input type="hidden" name="attachFile" class="originFileName"
							value="${board.imageFileName}">
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
					</div></td>
			</tr>
			<tr>
				<td colspan="4" class="text-right">
					<button type="button" class="btn btn-outline-dark toList">
						<b>Back</b>
					</button>
					<button type="button" class="btn btn-outline-success toModForm">
						<b>Edit</b>
					</button>

					<button type="button" class="btn btn-outline-danger remove">
						<b>Delete</b>
					</button>

				</td>
			</tr>

			<tr class="viewMode">
				<td colspan="4" class="text-right">
					<button type="button" class="btn btn-outline-primary modify">
						<b>EDIT</b>
					</button>
					<button type="button" class="btn btn-outline-primary backViewMode">
						<b>BACK</b>
					</button>
				</td>
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
					<td><textarea rows="3" class="form-control reply_content"></textarea></td>
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


</div>


<%@ include file="../layout/footer.jsp"%>