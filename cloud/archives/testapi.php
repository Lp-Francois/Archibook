<?php

//$url = 'http://localhost/archibook/api.php/isep';
$url = 'http://localhost/archibook/cloud/api.php/e34a2154179b291826b06d2c80db04b38899ac4208c564ab7cf6d481ad1585eb';

$data = 
[
	1 => 
	[
		'name' => 'admin4',
		'password' => 'admi4n',
		'mail' => 'admin4mail1@autre.com'
	]
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