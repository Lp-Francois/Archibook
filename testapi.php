<?php

//$url = 'http://localhost/archibook/api.php/isep';
$url = 'http://localhost/archibook/api.php';

$data = 
[
	1 => 
	[
		'name' => 'John',
		'password' => 'ahjdazdkjaznda'
	],
	2 => 
	[
		'name' => 'JB2',
		'password' => 'azerty2'
	],
];

$ch = curl_init( $url );
# Setup request to send json via POST.
$payload = json_encode( $data );
curl_setopt( $ch, CURLOPT_POSTFIELDS, $payload );
curl_setopt( $ch, CURLOPT_HTTPHEADER, array('Content-Type:application/json'));
# Return response instead of printing.
curl_setopt( $ch, CURLOPT_RETURNTRANSFER, true );
# Send request.
$result = curl_exec($ch);
curl_close($ch);
# Print response.
echo "<pre>$result</pre>";