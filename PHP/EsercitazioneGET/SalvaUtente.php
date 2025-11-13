<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <?php

// controllo se esiste il file
$nomeFile = "utente.json";

/**
 * esiste il file?
 * creo i dati da salvare in input
 * salvo i dati nel file
 */


if(!file_exists($nomeFile)){

    die("errore file non esistente");

}else{
    if (empty($_POST["nome"]) || empty($_POST["cognome"]) || empty($_POST["email"]) || empty($_POST["login"]) || empty($_POST["password"])) {
        die("Dati incompleti per la registrazione.");
    }
    // dati da salvare
    
    //leggere il file in formato json
    $json = file_get_contents($nomeFile);
    
    //decodifico il json in un array php
    $dati = json_decode($json, true);
    

    foreach ($dati as $utente) {
        if ($utente['login'] === $_POST['login']) {
            die("Errore: Il login esiste già. Scegli un altro login.");
        }
    }


    $utente = [
            "nome" => $_POST["nome"],
            "cognome" => $_POST["cognome"],
            "email" => $_POST["email"],
            "login" => $_POST["login"],
            "password" => $_POST["password"]
    ];
    //aggiungo i nuovi dati
    $dati[] = $utente;
    
//codifico l'array in formato json, trasformandolo in stringa json
$json = json_encode($dati, JSON_PRETTY_PRINT);

//salvo il file
file_put_contents($nomeFile, $json);

}
?>
    
</body>
</html>