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
	var nomRegexAC = /^[a-zA-Z]{2,}$/;
	var cinRegexAC = /^([a-zA-Z]{1,2})([0-9]{4,10})$/;
	var emailRegexAC = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var dateRegexAC = /^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$/;
	var phoneRegexAC = /(^[0-9]{10}$)|(^(\+)[0-9]{12}$)/;	
	var adresseRegexAC = /^[0-9a-zA-Z\s]*$/;
	var factureRegexAC = /^[0-9]+$/;
	var avocatAdvRegexAC = /^[a-zA-Z\s]{2,}$/;
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

function validationNomAC(){
	if(nomRegexAC.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
		
}

function validationCinAC(){
	if(cinRegexAC.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}

function validationDateAC(){
	if(dateRegexAC.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}

function validationAdresseAC(){
	if(adresseRegexAC.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}

function validationPhoneAC(){
	if(phoneRegexAC.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}

function validationEmailAC(){
	if(emailRegexAC.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}























// JavaScript for label effects only
	$(window).load(function(){
        
		$(".col-3 input").val("");
		
		$(".input-effect input").focusout(function(){
			if($(this).val() != ""){
				$(this).addClass("has-content");
			}else{
				$(this).removeClass("has-content");
			}
		})
$("#dateNais").click(function(){
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
       $("#submit").click(function(){
    	   var date = new Date($('#dateNais').val());
    	   day = date.getDate();
    	   month = date.getMonth() + 1;
    	   year = date.getFullYear();
    	   var aniv = [year, month, day].join('/');
    	   var nat = $("select#d").children("option:selected").val();
    	   $.post("Add",{"lieuNais":lieuNaissanceAC.value,"nom":nomAC.value,"nationalite":nat,"prenom":prenomAC.value,"dateNais":aniv,"cin":cinAC.value,"telephone":phoneAC.value,"email":emailAC.value,"adresse":adresseAC.value,"municipale":municipaleAC.value}, function(data){
    	    	if(data==1){
    	    		alert(hello)
    	    	}else{
    	    		window.location.href = "http://localhost:8080/Avocat/WEB-INF/views/pages/adminAuthentification"
    	    	}
    	    		
    	    });
                
       })
        
	});