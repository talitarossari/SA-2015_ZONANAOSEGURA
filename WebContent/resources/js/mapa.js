var geocoder;
var map;
var infowindow = new google.maps.InfoWindow();
var marker;

geocoder = new google.maps.Geocoder();

function initialize() {
	var mapOptions = {
		zoom : 11,
		disableDefaultUI : true,
	};

	map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
	var pontos = [ {
		lat : -50.49,
		lon : -25.14
	}, {
		lat : -50.49,
		lon : -25.654
	}, {
		lat : -50.49,
		lon : -25.14434
	} ];
	for (var i = 0; i < pontos.length; i++) {
		var ponto = pontos[i];
		var parliament = new google.maps.LatLng(ponto.lat, ponto.lon);
		var novomarker = new google.maps.Marker({
			map : map,
			animation : google.maps.Animation.DROP,
			position : parliament
		});
	}

	// Try HTML5 geolocation
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			var pos = new google.maps.LatLng(position.coords.latitude,
					position.coords.longitude);

			map.setCenter(pos);
		}, function() {
			handleNoGeolocation(true);
		});
	} else {
		// Browser doesn't support Geolocation
		handleNoGeolocation(false);
	}
}

function handleNoGeolocation(errorFlag) {
	if (errorFlag) {
		var content = 'Você foi redimencionado ao Rio de Janeiro!';
	} else {
		var content = 'Error: Your browser doesn\'t support geolocation.';
	}
	posicao = new google.maps.LatLng(-22.9035, -43.2096);
	var options = {
		map : map,
		position : new google.maps.LatLng(-22.9035, -43.2096),
	};

	map.setCenter(options.position);
}

function codeLatLng() {
	var lat = document.getElementById('form:latitude').value;
	var lng = document.getElementById('form:longitude').value;
	var latlng = new google.maps.LatLng(lat, lng);
	geocoder
			.geocode(
					{
						'latLng' : latlng
					},
					function(results, status) {
						if (status == google.maps.GeocoderStatus.OK) {
							if (results[1]) {
								document.getElementById("form:endereco").value = results[0].formatted_address;
							} else {
								alert('No results found');
							}
						} else {
							alert('Geocoder failed due to: ' + status);
						}
					});
}

google.maps.event.addDomListener(window, 'load', initialize);