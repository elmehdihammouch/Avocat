
//modification box inputs 
 	var montantGlobal;
 	var indemniteKilometrique;
 	var fraisLogement;

	var nomAdvM=document.getElementById("nomAdvM");
    var prenomAdvM=document.getElementById("prenomAdvM"); 
    var cinAdvM=document.getElementById("cinAdvM");
    var adresseAdvM=document.getElementById("adresseAdvM");
    var avocatAdvM=document.getElementById("avocatAdvM");
    var dateNotifM = document.getElementById("dateNotifM");
    var dateAcceptationM= document.getElementById("dateAcceptationM"); 
    var numeroProcesM  = document.getElementById("numeroProcesM");
    var statutM  = document.getElementById("statutM");
    var tribunalM = document.getElementById("tribunalM");
    var villeM = document.getElementById("villeM");
    var numeroSalM= document.getElementById("numeroSalM");
    var dateSeaM= document.getElementById("dateSeaM");
    var jugementM= document.getElementById("jugementM");
    var dateJugM = document.getElementById("dateJugM");
    var dateSuivM = document.getElementById("dateSuivM");
    var descriptionM= document.getElementById("descriptionM");
    	//facture inputs 
    var 	mtGlobalM = document.getElementById("mtGlobalM");
    var     IndemniteKmM = document.getElementById("IndemniteKmM");
    var     fraisLogM = document.getElementById("fraisLogM"); 
    var     montantBaseM = document.getElementById("montantBaseM");
    var 	lgKmM = document.getElementById("lgKmM");
    var 	prixKmM = document.getElementById("prixKmM");
    var 	dureeJrM = document.getElementById("dureeJrM");
    var 	prixJrM = document.getElementById("prixJrM");
    var 	mtPayeM = document.getElementById("mtPayeM");
    var 	mtRestantM = document.getElementById("mtRestantM");
    var 	datePayM = document.getElementById("datePayM");







//ensemble des regexps 
	var nomRegex = /^[a-zA-Z]{2,}$/;
	var cinRegex = /^([a-zA-Z]{1,2})([0-9]{4,10})$/;
	var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var dateRegex = /^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$/;
	var phoneRegex = /(^[0-9]{10}$)|(^(\+)[0-9]{12}$)/;	
	var adresseRegex = /^[0-9a-zA-Z\s\-]*$/;
	var numSalRegex = /^[0-9a-zA-Z\s\-]*$/;
	var factureRegex = /^[0-9]+$/;
	var avocatAdvRegex = /^[a-zA-Z\s]{2,}$/;
	var datelocal = /[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])T(2[0-3]|[01][0-9]):[0-5][0-9]/;
	var numberRegex = /^[0-9\.]*$/;




//events de validation 

	//validation 
	nomAdvM.addEventListener("keyup",validationNom);                           
    prenomAdvM.addEventListener("keyup",validationNom);                           
    cinAdvM.addEventListener("keyup",validationCin);                           
    adresseAdvM.addEventListener("keyup",validationAdresse);                           
    avocatAdvM.addEventListener("keyup",validationAvocatAdv); 
    lgKmM.addEventListener("keyup",validationNumber);
    prixKmM.addEventListener("keyup",validationNumber);
    dureeJrM.addEventListener("keyup",validationNumber);
    prixJrM.addEventListener("keyup",validationNumber);
    mtPayeM.addEventListener("keyup",validationNumber);
    
    //calcul 
    lgKmM.addEventListener("keyup",calculMontantGlobal);
    prixKmM.addEventListener("keyup",calculMontantGlobal);
    dureeJrM.addEventListener("keyup",calculMontantGlobal);
    prixJrM.addEventListener("keyup",calculMontantGlobal);
    	
    lgKmM.addEventListener("keyup",calculIdmKm);
    prixKmM.addEventListener("keyup",calculIdmKm);
    dureeJrM.addEventListener("keyup",calculFrLog);
    prixJrM.addEventListener("keyup",calculFrLog);
    	//calcule du reste
    lgKmM.addEventListener("keyup",calculRest);
    prixKmM.addEventListener("keyup",calculRest);
    dureeJrM.addEventListener("keyup",calculRest);
    prixJrM.addEventListener("keyup",calculRest);
    mtPayeM.addEventListener("keyup",calculRest);
    
   // dateNotifM.addEventListener("keyup",validationDate);                           
   // dateAcceptationM.addEventListener("keyup",validationDate);                           
   // numeroProcesM.addEventListener("keyup",);                           
   // statut.addEventListener("keyup",);                           
   // tribunalM.addEventListener("keyup",);                           
   // ville.addEventListener("keyup",);                           
   // numeroSalM.addEventListener("keyup",);                           
   // dateSeaM.addEventListener("keyup",);                           
   // jugementM.addEventListener("keyup",);                           
   // dateJugM.addEventListener("keyup",);                           
   // dateSuivM.addEventListener("keyup",);                           
   // descriptionM.addEventListener("keyup",);













