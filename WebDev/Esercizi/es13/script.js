let output = document.getElementById("ab");
let start = document.getElementById("da");
let end = document.getElementById("a");
let btn = document.getElementById("start");

btn.addEventListener("click", () => {

    let current = Number(start.value);
    let stop = Number(end.value);

    output.innerHTML = "";  // pulizia

    const timer = setInterval(() => {

        // crea un nuovo <p> e lo aggiunge al DOM
        const p = document.createElement("p");
        p.textContent = current;
        output.append(p);
        
        // stop
        if (current >= stop) {
            clearInterval(timer);
        }

        current++;
    }, 1000);

});

