//header js
active=document.getElementsByClassName("active");
	
	for(i=0;i<active.length;i++){
		active[i].classList.remove("active");
		i--;
	}
	document.getElementById("consulterProces").className += "active";
	document.getElementById("consulterProces").parentElement.previousElementSibling.className += " active";
//
//modification box inputs 
 	var montantGlobal;
 	var indemniteKilometrique;
 	var fraisLogement;
 	var montantPayeAncien;
 	var factTdToBeEdited;
 	

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
    var		mtPayeAncienM = document.getElementById("mtPayeAncienM");	







//ensemble des regexps 
	var nomRegex = /^([a-zA-Z]{2,})*$/;
	var cinRegex = /^(([a-zA-Z]{1,2})([0-9]{4,10}))*$/;
	var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var dateRegex = /^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$/;
	var phoneRegex = /(^[0-9]{10}$)|(^(\+)[0-9]{12}$)/;	
	var adresseRegex = /^[0-9a-zA-Z\s\-]*$/;
	var numSalRegex = /^[0-9a-zA-Z\s\-]*$/;
	var factureRegex = /^[0-9]+$/;
	var avocatAdvRegex = /^([a-zA-Z\s]{2,})*$/;
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


    var url = window.location.search










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
				if((key != "dateCP" && key != "dateSeance" && key != "dateAP" && key != "dateNotif"  && key != "dateJug" && key != "dateSui" && key != "facture.datePayement") && (obj[key]==null || obj[key]==0 )){obj[key]="---";}
				else if((key == "dateCP" || key == "dateSeance" || key == "dateAP" || key == "dateNotif"  || key == "dateJug" || key == "dateSui" || key == "facture.datePayement") && obj[key]==null){obj[key]=JSON.parse('{ "date":"----/--/--"}');}
			}
            for(var key in obj.facture){
            	if(obj.facture[key]==0){obj.facture[key]="-";}
            }
            //remplissage du Proces boxe
            document.getElementById("procesBox").children[2].innerHTML = "<span class=\"procesTitles\">Description : </span> <div >"+obj.description+"</div>";
            pb.children[0].innerHTML = " <span class=\"procesTitles\">Client : </span><br><div class=\"titlesContent\">"+affClient+"</div>";
            pb.children[1].innerHTML = " <span class=\"procesTitles\">Date de creation : </span><br><div class=\"titlesContent\">"+obj.dateCP.date+"</div>";
            pb.children[2].innerHTML = " <span class=\"procesTitles\">Date d'acceptation :  </span><br><div class=\"titlesContent\">"+obj.dateAP.date+"</div>";
            pb.children[3].innerHTML = " <span class=\"procesTitles\">Date de notification : </span><br><div class=\"titlesContent\">"+obj.dateNotif.date+"</div>";
            pb.children[4].innerHTML = " <span class=\"procesTitles\">Numero du proces :</span><br><div class=\"titlesContent\">"+obj.numP+"</div>";
            pb.children[6].innerHTML = " <span class=\"procesTitles\">Nom du advairsaire :</span><br><div class=\"titlesContent\">"+obj.nomAdv+"</div>";
            pb.children[7].innerHTML = " <span class=\"procesTitles\">Prenom du advairsaire : <div class=\"titlesContent\">"+obj.prenomAdv+"</div>";
            pb.children[8].innerHTML = " <span class=\"procesTitles\">CIN advairsaire :</span><br><div class=\"titlesContent\">"+obj.cinAdv+"</div>";
            pb.children[9].innerHTML = " <span class=\"procesTitles\">Adresse adversaire : </span><br><div class=\"titlesContent\">"+obj.adresseAdv+"</div>";
            pb.children[10].innerHTML= " <span class=\"procesTitles\">Avocat advairsaire : </span><br><div class=\"titlesContent\">"+obj.avocatAdv+"</div>";
            pb.children[11].innerHTML= " <span class=\"procesTitles\">Tribunal :</span><br><div class=\"titlesContent\">"+obj.tribunal+"</div>";
            pb.children[12].innerHTML= " <span class=\"procesTitles\">Ville : </span><br><div class=\"titlesContent\">"+obj.ville+"</div>";
            pb.children[13].innerHTML= " <span class=\"procesTitles\">Numero de la salle : </span><br><div class=\"titlesContent\">"+obj.saleNum+"</div>";
            pb.children[14].innerHTML= " <span class=\"procesTitles\">Date de la seance :</span><br><div class=\"titlesContent\">"+obj.dateSeance.date+"</div>";
            pb.children[15].innerHTML= " <span class=\"procesTitles\">Jugement : </span><br><div class=\"titlesContent\">"+obj.txtJug+"</div>";
            pb.children[16].innerHTML= " <span class=\"procesTitles\">Date du jugement : </span><br><div class=\"titlesContent\">"+obj.dateJug.date+"</div>";
            pb.children[17].innerHTML= " <span class=\"procesTitles\">Date de la seance suivante : </span><br><div class=\"titlesContent\">"+obj.dateSui.date+"</div>";
            if(obj.statut==1){ pb.children[5].innerHTML = " <span class=\"procesTitles\">Instance :</span><br><div class=\"titlesContent\">Premiere instance</div>";}
            else if(obj.statut==2){ pb.children[5].innerHTML = " <span class=\"procesTitles\">Instance :</span><br><div class=\"titlesContent\">Deuxieme instance</div>";}
            else if(obj.statut==3){ pb.children[5].innerHTML = " <span class=\"procesTitles\">Instance :</span><br><div class=\"titlesContent\">Troisieme instance</div>";}
            
            //remplissage du box de la facture
            fb.children[0].innerHTML = "<span class=\"procesTitles\">Numero de la  facture : </span><br><div class=\"titlesContent\">"+obj.facture.idFacture+"</div>";
            fb.children[1].innerHTML = "<span class=\"procesTitles\">Montant de base :  </span><br><div class=\"titlesContent\">"+obj.facture.mtBase+"</div>";
            fb.children[2].innerHTML = "<span class=\"procesTitles\">Montant Global : </span><br><div class=\"titlesContent\">"+obj.facture.mtGlobal+"</div>";
            fb.children[3].innerHTML = "<span class=\"procesTitles\">Montant payé : </span><br><div class=\"titlesContent\">"+obj.facture.mtPaye+"</div>";
            fb.children[4].innerHTML = "<span class=\"procesTitles\">Montant restant : </span><br><div class=\"titlesContent\">"+(obj.facture.mtGlobal-obj.facture.mtPaye)+"</div>";
            fb.children[5].innerHTML = "<span class=\"procesTitles\">Date de payement : </span><br><div class=\"titlesContent\">"+obj.facture.datePayement.date+"</div>";
			
            
            //remplissage du box des files
			filesb.innerHTML = "<li><a href=\"ConsulterProces?action=fileDownload&filename="+obj.files[0].nomFichier+"\" target=\"_blank\">"+obj.files[0].nomFichier+"</a></li>"
			for(let i=1;i<obj.files.length;i++){
			filesb.innerHTML += "<li><a href=\"ConsulterProces?action=fileDownload&filename="+obj.files[i].nomFichier+"\" target=\"_blank\">"+obj.files[i].nomFichier+"</a></li>"
            }
			
		}
		
	});
}
//---------------------------------------------------------------------------------------------------------------------
function modifier(){
	//actualisation**
	 mtPayeM.value.remove;
	 factTdToBeEdited = this.parentElement.parentElement.parentElement.children[1].textContent
	//**
	
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
            pb.children[14].children[0].children[1].value = obj.dateSeance.date;
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
            fb.children[2].children[0].children[1].value = "" ;
            fb.children[3].children[0].children[1].value = "" ;
            fb.children[4].children[0].children[1].textContent = "";
            fb.children[5].children[0].children[1].value = "" ;
            fb.children[6].children[0].children[1].value = "" ;
            fb.children[7].children[0].children[1].textContent = "";
            fb.children[8].children[0].children[1].textContent = obj.facture.mtGlobal ;
            fb.children[9].children[0].children[1].textContent = obj.facture.mtPaye;
            fb.children[10].children[0].children[1].value = "";
            fb.children[11].children[0].children[1].textContent = (obj.facture.mtGlobal-obj.facture.mtPaye) ;
            fb.children[12].children[0].children[1].value = obj.facture.datePayement.date ;
            //remplissage du box des files
			filesb.innerHTML = "<li ><a class=\"spanA\" href=\"ConsulterProces?action=fileDownload&filename="+obj.files[0].nomFichier+"\" target=\"_blank\">"+obj.files[0].nomFichier+" </a><span><span class=\"lp\"> </span><i class=\"fas fa-trash pieceIcon\"></i></span></li>"
			for(let i=1;i<obj.files.length;i++){
			filesb.innerHTML += "<li ><a class=\"spanA\" href=\"ConsulterProces?action=fileDownload&filename="+obj.files[i].nomFichier+"\" target=\"_blank\">"+obj.files[i].nomFichier+" </a><span><span class=\"lp\"> </span><i class=\"fas fa-trash pieceIcon\"></i></span></li>"
            }
            document.getElementById("fileProces").value=procesToBeEdited;
            
			Padding();
			
		    montantGlobal = obj.facture.mtGlobal;
		    indemniteKilometrique = obj.facture.indemniteKm;
		    fraisLogement = obj.facture.prixLog;
		    montantPayeAncien = obj.facture.mtPaye;
		    
		    var pieceIconTab = document.getElementsByClassName("pieceIcon");
		    for(let i=0;i<pieceIconTab.length;i++){
		    	pieceIconTab[i].addEventListener("click",supprimerPiece);
		    }
		    
			
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
		if ( confirm( " &eacutetes vous s&ucircr de vouloir modifier les donn&eacutees de ce proces?" ) ) {
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
				
				else{alert("modification echouee");}
			}); 		
			}
	}	
		else{
			alert("Certains champs sont invalides");
		}
		
		
}

