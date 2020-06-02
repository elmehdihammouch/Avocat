
//ensemble des divs
	var 	choixClient=document.getElementById("choixClient");
	var     dossier=document.getElementById("dossier");
	var     procesAD=document.getElementById("procesAD");
	var 	changeDisplay1AD=document.getElementById("changeDisplay1AD");
	var 	changeDisplay2AD=document.getElementById("changeDisplay2AD");

//ensemble des divs d'ajout du proces
	
	
	var     proces=document.getElementById("proces");
	var     fileUpload=document.getElementById("file_upload");
	var     facture=document.getElementById("facture");
	var 	titre=document.getElementById("titre_display");
	var 	img=document.getElementById("img_display");

//ensemble des inputs d'ajout du dossier 
	var 	cinClientAD=document.getElementById("cinClientAD");


//ensemble des inputs d'ajout du proces
	var 	nom=document.getElementById("nomAdv");
	var 	prenom=document.getElementById("prenomAdv");	
	var 	cin=document.getElementById("cinAdv");
	var 	adresse=document.getElementById("adresseAdv");
	var 	avocatAdv=document.getElementById("avocatAdv");
	var 	FMB=document.getElementById("FMB");

	//ensemble des regexps 
	var nomRegex = /^[a-zA-Z]{2,}$/;
	var cinRegex = /^([a-zA-Z]{1,2})([0-9]{4,10})$/;
	var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var dateRegex = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
	var phoneRegex = /(^[0-9]{10}$)|(^(\+)[0-9]{12}$)/;	
	var adresseRegex = /^[0-9a-zA-Z\s]*$/;
	var factureRegex = /^[0-9]+$/;
	var avocatAdvRegex = /^[a-zA-Z\s]{2,}$/;	


	var  	nomAC=document.getElementById("nom");
	var  	prenomAC=document.getElementById("prenom");
	var  	emailAC=document.getElementById("email");
	var  	phoneAC=document.getElementById("telephone");
	var  	cinAC=document.getElementById("cin");
	var  	dateNaissanceAC=document.getElementById("dateNais");
	var  	lieuNaissanceAC=document.getElementById("lieuNais");
	var  	adresseAC=document.getElementById("adresse");
	var  	municipaleAC=document.getElementById("municipale");
	
//ensemble des regexps 	
//listeners
	
//listeners for inputs 
nomAC.addEventListener("keyup",validationNomAC)	;
prenomAC.addEventListener("keyup",validationNomAC);
cinAC.addEventListener("keyup",validationCinAC);
adresseAC.addEventListener("keyup",validationAdresseAC);
emailAC.addEventListener("keyup",validationEmailAC);
phoneAC.addEventListener("keyup",validationPhoneAC);
//dateNaissanceAC.addEventL0istener("keyup",validationDateAC);
lieuNaissanceAC.addEventListener("keyup",validationAdresseAC);

municipaleAC.addEventListener("keyup",validationAdresseAC);


//fonctions de validation 

