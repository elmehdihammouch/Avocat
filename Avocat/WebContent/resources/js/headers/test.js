
function post(){
		$.post("AP",{"notifier":"notifier"}, function(data){
			var obj = JSON.parse(data);
			$( ".notification" ).children().eq(1).html('<p class="yellow">Vous avez '+Object.keys(obj).length+' nouvelle(s) notification(s)</p>');
			$( ".nbnotif" ).html(Object.keys(obj).length);
			$( "li" ).remove(".i");

			
			for (var object of obj)  {	
				if(object.nom == "date suivant" && object.duree <= 72 && object.duree >= 24){					
						$('.notification').append('<li class="i" style="background-color:#ffb3b3;"><a href="./ConsulterProces?idProc='+object.idproces+'"><big>N&apos;oubliez pas vous avez une audience</big><br> Client : '+object.nomclient+'<br> Numero du proces :'+object.idproces+'<br><span class="small italic j">'+object.date.split('.')[0]+'</span></a></li>');
				}else if(object.nom == "date suivant" && object.duree < 24){
						$('.notification').append('<li class="i" style="background-color:#ff6666;"><a href="./ConsulterProces?idProc='+object.idproces+'"><big>N&apos;oubliez pas vous avez une audience</big><br> Client : '+object.nomclient+'<br> Numero du proces :'+object.idproces+'<br><span class="small italic j">'+object.date.split('.')[0]+'</span></a></li>');	
				}else if(object.nom == "date notif" && object.duree <= 72 && object.duree >= 24){					
						$('.notification').append('<li class="i" style="background-color:#ffffb3;"><a href="./ConsulterProces?idProc='+object.idproces+'"><big>Rappel : Date de notification</big><br> Client : '+object.nomclient+'<br> Numero du proces :'+object.idproces+'<br><span class="small italic j">'+object.date.split('.')[0]+'</span></a></li>');
				}else if(object.nom == "date notif" && object.duree < 24){
						$('.notification').append('<li class="i" style="background-color:#ffff80;"><a href="./ConsulterProces?idProc='+object.idproces+'"><big>Rappel : Date de notification</big><br> Client : '+object.nomclient+'<br> Numero du proces :'+object.idproces+'<br><span class="small italic j">'+object.date.split('.')[0]+'</span></a></li>');
				}else if(object.nom == "date payement" && object.duree <= 72 && object.duree >= 24){					
						$('.notification').append('<li class="i" style="background-color:#ccffeb;"><a href="./ConsulterProces?idProc='+object.idproces+'"><big>Rappel : Date de Payement</big><br> Client : '+object.nomclient+'<br> Numero du proces :'+object.idproces+'<br><span class="small italic j">'+object.date.split('.')[0]+'</span></a></li>');
				}else if(object.nom == "date payement" && object.duree < 24){
						$('.notification').append('<li class="i" style="background-color:#66ffc2;"><a href="./ConsulterProces?idProc='+object.idproces+'"><big>Rappel : Date de Payement</big><br> Client : '+object.nomclient+'<br> Numero du proces :'+object.idproces+'<br><span class="small italic j">'+object.date.split('.')[0]+'</span></a></li>');
				}
				
				
			 // }
		}$('.notification').append('<li class="i"><a href="./">Tous les notifications</a></li>');
			
		})
		
			
		
	}	
	
$(window).load(function() {
	post();  
	setInterval('post()',10000)

	  $("#dis").on("click", function(){
		  $(this).parent().parent().parent().parent().submit()	  
	  });

});