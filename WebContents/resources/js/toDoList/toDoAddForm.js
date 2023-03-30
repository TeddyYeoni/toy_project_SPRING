let checkListAdd = {
	(function($) {
	  'use strict';
	    var checkNum = 0;
	  $(function checkListAdd() {
	    var todoListItem = $('.todo-list');
	    var todoListInput = $('.todo-list-input');
	    $('.todo-list-add-btn').on("click", function(event) {
	      event.preventDefault();
	
	      var item = $(this).prevAll('.todo-list-input').val();
	
	
	      if (item) {
	        todoListItem.append("<li><div class='form-check'><label class='form-check-label my-2'><input class='text' name='checkList' readonly='readonly' value='" + item + "'/><i class='input-helper'></i></label></div><i class='remove mdi mdi-close-circle-outline'></i></li>");
	        todoListInput.val("");
	      }
	      checkNum ++;
	    });
	  });
	})(jQuery);
};


/*
 $(fucntion(){
  	$('.addBtn').on("click", fuction(){
	  add : function(checkListAdd){
		  $.ajax({
		  		type: 'POST',
		 		url: `${contextPath}/todo/add`,
		 		data: {checkNum: checkNum},
		 		success: function(response) {
		 		  alert('success');
				},
		 		error: function() {
		  		  alert('failure');
		 		}
			}); // ajax end
		} // add end
		
  	}); // click end
  }); // funcition end
 */