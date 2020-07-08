active=document.getElementsByClassName("active");
	
	for(i=0;i<active.length;i++){
		active[i].classList.remove("active");
		i--;
	}
	document.getElementById("factureArchive").className += "active";
	document.getElementById("factureArchive").parentElement.previousElementSibling.className += " active";