//il DOM e' il Document Object Model, una rappresentazione strutturata del contenuto di una pagina web.
//Il DOM consente di accedere e manipolare gli elementi HTML e CSS tramite JavaScript.
//Ad esempio, possiamo usare il DOM per cambiare il testo di un paragrafo, modificare lo stile di un elemento o aggiungere nuovi elementi alla pagina.
//il BOM e' il Browser Object Model, una rappresentazione degli oggetti forniti dal browser web.
//Il BOM consente di interagire con il browser stesso, ad esempio per gestire le finestre, i cookie, la cronologia e altre funzionalità del browser.
//Ad esempio, possiamo usare il BOM per aprire una nuova finestra del browser, impostare un cookie o accedere alla cronologia di navigazione dell'utente.



//Ecco un esempio di come usare il DOM per ottenere il contenuto di un elemento HTML con l'id "result": e' un oggetto di tipo stringa
let str = document.getElementById("result");
str.textContent = "Ciao, mondo!"; // Modifica il testo dell'elemento con id "result" senza interpretare i tag HTML

//Ecco un esempio di come usare il DOM per ottenere il contenuto di un elemento HTML con l'id "htmlResult": e' un oggetto di tipo stringa
let htmlStr = document.getElementById("htmlResult");
htmlStr.innerHTML = "<strong>Ciao, mondo!</strong>"; // Modifica il contenuto HTML dell'elemento con id "htmlResult", interpretando i tag HTML

let inputObject = document.getElementById("inputText");

let btn = document.getElementById("clickButton");

btn.addEventListener("click", getInputAndShow);

function getInputAndShow(){
    let v = Number(inputObject.value)

    //Guardia
    if(isNaN(v)){
        return
    }
    console.log(typeof(v))
    
    str.textContent = v + ": "+(v+5);
    
}