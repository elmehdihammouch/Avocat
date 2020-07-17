$(document).ready(function(){
  
  $(".fa-external-link-square").on("click", function(){
	  var index = $(this).parent().parent().children().eq(1).text();
	  $("#num").val(index);
	  $("#submit").click();
		  
  });
})