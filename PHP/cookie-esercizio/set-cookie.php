
<?php
if (isset($_POST['nome'])) {
    $nome = htmlspecialchars($_POST['nome']);
    setcookie('utente', $nome, time() + 3600); 
    header('Location: index.php');
    exit();
} else {
    header('Location: index.php');
    exit();
}