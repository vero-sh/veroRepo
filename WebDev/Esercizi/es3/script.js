//Scrivi un programma che legga un numero da input e dica se è pari o dispari, 
// mostrando il risultato in un paragrafo tramite getElementById e textContent.

let a = document.getElementById("a");
let btn = document.getElementById("btn");
let res = document.getElementById("pa");

btn.addEventListener("click", () => {

    if(Number(a.value) % 2 === 0){
        res.textContent = "il numero "+a.value+ " e' pari";
    }else{
        res.textContent = "il numero "+a.value+ " e' dispari";
    }
    

})