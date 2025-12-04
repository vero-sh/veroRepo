/*

Input number per settare un limite massimo. 
Bottone + e bottone -. 
Display che mostra il contatore. 
Quando raggiungi il limite (o zero se vai sotto), 
appare un messaggio "LIMITE RAGGIUNTO!" in un div 
(per semplicità. un div è molto simile a un p). 
Il bottone corrispondente si disabilita.
*/

let c = 0;
let max = document.getElementById("max");
let display = document.getElementById("pp");
let btnsomma = document.getElementById("btnsomma");
let btnsottr = document.getElementById("btnsottrazione");
let mess = document.getElementById("div");

btnsomma.addEventListener("click", () =>{
      if(c<max.value) {
        c++;
    }
    updateDisplay();
})

btnsottr.addEventListener("click", () =>{
    if(c>0) {
        c--;
    }
    updateDisplay();
})

function updateDisplay(){

    display.textContent = c;
    if(c>=max.value){
        mess.textContent = "limite raggiunto"
        display.disabled = true;
    }else{
        display.disabled = false;
        mess.textContent = "";
    }

     if (c <= 0) {
        mess.textContent = "LIMITE RAGGIUNTO!";
        btnsottr.disabled = true;
    } else {
        btnsottr.disabled = false;
        if (c < max.value) mess.textContent = "";
    }
}

updateDisplay();



