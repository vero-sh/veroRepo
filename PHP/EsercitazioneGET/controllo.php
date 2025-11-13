<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Result</title>
    <style>
        body {
            background: linear-gradient(135deg, #ecc266ff 0%, #eb770bff 100%);
            font-family: 'Segoe UI', Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: #fff;
            padding: 2rem 3rem;
            border-radius: 16px;
            box-shadow: 0 8px 32px rgba(44, 62, 80, 0.15);
            text-align: center;
        }
        .success {
            color: #27ae60;
            font-size: 1.3rem;
            margin-bottom: 1rem;
        }
        .welcome {
            color: #2980b9;
            font-size: 1.1rem;
        }
        .fail {
            color: #c0392b;
            font-size: 1.3rem;
        }
    </style>
</head>
<body>
    <div class="container">
    <?php
        
        $nomeFile = "utente.json";

           if (!file_exists($nomeFile)) {
            die ("File non esistente");
        } else { $contenuto = file_get_contents($nomeFile);
            //var_dump --> stampa il tipo di variabile e il suo contenuto
            //var_dump($contenuto);
            $dati = json_decode($contenuto, true); //con true converto in array associativo
        }

        $controllo = true;
        foreach ($dati as $utente) {
                if ($utente['login'] === $_POST['username'] && $utente['password'] === $_POST['password']) {
                    echo "<h1>Benvenuto " . $utente['nome'] . "</h1>";
                    echo "<h3>Accesso effettuato con successo</h3>";
                    $controllo = false;
                    break;
                }
            }
            if ($controllo) {
                echo "<h1>Accesso negato</h1>";
                echo "<h3>Username o password errati</h3>";
            }
?>
        </div>
     

    </div>
    <?php
        if (!$controllo) {
            echo("<div class=container>");
            echo("<h1> Dati </h1>");
            echo("<h4>" . (isset($utente) ? $utente['nome'] : '') . " i tuoi dati sono i seguenti: </h4>");
            echo "<p>";
            foreach ($utente as $k => $v) {
                echo "$k: $v<br>";
            }
            echo "</p>";
            echo("</div>");
        }
    ?>
</body>
</html>