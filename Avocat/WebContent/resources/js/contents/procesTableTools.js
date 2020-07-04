
function pagination1(){
	tabP=document.getElementById("pagination1").value;
	tabT=document.getElementsByClassName("trow");
	select=document.getElementById("pagination2");
	mapSize = document.getElementById("mapSize").textContent;
	
	if(parseInt(mapSize)<parseInt(tabP)){tabP=mapSize;}
	
	//pages=document.getElementById("pages");
	divise=0;
if(Number.isInteger(tabT.length/tabP)){divise=tabT.length/tabP;}
else{divise=parseInt(tabT.length/tabP)+1};

	if(tabP==0){tabP=tabT.length}
	
	for(i=0;i<tabT.length;i++){
		tabT[i].style.display="none"
	}
	for(i=0;i<tabP;i++){
		tabT[i].style.display="table-row";
	}
if(Number.isInteger(tabT.length/tabP)){divise=tabT.length/tabP;}
else{divise=parseInt(tabT.length/tabP)+1};

select.innerHTML="";
for(i=0;i<divise;i++){
select.innerHTML+="<option value=\""+(i+1)+"\">"+(i+1)+"</option>";
document.getElementById("pagination1").addEventListener("change",pagination1);
}

/*pages.innerHTML="";
for(i=0;i<divise;i++){
pages.innerHTML+="<input type=\"text\" value=\""+(i+1)+"\" class=\"inp\">";
}*/


}


function pagination2(){
tabP1=document.getElementById("pagination1").value;
tabT=document.getElementsByClassName("trow");
tabP2=document.getElementById("pagination2").value;

for(i=0;i<tabT.length;i++){
		tabT[i].style.display="none"
	}
for(i=tabP*tabP2-tabP1;i<tabP*tabP2;i++){
tabT[i].style.display="table-row";
}

}


function search(){
//	filtre=document
filter=document.getElementById("filter").value;
tabaa=document.getElementsByClassName(filter);
valeur=document.getElementById("search").value.toUpperCase().trim();
	for(i=0;i<tabaa.length;i++){
		if(tabaa[i].textContent.toUpperCase().trim().includes(valeur)==false){
			tabaa[i].parentElement.style.display="none";
			}
		else{
			tabaa[i].parentElement.style.display="table-row";
		}	
}	}


function trier(){
filter=document.getElementById("filter").value;
tabaa=document.getElementsByClassName(filter);
tri=document.getElementById("tri").value;
	if(filter!="filters"){
		if(tri=="croissant"){
			$(document).ready(function() {
			    $('#tableAvocat').DataTable( {
			        "order": [[ filter, "asc" ]],
			        "paging":   false,
			        "ordering": true,
			        "info":     false,
			        "searching" : false,
			        "destroy" : true
			    } );
			} );
		}	
		else if (tri=="decroissant"){
			$(document).ready(function() {
			    $('#tableAvocat').DataTable( {
			        "order": [[ filter, "desc" ]],
			        "paging":   false,
			        "ordering": true,
			        "info":     false,
			        "searching" : false,
			        "destroy" : true
			    } );
			} );
		}
	}	
	if(tri=="desactive") {
		$(document).ready(function() {
		    $('#tableAvocat').DataTable( {
		        "order": [[ 1, "asc" ]],
		        "paging":   false,
		        "ordering": true,
		        "info":     false,
		        "searching" : false,
		        "destroy" : true
		        
		    } );
		} );
	}
	}
//}




window.onload = function(){
//sorting by procesArchId Onloading
	$(document).ready(function() {
	    $('#tableAvocat').DataTable( {
	        "order": [[ 1, "asc" ]],
	        "paging":   false,
	        "ordering": true,
	        "info":     false,
	        "searching" : false,
	        "destroy" : true
	        
	    } );
	} );
//*********************	

	document.getElementById("search").addEventListener("keyup",search);
	pagination1();
}