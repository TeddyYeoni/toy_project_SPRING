<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<script src="${contextPath}/resources/js/diary/diaryDetail.js"></script>

<div class="container">
	<div class="jumbotron">
		<h1>Diary</h1>
	</div>
	<form id="viewForm">
		<table class="table">
			<input type="hidden" name="dno" value="${diary.dno}">
			<tr>
				<th><b>Date</b></th>
				<td colspan="3">${diary.writeDate}</td>
			</tr>
			<tr>
				<th><b>Weather</b></th>
				<td>${diary.weather}</td>
				<th>Emotion</th>
				<td>${diary.emotion}</td>
			</tr>
			<tr>
				<th><b>Diary</b></th>
				<td colspan="3"><textarea rows="5" cols="50" name="content"
						class="form-control" readonly="readonly">${diary.content}</textarea></td>
			</tr>
			<tr>
				<th><b>Praise</b></th>
				<td><input type="text" name="praise" class="form-control"
					readonly="readonly" value="${diary.praise}"></td>
				<th>Thanks</th>
				<td><input type="text" name="thanks" class="form-control"
					readonly="readonly" value="${diary.thanks}"></td>
			</tr>
			<tr>
				<td colspan="4" class="text-right">
					<button type="button" class="btn btn-outline-dark toList">
						<b>Back</b>
					</button> <c:if test="${auth.id eq diary.writer}">
						<button type="button" class="btn btn-outline-success toModForm">
							<b>Edit</b>
						</button>
					</c:if> <c:if
						test="${auth.id eq diary.writer or auth.grade eq 'ASTRONAUT'}">
						<button type="button" class="btn btn-outline-danger remove">
							<b>Delete</b>
						</button>
					</c:if>
				</td>
			</tr>

			<tr class="viewMode">
				<c:if test="${auth.id eq diary.writer}">
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



</div>


<%@ include file="../layout/footer.jsp"%>