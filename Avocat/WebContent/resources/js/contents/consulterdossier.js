//header js
active=document.getElementsByClassName("active");
	
	for(i=0;i<active.length;i++){
		active[i].classList.remove("active");
		i--;
	}
	document.getElementById("consulterDossier").className += "active";
	document.getElementById("consulterDossier").parentElement.previousElementSibling.className += " active";
//



$(document).ready(function(){
	$("#print").on("click",function(){
		var OriginalPrintContents =  document.getElementById("DossierBox").innerHTML;
		var printContents = document.getElementById("DossierBox");  
		
		//remove() for box 
		 printContents.children[1].remove();
		
		
	    var printContents = document.getElementById("DossierBox");    
	 var originalContents = document.body.innerHTML;      
	 document.body.innerHTML = printContents.innerHTML;
	 
	 window.print();     
	 document.body.innerHTML = originalContents;
	 // for box
	 document.getElementById("DossierBox").innerHTML = OriginalPrintContents;
		  
		  
	  })  
  $(".affiche").on("click", function(){
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
 
  $("#prev").click(function(){
	  $("#affichage").hide();
	  $("#tab").show();
  
  })
  
  
  $(".modifie").on("click", function(){
	  var index = $(this).parent().parent().parent().children().eq(1).text();
	  $("#modifierCl").unbind();
	  $(".update").each(function(){
		  if($(this).children().children().val() == index){
				  $(this).show();
				  $("#mod").show();
				  $("#tab").hide();
				  etatav = $(this).children().eq(1).children().eq(0).children().children().eq(1).val();
				  typeproc = $(this).children().eq(1).children().eq(1).children().children().eq(1).val();
				  desc = $(this).children().eq(1).children().eq(2).children().children().eq(1).val();
				  that = this;
				  etatavNV = $(that).children().eq(1).children().eq(0).children().children().eq(1);
				  typeprocNV = $(that).children().eq(1).children().eq(1).children().children().eq(1);
				  descNV = $(that).children().eq(1).children().eq(2).children().children().eq(1);
				  $("#previous").click(function(){
					  $("#mod").hide();
					  $("#tab").show();
					  etatavNV.val(etatav)
					  typeprocNV.val(typeproc)
					  descNV.val(desc)
				  })
				  $("#modifierCl").bind("click", function(){
					  if( desc != descNV.val() || typeproc != typeprocNV.val() || etatav != etatavNV.val()  ){
						if(confirm('vouler vous vraiment modifier ce dossier')){
						$.post("CD",{"id":index,"type":typeprocNV.val(),"desc":descNV.val(),"etat":etatavNV.val(),"operation":"modifier"}, function(data){
 if(etatavNV.val()==1){stat = "premier instance"}else if(etatavNV.val()==2){stat = "deuxieme instance"}else if(etatavNV.val()==3){stat="troisieme instance"}							
					    	if(data==1){
					    		$("#mod").hide();
					    		$("#tab").show();
					    		$(".search").each(function(){  
					    			  if($(this).children().children().val() == index){
					    				  
					    				// change affichage
					    				$(this).children().eq(1).children().eq(5).children().eq(1).text(typeprocNV.val())
					    				$(this).children().eq(1).children().eq(6).children().eq(1).text(stat)
					    				$(this).children().eq(1).children().eq(7).children().eq(1).text(descNV.val())
					    				
					    			  }
					    		})
					    		$(".affiche").each(function(){
										  
										  if(index == $(this).parent().parent().parent().children().eq(1).text()){							  	
							    				$(this).parent().parent().parent().children().eq(5).text(typeprocNV.val())
							    				$(this).parent().parent().parent().children().eq(6).text(stat)
										  }  
								})
					    	}else {
					    		alert('un erreur est du lors du modification');
					    	}
					    })
						}else{
							$("#mod").hide();
					  		$("#tab").show();
					  		etatavNV.val(etatav)
							typeprocNV.val(typeproc)
							descNV.val(desc)
						}
				  }else if( desc == descNV.val() && typeproc == typeprocNV.val() && etatav == etatavNV.val()   ){
			  		  $("#mod").hide();
			  		  $("#tab").show();
			  		  
			  	  }
			})
		  }else{
			  $(this).hide()
			  
		  }
	  })
	  
	  
	  
  });

  
  $(".supprime").on("click", function(){
	  var index = $(this).parent().parent().parent().children().eq(1).text();
	  var supp = this;
	  if(confirm('voulez vous vraiment supprimer cette dossier')){
	  $.post("CD",{"id":index,"operation":"delete"}, function(data){
	    	if(data==1){
	    		$(supp).parent().parent().parent().remove();
	    	}else {
	    		alert('un erreur est du lors dans suppression');
	    	}

	  })
	  }
  });

   
  
  
  $(".tr-shadow").on("dblclick", function(){
	  var index = $(this).children().eq(1).text();
	  location.assign("./ConsulterProces?idDos="+index);
		  
  });
  
  

  
});