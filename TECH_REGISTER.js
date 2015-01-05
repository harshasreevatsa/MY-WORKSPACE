$(document).ready(function(){
	alert("CALLED");
	$("#REG").click(function(){
		var username = $("#username1").val();
		var password = $("#password1").val();
		$.ajax({
			type:"GET",
			url:"http://localhost/TECH_REGISTER.php?username="+username+"&password="+password,
			success:function(data)
			{
				alert(username);
				alert(password);
				$("p").append(data);
			},
			error:function()
			{
				$("p").append("A MINOR SLOWDOWN, PLEASE BEAR WITH US");
			}
		});
	});
});