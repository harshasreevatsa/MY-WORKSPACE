<?php
session_start();
$link = mysqli_connect("localhost","root","","myworkspace");
$sql = "SELECT * from cart c,descid d, item i where c.itemid = i.itemid and i.itemid=d.itemid  and username='".$_SESSION["username"]."'";
$result = mysqli_query($link,$sql);
$i=0;
$j=0;
while($row = mysqli_fetch_assoc($result))
{
	$cart[$i][$j] = $row["name"];
	$j = $j + 1;
	$cart[$i][$j] = $row["cost"];
	$j = $j + 1;
	$cart[$i][$j] = $row["link"];
	$j = $j + 1;
	$cart[$i][$j] = $row["quantity"];
	$j = $j + 1;
	$cart[$i][$j] = $row["username"];
	$j = $j + 1;
	$cart[$i][$j] = $row["itemid"];
	$j = $j + 1;
	
	$i = $i + 1;
	$j=0;
}
//echo " USERNAME= ".$_SESSION["username"];
$arr = ["num"=>$i,"par"=>$cart];
echo json_encode($arr);
?>