function afficher(){
	procesToBeShown = this.parentElement.parentElement.parentElement.children[1].textContent;
	affClient = this.parentElement.parentElement.parentElement.children[3].textContent;
	$.post("ConsulterProces",{action : "procesById" , procesToBeShown : procesToBeShown}, function(data){
		var obj = JSON.parse(data);
	
		
		if(obj!=null){
			document.getElementById("affichageDiv").style.display = "block";
			document.getElementById("tableDiv").style.display = "none";
            pb = document.getElementById("procesBox").children[3];
            fb = document.getElementById("factureBox").children[3];
            filesb = document.getElementById("filesBox").children[3];
			//null values check
            for(var key in obj){
				if((key != "dateCP" && key != "dateAP" && key != "dateNotif"  && key != "dateJug" && key != "dateSui" && key != "facture.datePayement") && (obj[key]==null || obj[key]==0 )){obj[key]="---";}
				else if((key == "dateCP" || key == "dateAP" || key == "dateNotif"  || key == "dateJug" || key == "dateSui" || key == "facture.datePayement") && obj[key]==null){obj[key]=JSON.parse('{ "date":"----/--/--"}');}
			}
            for(var key in obj.facture){
            	if(obj.facture[key]==0){obj.facture[key]="-";}
            }
            //remplissage du Proces boxe
            document.getElementById("procesBox").children[2].innerHTML += "<div >"+obj.description+"</div>";
            pb.children[0].innerHTML += "<div class=\"titlesContent\">"+affClient+"</div>";
            pb.children[1].innerHTML += "<div class=\"titlesContent\">"+obj.dateCP.date+"</div>";
            pb.children[2].innerHTML += "<div class=\"titlesContent\">"+obj.dateAP.date+"</div>";
            pb.children[3].innerHTML += "<div class=\"titlesContent\">"+obj.dateNotif.date+"</div>";
            pb.children[4].innerHTML += "<div class=\"titlesContent\">"+obj.numP+"</div>";
            pb.children[6].innerHTML += "<div class=\"titlesContent\">"+obj.nomAdv+"</div>";
            pb.children[7].innerHTML += "<div class=\"titlesContent\">"+obj.prenomAdv+"</div>";
            pb.children[8].innerHTML += "<div class=\"titlesContent\">"+obj.cinAdv+"</div>";
            pb.children[9].innerHTML += "<div class=\"titlesContent\">"+obj.adresseAdv+"</div>";
            pb.children[10].innerHTML += "<div class=\"titlesContent\">"+obj.avocatAdv+"</div>";
            pb.children[11].innerHTML += "<div class=\"titlesContent\">"+obj.tribunal+"</div>";
            pb.children[12].innerHTML += "<div class=\"titlesContent\">"+obj.ville+"</div>";
            pb.children[13].innerHTML += "<div class=\"titlesContent\">"+obj.saleNum+"</div>";
            pb.children[14].innerHTML += "<div class=\"titlesContent\">"+obj.dateSeance+"</div>";
            pb.children[15].innerHTML += "<div class=\"titlesContent\">"+obj.txtJug+"</div>";
            pb.children[16].innerHTML += "<div class=\"titlesContent\">"+obj.dateJug.date+"</div>";
            pb.children[17].innerHTML += "<div class=\"titlesContent\">"+obj.dateSui.date+"</div>";
            if(obj.statut==1){ pb.children[5].innerHTML += "<div class=\"titlesContent\">Premiere instance</div>";}
            else if(obj.statut==2){ pb.children[5].innerHTML += "<div class=\"titlesContent\">Deuxieme instance</div>";}
            else if(obj.statut==3){ pb.children[5].innerHTML += "<div class=\"titlesContent\">Troisieme instance</div>";}
            
            //remplissage du box de la facture
            fb.children[0].innerHTML += "<div class=\"titlesContent\">"+obj.facture.idFacture+"</div>";
            fb.children[1].innerHTML += "<div class=\"titlesContent\">"+obj.facture.mtBase+"</div>";
            fb.children[2].innerHTML += "<div class=\"titlesContent\">"+obj.facture.lgKm+"</div>";
            fb.children[3].innerHTML += "<div class=\"titlesContent\">"+obj.facture.prKm+"</div>";
            fb.children[4].innerHTML += "<div class=\"titlesContent\">"+obj.facture.indemniteKm+"</div>";
            fb.children[5].innerHTML += "<div class=\"titlesContent\">"+obj.facture.dureeJr+"</div>";
            fb.children[6].innerHTML += "<div class=\"titlesContent\">"+obj.facture.prixJr+"</div>";
            fb.children[7].innerHTML += "<div class=\"titlesContent\">"+obj.facture.prixLog+"</div>";
            fb.children[8].innerHTML += "<div class=\"titlesContent\">"+obj.facture.mtGlobal+"</div>";
            fb.children[9].innerHTML += "<div class=\"titlesContent\">"+obj.facture.mtPaye+"</div>";
            fb.children[10].innerHTML += "<div class=\"titlesContent\">"+(obj.facture.mtGlobal-obj.facture.mtPaye)+"</div>";
            fb.children[11].innerHTML += "<div class=\"titlesContent\">"+obj.facture.datePayement.date+"</div>";
			
            
            //remplissage du box des files
            for(let i=0;i<obj.files.length;i++){
			filesb.innerHTML += "<li><a href=\"ConsulterProces?action=fileDownload&filename="+obj.files[i].nomFichier+"\" target=\"_blank\">"+obj.files[i].nomFichier+"</a></li>"
            }
			
		}
		
	});
}
//---------------------------------------------------------------------------------------------------------------------
function modifier(){
	procesToBeEdited = this.parentElement.parentElement.parentElement.children[1].textContent;
	affClientM = this.parentElement.parentElement.parentElement.children[3].textContent;
	$.post("ConsulterProces",{action : "procesById" , procesToBeShown : procesToBeEdited}, function(data){
		var obj = JSON.parse(data);
		
		
		if(obj!=null){
			document.getElementById("modificationDiv").style.display = "block";
			document.getElementById("tableDiv").style.display = "none";
             pb = document.getElementById("procesBoxM").children[3];
             fb = document.getElementById("factureBoxM").children[3];
             filesb = document.getElementById("filesBoxM").children[3];
			//null values check
            for(var key in obj){
				if((key != "dateCP" && key != "dateAP" && key != "dateNotif"  && key != "dateJug" && key != "dateSui" && key != "facture.datePayement") && (obj[key]==null || obj[key]==0 )){obj[key]="";}
				else if((key == "dateCP" || key == "dateAP" || key == "dateNotif"  || key == "dateJug" || key == "dateSui" || key == "facture.datePayement") && obj[key]==null){obj[key]=JSON.parse('{ "date":"----/--/--"}');}
			}
            for(var key in obj.facture){
            	if(obj.facture[key]<1){obj.facture[key]="0";}
            }
            //remplissage du Proces boxe
          // document.getElementById("procesBoxM").children[2].children[0].children[1].textContent = obj.description;
           pb.children[0].children[0].children[1].textContent = affClientM;
           pb.children[1].children[0].children[1].textContent= obj.dateCP.date  ;
            pb.children[2].children[0].children[1].value = obj.dateAP.date;
            pb.children[3].children[0].children[1].value = obj.dateNotif.date;
            pb.children[4].children[0].children[1].value = obj.numP;
            pb.children[6].children[0].children[1].value = obj.nomAdv;
            pb.children[7].children[0].children[1].value = obj.prenomAdv;
            pb.children[8].children[0].children[1].value = obj.cinAdv;
            pb.children[9].children[0].children[1].value = obj.adresseAdv;
            pb.children[10].children[0].children[1].value = obj.avocatAdv;
            pb.children[11].children[0].children[1].value = obj.tribunal;
            pb.children[12].children[0].children[1].value = obj.ville;
            pb.children[13].children[0].children[1].value = obj.saleNum;
            pb.children[14].children[0].children[1].value = obj.dateSeance;
            pb.children[15].children[0].children[1].value = obj.txtJug;
            pb.children[16].children[0].children[1].value = obj.dateJug.date;
            pb.children[17].children[0].children[1].value = obj.dateSui.date;
            pb.children[18].children[0].children[1].value = obj.description;
            if(obj.statut==1){ pb.children[5].children[0].children[1].textContent = "Premiere Instance"; }
            else if(obj.statut==2){ pb.children[5].children[0].children[1].textContent = "Deuxieme Instance"; }
            else if(obj.statut==3){ pb.children[5].children[0].children[1].textContent = "Troisieme Instance"; }
            
            //remplissage du box de la facture
            fb.children[0].children[0].children[1].textContent = obj.facture.idFacture ;
            fb.children[1].children[0].children[1].textContent = obj.facture.mtBase ;
            /*fb.children[2].children[0].children[1].value = obj.facture.lgKm ;
            fb.children[3].children[0].children[1].value = obj.facture.prKm ;*/
            fb.children[4].children[0].children[1].textContent = obj.facture.indemniteKm ;
            /*fb.children[5].children[0].children[1].value = obj.facture.dureeJr ;
            fb.children[6].children[0].children[1].value = obj.facture.prixJr ;*/
            fb.children[7].children[0].children[1].textContent = obj.facture.prixLog ;
            fb.children[8].children[0].children[1].textContent = obj.facture.mtGlobal ;
            fb.children[9].children[0].children[1].value = obj.facture.mtPaye ;
            fb.children[10].children[0].children[1].textContent = (obj.facture.mtGlobal-obj.facture.mtPaye) ;
            fb.children[11].children[0].children[1].value = obj.facture.datePayement.date ;
            //remplissage du box des files
            for(let i=0;i<obj.files.length;i++){
			filesb.innerHTML += "<li ><a class=\"spanA\" href=\"ConsulterProces?action=fileDownload&filename="+obj.files[i].nomFichier+"\" target=\"_blank\">"+obj.files[i].nomFichier+" </a><span><span class=\"lp\"> </span><i class=\"fas fa-trash\"></i></span></li>"
            }
			Padding();
			
		    montantGlobal = obj.facture.mtGlobal;
		    indemniteKilometrique = obj.facture.indemniteKm;
		    fraisLogement = obj.facture.prixLog;
		    
			
		}
		
	});
}

