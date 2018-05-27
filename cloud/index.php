<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="theme-color" content="#ffffff">

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>ArchiBook</title>
    
  </head>
  <body class="container mt-5 center">
    <div>
    	<h1>_ Archibook _</h1>
    	<hr>
      <!--<span>Voici ArchiBook, c'est archi bien.</span>-->
    </div>

    <section>
		<!--
		<h2>Se connecter</h2>
		<form action="/archibook/cloud/check.php" method="post">
		  mail:<br>
		  <input type="text" name="mail" value="">
		  <br>
		  Password:<br>
		  <input type="password" name="password" value="">
		  <br><br>
		  <input type="submit" value="Submit">
		</form>
	-->

		<h3>Se connecter</h3>
		<form action="/archibook/cloud/check.php" method="post">
		  <div class="form-group">
		    <label for="mail">Email address</label>
		    <input name="mail" type="email" class="form-control" id="mail" placeholder="Enter email">
		  </div>
		  <div class="form-group">
		    <label for="password">Password</label>
		    <input name="password" type="password" class="form-control" id="password" placeholder="Password">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </section>

    <div>
		   
    </div>
  </body>
</html>
