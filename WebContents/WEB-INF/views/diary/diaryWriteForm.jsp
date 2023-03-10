<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container my-5">
	<div class="text-center my-5">
		<h1>New Diaryβ</h1>
	</div>

	<form action="${contextPath}/diary/write" method="post">
		<input type="hidden" name="writer" value="${auth.id}">
		${auth.id}
		<div class="form-group">
			<b>Date</b>&nbsp;&nbsp;&nbsp;<b>${todayDate}</b>
		</div>
		<div class="my-3">
			<b>Weather</b> <input type="checkbox" class="mx-2" name="weather"
				value="SUNNY">π&nbsp; <input type="checkbox" class="mx-2"
				name="weather" value="CLOUDY">β&nbsp; <input type="checkbox"
				class="mx-2" name="weather" value="FOGGY">π€&nbsp; <input
				type="checkbox" class="mx-2" name="weather" value="WINDY">π¬&nbsp;
			<input type="checkbox" class="mx-2" name="weather" value="RAINY">β&nbsp;
			<input type="checkbox" class="mx-2" name="weather" value="SNOWY">β&nbsp;
			<input type="checkbox" class="mx-2" name="weather" value="HOT">π₯&nbsp;
			<input type="checkbox" class="mx-2" name="weather" value="COLD">β&nbsp;

		</div>
		<div class="my-3">
			<b>Emotion</b> <input type="checkbox" class="mx-2" name="emotion"
				value="WELL">βΊ&nbsp; <input type="checkbox" class="mx-2"
				name="emotion" value="BAD">π€’&nbsp; <input type="checkbox"
				class="mx-2" name="emotion" value="GLAD">π₯°&nbsp; <input
				type="checkbox" class="mx-2" name="emotion" value="DEPRESSED">βΉ&nbsp;
			<input type="checkbox" class="mx-2" name="emotion" value="SAD">π­&nbsp;
			<input type="checkbox" class="mx-2" name="emotion" value="UPSET">π‘&nbsp;
			<input type="checkbox" class="mx-2" name="emotion" value="PAIN">π€&nbsp;
		</div>
		<div class="form-group">
			<b>Diary</b><br>
			<textarea rows="10" class="form-control" name="content"></textarea>
		</div>
		<div class="form-group">
			<b>Today's Praise</b> <input type="text" class="form-control"
				name="praise">
		</div>
		<div class="form-group">
			<b>Today's Thanks</b> <input type="text" class="form-control"
				name="thanks">
		</div>
		<div class="text-center">
			<a href="${contextPath}/diary" class="btn btn-outline-dark">Back</a>
			<button class="btn btn-outline-primary">Update</button>
		</div>
	</form>
	<div class="preview"></div>
</div>

<%@include file="../layout/footer.jsp"%>

<script>
	$(function() {

		// Weahter checkbox 1κ°λ§ μ²΄ν¬ κ°λ₯
		$('input[type="checkbox"][name="weather"]').click(
				function() {
					if ($(this).prop('checked')) {
						$('input[type="checkbox"][name="weather"]').prop(
								'checked', false);
						$(this).prop('checked', true);
						$(this).val();
					}
				});

		// Emtoion checkbox 1κ°λ§ μ²΄ν¬ κ°λ₯
		$('input[type="checkbox"][name="emotion"]').click(
				function() {
					if ($(this).prop('checked')) {
						$('input[type="checkbox"][name="emotion"]').prop(
								'checked', false);
						$(this).prop('checked', true);
						$(this).val();
					}
				});

	});
</script>