//traitement du modification avec le serveur 

function modifierProces(){
	 	//var statutMN;
		if(nomRegex.test(nomAdvM.value)==true && nomRegex.test(prenomAdvM.value)==true  && cinRegex.test(cinAdvM.value)==true && adresseRegex.test(adresseAdvM.value)==true && avocatAdvRegex.test(avocatAdvRegex.value)==true && adresseRegex.test(tribunalM.value)==true && adresseRegex.test(villeM.value)==true && adresseRegex.test(jugementM.value)==true && adresseRegex.test(descriptionM.value)==true &&  numSalRegex.test(numeroSalM.value)==true &&  numSalRegex.test(numeroProcesM.value)==true){
			/*if(statutM.value==="premiere Instance"){statutMN = 1;}
			else if(statutM.value==="deuxieme Instance"){statutMN = 2;}
			else if(statutM.value==="troisieme Instance"){statutMN = 3;}*/
			
			$.post("ConsulterProces",{action : "modifierProces", procesToBeEdited : procesToBeEdited , nomAdvM : nomAdvM.value , prenomAdvM : prenomAdvM.value , cinAdvM : cinAdvM.value , adresseAdvM : adresseAdvM.value , avocatAdvM : avocatAdvM.value , dateNotifM  : dateNotifM.value , dateAcceptationM : dateAcceptationM.value , numeroProcesM : numeroProcesM.value , tribunalM : tribunalM.value , villeM : villeM.value , numeroSalM : numeroSalM.value , dateSeaM : dateSeaM.value , jugementM : jugementM.value , dateJugM : dateJugM.value , dateSuivM : dateSuivM.value , descriptionM : descriptionM.value }, function(data){
				var obj = JSON.parse(data);
				if(obj.res==1){
					alert("Les donnees du proces ont ete modifie avec succes");
					//changement des données dans la  table
					tabRowM = document.getElementsByClassName("trowM");
					for(let i=0;i<tabRowM.length;i++){
						if(tabRowM[i].children[1].textContent == procesToBeEdited){
							
								tabRowM[i].children[4].textContent = obj.nomAdv+" "+obj.prenomAdv;
								
								if(obj.numP!=null){
									tabRowM[i].children[8].textContent = obj.numP;
								}else {
									tabRowM[i].children[8].textContent = "---"
								}
							
								if(obj.dateAP === null){
									tabRowM[i].children[7].style.color = "orange" ; 
									tabRowM[i].children[7].textContent = "en attente";
								}
								else{
									tabRowM[i].children[7].style.color = "#00ffcc" ; 
									tabRowM[i].children[7].textContent = "accepté";
								}
							}	
						}
					}
				
				else{alert("modification échouée");}
			}); 		
			}
		
		else{
			alert("veillez remplir les champs importants");
		}
		
		
}

