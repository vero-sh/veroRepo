<?php
// index.php - un display, include file operazione che usano $a (prev) e $b (display)
$displayValue = '';
$prevPosted = '';
$operazione = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $displayPosted = isset($_POST['display']) ? $_POST['display'] : '';
    $prevPosted = isset($_POST['prev']) ? $_POST['prev'] : '';
    $operazione = isset($_POST['operazione']) ? $_POST['operazione'] : '';

    // normalizzo virgola -> punto e cast a float quando serva
    $a = strlen($prevPosted) ? (float) str_replace(',', '.', $prevPosted) : null; // primo operando
    $b = strlen($displayPosted) ? (float) str_replace(',', '.', $displayPosted) : null; // secondo operando

    // se arriva il submit "=" eseguo l'operazione solo se ci sono entrambi gli operandi
    if ($operazione && $a !== null && $b !== null) {
        switch ($operazione) {
            case 'somma':
                include __DIR__ . '/somma.php';
                break;
            case 'sottrazione':
                include __DIR__ . '/sottrazione.php';
                break;
            case 'moltiplicazione':
                include __DIR__ . '/moltiplicazione.php';
                break;
            case 'divisione':
                if ($b === 0.0) {
                    $displayValue = 'Errore: divisione per zero';
                    $result = null;
                } else {
                    include __DIR__ . '/divisione.php';
                }
                break;
            default:
                $displayValue = 'Operazione non valida';
                $result = null;
        }

        if (isset($result)) {
            $displayValue = (string) $result;
            // dopo il calcolo resettare prev/operazione così l'utente può ricominciare
            $prevPosted = '';
            $operazione = '';
        }
    } elseif ($operazione && $a !== null && $b === null) {
        // operazione scelta ma manca il secondo operando
        $displayValue = 'Errore: secondo operando mancante';
    } else {
        // nessuna operazione: mantengo il display inviato (es. dopo digitazione)
        $displayValue = $displayPosted;
    }
}
?><!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Calcolatrice PHP - Un display</title>
    <style>
        input[type="text"] { width: 240px; padding: 8px; font-size: 1.2rem; text-align: right; }
        button { padding: 10px 12px; margin: 4px; font-size: 1rem; }
        .calculator { max-width: 280px; }
    </style>
</head>
<body>
    <div class="calculator">
        <h3>Calcolatrice</h3>

        <form action="" method="post" novalidate>
            <!-- display visibile (unico) -->
            <div>
                <input id="display" name="display" type="text" inputmode="decimal" autocomplete="off"
                       value="<?php echo htmlspecialchars($displayValue, ENT_QUOTES); ?>">
            </div>

            <!-- hidden: valore precedente e operazione scelta -->
            <input type="hidden" name="prev" id="prev" value="<?php echo htmlspecialchars($prevPosted, ENT_QUOTES); ?>">
            <input type="hidden" name="operazione" id="operazione" value="<?php echo htmlspecialchars($operazione, ENT_QUOTES); ?>">

            <div>
                <button type="button" onclick="clearDisplay()">C</button>
                <button type="button" onclick="setOperation('divisione')">÷</button>
                <button type="button" onclick="setOperation('moltiplicazione')">×</button>
                <button type="button" onclick="setOperation('sottrazione')">−</button>

                <div>
                    <button type="button" onclick="appendValue('7')">7</button>
                    <button type="button" onclick="appendValue('8')">8</button>
                    <button type="button" onclick="appendValue('9')">9</button>
                    <button type="button" onclick="setOperation('somma')">+</button>

                    <button type="button" onclick="appendValue('4')">4</button>
                    <button type="button" onclick="appendValue('5')">5</button>
                    <button type="button" onclick="appendValue('6')">6</button>
                    <button type="submit">=</button>

                    <button type="button" onclick="appendValue('1')">1</button>
                    <button type="button" onclick="appendValue('2')">2</button>
                    <button type="button" onclick="appendValue('3')">3</button>

                    <button type="button" onclick="appendValue('0')">0</button>
                    <button type="button" onclick="appendValue('.')">.</button>
                </div>
            </div>
        </form>
    </div>

    <script>
        const display = document.getElementById('display');
        const prevInput = document.getElementById('prev');
        const opInput = document.getElementById('operazione');

        // digita numeri nel display (gestisce anche il punto)
        function appendValue(v) {
            if (v === '.' && display.value.includes('.')) return;
            display.value = display.value + v;
        }

        // imposta operazione: salvo il valore corrente in prev, ma NON cancello il display
        function setOperation(op) {
            if (display.value === '') return;

            // se c'è già un'operazione pendente e un prev, eseguo il calcolo inviando il form
            if (prevInput.value !== '' && opInput.value !== '' && display.value !== '') {
                // invio il form per calcolare prev op display
                document.forms[0].submit();
                return;
            }

            prevInput.value = display.value;
            opInput.value = op;
            // non cancelliamo il display: l'utente vuole vederlo
            display.focus();
        }

        // reset completo
        function clearDisplay() {
            display.value = '';
            prevInput.value = '';
            opInput.value = '';
            display.focus();
        }

        // focus iniziale
        window.addEventListener('load', () => display.focus());
    </script>
</body>
</html>