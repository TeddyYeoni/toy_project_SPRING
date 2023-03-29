$(function() {
	console.log('스크립트 실행');
	$('.viewMode').hide();

	let viewForm = $('#viewForm');

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
			"method": "post"
		}).submit();

	});

});