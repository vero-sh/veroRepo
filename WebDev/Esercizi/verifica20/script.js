
let btnNotifica = document.getElementById("btn");

let timer;

let c = 1;

btnNotifica.addEventListener("click", () => {

    let div = document.createElement("div");
    div.textContent = `Notifica #${c}`;
    document.body.appendChild(div);

    timer = setTimeout(() => {
        
       document.body.removeChild(div);
        
    }, 3000);

    
    c++;

});