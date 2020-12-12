<?php
$dbServerName = "game-database.c5vzyypaaxx4.us-east-1.rds.amazonaws.com";
$dbUsername = "admin";
$dbPassword = "Nintendo9182!#";
$dbName = "GameDatabase";
 
$conn = mysqli_connect($dbServerName, $dbUsername, $dbPassword, $dbName);
?>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
<?php

$sql = "SELECT username, score FROM Score ORDER BY Score DESC ";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo "<table><tr><th>Username</th><th>Score</th></tr>";
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>" . $row["username"]. "</td><td>" . $row["score"]."</td></tr>";
    }
    echo "</table>";
} else {
    echo "0 results";
}

$conn->close();
?>
</body>
</html>