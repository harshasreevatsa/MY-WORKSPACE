$(document).ready(function(){
	alert("CALLED");
	$("#search_click").click(function(){
		var name = $("#search_name").val();
		$.ajax({
			type:"GET",
			contentType: 'application/json',
			dataType:'json',
			url:"http://localhost/TECH_ITEM.php?name="+name,
			success:function(data)
			{
				alert(data);
				$num = data.num;
				alert($num);
				$("div").html("");
				for(var i=0;i<$num;i++)
					{
					$("body").append("<div id='displa"+i+"'></div>");
					alert("item id= " + data.par[i][6]);
				$("#displa"+i).append("<a href='http://localhost/TECH_CART.php?itemid="+data.par[i][6]+"'"+"><img src='"+data.par[i][3]+"'/></a>");
				$("#displa"+i).append("</br>");
				$("#displa"+i).append("<p>functionality: "+data.par[i][0]+"</p>");

				$("#displa"+i).append("req: "+data.par[i][1]);
				$("#displa"+i).append("</br>");
				$("#displa"+i).append("cost: $"+data.par[i][4]);
				$("#displa"+i).append("</br>");
				$("#displa"+i).append("config: "+data.par[i][5]);
				$("#displa"+i).append("</br>");
					}
				alert(data.session1);
				$("#session").append(data.session1);
			},
			error:function()
			{
				
			}
		});
	});
});