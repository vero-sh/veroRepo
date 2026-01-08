let inventario = [
    { id: 1, nome: "pane", quantità: 10 },
    { id: 2, nome: "latte", quantità: 5 },
    { id: 3, nome: "uova", quantità: 12 },
    { id: 4, nome: "formaggio", quantità: 7 }
];

let inputId = document.getElementById("cod");

// ---------- FUNZIONE DI SUPPORTO ----------
function leggiId() {
    if (inputId.value === "" || isNaN(inputId.value) || inputId.value.length > 4) {
        alert("Inserisci un ID valido (numero fino a 4 cifre).");
        inputId.value = "";
        return null;
    }
    return parseInt(inputId.value);
}

// ---------- MOSTRA INVENTARIO ----------
function mostraInventario() {

    let p = document.createElement("p");
    p.innerHTML = "<strong>Inventario:</strong><br>";

    inventario.forEach(prodotto => {
        p.innerHTML += `ID: ${prodotto.id}, Nome: ${prodotto.nome}, Quantità: ${prodotto.quantità}<br>`;
    });

    document.body.appendChild(p);

    setTimeout(() => {
        p.remove();
    }, 5000);
}

// ---------- AGGIUNGI QUANTITÀ ----------
function aggiungiQta() {
    let idDaCercare = leggiId();
    if (idDaCercare === null) return;

    inventario.forEach(prodotto => {
        if (prodotto.id === idDaCercare) {
            prodotto.quantità += 10;
        }
    });

    mostraInventario();
    inputId.value = "";
}

// ---------- RIMUOVI QUANTITÀ ----------
function rimuoviQta() {
    let idDaCercare = leggiId();
    if (idDaCercare === null) return;

    inventario.forEach(prodotto => {
        if (prodotto.id === idDaCercare) {
            if (prodotto.quantità >= 5) {
                prodotto.quantità -= 5;
            } else {
                alert("Quantità insufficiente per rimuovere 5 unità.");
            }
        }
    });

    mostraInventario();
    inputId.value = "";
}

// ---------- ELIMINA PRODOTTO ----------
function eliminaProdotto() {
    let idDaCercare = leggiId();
    if (idDaCercare === null) return;

    inventario = inventario.filter(prodotto => prodotto.id !== idDaCercare);

    mostraInventario();
    inputId.value = "";
}

// ---------- STATISTICHE ----------
document.getElementById("mostraStat").addEventListener("click", () => {

    let p = document.createElement("p");
    let totaleProdotti = inventario.length;
    let totaleQuantità = 0;

    inventario.forEach(prodotto => {
        totaleQuantità += prodotto.quantità;
    });

    p.innerHTML = `
        Totale prodotti: ${totaleProdotti}<br>
        Totale quantità: ${totaleQuantità}
    `;

    document.body.appendChild(p);

    setTimeout(() => {
        p.remove();
    }, 5000);
});

// ---------- BOTTONI ----------
document.getElementById("btnAggiungi").addEventListener("click", aggiungiQta);
document.getElementById("btnRimuovi").addEventListener("click", rimuoviQta);
document.getElementById("btnElimina").addEventListener("click", eliminaProdotto);
