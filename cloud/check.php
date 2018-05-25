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

				    $message = '<p>Bienvenue '.$data['name'].', 
						vous êtes maintenant connecté!</p>';  

					
					$query=$db->prepare('SELECT *
			        FROM users WHERE school_id = :school_id');
			        $query->bindValue(':school_id',$data['school_id'], PDO::PARAM_STR);
			        $query->execute();
			        
			        echo '<h1>Les personnes de votre école : </h1>';
			        while ($donnees = $query->fetch()){
			        	echo $donnees['name'] . ' - ' . $donnees['mail'] . '</br>';
			        }

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