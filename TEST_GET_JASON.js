$(document).ready(function(){
	$("p").append("<b>LINKING</b>");
	$("#press").click(function()
		{
		var username = $("#male").val();
		$("p").append("<b> BEFORE GET JASON </b>");
		$.getJSON("http://localhost/newfile.php?username="+username,function(data){
			$("p").append("<b> AFTER GET JASON </b>");
			$.each(data,function(){
				$("p").append("<b>" + data.name + "</b");
			});
		});
});
});