<?php
try
{
$db = new PDO('mysql:host=localhost;dbname=archibook', 'root', '');
}
catch (Exception $e)
{
        die('Erreur : ' . $e->getMessage());
}
?>
