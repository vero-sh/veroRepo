/*

Input number per settare un limite massimo. 
Bottone + e bottone -. 
Display che mostra il contatore. 
Quando raggiungi il limite (o zero se vai sotto), 
appare un messaggio "LIMITE RAGGIUNTO!" in un div 
(per semplicità. un div è molto simile a un p). 
Il bottone corrispondente si disabilita.


*/

//da finire a casa

let cont = 0;

const MAX = document.getElementById("max");

const btn1 = document.getElementById("btnsomma");
const btn2 = document.getElementById("btnsottrazione");

while(true){
    
    console.log(c);

    if(btn1.addEventListener("click")){ 
        if(c>=MAX){
        alert("limite raggiunto: "+MAX);
        break; 
    }
    c++;  
}
    if(btn2.addEventListener("click")){
        if(c <= 0) {
        alert("numero negativo");
        break;
    }
    c--;
    }
}

