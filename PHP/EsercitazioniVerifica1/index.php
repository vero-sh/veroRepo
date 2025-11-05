<?php

$base = $_POST['base'];
$altezza = $_POST['altezza'];

// Calcola perimetro
$perimetro = 2 * ($base + $altezza);

// Salva in JSON
if ($_POST && isset($base) && isset($altezza)) {
    $dati = [
        'base' => $base,
        'altezza' => $altezza,
        'perimetro' => $perimetro,
        'data' => date('Y-m-d H:i:s')
    ];

    $json = json_encode($dati, JSON_PRETTY_PRINT);
    
    // inserimento contenuto nel file json
    $filename = 'risultati.json';
    file_put_contents($filename, $json);
    echo "<p style='color: green;'>Dati salvati con successo!</p>";
    
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Calcolo Perimetro</title>
</head>
<body>
    <form method="post">
        Base: <input type="number" name="base" value="<?php $base ?>" required><br>
        Altezza: <input type="number" name="altezza" value="<?php $altezza ?>" required><br>
        <button type="submit">Calcola e Salva</button>
    </form>

    <?php 
    if ($_POST && isset($base) && isset($altezza)){ 
        echo "<h3>Risultato:</h3>";
        echo "<p>Perimetro: $perimetro"; 
    }
    ?>
        <?php
        // Mostra il contenuto del JSON
        if (file_exists('risultati.json')) {
            $file_content = file_get_contents('risultati.json');
            echo "<pre>File JSON: " . htmlspecialchars($file_content);
        }
        ?>
    
</body>
</html>