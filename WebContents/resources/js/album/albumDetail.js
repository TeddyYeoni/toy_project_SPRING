$(function() {
	$('.viewMode').hide();

	let viewForm = $('#viewForm');
	let titleObj = $('input[name="title"]');
	let contentObj = $('textarea[name="content"]');
	let imageFile = $('.originFileName').val();
	let pTag = $('.preview p').html();
	let viewMode = $('.viewMode').val();

	let originImg = $('.originImg').clone();
	let titleVal = titleObj.val();
	let contentVal = contentObj.val();

	// Back 버튼
	$('.toList').on('click', function() {
		viewForm.attr({
			"action": `${contextPath}/album`,
			"method": "get"
		}).empty()
			.submit();
	});


	// Delete 버튼
	$('.remove').on('click', function() {
		viewForm.attr({
			"action": `${contextPath}/album/remove`,
			"method": "post",
		}).submit();

	});
	
	// 수정 버튼
	$('.toModForm').on('click', function() {
		$('input[name="title"],textarea[name="content"]').attr("readonly", false);
		$('.viewMode').show();
		$(this).closest('tr').hide();
	});
	
		// Edit 처리
	$('.modify').on('click', function() {
		viewForm.attr({
			"action": `${contextPath}/album/modify`,
			"method": "post"
		}).submit();
	});
	
	// 뷰 모드
	$('.backViewMode').on('click', function() {
		$('input[name="title"],textarea[name="content"]').attr("readonly", true);
		$('.viewMode').hide();
		$(this).closest('tr').prev().show();
		$('.preview').html(originImg);
		$('input[type="file"]').val();
		titleObj.val(titleVal);
		contentObj.val(contentVal);
		console.log(imageFile);
		if (imageFile == '' || imageFile == null) {
			$('.preview').html(pTag);
		}
	});

});