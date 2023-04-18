$(function () {
    'use strict';
    $(function () {
        var todoListItem = $('.todo-list');
        var todoListInput = $('.todo-list-input');
        var checkNum = 0; // checkList 목록 개수
        var completedNum = 0; // 완료한 목록 개수
        
        function addToDoListItem(){
         var item = todoListInput.val();
            if (item) {
                todoListItem.append("<li><div class='form-check'><label class='form-check-label'><input class='checkbox' type='checkbox'/>"
                    + item + "<i class='input-helper'></i></label></div><i class='remove mdi mdi-close-circle-outline'></i></li>");
                todoListInput.val("");
                checkNum++;
      			console.log('checkList 개수 : '+checkNum);
            } else {
                alert('내용을 입력해주세요 :)');
            }
        };

		// add 버튼 을 눌렀을 때 실행
        $('.todo-list-add-btn').on("click", function (event) {
            event.preventDefault();
            addToDoListItem();
           
        });
	
		// enter 키를 눌렀을 때 실행
		$('.todo-list-input').on('keyup', function(event) {
		  if (event.keyCode === 13) {
		    addToDoListItem();
		  }
		});


        todoListItem.on('change', '.checkbox', function () {
	        if ($(this).prop('checked')) {
	            completedNum++;
	        } else {
	            completedNum--;
	        }
	        console.log('완료한 개수 : ' + completedNum);
	        $(this).closest("li").toggleClass('completed');
	    });

	    todoListItem.on('click', '.remove', function () {
	        $(this).parent().remove();
	        checkNum--;
	        console.log('checkList 개수 : '+checkNum);
	    });

    });
});