$(document).ready(function(){
	alert("LINKED");
	$("#get").hover(function(){
		$("#p1").slideToggle(1200);
	});
	
	$("#get1").hover(function(){
		$("#p2").slideToggle(1400);
	});
	
	$("#get2").hover(function(){
		$("#p3").slideToggle(1400);
	});
	
	$("#get3").hover(function(){
		$("#hint").slideToggle("slow");
	});
	
	$("#get3").click(function(){
		$("#p4").slideToggle(1400);
	});
	
});