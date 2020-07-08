active=document.getElementsByClassName("active");
	
	for(i=0;i<active.length;i++){
		active[i].classList.remove("active");
		i--;
	}
	document.getElementById("procesArchive").className += "active";
	document.getElementById("procesArchive").parentElement.previousElementSibling.className += " active";