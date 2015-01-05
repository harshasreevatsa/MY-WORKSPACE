<?php
$username = $_GET["username"];
$itemid = $_GET["itemid"];
echo $username.$itemid;
$link =  mysqli_connect("localhost","root","","myworkspace");
$sql = "DELETE FROM cart WHERE username='".$username."' AND itemid=".$itemid;
$result = mysqli_query($link,$sql);
header('Location:http://localhost/SHOW_CART.html'); 
?>