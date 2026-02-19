-- Aggiornare la data di prestito mancante
UPDATE prestiti
SET data_prestito = '2026-02-19'
WHERE data_prestito IS NULL;

-- Aggiornare la data di restituzione mancante
UPDATE prestiti
SET data_restituzione = '2026-02-26'
WHERE data_restituzione IS NULL;
