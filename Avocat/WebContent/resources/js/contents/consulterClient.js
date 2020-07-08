	  var nomRegex = /^[a-zA-Z]{2,}$/;
	  var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  var phoneRegex = /(^[0-9]{10}$)|(^(\+)[0-9]{12}$)/;
	  var adresseRegex = /^[0-9a-zA-Z\s]*$/;	
	  var passRegex = /^[0-9a-zA-Z]{2,}$/;
	  
	  
//header js
	  active=document.getElementsByClassName("active");
		
		for(i=0;i<active.length;i++){
			active[i].classList.remove("active");
			i--;
		}
		document.getElementById("consulterClient").className += "active";
		document.getElementById("consulterClient").parentElement.previousElementSibling.className += " active";	  
//	  
	  
$(document).ready(function(){
	
	$("#print").on("click",function(){
		var OriginalPrintContents =  document.getElementById("ClientBox").innerHTML;
		var printContents = document.getElementById("ClientBox");  
		
		//remove() for box 
		 printContents.children[1].remove();
		 
		
	    var printContents = document.getElementById("ClientBox");    
	 var originalContents = document.body.innerHTML;      
	 document.body.innerHTML = printContents.innerHTML;
	 
	 window.print();     
	 document.body.innerHTML = originalContents;
	 // for box
	 document.getElementById("ClientBox").innerHTML = OriginalPrintContents;
		  
		  
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
  
  
  
  
  /* 
  $("#btnClose").on("click", function(){
	  $("#overlay").hide();
  })
  
  $("#btnClos").on("click", function(){
	  $("#over").hide();  
  })*/
  
  
  $(".modifier").on("click", function(){
	  var index = $(this).parent().parent().parent().children().eq(1).text();
	  $("#modifierCl").unbind();
	  $(".update").each(function(){
		  if($(this).children().children().val() == index){
				  $(this).show();
				  $("#mod").show();
				  $("#tab").hide();
				  nom = $(this).children().eq(1).children().eq(0).children().children().eq(1).val();
				  prenom = $(this).children().eq(1).children().eq(1).children().children().eq(1).val();
				  email = $(this).children().eq(1).children().eq(2).children().children().eq(1).val();
				  adresse = $(this).children().eq(1).children().eq(3).children().children().eq(1).val();
				  municipale = $(this).children().eq(1).children().eq(4).children().children().eq(1).val();
				  lieunais = $(this).children().eq(1).children().eq(5).children().children().eq(1).val();
				  tel = $(this).children().eq(1).children().eq(6).children().children().eq(1).val();
				  datenais = $(this).children().eq(1).children().eq(7).children().children().eq(1).val();
				  emailclient = $(this).children().eq(1).children().eq(8).children().children().eq(1).val();
				  password = $(this).children().eq(1).children().eq(9).children().children().eq(1).val();
				  statut = $(this).children().eq(1).children().eq(10).children().children().eq(1).val();
				  that = this;
				  nomNV = $(that).children().eq(1).children().eq(0).children().children().eq(1);
				  prenomNV = $(that).children().eq(1).children().eq(1).children().children().eq(1);
				  emailNV = $(that).children().eq(1).children().eq(2).children().children().eq(1);
				  adresseNV = $(that).children().eq(1).children().eq(3).children().children().eq(1);
				  municipaleNV = $(that).children().eq(1).children().eq(4).children().children().eq(1);
				  lieunaisNV = $(that).children().eq(1).children().eq(5).children().children().eq(1);
				  telNV = $(that).children().eq(1).children().eq(6).children().children().eq(1);
				  datenaisNV = $(that).children().eq(1).children().eq(7).children().children().eq(1);
				  emailclientNV = $(that).children().eq(1).children().eq(8).children().children().eq(1);
				  passwordNV = $(that).children().eq(1).children().eq(9).children().children().eq(1);
				  statutNV = $(that).children().eq(1).children().eq(10).children().children().eq(1);
				  	$("input").keyup(function(){
					  if(nomRegex.test(nomNV.val())==false) {nomNV.css("color","red")}	else {nomNV.css("color","#333")}
					  if(nomRegex.test(prenomNV.val())==false) {prenomNV.css("color","red")}	else {prenomNV.css("color","#333")}
					  if(emailRegex.test(emailNV.val())==false) {emailNV.css("color","red")}	else {emailNV.css("color","#333")}
					  if(adresseRegex.test(adresseNV.val())==false) {adresseNV.css("color","red")}	else {adresseNV.css("color","#333")}
					  if(adresseRegex.test(municipaleNV.val())==false) {municipaleNV.css("color","red")}	else {municipaleNV.css("color","#333")}
					  if(adresseRegex.test(lieunaisNV.val())==false) {lieunaisNV.css("color","red")}	else {lieunaisNV.css("color","#333")}
					  if(phoneRegex.test(telNV.val())==false) {telNV.css("color","red")}	else {telNV.css("color","#333")}
					  if(emailRegex.test(emailclientNV.val())==false) {emailclientNV.css("color","red")}	else {emailclientNV.css("color","#333")}
					  if(passRegex.test(passwordNV.val())==false) {passwordNV.css("color","red")}	else {passwordNV.css("color","#333")}
					  if(statutNV.val()!=0 && statutNV.val()!=1) {statutNV.css("color","red")}	else {statutNV.css("color","#333")}
				  
				  	})
				  	$("#previous").on("click",function(){
						$("#mod").hide();
						$("#tab").show();
						nomNV.val(nom)
					  	prenomNV.val(prenom)
					  	adresseNV.val(adresse)
					  	datenaisNV.val(datenais)
					  	emailclientNV.val(emailclient)
					  	emailNV.val(email)
				  		municipaleNV.val(municipale)
						lieunaisNV.val(lieunais)
						telNV.val(tel)
						passwordNV.val(password)
						statutNV.val(statut)
				  	}) 
				  	
				  $("#modifierCl").bind("click", function(){
					  if(nomRegex.test(nomNV.val()) && nomRegex.test(prenomNV.val()) && adresseRegex.test(lieunaisNV.val()) && adresseRegex.test(municipaleNV.val()) && adresseRegex.test(adresseNV.val()) && emailRegex.test(emailNV.val()) && phoneRegex.test(telNV.val()) && ( emailRegex.test(emailclientNV.val()) ) && ( passRegex.test(passwordNV.val()) ) && (statutNV.val() == 1 || statutNV.val() == 0 ) && (nomNV.val() != nom || prenomNV.val() != prenom || emailNV.val() != email || adresseNV.val() != adresse || emailclientNV.val() != emailclient || municipaleNV.val() != municipale || passwordNV.val() != password || statutNV.val()!= statut || telNV.val() != tel || lieunais != lieunaisNV.val() || datenais != datenaisNV.val())   ){
						if(confirm('voulez vous vraiment modifier les donnes')){
						  $.post("ConsulterClient",{"id":index,"datenais":datenaisNV.val(),"nom":nomNV.val(),"prenom":prenomNV.val(),"email":emailNV.val(),"adresse":adresseNV.val(),"municipale":municipaleNV.val(),"lieunais":lieunaisNV.val(),"telephone":telNV.val(),"emailCl":emailclientNV.val(),"password":passwordNV.val(),"statut":statutNV.val(),"operation":"modifier"}, function(data){
					    	if(data==1){
					    		$("#mod").hide();
					    		$("#tab").show();
					    		$(".search").each(function(){  
					    			  if($(this).children().children().val() == index){
					    				  
					    				// change affichage
					    				$(this).children().eq(1).children().eq(0).children().eq(1).text(nomNV.val())
					    				$(this).children().eq(1).children().eq(1).children().eq(1).text(prenomNV.val())
					    				$(this).children().eq(1).children().eq(3).children().eq(1).text(emailNV.val())
					    				$(this).children().eq(1).children().eq(4).children().eq(1).text(adresseNV.val())
					    				$(this).children().eq(1).children().eq(5).children().eq(1).text(municipaleNV.val())
					    				$(this).children().eq(1).children().eq(6).children().eq(1).text(lieunaisNV.val())
					    				$(this).children().eq(1).children().eq(8).children().eq(1).text(telNV.val())
					    				$(this).children().eq(1).children().eq(9).children().eq(1).text(datenaisNV.val())
					    				$(this).children().eq(1).children().eq(10).children().eq(1).text(emailclientNV.val())
					    				$(this).children().eq(1).children().eq(11).children().eq(1).text(passwordNV.val())
					    				$(this).children().eq(1).children().eq(12).children().eq(1).text(statutNV.val())
					    				
					    			  }
					    		})
					    		$(".afficher").each(function(){
										  
										  if(index == $(this).parent().parent().parent().children().eq(1).text()){
											  
											  	$(this).parent().parent().parent().children().eq(2).text(nomNV.val())
							    				$(this).parent().parent().parent().children().eq(3).text(prenomNV.val())
							    				$(this).parent().parent().parent().children().eq(5).children().text(emailNV.val())
							    				$(this).parent().parent().parent().children().eq(6).children().text(adresseNV.val())
							    				$(this).parent().parent().parent().children().eq(7).text(telNV.val())
										  }  
								})
					    	}else {
					    		alert('un erreur est du lors du modification');
					    	}
					    })}else{
					    	$("#mod").hide();
					    	$("#tab").show();
					    	
					    	nomNV.val(nom)
					    	prenomNV.val(prenom)
					    	adresseNV.val(adresse)
					    	datenaisNV.val(datenais)
					    	emailclientNV.val(emailclient)
					    	emailNV.val(email)
					    	municipaleNV.val(municipale)
							lieunaisNV.val(lieunais)
							telNV.val(tel)
							passwordNV.val(password)
							statutNV.val(statut)
					    	
					    	
					    }
			  	  
				  }else if( nomNV.val() == nom && prenomNV.val() == prenom && emailNV.val() == email && adresseNV.val() == adresse && emailclientNV.val() == emailclient && municipaleNV.val() == municipale && passwordNV.val() == password && statutNV.val()== statut && telNV.val() == tel && lieunais == lieunaisNV.val() && datenais == datenaisNV.val()   ){
			  		  $("#mod").hide();
			  		  $("#tab").show();
			  		  
			  	  }else if(nomRegex.test(nomNV.val()) && nomRegex.test(prenomNV.val()) && adresseRegex.test(lieunaisNV.val()) && adresseRegex.test(municipaleNV.val()) && adresseRegex.test(adresseNV.val()) && emailRegex.test(emailNV.val()) && phoneRegex.test(telNV.val()) && emailclient == undefined && password == undefined && statut == undefined && (nomNV.val() != nom || prenomNV.val() != prenom || emailNV.val() != email || adresseNV.val() != adresse || municipaleNV.val() != municipale || telNV.val() != tel || lieunais != lieunaisNV.val() || datenais != datenaisNV.val())   ){
			  		if(confirm('voulez vous vraiment modifier les donnes')){
			  		  $.post("ConsulterClient",{"id":index,"datenais":datenaisNV.val(),"nom":nomNV.val(),"prenom":prenomNV.val(),"email":emailNV.val(),"adresse":adresseNV.val(),"municipale":municipaleNV.val(),"lieunais":lieunaisNV.val(),"telephone":telNV.val(),"operation":"mod"}, function(data){
					    	if(data==1){
					    		$("#mod").hide();
					    		$("#tab").show();
					    		$(".search").each(function(){  
					    			  if($(this).children().children().val() == index){
					    				  
					    				// change affichage
					    				$(this).children().eq(1).children().eq(0).children().eq(1).text(nomNV.val())
					    				$(this).children().eq(1).children().eq(1).children().eq(1).text(prenomNV.val())
					    				$(this).children().eq(1).children().eq(3).children().eq(1).text(emailNV.val())
					    				$(this).children().eq(1).children().eq(4).children().eq(1).text(adresseNV.val())
					    				$(this).children().eq(1).children().eq(5).children().eq(1).text(municipaleNV.val())
					    				$(this).children().eq(1).children().eq(6).children().eq(1).text(lieunaisNV.val())
					    				$(this).children().eq(1).children().eq(8).children().eq(1).text(telNV.val())
					    				$(this).children().eq(1).children().eq(9).children().eq(1).text(datenaisNV.val())
					    				
					    			  }
					    		})
					    		$(".afficher").each(function(){
										  
										  if(index == $(this).parent().parent().parent().children().eq(1).text()){
											  
											  	$(this).parent().parent().parent().children().eq(2).text(nomNV.val())
							    				$(this).parent().parent().parent().children().eq(3).text(prenomNV.val())
							    				$(this).parent().parent().parent().children().eq(5).children().text(emailNV.val())
							    				$(this).parent().parent().parent().children().eq(6).children().text(adresseNV.val())
							    				$(this).parent().parent().parent().children().eq(7).text(telNV.val())
										  }  
								})
					    	}else {
					    		alert('un erreur est du lors du modification');
					    	}
					    })}else{
					    	$("#mod").hide();
					    	$("#tab").show();
					    	
					    	nomNV.val(nom)
					    	prenomNV.val(prenom)
					    	adresseNV.val(adresse)
					    	datenaisNV.val(datenais)
					    	emailclientNV.val(emailclient)
					    	emailNV.val(email)
					    	municipaleNV.val(municipale)
							lieunaisNV.val(lieunais)
							telNV.val(tel)
							passwordNV.val(password)
							statutNV.val(statut)
					    }
				 
			  	  }})
		  }else{
			  $(this).hide()
			  
		  }
	  })
	  
	 
	  
  });
  
  
  
  
  
  
  $(".supprimer").on("click", function(){
	  var index = $(this).parent().parent().parent().children().eq(1).text();
	  var supp = this;
	  if(confirm('voulez vous vraiment supprimer ce client')){
	  $.post("ConsulterClient",{"id":index,"operation":"delete"}, function(data){
	    	if(data==1){
	    		$(supp).parent().parent().parent().remove();
	    	}else {
	    		alert('un erreur est du lors dans suppression');
	    	}

	  })}
	  
  });

  
});