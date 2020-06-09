	var  	nomAC=document.getElementById("nom");
	var  	prenomAC=document.getElementById("prenom");
	var  	emailAC=document.getElementById("email");
	var  	phoneAC=document.getElementById("telephone");
	var  	cinAC=document.getElementById("cin");
	var  	dateNaissanceAC=document.getElementById("dateNais");
	var  	lieuNaissanceAC=document.getElementById("lieuNais");
	var  	adresseAC=document.getElementById("adresse");
	var  	municipaleAC=document.getElementById("municipale");	
    var 	choixConsultaion=document.getElementById("choixConsultaion");
	var     consultation=document.getElementById("consultation");
	var 	titre=document.getElementById("titre_display");
	var 	img=document.getElementById("img_display");
	var  	cin=document.getElementById("cinAC");
//ensemble des Regexps 
	var nomRegex = /^[a-zA-Z]{2,}$/;
	var cinRegex = /^([a-zA-Z]{1,2})([0-9]{4,10})$/;
	var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var dateRegex = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
	var phoneRegex = /(^[0-9]{10}$)|(^(\+)[0-9]{12}$)/;	
	var adresseRegex = /^[0-9a-zA-Z\s]*$/;
	var factureRegex = /^[0-9]+$/;
	var avocatAdvRegex = /^[a-zA-Z\s]{2,}$/;
//listeners
//listeners for inputs 
nomAC.addEventListener("keyup",validationNomAC)	;
prenomAC.addEventListener("keyup",validationNomAC);
cinAC.addEventListener("keyup",validationCinAC);
adresseAC.addEventListener("keyup",validationAdresseAC);
emailAC.addEventListener("keyup",validationEmailAC);
phoneAC.addEventListener("keyup",validationPhoneAC);
//dateNaissanceAC.addEventListener("keyup",validationDateAC);
lieuNaissanceAC.addEventListener("keyup",validationAdresseAC);
municipaleAC.addEventListener("keyup",validationAdresseAC);
//fonctions de validation 
cin.addEventListener("keyup",validationCinAC);




