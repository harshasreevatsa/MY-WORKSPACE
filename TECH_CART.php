<?php
session_start();
$_SESSION["itemid"] = $_GET["itemid"];
header("Location:http://localhost/TECH_CART.html");
?>