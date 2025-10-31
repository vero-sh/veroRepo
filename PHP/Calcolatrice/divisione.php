<?php
function divisione($a, $b) {
    if ($b == 0) {
        return "Errore: divisione per zero!";
    } else {
        return $a / $b;
    }
}

$risultato = divisione($a, $b);
echo "<h3>Risultato: $a ÷ $b = $risultato</h3>";
?>