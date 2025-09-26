//JS è debolmente tipizzato
//Non serve dichiarare il tipo di variabile
//Si usa let per dichiarare una variabile generica
//Si usa const per dichiarare una costante

//Non serve il punto e virgola alla fine di ogni istruzione, ma è buona pratica metterlo

//Non serve dichiarare il tipo di funzione
//Si usa function per dichiarare una funzione

console.log("Script loaded");

//Dichiarazione di variabili
let x = 6;
let y = "ciaoaiodiaoi";

//Dichiarazione di costanti
const Z = 10;

console.log("x:" + typeof(x));
x = "ciao";
console.log("x:" + typeof(x));

//true e false sono booleani
let isTrue = true;
let isFalse = false;
console.log("isTrue:" + typeof(isTrue));
console.log("isFalse:" + typeof(isFalse));

//undefined è null
//undefined è quando una variabile non è stata inizializzata ed è di default undefined
//null lo decide il programmatore 
let n = null; //oggetto con valore null
let u; //undefined e' cmq un oggetto

console.log("n:" + typeof(n));
console.log("u:" + typeof(u));

//Array
let arr = [1, 2, 3, 4, 5];
console.log("arr:" + typeof(arr));

//Oggetto
let obj = {
    nome: "Mario",
    eta: 30,
    professione: "Sviluppatore"
};
console.log("obj:" + typeof(obj));

//Stringhe
let str1 = 'Ciao';
console.log(str1[1]); //carattere alla posizione 1 uguale a fare str1.charAt(1)
console.log(str1.charAt(1)); //carattere alla posizione 1
console.log(str1.length); //lunghezza della stringa
console.log(str1.toUpperCase()); //tutto maiuscolo
console.log(str1.toLowerCase()); //tutto minuscolo      
console.log(str1.indexOf('a')); //posizione del carattere
console.log(str1.replace('C', 'B')); //sostituisce C con B
console.log(str1.concat(' Mondo')); //concatena due stringhe
console.log(str1.split('')); //divide la stringa in un array di caratteri
console.log(str1.lastIndexOf('a')); //ultima occorrenza del carattere
console.log(str1.slice(1, 3)); //sottostringa da indice 1 a 3 (escluso 3) ha sostituito substring
console.log(str1.replaceAll('Ciao', 'B')); //sostituisce tutte le occorrenze di Ciao con B
console.log(str1.includes('Cia')); //true se la stringa contiene Cia, include verifica se una stringa contiene una sottostringa


//Operazioni
//+ - * / % ++ -- ** (operatore di potenza)
//BIMDAS (Brackets, Indices, Multiplication and Division, Addition and Subtraction)

console.log(2**3); //2 alla 3
console.log(5 * "ciao"); //NaN (Not a Number perche' non si puo' moltiplicare un numero per una stringa come su python)


//Funzione
function somma(a, b) {
    return a + b;
}
console.log("somma:" + typeof(somma));
console.log("somma(5, 10): " + somma(5, 10));
