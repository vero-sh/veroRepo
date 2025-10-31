<?php

/*

 - PHP è un linguaggio sincrono: elabora la pagina sul server e invia la risposta al client solo dopo aver completato l'elaborazione.
 Il codice viene eseguito ogni volta che la pagina viene richiesta. php aggiunge funzionalità dinamiche alle pagine web statiche (html).
 come java e' di derivazione C;
 
 - Node.js è asincrono: può gestire richieste e risposte in modo non bloccante, fornendo risposte immediate al client mentre continua ad elaborare altre operazioni
    
 - sito sincrono vs sito asincrono
 Un sito sincrono attende che ogni richiesta venga completata prima di procedere, mentre un sito asincrono può gestire più richieste contemporaneamente, 
 migliorando le prestazioni e l'esperienza utente.

- il file va salvato con estensione .php se per esempio metto estensione .html non viene interpretato dal web server come php ma come html

- il metodo Get invia i dati tramite l'url, il metodo Post invia i dati in modo nascosto
- il metodo Post e' piu sicuro del metodo Get perche i dati non sono visibili nell'url

- il codice php va inserito tra i tag <?php e ?> e viene interpretato dal motore php
- se mischio codice html e php va messa l'estensione .php altrimenti il codice php non viene interpretato

- come in java separiamo le istruzioni con il punto e virgola ;
- per i commenti in php si usano // per commenti su una riga e  per commenti su più righe
- per stampare a video si usa echo o print
- per concatenare stringhe si usa il punto .

- php e' debolmente tipizzato: non serve dichiarare il tipo di variabile, lo fa in automatico il motore php
- per dichiarare una variabile si usa il simbolo $ prima del nome della variabile
- per stampare si usa o echo o print, l output si vede nell html generato dal php
- codice html puo essere mischiato con codice php ma il contrario no, il codice php non puo essere mischiato con codice html

- dichiarazione per valore:
$nomeVariabile = valore;

- dichiarazione per riferimento:
$nomeVariabile =& altraVariabile;
- la & indica che la variabile punta alla stessa locazione di memoria di altraVariabile, simile alle variabili di classe in java

-nella programmazione web il web srver non ha memoria tra una richiesta e l altra, ogni volta che arriva una richiesta il web server esegue il codice php da zero

- le costatnti si dichiarano con define("NOME_COSTANTE", valore); e per convenzione si scrivono in maiuscolo

-le stringhe si possono delimitare con apici singoli 'stringa' o doppi apici "stringa"
- con i doppi apici le variabili vengono interpretate, con gli apici singoli no. Esempio:
$nome = "Mario";
echo "Ciao $nome"; // stampa Ciao Mario(interpreta la variabile) 
echo 'Ciao $nome'; // stampa Ciao $nome(non interpreta la variabile)

per concatenare le stringhe si usa il punto . Esempio:
$nome = "Mario";
$cognome = "Rossi";
echo "Ciao " . $nome . " " . $cognome; // stampa Ciao Mario Rossi

- casting: forzare il tipo di una variabile
$var = (int) "123"; // forzo la variabile a essere di tipo intero


- OPERATORI MATEMATICI:
tutti uguali a java ma si aggiungono i seguenti:
== controlla solo il valore, 
=== identico o strettamente uguale (controlla anche il tipo)

!= diverso (controlla solo il valore)
!== non identico o strettamente diverso (controlla anche il tipo)

- OPERATORI LOGICI:
&& AND
|| OR

! NOT


-DATI COMPOSTI:
array numerici: gli elementi sono indicizzati con numeri interi a partire da 0
$array = array("elemento1", "elemento2", "elemento3");

array associativi o hasmap: gli elementi sono indicizzati con chiavi di tipo stringa
$array = array("chiave1" => "valore1", "chiave2" => "valore2");

CICLO FOR:
for ($i = 0; $i < 3; $i++) {
    echo $i;
}

CICLO FOREACH:
foreach ($array as $elemento) {
    echo $elemento;
}
    
CICLO WHILE:
while ($condizione) {
    // codice da eseguire finché la condizione è vera
}

userem winSCP che utilizza il protocollo SFTP per caricare i file sul server dal client 
per collegarsi occorre il nome del server(tave.osdb.it), username e password. la porta di default e' la 22 ma puo essere cambiata.
si utilizza la cartella web per caricare i file che saranno visibili dal web server

error 404 not found: il file non esiste o non e' raggiungibile dal web server

error 500 internal server error: errore nel codice php, per vedere l'errore occorre abilitare la visualizzazione degli errori nel file php.ini



*/

?>