let arrayNumbers = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100];
let p = document.getElementById("p");

let btn = document.getElementById("btn").addEventListener("click", () =>{
    let sum = 0;
    for(let i = 0; i < arrayNumbers.length; i++){
        sum += arrayNumbers[i];
    }
    p.textContent = `La somma degli elementi dell'array è:` + Number(sum);
});

