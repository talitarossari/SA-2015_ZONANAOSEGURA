var a = 0;
var b = 0;

$( ".desce1" ).click(function() {
	if(a==0){
		$(".collapse").css("display" , "block");
		$(".collapse").css("height" , "100%");
		$(".dropdown2").addClass("glyphicon-menu-down");
		$(".desce1").addClass("active");
		a=1;
	} else {
		$(".collapse").css("display" , "none");
		$(".collapse").css("height" , "0px");
		$(".dropdown2").removeClass("glyphicon-menu-down");
		$(".desce1").removeClass("active");
		$(".desce2").removeClass("active");
		$(".collapse2").css("display" , "none");
		$(".collapse2").css("height" , "0px");
		$(".dropdown3").removeClass("glyphicon-menu-down");
		b=0;
		a=0;
	}
});
$( ".desce2" ).click(function() {
	if(b==0){
		$(".collapse2").css("display" , "block");
		$(".collapse2").css("height" , "100%");
		$(".dropdown3").addClass("glyphicon-menu-down");
		$(".desce1").addClass("active");
		$(".desce2").addClass("active");
		b=1;
	} else {
		$(".collapse2").css("display" , "none");
		$(".collapse2").css("height" , "0px");
		$(".dropdown3").removeClass("glyphicon-menu-down");
		$(".desce1").addClass("active");
		$(".desce2").removeClass("active");
		b=0;
	}
});
