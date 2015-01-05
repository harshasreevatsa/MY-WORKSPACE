$(document).ready(function(){
	alert("getting called before");
	$("#show_cart").click(function(){
		alert("getting called");
		$(location).attr('href',"http://localhost/SHOW_CART.html");
		alert("CALLED SHOW CART");
	});
});