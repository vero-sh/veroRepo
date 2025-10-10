<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Result</title>
    <style>
        body {
            background: linear-gradient(135deg, #74ebd5 0%, #ACB6E5 100%);
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
            array("username" => "Niccolò", "password" => "Veronesi"),
            array("username" => "admin", "password" => "123"),
            array("username" => "Luca", "password" => "Mazzoni"),
        );

        $login_failed = true;
        foreach($_USER as $value) {
            if ($_GET["username"] === $value["username"] && $_GET["password"] === $value["password"]) {
                echo '<p class="success">Login effettuato con successo</p>';
                echo '<p class="welcome">Benvenuto ' . htmlspecialchars($value["username"]) . '</p>';
                $login_failed = false;
                break;
            }
        }
        if($login_failed) {
            echo '<p class="fail">Login fallito</p>';
        }
    ?>
    </div>
</body>
</html>