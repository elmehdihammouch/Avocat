
function afficher(){
	procesToBeShown = this.parentElement.parentElement.parentElement.children[1].textContent;
	affClient = this.parentElement.parentElement.parentElement.children[3].textContent;
	$.post("ConsulterProces",{action : "procesById" , procesToBeShown : procesToBeShown}, function(data){
		var obj = JSON.parse(data);
		
		if(obj!=null){
			document.getElementById("affichageDiv").style.display = "block";
			document.getElementById("tableDiv").style.display = "none";
            var pb = document.getElementById("procesBox").children[3];
            var fb = document.getElementById("factureBox").children[3];
			
            //null values check
            for(var key in obj){
				if((key != "dateCP" && key != "dateAP" && key != "dateNotif"  && key != "dateJug" && key != "dateSui" && key != "facture.datePayement") && obj[key]==null ){obj[key]="---";}
				else if((key == "dateCP" || key == "dateAP" || key == "dateNotif"  || key == "dateJug" || key == "dateSui" || key == "facture.datePayement") && obj[key]==null){obj[key]=JSON.parse('{ "date":"----/--/--"}');}
				
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
			
			
			
			
		}
		
	});
}

function modifier(){
alert(2);
}

function supprimer(){
	alert(3);
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


//script du pop up
/*var overlay = document.getElementById('overlay');
var btnClose = document.getElementById('btnClose');
popUp = document.getElementsByClassName("btnPopup");

for(let i=0;i<popUp.length;i++){
	popUp[i].addEventListener("click",openMoadl)
}

function openMoadl() {
overlay.style.display='block';
}

btnClose.addEventListener('click',closeModal);
function closeModal() {
overlay.style.display='none';
}*/

