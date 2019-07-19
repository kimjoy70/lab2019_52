<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>                                                    
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAkpi1xlMiycMxzBdcPvieqTSxGFo8ECCU"></script>  
  	<script type="text/javascript">
  		function getMyLocation(){
  			if(navigator.geolocation){
  				navigator.geolocation.getCurrentPosition(initMap);
  			}
  			else{
  				alert("이런 지오로케이션이 제공되지 않네요.");
  			}
  		}
  	</script>
  </head>
  <body onLoad="getMyLocation()">
    <div id="map" style="width:800px;height:650px;"></div>
    <script>
      function initMap() {
    	//월드메르디앙벤처2차 37.478687, 126.878687
        var myLatLng = {lat: 37.478687, lng: 126.878687};

        // Create a map object and specify the DOM element
        // for display.
        var map = new google.maps.Map(document.getElementById('map'), {
          center: myLatLng,
          zoom: 16
        });

        // Create a marker and set its position.
        var marker = new google.maps.Marker({
          map: map,
          position: myLatLng,
          title: '한국소프트인재개발원'
        });
        var markerMaxWidth = 300;
        //말풍선 내용
        var contentString = "<div><h2>교육센터 위치</h2><p>내용</p><a href=http://www.naver.com>네이버</a></div>"
        var infoWindow = new google.maps.InfoWindow({
        	content:contentString
           ,maxWidth:markerMaxWidth
        });
        google.maps.event.addListener(marker,'click',function(){
        	infoWindow.open(map, marker);
        });
      }

    </script>
  </body>
</html>