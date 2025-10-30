<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Calcolatrice PHP</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h3 class="card-title mb-4 text-center">Calcolatrice</h3>

                        <form action="" method="post" class="needs-validation" novalidate>
                            <div class="mb-3">
                                <label for="num1" class="form-label">Numero 1</label>
                                <input id="num1" type="number" name="num1" step="any" required class="form-control">
                                <div class="invalid-feedback">Inserisci il primo numero.</div>
                            </div>

                            <div class="mb-3">
                                <label for="num2" class="form-label">Numero 2</label>
                                <input id="num2" type="number" name="num2" step="any" required class="form-control">
                                <div class="invalid-feedback">Inserisci il secondo numero.</div>
                            </div>

                            <div class="mb-3">
                                <label for="operazione" class="form-label">Operazione</label>
                                <select id="operazione" name="operazione" required class="form-select">
                                    <option value="somma">Somma (+)</option>
                                    <option value="sottrazione">Sottrazione (-)</option>
                                    <option value="moltiplicazione">Moltiplicazione (×)</option>
                                    <option value="divisione">Divisione (÷)</option>
                                </select>
                                <div class="invalid-feedback">Seleziona un'operazione.</div>
                            </div>

                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary">Calcola</button>
                            </div>
                        </form>

                        <?php if ($_SERVER['REQUEST_METHOD'] === 'POST'): ?>
                            <div class="mt-4">
                                <h5 class="mb-3">Risultato</h5>
                                <div class="card">
                                    <div class="card-body">
                                        <?php
                                        // Valori puliti
                                        $num1 = isset($_POST['num1']) ? (float)$_POST['num1'] : 0;
                                        $num2 = isset($_POST['num2']) ? (float)$_POST['num2'] : 0;
                                        $operazione = isset($_POST['operazione']) ? $_POST['operazione'] : '';

                                        // In base all’operazione, includo il file corrispondente
                                        switch ($operazione) {
                                            case 'somma':
                                                include 'somma.php';
                                                break;
                                            case 'sottrazione':
                                                include 'sottrazione.php';
                                                break;
                                            case 'moltiplicazione':
                                                include 'moltiplicazione.php';
                                                break;
                                            case 'divisione':
                                                include 'divisione.php';
                                                break;
                                            default:
                                                echo "<div class=\"alert alert-danger\">Operazione non valida.</div>";
                                        }
                                        ?>
                                    </div>
                                </div>
                            </div>
                        <?php endif; ?>

                    </div>
                </div>

            
            </div>
        </div>
    </div>

    <!-- Bootstrap 5 JS (optional, per validazione e componenti) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Simple client-side bootstrap validation
        (function () {
            'use strict'
            var forms = document.querySelectorAll('.needs-validation')
            Array.prototype.slice.call(forms).forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
        })()
    </script>
</body>
</html>
