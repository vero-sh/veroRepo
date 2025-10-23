<?php

// controllo se esiste il file
$nomeFile = "dates.json";

/**
 * esiste il file?
 * creo i dati da salvare in input
 * salvo i dati nel file
 */


if(!file_exists($nomeFile)){

    die("errore file non esistente");

}else{
    // dati da salvare
    $utente = [
            "login" => "Niccolo",
            "password" => "Veronesi"
    ];

//leggere il file in formato json
$json = file_get_contents($nomeFile);

//decodifico il json in un array php
$dates = json_decode($json, true);
if (!is_array($dates)) {
    $dates = [];
}

//aggiungo i nuovi dati
$dates[] = $utente;

//codifico l'array in formato json, trasformandolo in stringa json
$json = json_encode($dates, JSON_PRETTY_PRINT);

//salvo il file
file_put_contents($nomeFile, $json);

}
?>