function validationNomAC(){
	if(nomRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
		
}

function validationCinAC(){
	if(cinRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}

function validationDateAC(){
	if(dateRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}

function validationAdresseAC(){
	if(adresseRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}

function validationPhoneAC(){
	if(phoneRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}

function validationEmailAC(){
	if(emailRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}




//listeners
	changeDisplay1AD.addEventListener('click',changeDisplayF1AD);
	changeDisplay2AD.addEventListener('click',changeDisplayF2AD);

//listeners pour l'ajout du proces
	

//listeners pour les inputs d'ajout du dossier
cinClientAD.addEventListener("keyup",validationCin);		

//listeners pour les i,puts d'ajout du proces
nom.addEventListener("keyup",validationNom)	;
prenom.addEventListener("keyup",validationNom);
cin.addEventListener("keyup",validationCin);
adresse.addEventListener("keyup",validationAdresse);
avocatAdv.addEventListener("keyup",validationAvocatAdv);
document.getElementById("FMB").addEventListener("keyup",validationFacture);




//fonctions de validation 

function validationNom(){
	if(nomRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
		
}

function validationCin(){
	if(cinRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}

function validationDate(){
	if(dateRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}

function validationAdresse(){
	if(adresseRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}

function validationPhone(){
	if(phoneRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}

function validationFacture(){
	if(factureRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}

function validationAvocatAdv(){
	if(avocatAdvRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}
















function changeDisplayF1AD(){
	if(choixClient.style.display=="block" && dossier.style.display=="none" && procesAD.style.display=="none")	{
		if(cinRegex.test(cinClientAD.value)==true){
			$.post("AD",{"cinClientAD":cinClientAD.value,"operation":"check"}, function(data){
				if(data==1 ){
					choixClient.style.display="none";
					dossier.style.display="block";
					procesAD.style.display="none";
					changeDisplay2AD.parentElement.style.display="block";
					changeDisplay1AD.parentElement.className="col-xs-3 col-xs-offset-2 herite-ajout-proces";
							titre.style.display="none";
							img.style.display="none";
							img.nextElementSibling.style.display="none";
							titre.nextElementSibling.children[0].style.display="none";
					
				}else{alert("ce client n'existe pas")}
			})
			//if(/*ici on realisera une recherche sur le client saisie par l'utilisateur*/){
				
			//}	
		}
		else{alert("veillez saisir un CIN valide");}			
	}

	else if(choixClient.style.display=="none" && dossier.style.display=="block" && procesAD.style.display=="none"){
		choixClient.style.display="none";
		dossier.style.display="none";
		procesAD.style.display="block";
		
					//proces js


	}else if( proces.style.display=="block" && fileUpload.style.display=="none" && facture.style.display=="none" ){
		
		if( nomRegex.test(nomAdv.value)==true && nomRegex.test(prenomAdv.value)==true && cinRegex.test(cinAdv.value)==true && adresseRegex.test(adresseAdv.value)==true && avocatAdvRegex.test(avocatAdv.value==true) ){
			proces.style.display='none';
			fileUpload.style.display="block";
			facture.style.display="none";
			changeDisplay1AD.focus();
		}else{
			alert("certains champs sont vides ou invalides")
		}
		
	}

	else if( proces.style.display=="none" && fileUpload.style.display=="block" && facture.style.display=="none" ){
		
			proces.style.display='none';
			fileUpload.style.display="none";
			facture.style.display="block";
			document.getElementById("SUBMIT").parentElement.style.display="block";
			changeDisplay1AD.parentElement.style.display="none";
			document.getElementById("facture").focus();
		
	}

	else if( proces.style.display=="none" && fileUpload.style.display=="none" && facture.style.display=="block" ){
		
		if(factureRegex.test(FMB.value)==true){
			proces.style.display='none';
			fileUpload.style.display="none";
			facture.style.display="block";
			
		}
		else {
			alert("certains champs sont vides ou invalides");
		}
		
	}

}

function changeDisplayF2AD(){
	/*if(choixClient.style.display=="none" && dossier.style.display=="none" && procesAD.style.display=="none")	{
		choixClient.style.display="none";
		dossier.style.display="block";
		procesAD.style.display="none";
		changeDisplay2AD.parentElement.style.display="block";
		changeDisplay1AD.parentElement.className="col-xs-3 col-xs-offset-2 herite-ajout-proces";
				titre.style.display="none";
				img.style.display="none";
				img.nextElementSibling.style.display="none";
				titre.nextElementSibling.children[0].style.display="none";
	}*/

	 if(choixClient.style.display=="none" && dossier.style.display=="block" && procesAD.style.display=="none"){
		choixClient.style.display="block";
		dossier.style.display="none";
		procesAD.style.display="none";
		changeDisplay2AD.parentElement.style.display="none";
		changeDisplay1AD.parentElement.className="col-xs-3 col-xs-offset-5 herite-ajout-proces";
		titre.style.display="block";
		img.style.display="block";
		img.nextElementSibling.style.display="block";
		titre.nextElementSibling.children[0].style.display="block";


	}else if( proces.style.display=="block" && fileUpload.style.display=="none" && facture.style.display=="none" ){
//changement du display des grandes divs 
		choixClient.style.display="none";
		dossier.style.display="block";
		procesAD.style.display="none";
		changeDisplay1AD.parentElement.style.display="block";
		changeDisplay2AD.parentElement.style.display="block";
	}

	else if( proces.style.display=="none" && fileUpload.style.display=="block" && facture.style.display=="none" ){
		proces.style.display='block';
		fileUpload.style.display="none";
		facture.style.display="none";		
	}

	else if( proces.style.display=="none" && fileUpload.style.display=="none" && facture.style.display=="block" ){
		proces.style.display='none';
		fileUpload.style.display="block";
		facture.style.display="none";
		changeDisplay1AD.parentElement.style.display="block";
		document.getElementById("SUBMIT").parentElement.style.display="none";
	}

	if(proces.style.display=="none" && fileUpload.style.display=="none" && facture.style.display=="none" ){

	}

}



$(window).load(function(){
		$(".col-3 input").val("");
		
		$(".input-effect input").focusout(function(){
			if($(this).val() != ""){
				$(this).addClass("has-content");
			}else{
				$(this).removeClass("has-content");
			}
		})
	});

$(window).load(function(){
			$(".col-3 input").val("");
			
			$(".input-effect select").focusout(function(){
				if($(this).text() != ""){
					$(this).addClass("has-content");
				}else{
					$(this).removeClass("has-content");
				}
			})
	});

window.onload = function(){
	
	active=document.getElementsByClassName("active");
	j = active.length;
/*	while(active.length>0){
		active[j-1].classList.remove("active");
		j--;
	}*/
	for(i=0;i<active.length;i++){
		active[i].classList.remove("active");
		i--;
	}
	document.getElementById("creerDossier").className += "active";
	document.getElementById("creerDossier").parentElement.previousElementSibling.className += " active";
	$("#dateNais").focus(function(){
        $(this).prop('type','date');
	})
    $("#dateNais").blur(function(){
        $(this).prop('type','text');
    })
    
inp=document.getElementsByClassName("effect-16");
	
	for(i=0;i<inp.length;i++){
		if(inp[i].value!=""){
			inp[i].className += " has-content";
		}
		
	}
	
	$("#datePay").focus(function(){
        $(this).prop('type','datetime-local');
	})
    $("#datePay").blur(function(){
        $(this).prop('type','text');
    })
    
    $("#dateNotif").focus(function(){
        $(this).prop('type','datetime-local');
	})
    $("#dateNotif").blur(function(){
        $(this).prop('type','text');
    })



	
    $("select#d").focusout(function(){
         
      if($(this).children("option:selected").val() !=""){

          $(this).addClass("has-content");
          $(this).addClass("effect-16");
          $(this).removeClass("effect-16-validation");
		}else{
          $(this).removeClass("has-content");
          $(this).removeClass("effect-16");
          $(this).addClass("effect-16-validation");
		}
	})
	$("#return").click(function(){
		choixClient.style.display="block";
		dossier.style.display="none";
		procesAD.style.display="none";
		changeDisplay2AD.parentElement.style.display="none";
		changeDisplay1AD.style.display="block";
		titre.style.display="block";
		img.style.display="block";
		img.nextElementSibling.style.display="block";
		titre.nextElementSibling.children[0].style.display="block";
		document.getElementById("add").style.display="none";
	})
	$("#nouveauClientAD").click(function(){
		$.post("AD",{"cinClientAD":cinClientAD.value,"operation":"check"}, function(data){
			if(cinRegex.test(cinClientAD.value)==true){
			if(data!=1 && confirm("voulez vous ajouter un nouveau client" )){
				document.getElementById("add").style.display="block";
				choixClient.style.display="none";
				changeDisplay1AD.style.display="none";
				changeDisplay2AD.style.display="none";
				titre.style.display="none";
				img.style.display="none";
				img.nextElementSibling.style.display="none";
				titre.nextElementSibling.children[0].style.display="none";
				$("#cin").val(cinClientAD.value);
				$("#cin").addClass("has-content effect-16")
			}else if(data == 1){
				alert("ce client existe deja ")
			}}else{alert("CIN n'est pas valide")}
			
		})
		
	})
   $("#submit").click(function(){
	   var date = new Date($('#dateNais').val());
	   day = date.getDate();
	   month = date.getMonth() + 1;
	   year = date.getFullYear();
	   var aniv = [year, month, day].join('-');
	   var nat = $("select#d").children("option:selected").val();
	   if(nomRegex.test(nomAC.value)==true && nomRegex.test(prenomAC.value)==true && cinRegex.test(cinAC.value)==true && emailRegex.test(emailAC.value)==true && dateRegex.test([day, month, year].join('/'))==true){
	   $.post("AD",{"lieuNais":lieuNaissanceAC.value,"nom":nomAC.value,"nationalite":nat,"prenom":prenomAC.value,"dateNais":aniv,"cin":cinAC.value,"telephone":phoneAC.value,"email":emailAC.value,"adresse":adresseAC.value,"municipale":municipaleAC.value,"operation":"add"}, function(data){
	    	if(data==1){
	    		document.getElementById("add").style.display="none";
	    		choixClient.style.display="none";
				dossier.style.display="block";
				procesAD.style.display="none";
				changeDisplay2AD.parentElement.style.display="block";
				changeDisplay1AD.style.display="block";
				titre.style.display="none";
				img.style.display="none";
				img.nextElementSibling.style.display="none";
				titre.nextElementSibling.children[0].style.display="none";
	    	}else{
	    		
	    	}
	    		
	    });}else{
	    	alert("nom : "+nomRegex.test(nomAC.value)+"pre" +
	    			"nom : "+nomRegex.test(prenomAC.value)+"cin : "+cinRegex.test(cinAC.value)+"email : "+emailRegex.test(emailAC.value)+"date : "+dateRegex.test([day, month, year].join('/'))+[day, month, year].join('/')+"  aniv :"+aniv)}
	    		
            
   })


};


//script relative aux relations entre les pages

window.onload = function(){
	
	active=document.getElementsByClassName("active");

	for(i=0;i<active.length;i++){
		active[i].classList.remove("active");
		i--;
	}
	document.getElementById("creerDossier").className += "active";
	document.getElementById("creerDossier").parentElement.previousElementSibling.className += " active";

};