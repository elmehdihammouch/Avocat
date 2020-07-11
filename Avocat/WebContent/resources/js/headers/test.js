
function post(){
		$.post("AP",{"notifier":"notifier"}, function(data){
			var obj = JSON.parse(data);
			$( ".notification" ).children().eq(1).html('<p class="yellow">Vous avez '+Object.keys(obj).length+' nouveux notification</p>');
			$( ".nbnotif" ).html(Object.keys(obj).length);
			$( "li" ).remove(".i");

			
			for (var object of obj)  {	
				if(object.nom == "date suivant" && object.duree <= 72 && object.duree >= 24){					
						$('.notification').append('<li class="i" style="background-color:#B21818;"><a href="./ConsulterProces?idProc='+object.idproces+'"> <big>'+object.nomclient+': </big> N&apos;oubliez pas vous avez<br> une audience du proces qui avait id ='+object.idproces+'<br><span class="small italic j">'+object.date.split('.')[0]+'</span></a></li>');
				}else if(object.nom == "date suivant" && object.duree < 24){
						$('.notification').append('<li class="i" style="background-color:#FF2F2F;"><a href="./ConsulterProces?idProc='+object.idproces+'"> <big>'+object.nomclient+': </big> N&apos;oubliez pas vous avez<br> une audience du proces qui avait id ='+object.idproces+'<br><span class="small italic j">'+object.date.split('.')[0]+'</span></a></li>');	
				}else if(object.nom == "date notif" && object.duree <= 72 && object.duree >= 24){					
						$('.notification').append('<li class="i" style="background-color:#F7FF94;"><a href="./ConsulterProces?idProc='+object.idproces+'"> <big>'+object.nomclient+': </big> Rappel pour<br> la  fin de delais  du proces qui avait id ='+object.idproces+'<br><span class="small italic j">'+object.date.split('.')[0]+'</span></a></li>');
				}else if(object.nom == "date notif" && object.duree < 24){
						$('.notification').append('<li class="i" style="background-color:#EEFF25;"><a href="./ConsulterProces?idProc='+object.idproces+'"> <big>'+object.nomclient+': </big> Rappel pour<br> la  fin de delais  du proces qui avait id ='+object.idproces+'<br><span class="small italic j">'+object.date.split('.')[0]+'</span></a></li>');
				}else if(object.nom == "date payement" && object.duree <= 72 && object.duree >= 24){					
						$('.notification').append('<li class="i" style="background-color:#D4FF42;"><a href="./ConsulterProces?idProc='+object.idproces+'"> <big>'+object.nomclient+': </big> Rappel pour<br> la  date du payement  du proces qui avait id ='+object.idproces+'<br><span class="small italic j">'+object.date.split('.')[0]+'</span></a></li>');
				}else if(object.nom == "date payement" && object.duree < 24){
						$('.notification').append('<li class="i" style="background-color:#A5C731;"><a href="./ConsulterProces?idProc='+object.idproces+'"> <big>'+object.nomclient+': </big> Rappel pour<br> la  date du payement  du proces qui avait id ='+object.idproces+'<br><span class="small italic j">'+object.date.split('.')[0]+'</span></a></li>');
				}
				
				
			 // }
		}$('.notification').append('<li class="i"><a href="#">See all notifications</a></li>');
			
		})
		
			
		
	}	
	
$(window).load(function() {
	post();  
	setInterval('post()',10000)



});