function modifierFacture(){
	if(numberRegex.test(prixJrM.value)==true &&  numberRegex.test(prixKmM.value)==true &&  numberRegex.test(lgKmM.value)==true &&  numberRegex.test(dureeJrM.value)==true &&  numberRegex.test(mtPayeM.value)==true &&  numberRegex.test(mtGlobalM.textContent)==true &&  numberRegex.test(mtRestantM.textContent)==true &&numberRegex.test(IndemniteKmM.textContent)==true &&    numberRegex.test(fraisLogM.textContent)==true &&  numberRegex.test(montantBaseM.textContent)==true &&   datelocal.test(datePayM.value)==true ){
		 $.post("ConsulterProces",{action : "modifierFacture", procesToBeEdited : procesToBeEdited , montantBaseM : montantBaseM.textContent , lgKmM : lgKmM.value , prixKmM : prixKmM.value , IndemniteKmM : IndemniteKmM.textContent , dureeJrM : dureeJrM.value , prixJrM : prixJrM.value , fraisLogM : fraisLogM.textContent , mtGlobalM : mtGlobalM.textContent ,  mtPayeM : mtPayeM.value , datePayM : datePayM.value }, function(data){});
	}
	else{
		alert("no");
	}

}


















//------------------------------------------------------------------------------------------------------------------------------------------------------
function supprimer(){
	alert(3);
}


