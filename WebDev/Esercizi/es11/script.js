//Calcolatrice di spesa di gruppo
//Input con nome persona e importo speso. Bottone per aggiungere. Mostra lista delle spese. Alla fine calcola: 
// quanto ha speso ognuno, quanto dovrebbe aver speso (media), chi deve dare soldi a chi per pareggiare.

let array = [];
let nome = document.getElementById("name");
let amount = document.getElementById("amount");
let add = document.getElementById("btn");
let btn2 = document.getElementById("btn2");

add.addEventListener("click", () =>{

    array.push({nome, importo});
    let li = document.createElement("li");
    li.textContent = `${nome} ha speso €${importo.toFixed(2)}`;
    listaSpese.appendChild(li);

    nome.value = "";
    amount.value = "";

    for (let s of array) {
    sommaTotale += s.importo;
    totali[s.nome] = totali[s.nome] + s.importo;
}

})