function modifierFacture(){
	if(numberRegex.test(prixJrM.value)==true &&  numberRegex.test(prixKmM.value)==true &&  numberRegex.test(lgKmM.value)==true &&  numberRegex.test(dureeJrM.value)==true &&  numberRegex.test(mtPayeM.value)==true &&  numberRegex.test(mtGlobalM.textContent)==true &&  numberRegex.test(mtRestantM.textContent)==true &&numberRegex.test(IndemniteKmM.textContent)==true &&    numberRegex.test(fraisLogM.textContent)==true &&  numberRegex.test(montantBaseM.textContent)==true &&   datelocal.test(datePayM.value)==true ){
		
			if ( confirm( "êtes vous sûr de vouloir modifier les données de cette facture?" ) ) {
			$.post("ConsulterProces",{action : "modifierFacture", procesToBeEdited : procesToBeEdited , montantBaseM : montantBaseM.textContent , lgKmM : lgKmM.value , prixKmM : prixKmM.value , IndemniteKmM : IndemniteKmM.textContent , dureeJrM : dureeJrM.value , prixJrM : prixJrM.value , fraisLogM : fraisLogM.textContent , mtGlobalM : mtGlobalM.textContent ,  mtPayeM : mtPayeM.value , mtPayeAncienM : mtPayeAncienM.textContent , datePayM : datePayM.value }, function(data){
				var obj = JSON.parse(data);
				if(obj.res==1){
						alert("Modification terminee");
						var factTdToBeEditedTab = document.getElementsByClassName("etatFacture");
						
						console.log(factTdToBeEdited);
								for(let i=0;i<factTdToBeEditedTab.length;i++){
									if(factTdToBeEditedTab[i].parentElement.children[1].textContent==factTdToBeEdited){
										if(parseFloat(obj.mtGblobal)-parseFloat(obj.mtPaye)==0){
										factTdToBeEditedTab[i].textContent="payee";
										factTdToBeEditedTab[i].style.color ="#00ffcc";
										}
										else{
											factTdToBeEditedTab[i].textContent="pas encore payee";
											factTdToBeEditedTab[i].style.color ="#ff3333";
										}
									}
								}
							
				}
				
				else{
						alert("La modification de la facture a echoue");
				}
				
			});
			}	
	}
	else{
		alert("certains champs ne sont pas valides");
	}

}


















