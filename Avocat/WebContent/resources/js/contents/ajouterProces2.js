//ajout des evenements sur les dossiers chargés
dossierClick();

//ensemble des divs
	
	
	var 	choixDossier=document.getElementById("choixDossier");
	var     proces=document.getElementById("proces");
	var     fileUpload=document.getElementById("file_upload");
	var     facture=document.getElementById("facture");
	var 	changeDisplay1=document.getElementById("changeDisplay1");
	var 	changeDisplay2=document.getElementById("changeDisplay2");
	var 	backSubmitButton=document.getElementById("backSubmitButton");
	var 	titre=document.getElementById("titre_display");
	var 	img=document.getElementById("img_display");

//ensemble des inputs

	var 	nom=document.getElementById("nom");
	var 	prenom=document.getElementById("prenom");	
	var 	cinAdv=document.getElementById("cinAdv");
	var 	adresse=document.getElementById("adresse");
	var 	avocatAdv=document.getElementById("avocatAdv");
	var 	FMB=document.getElementById("FMB");
	var 	datenotif = document.getElementById("dateNotif");
	var 	datePay = document.getElementById("datePay");
	var 	dateNais = document.getElementById("dateNais");

	

//ensemble des regexps 
	var nomRegex = /^[a-zA-Z]{2,}$/;
	var cinRegex = /^([a-zA-Z]{1,2})([0-9]{4,10})$/;
	var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var dateRegex = /^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$/;
	var phoneRegex = /(^[0-9]{10}$)|(^(\+)[0-9]{12}$)/;	
	var adresseRegex = /^[0-9a-zA-Z\s]*$/;
	var factureRegex = /^[0-9]+$/;
	var avocatAdvRegex = /^[a-zA-Z\s]{2,}$/;
	var datelocal = /[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])T(2[0-3]|[01][0-9]):[0-5][0-9]/;
//listeners
	changeDisplay1.addEventListener('click',changeDisplayF1);
	changeDisplay2.addEventListener('click',changeDisplayF2);
//listeners for inputs 
nom.addEventListener("keyup",validationNom)	;
prenom.addEventListener("keyup",validationNom);
cinAdv.addEventListener("keyup",validationCin);

adresse.addEventListener("keyup",validationAdresse);
avocatAdv.addEventListener("keyup",validationAvocatAdv);
document.getElementById("FMB").addEventListener("keyup",validationFacture);
document.getElementById("FMB").addEventListener("keyup",calcul);
document.getElementById("mtPaye").addEventListener("keyup",calcul);

var tabDos = document.getElementsByClassName("dossierContent");
for(let i=0;i<tabDos.length;i++){
	tabDos[i].addEventListener("click",choixDos)
}




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














//fonction qui change le display
function changeDisplayF1(){
	
	if( choixDossier.style.display=="block" &&   proces.style.display=="none" && fileUpload.style.display=="none" && facture.style.display=="none" ){
		if(document.getElementById("idDossierClicked").value != ""){
		
			choixDossier.style.display="none";
			proces.style.display='block';
			fileUpload.style.display="none";
			facture.style.display="none";
			backSubmitButton.parentElement.style.display = "none";
			changeDisplay2.parentElement.style.display = "block";
			
			
		}
		else{alert("veillez choisir un dossier")}
		
	}

	else if(choixDossier.style.display=="none" && proces.style.display=="block" && fileUpload.style.display=="none" && facture.style.display=="none" ){
		var datenotif = $("#dateNotif").val();
		statut = $("select#statut").children("option:selected").val();
		if( nomRegex.test(nom.value)==true && nomRegex.test(prenom.value)==true &&  datelocal.test(datenotif) == true  && statut !="" ){
			
			choixDossier.style.display="none";
			proces.style.display='none';
			fileUpload.style.display="block";
			facture.style.display="none";
		}
		else {
			if(nomRegex.test(nom.value)==false){$("#nom").addClass("has-content effect-16-validation")}
			if(nomRegex.test(prenom.value)==false){$("#prenom").addClass("has-content effect-16-validation")}
			if(datelocal.test(datenotif)==false){$("#dateNotif").addClass("has-content effect-16-validation")}
			if(statut == ""){$("#statut").addClass("has-content effect-16-validation")}
		}
		
		
	}
	
	else if(choixDossier.style.display=="none" && proces.style.display=="none" && fileUpload.style.display=="block" && facture.style.display=="none" ){
		
		
			
			choixDossier.style.display="none";
			proces.style.display='none';
			fileUpload.style.display="none";
			facture.style.display="block";
			document.getElementById("changeDisplay1").style.display="none";
			document.getElementById("submitButton").parentElement.style.display="block";
			
			
		}

	else if( choixDossier.style.display=="none" && proces.style.display=="none" && fileUpload.style.display=="none" && facture.style.display=="block" ){
		
		if(factureRegex.test(FMB.value)==true){
			alert("succes");
		}
		else {
			alert("certains champs sont vides ou invalides");
		}
		
	}
	


}


