<?php
 
$method = $_SERVER['REQUEST_METHOD'];
//$request = explode('/', trim($_SERVER['PATH_INFO'],'/'));
//var_dump($request);

$input = json_decode(file_get_contents('php://input'),true);

include('bdd.php');

foreach ($input as $user) {
	echo $user['name']."\r\n";
	echo $user['password']."\r\n";

	$req = $db->prepare('INSERT INTO users(name, password) VALUES(:name, :password)');
	$req->execute(array(
	'name' => $user['name'],
	'password' => $user['password'],
	));
}




