select * from utente where eta>25;
select * from utente where nome like 'P%';
select * from utente where email like '%gmail%';
select * from utente where cognome like '%ra';
select * from utente where eta BETWEEN 18 AND 30;
SELECT DISTINCT autore FROM Libro;
select * from libro where titolo like '%amore%';
select * from libro where anno_pub <= 2100;
select * from libro where isbn is not null;

/*
Selezionare i nomi e cognomi degli utenti insieme alla data dei loro prestiti.
*/

select u.nome, u.cognome, p.data_prestito from utente u join prestito p on u.id_utente = p.id_utente;

/*
Selezionare i titoli dei libri prestati senza duplicati.
*/
SELECT DISTINCT l.titolo FROM Libro l JOIN Prestito p ON l.id_libro = p.id_libro;

/*
Selezionare i nomi degli utenti e i titoli dei libri che hanno preso in prestito.
*/

SELECT u.nome, u.cognome, l.titolo
FROM utente u
JOIN prestito p ON u.id_utente = p.id_utente
JOIN libro l ON p.id_libro = l.id_libro;
 