function precedent(){
	document.getElementById("tableDiv").style.display = "block";
	document.getElementById("affichageDiv").style.display = "none";
	document.getElementById("modificationDiv").style.display = "none";

}

function Padding(){

	rightP=document.getElementsByClassName("spanM");
	leftP=document.getElementsByClassName("lp");
	rightA=document.getElementsByClassName("spanA");

	//rightPD=document.getElementsByClassName("spanMD");
	for(let i=0;i<rightP.length;i++){
		content = rightP[i].textContent.padEnd(30," ");
		rightP[i].textContent = content;
		}
	for(let i=0;i<leftP.length;i++){
		content = leftP[i].textContent.padStart(28," ");
		leftP[i].textContent = content;
		}
	for(let i=0;i<rightA.length;i++){
		content = rightA[i].textContent.padEnd(30," ");
		rightA[i].textContent = content;
		}
}


function imprimer(divName) {
	// OriginalPrintContents for box
	var OriginalPrintContents =  document.getElementById(divName).innerHTML;
	var printContents = document.getElementById(divName);  
	
	//remove() for box 
	 printContents.children[1].remove();
	 printContents.children[3].remove();
	
    var printContents = document.getElementById(divName);    
 var originalContents = document.body.innerHTML;      
 document.body.innerHTML = printContents.innerHTML;
 
 window.print();     
 document.body.innerHTML = originalContents;
 // for box
 document.getElementById(divName).innerHTML = OriginalPrintContents;
 }


