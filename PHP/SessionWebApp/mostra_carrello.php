<?php
session_start();

if (!isset($_SESSION['utente'])) {
    header("Location: index.php");
    exit;
}

$utente = $_SESSION['utente'];
$carrello = $_SESSION['carrello'] ?? [];
?>

<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Carrello</title></head>
<body>

<h1>Carrello</h1>

<h2>Dati utente</h2>
<p>ID: <?= $utente['id'] ?></p>
<p>Nome: <?= $utente['nome'] ?></p>
<p>Cognome: <?= $utente['cognome'] ?></p>

<h2>Oggetti nel carrello</h2>

<?php if (empty($carrello)): ?>
    <p>Il carrello è vuoto.</p>
<?php else: ?>
    <ul>
        <?php foreach ($carrello as $o): ?>
            <li><?= $o['nome'] ?></li>
        <?php endforeach; ?>
    </ul>
<?php endif; ?>

<p><a href="oggetti.php">Torna alla lista oggetti</a></p>

</body>
</html>
