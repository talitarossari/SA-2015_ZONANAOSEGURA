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
        map: map,
        title: beach[0]
    });
  }
}
google.maps.event.addDomListener(window, 'load', initialize);
});