<?php
session_start();


if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    $idInserito = $_POST['id'];

   
    $utente = json_decode(file_get_contents("utente.json"), true);

    if ($idInserito == $utente['id']) {
        $_SESSION['utente'] = $utente; 
        header("Location: oggetti.php");
        exit;
    } else {
        $errore = "ID utente non valido!";
    }
}
?>

<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Login</title></head>
<body>

<h1>Login</h1>

<form method="POST">
    <input type="text" name="id" placeholder="Inserisci ID utente" required>
    <button type="submit">Accedi</button>
</form>

</body>
</html>
