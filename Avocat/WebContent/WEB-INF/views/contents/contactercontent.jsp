<div class="row " id="contacterContent" >
               
				<div class="container-fluid">
               		<div class="row content3">
               			    <script type='text/javascript'
            src='http://www.bing.com/api/maps/mapcontrol?callback=GetMap&key=AvdYlk21f_BfunEXsScGgsLtDHtm3TX8ucKB30Gx5vu6C9tD7qHCiuTuEUBJh8H4' 
            async defer></script>
    
    <script type='text/javascript'>
    function GetMap()
    {
        var map = new Microsoft.Maps.Map('#myMap', {
            center : new Microsoft.Maps.Location(33.566746, -7.541578)});
        var center = map.getCenter();

        //Create custom Pushpin
        var pin = new Microsoft.Maps.Pushpin(center,  {
            color: 'red'
        });
        map.entities.push(pin);
    }
    
    </script>
                         <div id="myMap" style="position:relative;width:1000vh;height:100vh;"></div>
               		</div>
               </div>
			
		</div>	