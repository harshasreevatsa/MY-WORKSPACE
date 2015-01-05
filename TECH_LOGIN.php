<?php
session_start();
$username = $_GET["username"];
$password = $_GET["password"];
$link = mysqli_connect("localhost","root","","myworkspace");
$sql = "SELECT password FROM login WHERE username='".$username."'";
$result = mysqli_query($link,$sql);
if($row = mysqli_fetch_assoc($result))
{
	if($row["password"]===$password)
	{
		//echo "WELCOME ".$username;
		$_SESSION["username"] = $username;
	}
	else
		echo "PASSWORD AND USERNAME DOES NOT MATCH";
}
else
	echo "USER NOT FOUND";
mysqli_close($link);
?>