//------------------------------------------------------------------------------------------------------------------------------------------------------
function supprimer(){
	procesToBeDeleted = this.parentElement.parentElement.parentElement.children[1].textContent;
	rowToDelete = this.parentElement.parentElement.parentElement;
	if ( confirm( "êtes vous sûr de vouloir supprimer ce proces?" ) ) {
		$.post("ConsulterProces",{action : "supprimerProces", procesToBeDeleted : procesToBeDeleted }, function(data){
				if(data==1){
					alert("le proces a été suprimé avec succes");
					rowToDelete.remove();
				}
				else{alert("suppression echouée");}
			});
	}	
}

function supprimerPiece(){
	pieceToBeDeleted = this.parentElement.parentElement;
	if ( confirm( "êtes vous sûr de vouloir supprimer cette piece jointe?" ) ) {
		$.post("ConsulterProces",{action : "supprimerPiece", pieceToBeDeleted : pieceToBeDeleted.children[0].textContent }, function(data){
			if(data==1){
				pieceToBeDeleted.remove();
				alert("piece supprimée");
			}
			else{alert("suppression echouee");}
		});
	}
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
	if(numberRegex.test(lgKmM.value)==false || numberRegex.test(prixKmM.value)==false  || numberRegex.test(dureeJrM.value)==false  || numberRegex.test(prixJrM.value)==false )
	{mtGlobalM.textContent=0;}
	else{mtGlobalM.textContent = parseFloat( parseFloat(montantGlobal) +  parseFloat((lgKmM.value*prixKmM.value)) + parseFloat((dureeJrM.value*prixJrM.value)) ).toFixed(3); }
}

