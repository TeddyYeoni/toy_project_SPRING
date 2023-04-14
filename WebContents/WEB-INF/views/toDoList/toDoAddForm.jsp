<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/todoStyle.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">
</script>
<script src="${contextPath}/resources/js/toDoList/toDoAddForm.js"></script>

<div class="container my-5">
	<div class="text-center my-5">
		<h1>Today's To Do List✏</h1>
	</div>
	<div class="text-center">
		<b>Date</b>&nbsp;&nbsp;&nbsp;<b>${todayDate}</b>
	</div>
	<div class="page-content page-container" id="page-content">
		<div class="padding">
			<div class="row container d-flex justify-content-center">
				<div class="col-md-12">
					<div class="card px-3">
						<div class="card-body">
							<h4>Check List✔</h4>
							<h4 class="card-title">해야할 일을 추가해보세요!</h4>
							<div class="add-items d-flex">
								<input type="text" class="checkList form-control todo-list-input"
									placeholder="What do you need to do today?"> <a
									href="${contextPath}/checkList/add"
									class="add btn btn-primary font-weight-bold todo-list-add-btn">Add</a>
							</div>
							<div class="list-wrapper">
								<ul class="d-flex flex-column-reverse todo-list">
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