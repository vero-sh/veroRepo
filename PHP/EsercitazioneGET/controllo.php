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
        $_USER = array(
            "Niccolò" => "Veronesi",
            "admin" => "123",
            "Luca" => "Mazzoni",
            "Malaman" => "Malaman123"
        );
        $controllo = true;
        if(isset($_USER[$_GET["username"]]) && $_USER[$_GET["username"]] === $_GET["password"]) {
                echo '<img src="IMG_6875.jpeg" alt="Foto stadio" style="width:120px; border-radius:10px; margin-bottom:0.5rem;">';
                echo '<div class="success">Login Effettuato!</div>';
            echo '<div class="welcome">Benvenuto, ' . htmlspecialchars($_GET["username"]) . '!</div>';
            $controllo = false;
            break;

        } else {
            echo '<div class="fail">Login Fallito. Nome utente o password non validi.</div>';
        }
?>
        </div>
        <?php
        if($controllo) {
                echo '<div class="fail">Login Fallito. Nome utente o password non validi.</div>';
                echo '<h4r>I tuoi dati: </h4>';
                
            }

        ?>

    </div>
</body>
</html>