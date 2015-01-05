<?php
session_start();
$name = $_GET["name"];
$link = mysqli_connect("localhost","root","","myworkspace");
$sql = "SELECT itemid from item WHERE name='".$name."'";
$result = mysqli_query($link,$sql);
$ret_func="";
$ret_req="";
$ret_version="";
$ret_link="";
$ret_cost="";
$ret_config="";
$ret_itemid="";
$session1="";
$i=0;
$j=0;
while($row=mysqli_fetch_assoc($result))
{
	$sql1 = "SELECT func,req,version,link,cost,config FROM descid WHERE itemid='".$row["itemid"]."'";
	$result1 = mysqli_query($link,$sql1);
	while($row1=mysqli_fetch_assoc($result1))
	{
		$ret[$i][$j] = $row1["func"];
		$j = $j + 1;
		$ret[$i][$j] = $row1["req"];
		$j = $j + 1;
		$ret[$i][$j] = $row1["version"];
		$j = $j + 1;
		$ret[$i][$j] = $row1["link"];
		$j = $j + 1;
		$ret[$i][$j] = $row1["cost"];
		$j = $j + 1;
		$ret[$i][$j] = $row1["config"]; 	
		$j = $j + 1;
	}
	$ret[$i][$j]=$row["itemid"];
	$j=0;
	$i = $i + 1;
}


$arr = ["num"=>$i,"par"=>$ret,"session1"=>$_SESSION["username"]];
echo json_encode($arr);
?>
