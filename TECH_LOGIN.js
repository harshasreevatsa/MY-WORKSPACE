$(document).ready(function()
{
	$("p").append("SUCCESS ");
	$("#login").click(function()
	{
		$("p").append("SUCCESS ");
		var username = $("#uname").val();
		var password = $("#pword").val();
		$.ajax(
		{
			type:"GET",
			//contentType:"application/json",
			//dataType:"json",
			url:"http://localhost/TECH_LOGIN.php?username="+username+"&password="+password,
			success:function(data)
			{
				alert(data);
				//$("p").append(data);
				window.location("http://localhost/TECH_ITEM.html");
			},
			error:function()
			{
				$("p").append("Something Broke!!!");
			}
		});
	});
	$("#register").click(function(){
		window.location("http://localhost/TECH_REGISTER.html");
	});
});