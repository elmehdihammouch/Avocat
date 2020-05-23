
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
	var 	changeDisplay1=document.getElementById("changeDisplay1");
	var 	changeDisplay2=document.getElementById("changeDisplay2");
	var 	titre=document.getElementById("titre_display");
	var 	img=document.getElementById("img_display");

//ensemble des inputs d'ajout du dossier 
	var 	cinClientAD=document.getElementById("cinClientAD");


//ensemble des inputs d'ajout du proces
	var 	nom=document.getElementById("nom");
	var 	prenom=document.getElementById("prenom");	
	var 	cin=document.getElementById("cin");
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
	changeDisplay1AD.addEventListener('click',changeDisplayF1AD);
	changeDisplay2AD.addEventListener('click',changeDisplayF2AD);

//listeners pour l'ajout du proces
	changeDisplay1.addEventListener('click',changeDisplayF1);
	changeDisplay2.addEventListener('click',changeDisplayF2);

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
			//if(/*ici on realisera une recherche sur le client saisie par l'utilisateur*/){
				choixClient.style.display="none";
				dossier.style.display="block";
				procesAD.style.display="none";
				changeDisplay2AD.parentElement.style.display="block";
				changeDisplay1AD.parentElement.className="col-xs-3 col-xs-offset-2 herite-ajout-proces";
						titre.style.display="none";
						img.style.display="none";
						img.nextElementSibling.style.display="none";
						titre.nextElementSibling.children[0].style.display="none";
			//}	
		}
		else{alert("veillez saisir un CIN valide");}			
	}

	else if(choixClient.style.display=="none" && dossier.style.display=="block" && procesAD.style.display=="none"){
		choixClient.style.display="none";
		dossier.style.display="none";
		procesAD.style.display="block";
		changeDisplay1AD.parentElement.style.display="none";
		changeDisplay2AD.parentElement.style.display="none";
					//proces js


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


	}
}









//----------------------------------------------------fonctions de changement du dysplay d'ajout du proces ----------------------------------------------------
//fonction qui change le display
function changeDisplayF1(){

	if( proces.style.display=="block" && fileUpload.style.display=="none" && facture.style.display=="none" ){
		
		if( nomRegex.test(nom.value)==true && nomRegex.test(prenom.value)==true && cinRegex.test(cin.value)==true && adresseRegex.test(adresse.value)==true && avocatAdvRegex.test(avocatAdv.value0==true) ){
			proces.style.display='none';
			fileUpload.style.display="block";
			facture.style.display="none";
			document.getElementById("changeDisplay1").focus();
		}
		else {
			alert("certains champs sont vides ou invalides")
		}
		
	}

	else if( proces.style.display=="none" && fileUpload.style.display=="block" && facture.style.display=="none" ){
		
			proces.style.display='none';
			fileUpload.style.display="none";
			facture.style.display="block";
			document.getElementById("changeDisplay1").innerHTML="ajouter ce proces";
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


function changeDisplayF2(){

	if( proces.style.display=="block" && fileUpload.style.display=="none" && facture.style.display=="none" ){
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
		document.getElementById("changeDisplay1").innerHTML="suivant";	
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

	
		
	


};