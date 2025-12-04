
//Crea un pulsante “Mostra notifica”. Ogni volta che l’utente clicca, devi generare dinamicamente una notifica che scompare dopo 3 secondi. 
// Al click crea un <div> usando createElement. Imposta il testo “Nuova notifica #N”. 
// Aggiungi la notifica a un container usando .append(). Dopo 3 secondi, rimuovila. 
// Le notifiche devono impilarsi (non sovrascriversi).

let btn = document.getElementById("btn");
let container = document.getElementById("container");
let count = 1;

btn.addEventListener("click", () => {
    let div = document.createElement("div");
    div.textContent = "Nuova notifica #" + count;
    count++;

    container.append(div);

    setTimeout(() => {
        div.remove();
    }, 3000);
});
