active=document.getElementsByClassName("active");
	
	for(i=0;i<active.length;i++){
		active[i].classList.remove("active");
		i--;
	}
	alert(1)
	document.getElementById("accueil").className += "active";
	//document.getElementById("accueil").parentElement.previousElementSibling.className += " active";


$(".tr-shadow").on("dblclick", function(){
	  var index = $(this).children().eq(1).text();
	  location.assign("./ConsulterProces?idProc="+index);
	  	  
  });
  
  
 function afficher(){
	 $(".tr-shadow").each( function(){
		  var index = $("select#aff").children("option:selected").val();
		  if(index == $(this).children().eq(6).text()){
			  $(this).show();
		  }else if(index == ""){
			  $(this).show();
		  }else{
			  $(this).hide();
		  }
		  	  
	  });
	  
 }