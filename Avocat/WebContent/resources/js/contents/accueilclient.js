$(document).ready(function(){
	   active=document.getElementsByClassName("active");

		for(i=0;i<active.length;i++){
			active[i].classList.remove("active");
			i--;
		}
		document.getElementById("AccueilSB1").parentElement.className += " active";
	
	$("#dis").on("click", function(){
		  $(this).parent().parent().parent().parent().submit()	  
	  });
	
  $(".fa-folder-open").on("click", function(){
	  var index = $(this).parent().parent().children().eq(1).text();
	  $("#num").val(index);
	  $("#submit").click();
		  
  });
  $("#ret").on("click", function(){
	document.getElementById("tableDiv").style.display = "block";
	document.getElementById("affichageDiv").style.display = "none";
  });
})
tabAff = document.getElementsByClassName("fa-external-link-square");
	for(let i=0;i<tabAff.length;i++){
		tabAff[i].addEventListener("click",afficher)
	}

  function afficher(){
		procesToBeShown = this.parentElement.parentElement.children[1].textContent;
		affClient = this.parentElement.parentElement.children[3].textContent;
  $.post("AccueilClient",{action : "procesById" , procesToBeShown : procesToBeShown}, function(data){
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