//fonctions de calcul 
function calculMontantGlobal(){
	mtGlobalM.textContent = parseFloat((parseFloat(montantGlobal) +  (parseFloat( parseFloat(indemniteKilometrique) + (lgKmM.value*prixKmM.value))) + (parseFloat( parseFloat(fraisLogement) + (dureeJrM.value*prixJrM.value))))).toFixed(3); 
}

function calculIdmKm(){
	IndemniteKmM.textContent  = parseFloat(parseFloat( parseFloat(indemniteKilometrique) + (lgKmM.value*prixKmM.value))).toFixed(3);
}

function calculFrLog(){
	fraisLogM.textContent  = parseFloat(parseFloat( parseFloat(fraisLogement) + (dureeJrM.value*prixJrM.value))).toFixed(3);
}

function calculRest(){
	mtRestantM.textContent = parseFloat(parseFloat(mtGlobalM.textContent) - mtPayeM.value).toFixed(3);
}




// validation des inputs 
function validationNom(){
	if(nomRegex.test(this.value)==false) {this.style.color = "red"}
	else {this.style.color = "#333"}
		
}

function validationCin(){
	if(cinRegex.test(this.value)==false)  {this.style.color = "red"}
	else {this.style.color = "#333"}
}

function validationDate(){
	if(dateRegex.test(this.value)==false)  {this.style.color = "red"}
	else {this.style.color = "#333"}
}

function validationAdresse(){
	if(adresseRegex.test(this.value)==false)  {this.style.color = "red"}
	else {this.style.color = "#333"}
}

function validationPhone(){
	if(phoneRegex.test(this.value)==false)  {this.style.color = "red"}
	else {this.style.color = "#333"}
}

function validationFacture(){
	if(factureRegex.test(this.value)==false)  {this.style.color = "red"}
	else {this.style.color = "#333"}
}

function validationAvocatAdv(){
	if(avocatAdvRegex.test(this.value)==false)  {this.style.color = "red"}
	else {this.style.color = "#333"}
}

function validationNumber(){
	if(numberRegex.test(this.value)==false)  {this.style.color = "red"}
	else {this.style.color = "#333"}
}





















//window.onload
window.onload = function(){
	
	tabMod = document.getElementsByClassName("modifier");
	for(let i=0;i<tabMod.length;i++){
		tabMod[i].addEventListener("click",modifier)
	}

	tabAff = document.getElementsByClassName("afficher");
	for(let i=0;i<tabAff.length;i++){
		tabAff[i].addEventListener("click",afficher)
	}

	tabSup = document.getElementsByClassName("supprimer");
	for(let i=0;i<tabSup.length;i++){
		tabSup[i].addEventListener("click",supprimer)
	}
}


