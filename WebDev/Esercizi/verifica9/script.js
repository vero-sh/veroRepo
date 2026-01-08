let arrayNomi = ["Ana", "Bruno", "Carla", "Diego", "Elena", "Fabio", "Giulia", "Hugo", "Irene", "Luca"];

let res = document.getElementById("p");

let btn = document.getElementById("btn").addEventListener("click", () => {
    

    let tpm = arrayNomi[0];

    for (let i = 1; i < arrayNomi.length; i++) {
        if(arrayNomi[i].length > tpm.length){
            tpm = arrayNomi[i];
        }
    }

    res.textContent = `Il nome più lungo è: ${tpm} con ${tpm.length} caratteri.`;
});