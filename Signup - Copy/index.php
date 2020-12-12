<!DOCTYPE html>
<html lang="en">
<?php
$dbServerName = "game-database.c5vzyypaaxx4.us-east-1.rds.amazonaws.com";
$dbUsername = "admin";
$dbPassword = "Nintendo9182!#";
$dbName = "GameDatabase";
 
$conn = mysqli_connect($dbServerName, $dbUsername, $dbPassword, $dbName);
?>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <div class="main">

        
        <div class="container">
            <div class="signup-content">
                <form method="POST" id="signup-form" class="signup-form">
                    <h2>Sign up </h2>                  
                        
                    <div class="form-group">
                        <input type="text" class="form-input" name="email" id="email" placeholder="UserName"/>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-input" name="password" id="password" placeholder="Password"/>
                        <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                    </div> 
					<div class="form-group">
                        <input type="text" class="form-input" name="passwordRepeat" id="passwordRepeat" placeholder="Repeat Password"/>
                        <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                    </div>   					
                    <div class="form-group">
                        <input type="submit" name="submit" id="submit" class="form-submit submit" value="Sign up"/>
                        <a href="http://lamp.eng.fau.edu/~rleiva2017/Game/Login/index.php" class="submit-link submit">Already have an account? Login</a>
                    </div>
                </form>
            </div>
        </div>
<?php
	if(isset($_POST['submit']))
	{
	$name = $_POST['name'];
	$email = $_POST['email'];
	$password = $_POST['password'];
	$passwordRepeat = $_POST['passwordRepeat'];
	
		if(empty($name) ||empty($email) || empty($password) || empty($passwordRepeat) )
		{
		header("Location: ../signup/index.php?error=emptyfields&name=".$name."&mail=".$email);
		exit();
		}
		else if($password != $passwordRepeat)
		{
		header("Location: ../signup/index.php?error=passwordcheck&name=".$name."&mail=".$email);
		exit();
		}
		else
		{
			$sql = "SELECT username FROM Account WHERE username=?";
			$stmt = mysqli_stmt_init($conn);
			if(!mysqli_stmt_prepare($stmt,$sql))
			{
				header("Location: ../signup/index.php?error=sqlerror");
				exit();
			}
			else 
			{
				mysqli_stmt_bind_param($stmt,"s",$email);
				mysqli_stmt_execute($stmt);
				mysqli_stmt_store_result($stmt);
				$resultCheck = mysqli_stmt_num_rows($stmt);
				if ($resultCheck > 0)
				{
					header("Location: ../signup/index.php?error=mailtaken&name=".$name);
					exit();
					
				}
				else
				{
					$sql = "INSERT INTO Account(username,password) VALUES (?,?)";
					$stmt = mysqli_stmt_init($conn);
					if(!mysqli_stmt_prepare($stmt,$sql))
					{		
						header("Location: ../signup/index.php?error=sqlerror");
						exit();
					}
					else
					{
						$hashedpass = password_hash($password,PASSWORD_DEFAULT);
						mysqli_stmt_bind_param($stmt,"ss",$email,$hashedpass);
						mysqli_stmt_execute($stmt);
						header("Location: ../signup/index.php?signup=success");
						exit();					
				}
			}
		}
		
	}
	mysqli_stmt_close($stmt);
	mysqli_close($conn);
}
	
	
	?>
	<div class="login100-more" style="background-image: url('images/aurora-5599375_1920.jpg');"></div>
    </div>
	

    
    
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>