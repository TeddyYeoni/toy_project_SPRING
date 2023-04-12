$(function () {
    'use strict';
    $(function () {
        var todoListItem = $('.todo-list');
        var todoListInput = $('.todo-list-input');
        var checkNum = 0; // checkList 목록 개수
        var completedNum = 0; // 완료한 목록 개수

        $('.todo-list-add-btn').on("click", function (event) {
            event.preventDefault();

            var item = $(this).prevAll('.todo-list-input').val();

            if (item) {
                todoListItem.append("<li><div class='form-check'><label class='form-check-label'><input class='checkbox' type='checkbox'/>"
                    + item + "<i class='input-helper'></i></label></div><i class='remove mdi mdi-close-circle-outline'></i></li>");
                todoListInput.val("");
                checkNum++;
      			console.log('checkList 개수 : '+checkNum);
            } else {
                alert('내용을 입력해주세요 :)');
            }
        });

        todoListItem.on('change', '.checkbox', function () {
            if ($(this).attr('checked')) {
                $(this).removeAttr('checked');
                completedNum--;
            } else {
                $(this).attr('checked', 'checked');
                completedNum++;
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