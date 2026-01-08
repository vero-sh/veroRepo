let num = document.getElementById("num");

let btn = document.getElementById("btn").addEventListener("click", ()=>{ 

    if(num.value % 2 == 0){
        alert("O número é par");
    }    else{
        alert("O número é ímpar");
    }

})