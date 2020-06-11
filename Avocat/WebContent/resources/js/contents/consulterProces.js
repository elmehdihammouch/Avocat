
function afficher(){
	procesToBeShown = this.parentElement.parentElement.parentElement.children[1].textContent;
	$.post("ConsulterProces",{action : "procesById" , procesToBeShown : procesToBeShown}, function(data){
		var obj = JSON.parse(data);
		alert(obj.files[0].nomFichier);
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
var overlay = document.getElementById('overlay');
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
}

