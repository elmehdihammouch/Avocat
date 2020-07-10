
function post(){
		$.post("AP",{"notifier":"notifier"}, function(data){
			var obj = JSON.parse(data);
			$( ".notification" ).children().eq(1).html('<p class="yellow">Vous avez '+Object.keys(obj).length+' nouveux notification</p>');
			console.log($( ".notification" ).children().eq(2))
			console.log($( ".notification" ).children().eq(3))
			$( ".nbnotif" ).html(Object.keys(obj).length);

				$( "li" ).remove(".i");

			for (var object of obj)  {
				
				
				if(object.nom == "date suivant" && object.duree <= 72 && object.duree >= 24){					
					object.nom="Vous avez une audience"
					$('.notification').append('<li class="i"><a href="./ConsulterProces?idProc='+object.idproces+'"> <span class="label label-warning"><i class="fa fa-bell"></i></span>&nbsp'+object.nom+'<br><span class="small italic"> '+parseInt(object.duree/24)+' jour reste</span></a></li>');
				}else if(object.nom == "date suivant" && object.duree < 24){
					
					object.nom="Vous avez une audience dans ce jour"
						$('.notification').append('<li class="i"><a href="./ConsulterProces?idProc='+object.idproces+'"><span class="label label-danger"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></span>&nbsp'+object.nom+'<span class="small italic">'+object.duree+' heure resté</span></a></li>');	
				}else if(object.nom == "date notif" && object.duree <= 72 && object.duree >= 24){					
					object.nom="delais "
					$('.notification').append('<li class="i"><a href="./ConsulterProces?idProc='+object.idproces+'"><span style="background-color : yellow">'+object.nom+'</span><span class="small italic"> '+parseInt(object.duree/24)+' jour reste</span></a></li>');
				}else if(object.nom == "date notif" && object.duree < 24){
					
					object.nom="Vous avez une audience dans ce jour"
						$('.notification').append('<li class="i"><a href="./ConsulterProces?idProc='+object.idproces+'"><span style="background-color : red">'+object.nom+'</span><span class="small italic">'+object.duree+' heure resté</span></a></li>');	
				}
				
				
			 // }
		}
		})
		
			
		
	}	
	
$(window).load(function() {
	post();  
	setInterval('post()',600000)



});