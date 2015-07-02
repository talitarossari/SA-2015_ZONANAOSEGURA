$(function(){
	$('.navbar-nav a')
		.each(function(key, el){ 
			if(el.href == location.href) 
				$(el.parentElement).addClass('active');
	});
});

function abrir(){
	document.getElementById("#enviarSugestao").style.display="block";
}