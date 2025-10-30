<?php
function divisione($num1, $num2) {
    if ($num2 == 0) {
        return "Errore: divisione per zero!";
    } else {
        return $num1 / $num2;
    }
}

$risultato = divisione($num1, $num2);
echo "<h3>Risultato: $num1 ÷ $num2 = $risultato</h3>";
?>