//il createElement è una funzione di javaScript che permette di creare un nuovo elemento HTML

console.log("test");

const button = document.createElement("button");

button.textContent = "Cliccami"; //imposta il testo del bottone

button.addEventListener("click", function() {
    alert("SEI UN NEGRO");
});

document.body.append(button);

//crea un bottone nel body della pagina,
//appendchild serve per aggiungere un elemento come figlio di un altro elemento
// cosa cambia se metto o non metto le tonde dopo il nome della funzione? 
//se metto le tonde la funzione viene eseguita subito, se non le metto la funzione viene passata come riferimento e viene eseguita solo quando viene chiamata 

console.log("test dopo");

//per temporizzare l'esecuzione di una funzione si usa setTimeout
setTimeout(function() {
    alert("SONO PASSATI 3 SECONDI");
}, 3000); // primo modo e' oneshot

//setInterval serve per eseguire una funzione a intervalli regolari
setInterval(function() {
    console.log("SONO PASSATI 5 SECONDI");
}, 5000); // secondo modo e' ripetuto

//per fermare un setInterval si usa clearInterval o clearTimeout 