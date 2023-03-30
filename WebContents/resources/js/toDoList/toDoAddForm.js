(function($) {
  'use strict';
  $(function() {
    var todoListItem = $('.todo-list');
    var todoListInput = $('.todo-list-input');
    var checkNum = 0;
    $('.todo-list-add-btn').on("click", function(event) {
      event.preventDefault();

      var item = $(this).prevAll('.todo-list-input').val();


      if (item) {
        todoListItem.append("<li><div class='form-check'><label class='form-check-label my-2'><input class='text' name='checkList' readonly='readonly' value='" + item + "'/><i class='input-helper'></i></label></div><i class='remove mdi mdi-close-circle-outline'></i></li>");
        todoListInput.val("");
      }
      checkNum ++;
      todoListItem.append(checkNum).submit();
    });
  });
})(jQuery);