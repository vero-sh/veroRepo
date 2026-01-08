let input = document.getElementById("input");

let btnSubmit = document.getElementById("submit");

btnSubmit.disabled = true;

input.addEventListener("input", () => {
    if (input.value.length >= 20) {
        btnSubmit.disabled = false;
    } else {
        btnSubmit.disabled = true;
    }
});


btnSubmit.addEventListener("click", () => {

alert("Form submitted!");

});


