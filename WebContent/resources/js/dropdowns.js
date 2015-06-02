var a = 0;
var b = 0;

$( ".desce1" ).click(function() {
	if(a==0){
		$(".desce1").removeClass("glyphicon glyphicon-menu-down");
		$(".desce1").addClass("glyphicon glyphicon-menu-right");
		a=1;
	} else {
		$(".desce1").addClass("glyphicon glyphicon-menu-down");
		$(".desce1").removeClass("glyphicon glyphicon-menu-right");
		b=0;
		a=0;
	}
});
$( ".desce2" ).click(function() {
	if(b==0){
		$(".desce2").removeClass("glyphicon glyphicon-menu-down");
		$(".desce2").addClass("glyphicon glyphicon-menu-right");
		b=1;
	} else {
		$(".desce2").addClass("glyphicon glyphicon-menu-down");
		$(".desce2").removeClass("glyphicon glyphicon-menu-right");
		b=0;
	}
});
