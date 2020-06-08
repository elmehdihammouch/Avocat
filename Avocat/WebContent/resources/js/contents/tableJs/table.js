
function afficher(){
	alert(1);
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
		tabMod[i].children[0].addEventListener("click",modifier)
	}

	tabAff = document.getElementsByClassName("afficher");
	for(let i=0;i<tabAff.length;i++){
		tabAff[i].children[0].addEventListener("click",afficher)
	}

	tabSup = document.getElementsByClassName("supprimer");
	for(let i=0;i<tabSup.length;i++){
		tabSup[i].children[0].addEventListener("click",supprimer)
	}
}