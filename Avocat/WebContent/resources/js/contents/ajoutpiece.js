$(document).ready(function(){
	   active=document.getElementsByClassName("active");

		for(i=0;i<active.length;i++){
			active[i].classList.remove("active");
			i--;
		}
		
		document.getElementById("AccueilSB").parentElement.className += " active";
	
	$("#dis").on("click", function(){
		  $(this).parent().parent().parent().parent().submit()	  
	  });
  $(".fa-external-link-square").on("click", function(){
	  var index = $(this).parent().parent().children().eq(1).text();
	  $("#num").val(index);
	  $("#submit").click();
		  
  });

})