function calculIdmKm(){
	if(numberRegex.test(lgKmM.value)==false || lgKmM.value=="" || numberRegex.test(prixKmM.value)==false || prixKmM.value=="")
	{IndemniteKmM.textContent  = 0;}
	else{IndemniteKmM.textContent  = parseFloat((lgKmM.value*prixKmM.value)).toFixed(3);}
}

function calculFrLog(){
	if(numberRegex.test(dureeJrM.value)==false || dureeJrM.value=="" || numberRegex.test(prixJrM.value)==false || prixJrM.value=="")
	{fraisLogM.textContent  = 0;}
	else{fraisLogM.textContent  = parseFloat((dureeJrM.value*prixJrM.value)).toFixed(3);}
}

function calculRest(){
	if(numberRegex.test(mtPayeM.value)==false || mtPayeM.value=="")
	{mtRestantM.textContent = parseFloat(parseFloat(mtGlobalM.textContent) - (0 + parseFloat(montantPayeAncien) ) ).toFixed(3);}
	else{mtRestantM.textContent = parseFloat(parseFloat(mtGlobalM.textContent) - (parseFloat(mtPayeM.value) + parseFloat(montantPayeAncien) ) ).toFixed(3);}

	
	

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
	if(url != ''){
		var idDos = url.split('=');
		$(".tr-shadow").each(function(){
			  var index = $(this).children().eq(2).text();
			  console.log(idDos[1] +" :::  "+ $(this).children().eq(1).text())
			  if(idDos[1] == index && idDos[0] =='?idDos'){
				  $(this).css("visibility", "visible");
			  }else  if(idDos[1] == $(this).children().eq(1).text() && idDos[0] =='?idProc'){
				  
				  $(this).css("visibility", "visible");
			  }
				  
		  });
		
	}
	
	
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
	
	if(document.getElementById("idProcesFile").textContent!="null"){
		trowMod = document.getElementsByClassName("trowM");
		for(let i=0;i<trowMod.length;i++){
			if(trowMod[i].children[1].textContent==document.getElementById("idProcesFile").textContent){
				trowMod[i].children[10].children[0].children[1].click();
			}
		}
	}
	
	
}



