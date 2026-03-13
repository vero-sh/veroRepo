<?php
session_start();

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "biblioteca";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($_SERVER["REQUEST_METHOD"] == "POST") {

    $email = $_POST["email"];
    $password = $_POST["password"];

    $sql = "SELECT * FROM utente 
            WHERE email='$email' AND id_utente='$password'";

    $result = $conn->query($sql);

    if ($result->num_rows > 0) {

        $row = $result->fetch_assoc();

        echo "Login corretto<br>";

        $_SESSION["id_utente"] = $row["id_utente"];

        echo "<a href='mostra.php'>Vai alla pagina Mostra</a>";

    } else {

        echo "Login o password errati";

    }

}

$conn->close();
?>