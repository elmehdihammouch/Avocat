$(document).ready(function(){
	$("#print").on("click",function(){
		var OriginalPrintContents =  document.getElementById("ConsultationBox").innerHTML;
		var printContents = document.getElementById("ConsultationBox");  
		
		//remove() for box 
		 printContents.children[1].remove();
		 
		
	    var printContents = document.getElementById("ConsultationBox");    
	 var originalContents = document.body.innerHTML;      
	 document.body.innerHTML = printContents.innerHTML;
	 
	 window.print();     
	 document.body.innerHTML = originalContents;
	 // for box
	 document.getElementById("ConsultationBox").innerHTML = OriginalPrintContents;
		  
		  
	  })   
  $(".afficher").on("click", function(){
	  // prendre la valeur l'id qui se trouve dans la page hidden
	  var index = $(this).parent().parent().parent().children().eq(1).text();
	  $(".search").each(function(){
		  // each : fonctionne comme une boucle il fait la fonction dans tous les balise qui contiennent balise search
		  if($(this).children().children().val() == index){
			  $("#affichage").show();
			  $("#tab").hide();
			  $(this).show();
			  
		  }else{
			  $(this).hide()
		  }
	  })
	
	  
  });
 
  $("#prev").on("click",function(){
	  $("#affichage").hide();
	  $("#tab").show();
  
  })
  
  
   
  
  
  
  
  
  $(".supprimer").on("click", function(){
	  var index = $(this).parent().parent().parent().children().eq(1).text();
	  var supp = this;
	  if(confirm('voulez vous supprimer cette ligne')){
	  $.post("CC",{"id":index,"operation":"delete"}, function(data){
	    	if(data==1){
	    		$(supp).parent().parent().parent().remove();
	    	}else {
	    		alert('un erreur est du lors dans suppression');
	    	}

	  })
	  }	  
  });

  
});