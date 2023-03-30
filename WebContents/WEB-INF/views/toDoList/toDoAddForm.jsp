<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<script src="${contextPath}/resources/css/todoStyle.css"></script>
<script src="${contextPath}/resources/js/toDoList/toDoAddForm.js"></script>
 
<div class="container my-5">
	<div class="text-center my-5">
		<h1>Today's To Do List✏</h1>
	</div>
	<form action="${contextPath}/todo/add" method="post">
		<b>Date</b>&nbsp;&nbsp;&nbsp;<b>${todayDate}</b>
		<h4>Check List✔</h4>
		<div class="page-content page-container my-3" id="page-content">
			<div class="padding">
				<div class="row container d-flex justify-content-center">
					<div class="col-md-12">
						<div class="card px-3">
							<div class="card-body">
								<div class="add-items d-flex">
									<input type="text" class="form-control todo-list-input"
										placeholder="What do you need to do today?">
									<button
										class="add btn btn-primary font-weight-bold todo-list-add-btn">Add</button>
								</div>
								<div class="list-wrapper">
									<ul class="d-flex flex-column-reverse todo-list">
										<li>
											<div class="form-check">
												<label class="form-check-label my-2"> <input
													class="text" readonly="readonly" value="해야 할 일 목록"><i
													class="input-helper"></i></label>
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
	</form>
	<div class="text-center my-5">
		<a href="${contextPath}/todo" class="btn btn-outline-dark">Back</a>
		<button class="btn btn-outline-primary">Update</button>
	</div>

</div>

<%@include file="../layout/footer.jsp"%>