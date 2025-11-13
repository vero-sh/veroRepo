<?php

$a = $_POST['num1'];
$b = $_POST['num2'];

$operatore = $_POST['operatore'];
$risultato = "";

if($_POST && isset($a) && isset($b) && isset($operatore)){
if($operatore == "+") $risultato = $a + $b;
elseif($operatore == "-") $risultato = $a - $b;
elseif($operatore == "*") $risultato = $a * $b;
elseif($operatore == "/") $risultato = $a / $b;
else echo "<p>scegli un operatore</p>";
}

echo $risultato;
//salvo in json

$json = json_encode($risultato);

file_put_contents('risultati.json', $json);


?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <form method="post">
        <input type="number" name= "num1" value= "<?php echo $a;?>"> <br>
        <input type="number" name= "num2" value= <?php echo $b;?>> <br>
        <select name="operatore">
        <option value="+" >+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
        </select> 
        <br>
        <button type = "submit"> Calcola</button>
    </form>
    
</body>
</html>