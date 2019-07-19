<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.vo.RestaurantVO" %>      
<!DOCTYPE html>
<html>
  <head>
  	<script type="text/javascript" src="/js/jquery.min.js"></script>  
  	  <script async defer 
          src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA-FKKja8sdfgMggjEvEa5agaP6D9wBd6s&callback=initMap">
  	  </script>     
  	<script>
  		function initMap(){
  			//alert("호출");
  		    var map = new google.maps.Map(document.getElementById('map'), {
                                          zoom: 14,
					                      center: new google.maps.LatLng(37.549012, 126.988546),
                                          mapTypeId: google.maps.MapTypeId.ROADMAP
			});
			var infowindow = new google.maps.InfoWindow();  			
	  		$.ajax({
	  			    method:'get'
	  		       ,url:'jsonRestaurantList2.jsp'  
	  		       ,dataType:'json'
	  		       ,success:function(data){
	  		    	   //alert(data);
	  		    	   //var result = JSON.stringify(data);
	  		    	   //var jsonDoc = JSON.parse(data);
	  		    	   //alert(data[0].lat);
	  		    	   //alert(jsonDoc);
	  		    	   var resArray = new Array(data.length);
	  		    	   for(var x=0;x<data.length;x++){
	  		    			resArray[x] = [data[x].lat,data[x].lng];
	  		    			//alert(resArray[x][0]);
	  		    			alert(resArray.length+", "+resArray[0].length);
	  		    	   }
	  		    	   var t1 = new google.maps.LatLng(resArray[0][0],resArray[0][1]);
 		    	    	marker = new google.maps.Marker({
								id:i,
								map: map,
								//position: myLatLng,
								position: t1
 		    	    	});
/* 					$.each(data, function(index, item){
						//alert(item.lat + ":" +item.lng);
						marker = new google.maps.Marker({
								id:i,
								map: map,
								position: new google.maps.LatLng(item.lat, item.lng)
						});
					});   */    

	  		    	var marker, i;
/* 	  		    	if(jsonDoc.length>0){
	  		    		for(var i=0;i<jsonDoc.length;i++){
	  		    			alert(jsonDoc[i].lat+","+parseFloat(jsonDoc[i].lat));
	  		    	    	marker = new google.maps.Marker({
	  		    	        								id:i,
	  		    	        								map: map,
	  		    	        								//position: myLatLng,
	  		    	        								position: new google.maps.LatLng(jsonDoc[i].lat, jsonDoc[i].lng)
	  		    	      	});
	  		    		}
	  		    	} */
	  		    }/////////end of success
	  		});///////////end of ajax  		
  		}
  	</script>                                             
  </head>
<body>
  <div id="map" style="width: 800px; height: 600px;"></div>
  <script type="text/javascript">
  	$(document).ready(function(){

  	});///////////////end of ready
  </script>
</body>
</html>