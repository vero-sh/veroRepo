
let input = document.getElementById("input");

let timer;

input.addEventListener("input", ()=>{
    
    clearTimeout(timer);

    timer = setTimeout(()=>{

        if(input == null || input.value.trim() === ""){

            input.disabled = true;
            alert("Tempo scaduto! Input bloccato.");
        }else{
            alert("Input ricevuto: " + input.value);
        }
    }, 3000);
})