function changeDisplayF2(){

	if( choixDossier.style.display=="none" && proces.style.display=="block" && fileUpload.style.display=="none" && facture.style.display=="none" ){
		
		
		choixDossier.style.display="block";
		proces.style.display='none';
		fileUpload.style.display="none";
		facture.style.display="none";
		backSubmitButton.parentElement.style.display = "block";
		changeDisplay2.parentElement.style.display = "none";
		
	}

	else if(choixDossier.style.display=="none" && proces.style.display=="none" && fileUpload.style.display=="block" && facture.style.display=="none" ){
		
		choixDossier.style.display="none";
		proces.style.display='block';
		fileUpload.style.display="none";
		facture.style.display="none";		
	}

	else if( choixDossier.style.display=="none" && proces.style.display=="none" && fileUpload.style.display=="none" && facture.style.display=="block" ){
		
		choixDossier.style.display="none";
		proces.style.display='none';
		fileUpload.style.display="block";
		facture.style.display="none";
		document.getElementById("changeDisplay1").style.display="block";
		document.getElementById("submitButton").parentElement.style.display="none";
	}

	else if(choixDossier.style.display=="block" && proces.style.display=="none" && fileUpload.style.display=="none" && facture.style.display=="none" ){
	
		
		$.post("AjouterProces",{action : "backProces1" }, function(data){});
	}


	}


//ajout des events sur les dossiers 

function dossierClick(){
	tabDossier = document.getElementsByClassName("dossierContent");
	for(i=0;i<tabDossier.length;i++){
		tabDossier[i].addEventListener("click",dossierClicked);
	}
}

function dossierClicked(){
	document.getElementById("idDossierClicked").value = this.parentElement.children[0].textContent;
	/*$.post("AjouterProces",{action : "dossierForCheck" , dossierForCheck : this.parentElement.children[0].textContent}, function(data){
		if(data==1){document.getElementById("idDossierClicked").value = this.parentElement.children[0].textContent;}
		else{alert("dossier plein")}
	});*/
	}


function choixDos(){
	for(let i=0;i<tabDos.length;i++){
		tabDos[i].parentElement.style.backgroundColor = "";
	}
	this.parentElement.style.backgroundColor = "#ccffe6";
}


function calcul(){
	
	document.getElementById("mtGlobal").value= FMB.value ;
	document.getElementById("mtRestant").value= (FMB.value) - (document.getElementById("mtPaye").value);
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
		
		$("#submitButton").click(function(){
			var mtg = $("#mtGlobal").val();
			var datepay = $("#datePay").val();
			var mtglobal =$("#mtGlobal").val();
			var mtpaye = $("#mtPaye").val();
			if(factureRegex.test(FMB.value)==true && factureRegex.test(mtg)==true && factureRegex.test(mtpaye)==true && datelocal.test(datepay) == true){
				$('#submitButton').removeAttr("type").attr("type", "submit");
			}
			else {
				if(factureRegex.test(FMB.value)==false){$("#FMB").addClass("has-content effect-16-validation")}
				if(factureRegex.test(mtg)==false){$("#mtGlobal").addClass("has-content effect-16-validation")}
				if(factureRegex.test(mtpaye)==false){$("#mtPaye").addClass("has-content effect-16-validation")}
				if(datelocal.test(datepay)==false){$("#datePay").addClass("has-content effect-16-validation")}
				
			}
	})
		
		
	});

//script du calcul de la facture






window.onload = function(){

	//script relative aux relations entre les pages	
	active=document.getElementsByClassName("active");

	for(i=0;i<active.length;i++){
		active[i].classList.remove("active");
		i--;
	}
	document.getElementById("creerProces").className += "active";
	document.getElementById("creerProces").parentElement.previousElementSibling.className += " active";
	
	inp=document.getElementsByClassName("effect-16");
	
	for(i=0;i<inp.length;i++){
		if(inp[i].value!=""){
			inp[i].className += " has-content";
		}
		
	}
	// verif date-time
	
	$("#dateNotif").change(function(){
		if(datelocal.test(datenotif)==true){$("#dateNotif").addClass("has-content effect-16-validation")}
		else{$("#dateNotif").addClass("has-content effect-16")
			$("#dateNotif").removeClass("effect-16-validation")
			}
		});
	$("#datePay").change(function(){
		if(datelocal.test(datePay)==true){$("#dateNotif").addClass("has-content effect-16-validation")}
		else{$("#datePay").addClass("has-content effect-16")
			$("#datePay").removeClass("effect-16-validation")
			}})
	// verif que select est plein
			
			
    $("select").focusout(function(){
         
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
}