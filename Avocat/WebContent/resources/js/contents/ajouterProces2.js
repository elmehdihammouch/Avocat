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

	

//ensemble des regexps 
	var nomRegex = /^[a-zA-Z]{2,}$/;
	var cinRegex = /^([a-zA-Z]{1,2})([0-9]{4,10})$/;
	var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var dateRegex = /^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$/;
	var phoneRegex = /(^[0-9]{10}$)|(^(\+)[0-9]{12}$)/;	
	var adresseRegex = /^[0-9a-zA-Z\s]*$/;
	var factureRegex = /^[0-9]+$/;
	var avocatAdvRegex = /^[a-zA-Z\s]{2,}$/;
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
			backSubmitButton.style.display = "none";
			changeDisplay2.style.display = "block";
			
			
		}
		else{alert("veillez choisir un dossier")}
		
	}

	else if(choixDossier.style.display=="none" && proces.style.display=="block" && fileUpload.style.display=="none" && facture.style.display=="none" ){
		
		if( nomRegex.test(nom.value)==true && nomRegex.test(prenom.value)==true && cinRegex.test(cinAdv.value)==true && adresseRegex.test(adresse.value)==true && avocatAdvRegex.test(avocatAdv.value0==true) ){
			
			choixDossier.style.display="none";
			proces.style.display='none';
			fileUpload.style.display="block";
			facture.style.display="none";
			
			
		}
		else {
			alert("certains champs sont vides ou invalides")
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
		backSubmitButton.style.display = "block";
		changeDisplay2.style.display = "none";
		
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
		document.getElementById("submitButton").parentElement.style.display="none";
		document.getElementById("changeDisplay1").style.display="block";	
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
	document.getElementById("creerProces").className += "active";
	document.getElementById("creerProces").parentElement.previousElementSibling.className += " active";

};

window.onload = function(){
	
	inp=document.getElementsByClassName("effect-16");
	
	for(i=0;i<inp.length;i++){
		if(inp[i].value!=""){
			inp[i].className += " has-content";
		}
		
	}
	

};









//verification avec le serveur
window.onload = function(){
	$("#datePay").click(function(){
        $(this).prop('type','datetime-local');
	})
    $("#datePay").blur(function(){
        $(this).prop('type','text');
    })
}

window.onload = function(){
	$("#dateNotif").click(function(){
        $(this).prop('type','datetime-local');
	})
    $("#dateNotif").blur(function(){
        $(this).prop('type','text');
    })
}