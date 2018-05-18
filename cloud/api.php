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
			}else {
				die();
			}


$input = json_decode(file_get_contents('php://input'),true);

include('bdd.php');

foreach ($input as $user) {
	echo $user['name']."\r\n";
	echo $user['password']."\r\n";

	$name = $user['name'];
	$password = hash('sha256', $user['password']);

	$req = $db->prepare('INSERT INTO users(name, password) VALUES(:name, :password)');
	$req->execute(array(
	'name' => $name,
	'password' => $password,
	));
}




