
<?php
if (isset($_COOKIE['utente'])) {
    setcookie('utente', '', time() - 3600); 
}   

