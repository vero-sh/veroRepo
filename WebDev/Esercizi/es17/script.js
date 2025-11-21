//Crea un semaforo con tre div (rosso, giallo, verde). Il colore attivo deve cambiare automaticamente ogni 2 secondi.
//Cosa posso usare per ciclare tra i colori
//Un pulsante deve poter fermare e riattivare il ciclo senza resettarlo

let divYellow = document.getElementById('giallo');
let divRed = document.getElementById('rosso');
let divGreen = document.getElementById('verde');
let colors = ['rosso', 'giallo', 'verde'];
let currentIndex = 0;
let intervalId = null;
let trafficLight = document.getElementById('semaforo');
let toggleButton = document.getElementById('toggle-button');
let isRunning = true;

function updateTrafficLight() {
    divRed.style.backgroundColor = 'grey';
    divYellow.style.backgroundColor = 'grey';
    divGreen.style.backgroundColor = 'grey';
    if (colors[currentIndex] === 'rosso') {
        divRed.style.backgroundColor = 'red';
    } else if (colors[currentIndex] === 'giallo') {
        divYellow.style.backgroundColor = 'yellow';
    } else if (colors[currentIndex] === 'verde') {
        divGreen.style.backgroundColor = 'green';
    }   
    currentIndex = (currentIndex + 1) % colors.length; 
}

function startTrafficLight() {
    intervalId = setInterval(updateTrafficLight, 2000);
}
function stopTrafficLight() {
    clearInterval(intervalId);
    intervalId = null;
}

toggleButton.addEventListener('click', () => {
    if (isRunning) {
        stopTrafficLight();
        toggleButton.textContent = 'Start';
    } else {
        startTrafficLight();
        toggleButton.textContent = 'Stop';
    }
    isRunning = !isRunning;
});

startTrafficLight();
updateTrafficLight();
