$(document).ready(function(){
	alert("static cart");
	$.ajax({
		type:"GET",
		contentType:'application/json',
		dataType:'json',
		url:"http://localhost/TECH_SHOWCART.php",
		success:function(data)
		{
			
			alert(data);
			$num = data.num;
			alert($num);
			for(var i=0;i<$num;i++)
				{
				$("body").append("<div id='displa"+i+"'></div>");
				$("#displa"+i).append("</br>");
				$("#displa"+i).append(i);
				$("#displa"+i).append("</br>");
					$("#displa"+i).append("<img src='"+data.par[i][2]+"'"+"/>");
					$("#displa"+i).append("name: "+data.par[i][0]);
					$("#displa"+i).append("cost for each product: "+data.par[i][1]);
					$("#displa"+i).append("quantity: "+ data.par[i][3]);
					$("#displa"+i).append("<a href='http://localhost/TECH_REMOVE.php?username="+data.par[i][4]+"&itemid="+data.par[i][5]+"'"+">REMOVE ITEM</a>");
					$("#displa"+i).append("          ");
				}
		},
		error:function()
		{
			
		}
	});
	$("#buy").click(function()
	{
		
	});
});