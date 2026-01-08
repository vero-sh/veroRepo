let rosso = document.getElementById("rosso");
let giallo = document.getElementById("giallo");
let verde = document.getElementById("verde");

let btn = document.getElementById("avviaCiclo");

let stato = 0; 
// 0 = rosso
// 1 = giallo (dopo rosso)
// 2 = verde
// 3 = giallo (dopo verde)

function spegniTutto() {
    rosso.style.backgroundColor = "gray";
    giallo.style.backgroundColor = "gray";
    verde.style.backgroundColor = "gray";
}

btn.addEventListener("click", () => {
    spegniTutto();

    if (stato === 0) {
        rosso.style.backgroundColor = "red";
        stato = 1;
    } else if (stato === 1) {
        giallo.style.backgroundColor = "yellow";
        stato = 2;
    } else if (stato === 2) {
        verde.style.backgroundColor = "green";
        stato = 3;
    } else {
        giallo.style.backgroundColor = "yellow";
        stato = 0;
    }
});
