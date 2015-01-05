<?php
$username = $_GET["username"];
$password = $_GET["password"];
$link = mysqli_connect("localhost","root","","myworkspace");
$sql = "SELECT password FROM login WHERE username='".$username."'";
$result = mysqli_query($link,$sql);
if($row = mysqli_fetch_assoc($result))
{
	echo "USERNAME IS ALREADY IN USE, PLEASE CHOOSE A DIFFERENT USERNAME";	
}
else
{
	$ins = "INSERT INTO login (username,password) VALUES ('".$username."',"."'".$password."')";
	$ins_res = mysqli_query($link,$ins);
	echo "YOU ARE REGISTERED".$username.$password;
}
mysqli_close($link);
?>