<?php
session_start();

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "biblioteca";

$conn = new mysqli($servername, $username, $password, $dbname);

if (!isset($_SESSION["id_utente"])) {
    echo "Devi fare il login";
    exit();
}

$id = $_SESSION["id_utente"];

$sql = "SELECT * FROM utente WHERE id_utente='$id'";

$result = $conn->query($sql);

if ($result->num_rows > 0) {

    $row = $result->fetch_assoc();

    echo "<h2>Dati Utente</h2>";

    echo "ID: " . $row["id_utente"] . "<br>";
    echo "Nome: " . $row["nome"] . "<br>";
    echo "Cognome: " . $row["cognome"] . "<br>";
    echo "Email: " . $row["email"] . "<br>";
    echo "Età: " . $row["eta"] . "<br>";

}

$conn->close();
?>