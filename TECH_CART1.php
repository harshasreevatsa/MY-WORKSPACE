<?php
session_start();
$link = mysqli_connect("localhost","root","","myworkspace");
$sql1 = "SELECT func,req,version,link,cost,config FROM descid WHERE itemid='".$_SESSION["itemid"]."'";
$result1 = mysqli_query($link,$sql1);
$i=0;
$j=0;
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
$j=0;
$i = $i + 1;
$arr=["num"=>$i,"par"=>$ret];
echo json_encode($arr);
?>