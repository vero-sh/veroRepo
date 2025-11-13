//set-cookie.php
Contiene la funzione che riceve il nome dal form e imposta un cookie valido per un’ora. 
<?php
if (isset($_POST['nome'])) {
    $nome = htmlspecialchars($_POST['nome']);
    setcookie('utente', $nome, time() + 3600); // Cookie valido per 1 ora
    header('Location: index.php');
    exit();
} else {
    header('Location: index.php');
    exit();
}