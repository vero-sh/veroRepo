let nome = document.getElementById("nome");
let importo = document.getElementById("importo");

let arraySpese = [];

let divSpese = document.getElementById("spese");
let divTotale = document.getElementById("totale");

// AGGIUNGI
document.getElementById("add").addEventListener("click", () => {
    if (nome.value === "" || importo.value === "") return;

    arraySpese.push({
        nome: nome.value,
        importo: parseFloat(importo.value)
    });

    nome.value = "";
    importo.value = "";
});

// MOSTRA
document.getElementById("mostra").addEventListener("click", () => {
    divSpese.innerHTML = "";

    arraySpese.forEach(spesa => {
        divSpese.innerHTML += `<p>${spesa.nome} ha speso ${spesa.importo} €</p>`;
    });
});

// CALCOLA
document.getElementById("calcola").addEventListener("click", () => {
    let totale = 0;

    arraySpese.forEach(spesa => {
        totale += spesa.importo;
    });

    let media = totale / arraySpese.length;

    divTotale.innerHTML = `
        <p>Totale: ${totale.toFixed(2)} €</p>
        <p>Media a persona: ${media.toFixed(2)} €</p>
    `;

    arraySpese.forEach(spesa => {
        let differenza = spesa.importo - media;

        if (differenza > 0) {
            divTotale.innerHTML += `<p>${spesa.nome} deve ricevere ${differenza.toFixed(2)} €</p>`;
        } else if (differenza < 0) {
            divTotale.innerHTML += `<p>${spesa.nome} deve dare ${Math.abs(differenza).toFixed(2)} €</p>`;
        } else {
            divTotale.innerHTML += `<p>${spesa.nome} è in pari</p>`;
        }
    });
});
