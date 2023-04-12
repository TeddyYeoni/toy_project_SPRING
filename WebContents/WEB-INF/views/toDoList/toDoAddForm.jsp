<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/todoStyle.css">
<script src="${contextPath}/resources/js/toDoList/toDoAddForm.js"></script>

<div class="container my-5">
	<div class="text-center my-5">
		<h1>Today's To Do List✏</h1>
	</div>
	<b>Date</b>&nbsp;&nbsp;&nbsp;<b>${todayDate}</b>
	<h4>Check List✔</h4>
	<div class="page-content page-container my-3" id="page-content">
		<div class="padding">
			<div class="row container d-flex justify-content-center">
				<div class="col-md-12">
					<div class="card px-3">
						<div class="card-body">
							<div class="add-items d-flex my-3">
								<input type="text" class="form-control todo-list-input"
									placeholder="What do you need to do today?">
								<button
									class="add btn btn-primary font-weight-bold todo-list-add-btn">Add</button>
							</div>
							<div class="list-wrapper">
								<ul class="d-flex flex-column-reverse todo-list">
									<li>
										<div class="form-check d-flex justify-content-between">
											<div class="checkLabael">
												<label class="form-check-label my-2">체크리스트<i
													class="input-helper"></i></label>
											</div>
											<div class="checkListBtn text-right">
												<button class='btn btn-outline-primary checkMod'>modify</button>
												<button class='btn btn-outline-danger checkDel'>delete</button>
											</div>
										</div> <i class="remove mdi mdi-close-circle-outline"></i>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="text-center my-5">
		<a href="${contextPath}/todo" class="btn btn-outline-dark">Back</a>
		<button class="btn btn-outline-primary addBtn">Update</button>
	</div>

</div>

<%@include file="../layout/footer.jsp"%>