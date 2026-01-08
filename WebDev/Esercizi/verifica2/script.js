
let btn = document.getElementById("btn");
let result = document.getElementById("ris");
let num1 = document.getElementById("1");
let num2 = document.getElementById("2");

btn.addEventListener("click", () => {

  let temp = Number(num1.value) + Number(num2.value);

  result.textContent = temp;

})