$(function checkListCount() {
  
    var checkNum = 0;
    var todoListItem = $('.todo-list');
    var todoListInput = $('.todo-list-input');
    
    $('.todo-list-add-btn').on("click", function(event) {
      event.preventDefault();

      var item = $(this).prevAll('.todo-list-input').val();

      if (item) {
        todoListItem.append("<li><div class='form-check'><label class='form-check-label my-2'>"
        					+ item + "<i class='input-helper'></i></label></div>"
        					+ "<i class='remove mdi mdi-close-circle-outline'></i></li>");
        todoListInput.val("");
      }
      
      checkNum ++;
      
   }); // on click end
 }); // checkListCount end
  
