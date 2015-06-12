$(function(){
	
	$('.sugestao').click(function (event){
		if($('#enviarSugestao').css("display") == "none"){
			$('#enviarSugestao').css("display" , "block");
			$('.sug2').css("display" , "none");
		} else {
			$('#enviarSugestao').css("display" , "none");
			$('.sug2').css("display" , "block");
		}
	});
	
});