//variable globaux



//ensemble des divs
	
	var 	choixClient=document.getElementById("choixClient");
	var 	clientValide=document.getElementById("clientValide");
	
	var 	changeDisplay1=document.getElementById("changeDisplay1");
	var 	changeDisplay2=document.getElementById("changeDisplay2");
	var 	submitButton=document.getElementById("submitButton");
	var 	titre=document.getElementById("titre_display");
	var 	img=document.getElementById("img_display");

//ensemble des inputs
	var 	cinClient=document.getElementById("cinClient");
	

	

//ensemble des regexps 
	
	var cinRegex = /^([a-zA-Z]{1,2})([0-9]{4,10})$/;

//listeners
	changeDisplay1.addEventListener('click',changeDisplayF1);
	changeDisplay2.addEventListener('click',changeDisplayF2);
//listeners for inputs 

cinClient.addEventListener("keyup",validationCin);





//fonctions de validation 



function validationCin(){
	if(cinRegex.test(this.value)==false) {this.className="effect-16-validation has-content"}
	else {this.className="effect-16"}
}
















//fonction qui change le display
function changeDisplayF1(){
	

	if(choixClient.style.display=="block" && clientValide.style.display=="none" ){
		if(cinRegex.test(cinClient.value)==true){
			//verification de l'existance du client dans la base de données
			$.post("AjouterProces",{action : "choixDossier" , cinClient : cinClient.value}, function(data){
				
    

			
				if(data==0){
					alert("impossible de trouver un client avec le CIN donné");
				}else {	
					//remplissage des donnes client 
					var obj = JSON.parse(data);
					document.getElementById("idClient").innerHTML = obj.clientID;
					document.getElementById("nomClient").innerHTML = obj.clientNom;
					document.getElementById("prenomClient").innerHTML = obj.clientPrenom;
					//-----
					clientValide.style.display = 'block';
					choixClient.style.display = 'none';
					changeDisplay2.parentElement.style.display="block";
					submitButton.parentElement.style.display="block";
					changeDisplay1.parentElement.style.display="none";
						titre.style.display="none";
						img.style.display="none";
						img.nextElementSibling.style.display="none";
						titre.nextElementSibling.children[0].style.display="none";
						submitButton.style.display="block";
				}
					
			});	
			
			
				
			

			//*********************
		}else {alert("veillez saisir un CIN valide")}			
		
			
	}

	}


function changeDisplayF2(){

	if(choixClient.style.display=="none" && clientValide.style.display=="block"  ){
		
		choixClient.style.display='block';
		clientValide.style.display="none";
		changeDisplay1.parentElement.style.display="block";
		changeDisplay2.parentElement.style.display="none";
		submitButton.parentElement.style.display="none";
		changeDisplay1.parentElement.className="col-xs-3 col-xs-offset-5 herite-ajout-proces";
			titre.style.display="block";
			img.style.display="block";
			img.nextElementSibling.style.display="block";
			titre.nextElementSibling.children[0].style.display="block";
		
	}

}


//ajout des events sur les dossiers 









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









