$(function() {
	var geocoder;
	var map;
	var infowindow = new google.maps.InfoWindow();
	var marker;

	geocoder = new google.maps.Geocoder();

	function initialize() {
		var mapOptions = {
			zoom : 15,
			disableDefaultUI : true,
		};
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);

		// Try HTML5 geolocation
		if (navigator.geolocation) {
			navigator.geolocation
					.getCurrentPosition(
							function(position) {
								var pos = new google.maps.LatLng(
										position.coords.latitude,
										position.coords.longitude);

								document.getElementById("form:latitude").value = position.coords.latitude;
								document.getElementById("form:longitude").value = position.coords.longitude;
								codeLatLng();
								marker = new google.maps.Marker({
									map : map,
									position : pos,
									draggable : true,
								});

								google.maps.event
										.addListener(
												marker,
												'dragend',
												function(evt) {
													document
															.getElementById("form:latitude").value = evt.latLng
															.lat();
													document
															.getElementById("form:longitude").value = evt.latLng
															.lng();
													codeLatLng();
												});

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
		marker = new google.maps.Marker({
			map : map,
			position : posicao,
			draggable : true,
		});
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
});

$(function(){
	$(".descricao").on('keyup',function(event){
        $(this).val($(this).val().substring(0,256));
		if(this.value.length != 256){
			$(".contador").text(256-this.value.length+" caracteres restantes");
		} else {
			$(".contador").text("Voce utilizou todos os caracteres.");
		}
	});
	$(".descricao").on('keydown',function(event){
        $(this).val($(this).val().substring(0,255));
	});
	
	
	$("#horario").on('keyup',function(event){
        $(this).val($(this).val().substring(0,5));
		if(this.val().length == 2){
			document.getElementById("form:horario").value = document.getElementById("form:horario").value+":";
		} 
	});
	$("#horario").on('keydown',function(event){
        $(this).val($(this).val().substring(0,5));
		if(this.val().length == 2){
			document.getElementById("form:horario").value = document.getElementById("form:horario").value+":";
		} 
	});
	
	
});