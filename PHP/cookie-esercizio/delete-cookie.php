
<?php
if (isset($_COOKIE['utente'])) {
    setcookie('utente', '', time() - 3600); // Imposta la scadenza del cookie nel passato per cancellarlo
}   

