$(function(){
	$('.navbar-nav li a')
		.each(function(key, el){ 
			if(el.href == location.href) 
				$(el.parentElement).addClass('active');
		});
});