<?php
session_start();
$link = mysqli_connect("localhost","root","","myworkspace");
$sql1 = "SELECT username,itemid,status,quantity FROM cart WHERE username='".$_SESSION["username"]."'";
$result1 = mysqli_query($link,$sql1);
$qy=0;
$qs="";
while($row = mysqli_fetch_assoc($result1))
{
	echo "BUYING FOR THE FIRST TIME";
	if($_SESSION["itemid"]===$row["itemid"] && $row["status"]==="incart")
	{
		$qy = $row["quantity"] + 1;
		echo $qy;
		$update = "UPDATE cart set quantity=".$qy." WHERE username='".$_SESSION["username"]."' AND itemid='".$row["itemid"]."' AND status='incart'";
		mysqli_query($link,$update);
	}
	else
	{
		echo "BUYING FOR THE FIRST TIME";
		$sql = "INSERT INTO CART values('".$_SESSION["username"]."','".$_SESSION["itemid"]."',1,'incart')";
		$result = mysqli_query($link,$sql);
	}
		
}
if(!($rwwww = mysqli_fetch_assoc($result1)))
{
	echo "BUYING FOR THE FIRST TIME";
	$sql = "INSERT INTO CART values('".$_SESSION["username"]."','".$_SESSION["itemid"]."',1,'incart')";
	$result = mysqli_query($link,$sql);
}

?>