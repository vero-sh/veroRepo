

let array = ["mela", "pera", "banana"];
let btn = document.getElementById("btn");
let res = document.getElementById("pa");
let num = document.getElementById("num");


btn.addEventListener("click", () =>{

    if(array.length-1>=Number(num.value)){
        res.textContent = array[Number(num.value)];
    }

})


