$(function(){
function initialize() {
  var mapOptions = {
    zoom: 15,
	disableDefaultUI : true,
    center: new google.maps.LatLng(-27.5969,-48.5495)
  }
  var map = new google.maps.Map(document.getElementById('map-canvas'),
                                mapOptions);						
var localizacao = [];		
 for(var i = 0; i<$(".endereco").length;i++){
	 localizacao[i] = [$(".endereco")[i].value,$(".latitude")[i].value,$(".longitude")[i].value]
}			
  setMarkers(map, localizacao);
}




/**
 * Data for the markers consisting of a name, a LatLng and a zIndex for
 * the order in which these markers should display on top of each
 * other.
 */



function setMarkers(map,locations) {
  for (var i = 0; i < locations.length; i++) {
    var beach = locations[i];
    var myLatLng = new google.maps.LatLng(beach[1], beach[2]);
    var marker = new google.maps.Marker({
        position: myLatLng,
        map: map
    });
    var content = "O Endereco <b> é: </b> " + beach[0];    

    var infowindow = new google.maps.InfoWindow()

    google.maps.event.addListener(marker,'click', (function(marker,content,infowindow){ 
          return function() {
             infowindow.setContent(content);
             infowindow.open(map,marker);
          };
      })(marker,content,infowindow)); 
  }
}
google.maps.event.addDomListener(window, 'load', initialize);
});

$(function(){
	function codeAddress() {
	  var address = document.getElementById('cidade').value;
	  geocoder.geocode( { 'address': address}, function(results, status) {
	    if (status == google.maps.GeocoderStatus.OK) {
	      map.setCenter(results[0].geometry.location);
	      var marker = new google.maps.Marker({
	          map: map,
	          position: results[0].geometry.location,
	          zoom: 15	          
	      });
	    } else {
	      alert('Geocode was not successful for the following reason: ' + status);
	    }
	  });
	}
});