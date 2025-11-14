let display = document.getElementById("timer");
let startButton = document.getElementById("startButton");
let resetButton = document.getElementById("resetButton");
let pauseButton = document.getElementById("pauseButton");

let timer = {
    seconds: 1500,
    running: false,
    intervalId: null
};

function updateDisplay() {
    let min = Math.floor(timer.seconds / 60);
    let sec = timer.seconds % 60;
    display.textContent = min + ":" + sec;
}

function tick() {
    if (timer.seconds > 0) {
        timer.seconds--;
        updateDisplay();
    } else {
        // stop when reaches 0
        clearInterval(timer.intervalId);
        timer.intervalId = null;
        timer.running = false;
    }
}

// show initial value
updateDisplay();

startButton.addEventListener("click", function() {
    if (!timer.running) {
        timer.running = true;
        timer.intervalId = setInterval(tick, 1000);
    }
});

pauseButton.addEventListener("click", function() {
    if (timer.intervalId !== null) {
        clearInterval(timer.intervalId);
        timer.intervalId = null;
    }
    timer.running = false;
});

resetButton.addEventListener("click", function() {
    if (timer.intervalId !== null) {
        clearInterval(timer.intervalId);
        timer.intervalId = null;
    }
    timer.seconds = 1500;
    timer.running = false;
    updateDisplay();
});
