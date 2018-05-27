<?php
 
include('bdd.php');

$method = $_SERVER['REQUEST_METHOD'];
$request = explode('/', trim($_SERVER['PATH_INFO'],'/'));

$req_keys = $db->prepare('SELECT *
		        FROM school_keys WHERE school_key = :school_key');
		        $req_keys->bindValue(':school_key',$request[0], PDO::PARAM_STR);
		        $req_keys->execute();
		        $data=$req_keys->fetch();
			if ($data['school_key']) {
				// it is ok

				$school_id = $data['ID'];
			}else {
				die();
			}


$input = json_decode(file_get_contents('php://input'),true);

include('bdd.php');

foreach ($input as $user) {
	/*
	echo $user['name']."\r\n";
	echo $user['password']."\r\n";
	echo $user['mail']."\r\n";
	echo $school_id."\r\n";
	*/
	$name = $user['name'];
	$mail = $user['mail'];
	$password = hash('sha256', $user['password']);
/*
	$query=$db->prepare('SELECT mail
		        FROM users WHERE school_id = :school_id');
		        $query->bindValue(':school_id',$school_id, PDO::PARAM_STR);
		        $query->execute();
		        $data=$query->fetch();
*/

	$req = $db->prepare('INSERT INTO users(name, password, mail, school_id) VALUES(:name, :password, :mail, :school_id)');
	$req->execute(array(
	'name' => $name,
	'password' => $password,
	'mail' => $mail,
	'school_id' => $school_id,
	));
}