function validationCin(){
	if(cinRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}
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

$("#changeDisplay1").click(function(){
	if(choixConsultaion.style.display=="block" && consultation.style.display=="none" && $('#cinAC').hasClass('effect-16') ){
		$.post("AC",{"operation":"check","cinClientAD":cin.value}, function(data){
			if(cinRegex.test(cin.value)==true && $('#cinAC').hasClass('effect-16')){
				if(data==1){
					document.getElementById("add").style.display="none";
					choixConsultaion.style.display='block';
					consultation.style.display='block';			
					$("#divadd").hide();
					$("#divsuiv").hide();
					$("#divconf").show();
					titre.style.display="none";
					img.style.display="none";
					img.nextElementSibling.style.display="none";
					titre.nextElementSibling.children[0].style.display="none";
				}else if(data != 1){
					alert("ce client n'existe deja ")
				}}
	
		})
	
}})
$("#confirmer").click(function(){
	var	type = $("#type").children("option:selected").val();
	if(type!='' && factureRegex.test($("#frais").val())==true){
	   $.post("AC",{"type":$("#type").children("option:selected").val(),"frais":$("#frais").val(),"desc":$("#desc").val(),"operation":"addc","cinClientAD":cin.value}, function(data){
	    	alert($("select#type").children("option:selected").val())
	    		
	   })        }else{
		   if(factureRegex.test($("#frais").val())==false){$("#frais").addClass("has-content effect-16-validation")}
		   if(type == ""){$("select#type").addClass("has-content effect-16-validation")}
		   
	   }
   })

$("#submit").click(function(){
	   var date = new Date($('#dateNais').val());
	   day = date.getDate();
	   month = date.getMonth() + 1;
	   year = date.getFullYear();
	   var aniv = [year, month, day].join('-');
	   var nat = $("select#d").children("option:selected").val();
	   if(nomRegex.test(nomAC.value)==true && nomRegex.test(prenomAC.value)==true && cinRegex.test(cinAC.value)==true && emailRegex.test(emailAC.value)==true&& phoneRegex.test(phoneAC.value)==true && nat != "" && adresseRegex.test(municipaleAC.value)==true && adresseRegex.test(lieuNaissanceAC.value)==true && adresseRegex.test(adresseAC.value)==true && dateRegex.test([day, month, year].join('/'))==true){
	   $.post("AC",{"lieuNais":lieuNaissanceAC.value,"nom":nomAC.value,"nationalite":nat,"prenom":prenomAC.value,"dateNais":aniv,"cin":cinAC.value,"telephone":phoneAC.value,"email":emailAC.value,"adresse":adresseAC.value,"municipale":municipaleAC.value,"operation":"add"}, function(data){
	    	if(data==1){
	    		document.getElementById("add").style.display="none";
				choixConsultaion.style.display='none';
				consultation.style.display='block';			
				$("#divadd").hide();
				$("#divsuiv").hide();
				$("#divconf").show();
				titre.style.display="none";
				img.style.display="none";
				img.nextElementSibling.style.display="none";
				titre.nextElementSibling.children[0].style.display="none";
				
	    	}else{
	    		alert("erreur dans dans server");
	    	}
	    		
	    });}else{
	    	if(emailRegex.test(emailAC.value)==false){$("#email").addClass("has-content effect-16-validation")}
	    	if(nomRegex.test(nomAC.value)==false){$("#nom").addClass("has-content effect-16-validation")}
	    	if(nomRegex.test(prenomAC.value)==false){$("#prenom").addClass("has-content effect-16-validation")}
	    	if(cinRegex.test(cinAC.value)==false){$("#cin").addClass("has-content effect-16-validation")}
	    	if(phoneRegex.test(phoneAC.value)==false){$("#telephone").addClass("has-content effect-16-validation")}
	    	if(adresseRegex.test(adresseAC.value)==false){$("#adresse").addClass("has-content effect-16-validation")}
	    	if(dateRegex.test([day, month, year].join('/'))==false){$("#dateNais").addClass("has-content effect-16-validation")}
	    	if(adresseRegex.test(lieuNaissanceAC.value)==false){$("#lieuNais").addClass("has-content effect-16-validation")}
	    	if(adresseRegex.test(municipaleAC.value)==false){$("#municipale").addClass("has-content effect-16-validation")}
	    	if(nat==""){$("select#d").addClass("has-content effect-16-validation")}
	
	    }

   })

$(window).load(function(){        
	$("#frais").change(function(){
		if(factureRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
		else {this.className="effect-16"}
		});
		$(".col-3 input").val("");
		$(".input-effect input").focusout(function(){
			if($(this).val() != ""){
				$(this).addClass("has-content");
			}else{
				$(this).removeClass("has-content");
			}
		})
		$("#dateNais").focus(function(){
            $(this).prop('type','date');
		})
        $("#dateNais").blur(function(){
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
		$("select#type").focusout(function(){
             
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
			document.getElementById("add").style.display="none";
			choixConsultaion.style.display='block';
			consultation.style.display='none';
			$("#divadd").show();
			$("#divsuiv").show();
			titre.style.display="block";
			img.style.display="block";
			img.nextElementSibling.style.display="block";
			titre.nextElementSibling.children[0].style.display="block";
			
		})
		$("#nouveauClientAD").click(function(){
			$.post("AC",{"operation":"check","cinClientAD":cin.value}, function(data){
				if(cinRegex.test(cin.value)==true){
					if(data!=1 && confirm("voulez vous ajouter un nouveau client" )){
						document.getElementById("add").style.display="block";
						choixConsultaion.style.display='none';
						consultation.style.display='none';			
						$("#divadd").hide();
						$("#divsuiv").hide();
						titre.style.display="none";
						img.style.display="none";
						img.nextElementSibling.style.display="none";
						titre.nextElementSibling.children[0].style.display="none";
						$("#cin").val(cin.value);
						$("#cin").addClass("has-content effect-16")
					}else if(data == 1){
						alert("ce client existe deja ")
					}}else{alert("CIN n'est pas valide")}
					
			})
			})
			
		
		
			
})


//script relative aux relations entre les pages

window.onload = function(){
	
	active=document.getElementsByClassName("active");

	for(i=0;i<active.length;i++){
		active[i].classList.remove("active");
		i--;
	}
	document.getElementById("creerConsultation").className += "active";
	document.getElementById("creerConsultation").parentElement.previousElementSibling.className += " active";

};