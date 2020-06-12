$(document).ready(function(){
  $(".afficher").one("click", function(){
    alert("afficher")
  });
  $(".modifier").one("click", function(){
	    alert("modifier")
	  });
  $(".supprimer").one("click", function(){
	  $(this).remove();
	  });
});