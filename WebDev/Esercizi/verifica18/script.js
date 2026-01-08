let btnStart = document.getElementById("start");

let timer;
let count = 0;
let isCounting = false;

// LISTENER UNA SOLA VOLTA
document.addEventListener("keydown", () => {
  if (isCounting) {
    count++;
  }
});

btnStart.addEventListener("click", () => {
  clearTimeout(timer);
  count = 0;
  isCounting = true;

  timer = setTimeout(() => {
    isCounting = false;

    let p = document.createElement("p");
    p.textContent = `You pressed ${count} keys in 5 seconds!`;
    document.body.appendChild(p);

    alert("Time's up!");
  }, 5000);
});
