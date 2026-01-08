let btnStart = document.getElementById("start");

const da = 0;

const a = 10;

let interval;

btnStart.addEventListener("click", ()=>{
   
    let c = da;
    interval = setInterval(() => {

        if(c <= a){

        let p = document.createElement("p")
        p.textContent = Number(c);
        document.body.appendChild(p);
        c++;

        } else {
            clearInterval(interval);
        }
    }, 1000);

});