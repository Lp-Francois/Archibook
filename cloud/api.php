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
	$name = $user['name'];
	$mail = $user['mail'];
	//$password = hash('sha256', $user['password']);
	$password = substr($user['password'], 8); //remove {SHA256}*
	$password =  bin2hex(base64_decode($password));

   $checkUni = $db->prepare('SELECT *
	    FROM users WHERE mail = :mail' );
    $checkUni->bindValue(':mail',$mail, PDO::PARAM_STR);
    $checkUni->execute();
    $data=$checkUni->fetch();
	if ($data) {
		$req = $db->prepare('UPDATE users SET name = :name, password = :password WHERE mail = :mail');
		$req->execute(array(
			'name' => $name,
			'password' => $password,
			'mail' => $mail
			));
	}else {
		$req = $db->prepare('INSERT INTO users(name, password, mail, school_id) VALUES(:name, :password, :mail, :school_id)');
		$req->execute(array(
		'name' => $name,
		'password' => $password,
		'mail' => $mail,
		'school_id' => $school_id,
		));
	}
}




