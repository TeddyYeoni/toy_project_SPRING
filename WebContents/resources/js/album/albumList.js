$(function() {
	let listForm = $('#uploadForm');
	$('.title').on('click', function(e) {
		e.preventDefault();
		$('[name="ano"]').remove();
		let qnoData = "<input type='hidden' name='ano' value='" + $(this).attr('href') + "'/>";
		listForm.append(qnoData)
			.attr("action", `${contextPath}/ana/detail`)
			.submit();
	});
	
});
