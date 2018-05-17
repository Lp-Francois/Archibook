<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="theme-color" content="#ffffff">

    <title>ArchiBook</title>
    
  </head>
  <body>
    <div>
      <span>Voici ArchiBook, c'est archi bien.</span>
    </div>

    <section>
		
		<h2>Se connecter</h2>
		<form action="/archibook/" method="post">
		  Name:<br>
		  <input type="text" name="name" value="">
		  <br>
		  Password:<br>
		  <input type="passwodr" name="password" value="">
		  <br><br>
		  <input type="submit" value="Submit">
		</form> 
    </section>

    <div>
		    <?php
		
			include("bdd.php");


		    $message='';
		    if (empty($_POST['name']) || empty($_POST['password']) ) //Oublie d'un champ
		    {
		        $message = '<p>une erreur s\'est produite pendant votre identification.
			Vous devez remplir tous les champs</p>';
		    }
		    else
		    {
		        $query=$db->prepare('SELECT name, password
		        FROM users WHERE name = :name');
		        $query->bindValue(':name',$_POST['name'], PDO::PARAM_STR);
		        $query->execute();
		        $data=$query->fetch();
			if ($data['password'] == $_POST['password']) // Acces OK !
			{
				echo 'it works';

			    $message = '<p>Bienvenue '.$data['name'].', 
					vous êtes maintenant connecté!</p>';  
			}
			else // Acces pas OK !
			{
			    $message = '<p>Une erreur s\'est produite 
			    pendant votre identification.<br /> Le mot de passe ou le pseudo 
		            entré n\'est pas correcte.';
			}
		    $query->CloseCursor();
		    }
		    echo $message;

	
		?>
    </div>
  </body>
</html>
