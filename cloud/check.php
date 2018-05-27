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
    	<h1>Archibook</h1>
    	<hr>
    </div>

    <section>
		<?php
			
			include("bdd.php");
		    $message='';
		    if (empty($_POST['mail']) || empty($_POST['password']) ) //Oublie d'un champ
		    {
		        $message = '<p>une erreur s\'est produite pendant votre identification.
				Vous devez remplir tous les champs</p>';
		    }
		    else
		    {

		        $query=$db->prepare('SELECT mail, password, name, school_id
		        FROM users WHERE mail = :mail');
		        $query->bindValue(':mail',$_POST['mail'], PDO::PARAM_STR);
		        $query->execute();
		        $data=$query->fetch();

		        
				if ($data['password'] == hash('sha256', $_POST['password']))
				{
					echo '<i>Vous êtes connecté(e).</i>';
					$query=$db->prepare('SELECT *
			        FROM users WHERE school_id = :school_id');
			        $query->bindValue(':school_id',$data['school_id'], PDO::PARAM_STR);
			        $query->execute();

			        echo '<h3>Les personnes de votre école : </h3>';
			       	echo '<ul class="list-group">';
			        while ($donnees = $query->fetch()){
			        	echo '<li class="list-group-item">'.$donnees['name'] . ' - ' . $donnees['mail'] . '</li>';
			        }
			        echo '</ul>';

				}
				else
				{
				    $message = '<p>Une erreur s\'est produite 
				    pendant votre identification.<br /> Le mot de passe ou le pseudo 
			            entré n\'est pas correcte.';
				}
		    	$query->CloseCursor();
		    }
		    echo $message;
			
		?>
    </section>

    <div>
		   
    </div>
  </body>
</html>

