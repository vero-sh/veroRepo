<?php
session_start();

if (!isset($_SESSION['utente'])) {
    header("Location: index.php");
    exit;
}


if (isset($_GET['add'])) {
    $idAdd = intval($_GET['add']);

    $oggetti = json_decode(file_get_contents("oggetti.json"), true);

    foreach ($oggetti as $o) {
        if ($o['id'] == $idAdd) {
            $_SESSION['carrello'][] = $o;
            $messaggio = "Aggiunto: " . $o['nome'];
            break;
        }
    }
}

$oggetti = json_decode(file_get_contents("oggetti.json"), true);
$utente = $_SESSION['utente'];
?>

<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Oggetti</title></head>
<body>

<h1>Benvenuto <?= $utente['username'] ?></h1>

<h2>Lista oggetti</h2>

<?php if (isset($messaggio)) echo "<p>$messaggio</p>"; ?>

<?php foreach ($oggetti as $o): ?>
    <p>
        <?= $o['nome'] ?>
        <a href="?add=<?= $o['id'] ?>">[Aggiungi al carrello]</a>
    </p>
<?php endforeach; ?>

<h2>Menu</h2>
<p><a href="mostra_carrello.php">Vedi carrello</a></p>
<p><a href="index.php">Logout</a></p>

</body>
</html>
