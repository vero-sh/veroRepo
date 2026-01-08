let arrayFrutas = ["manzana", "banana", "cereza", "durazno", "uva"];

let index = document.getElementById("index");

let p = document.getElementById("p");

let btn = document.getElementById("btn").addEventListener("click", () => {

    p.textContent = arrayFrutas[index.value-1];

})
