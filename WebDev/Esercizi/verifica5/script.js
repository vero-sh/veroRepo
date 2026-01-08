
let array = ["mela", "banana", "arancia", "kiwi", "fragola"];

let res = document.getElementById("result");

let btn = document.getElementById("btn").addEventListener("click", ()=>{


let n = array.length; 
res.textContent = "Lunghezza array: " + n;


})