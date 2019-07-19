<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>                  
  	<meta charset="utf-8">                                  
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA-FKKja8sdfgMggjEvEa5agaP6D9wBd6s"></script>  
  </head>
<body>
  <div id="map" style="width: 800px; height: 600px;"></div>
  <script type="text/javascript">
    var locations = [
      ['명동', 37.563576, 126.983431],
      ['가로수길', 37.520300, 127.023008],
      ['광화문', 37.575268, 126.976896],
      ['남산', 37.550925, 126.990945],
      ['이태원', 37.540223, 126.994005]
    ];

    var map = new google.maps.Map(document.getElementById('map'), {
      		                      zoom: 14,
       							  center: new google.maps.LatLng(37.549012, 126.988546),
                                  mapTypeId: google.maps.MapTypeId.ROADMAP
    });
    var infowindow = new google.maps.InfoWindow();
    var marker, i;
    for (i = 0; i < locations.length; i++) {  
      marker = new google.maps.Marker({
        id:i,
        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        map: map
      });

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent(locations[i][0]);
          infowindow.open(map, marker);
        }
      })(marker, i));
      if(marker)
      {
      	marker.addListener('click', function() {
        	map.setZoom(15);
        	map.setCenter(this.getPosition());
      	});
   	  }

   }
  </script>
</body>
</html>