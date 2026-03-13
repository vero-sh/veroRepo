
<?php

// prendere i dati del form e inserirli nel database

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "biblioteca";

$conn = new mysqli($servername, $username, $password, $dbname);

//seleziono il database
$conn->select_db($dbname);

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $id = $_POST["id"];
    $nome = $_POST["nome"];
    $cognome = $_POST["cognome"];
    $email = $_POST["email"];
    $eta = $_POST["eta"];

    $sql = "INSERT INTO $dbname.utente (id_utente, nome, cognome, email, eta) VALUES ('$id', '$nome', '$cognome', '$email', '$eta')";

    if ($conn->query($sql) === TRUE) {
        echo "Nuovo record inserito con successo";
    } else {
        echo "Errore: " . $sql . "<br>" . $conn->error;
    }
}


?>