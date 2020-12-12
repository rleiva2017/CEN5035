<?php
$dbServerName = "aws-faugroup17.c5vzyypaaxx4.us-east-1.rds.amazonaws.com";
$dbUsername = "admin";
$dbPassword = "FAUGroup17!!";
$dbName = "AWSFAUGroup17";
 
$email = ;
$total =;
$date =;
$sql = "INSERT INTO Transaction(T_total,Tdate,Temail) VALUES (?,?,?,?)";
$stmt = mysqli_stmt_init($conn);		
mysqli_stmt_bind_param($stmt,"dss",$total,$date,$$email);
mysqli_stmt_execute($stmt);
exit();					
?>