<?php
$nomeFile = "utente.json"; //verifico se il file esiste
if(!file_exists($nomeFile)){
    die("File non esistente");
}else{
    $contenutoFile = file_get_contents($nomeFile); //leggo il contenuto del file
    //var_dump($contenutoFile); stampo il contenuto del file\\
    $dati = json_decode($contenutoFile, true);
    foreach($dati as $utente){
        echo("<p>"); //recupero un oggetto alla volta\\
        foreach($utente as $key => $value){
            echo("<strong>$key:</strong> $value<br>");
        }
        echo("</p>");
    }
}