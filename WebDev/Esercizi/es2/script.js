//Crea due caselle di input per inserire due numeri e un bottone che, quando premuto, calcoli e mostri la loro somma sullo schermo usando getElementById e textContent.

let a = document.getElementById("a");
let b = document.getElementById("b");
let btn = document.getElementById("btn");
let r = document.getElementById("result");
let sum = 0;

btn.addEventListener("click", () => {
    sum = Number(a.value) + Number(b.value);
    r.textContent = sum;
});