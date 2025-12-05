let btnLibera = document.getElementById('libera')
let btnOccupa = document.getElementById('occupa')
let btnElimina = document.getElementById('elimina')
let boxAula = document.getElementById('aula')
let inUtente = document.getElementById('utente')
let inCod = document.getElementById('cod')

let arrayPc = [
    {codicePc : "A01", utente : "", stato : "libero"},
    {codicePc : "B02", utente : "", stato : "libero"},
    {codicePc : "C03", utente : "", stato : "libero"}
]

function pcByCod (cod) {
    for (let pc of arrayPc) {
        if (cod == pc.codicePc) {
            return pc
        } 
    }
    alert('CODICE NON VALIDO')
    return null
}

function pcByUtente (utente) {
    for (let pc of arrayPc) {
        if (utente == pc.utente) {
            return pc
        }
    }
    return null
}

function issetCod () {
    if (inCod.value != "") {
        return true
    }
    alert("INSERIRE UN CODICE")
    return false
}

function issetUtente () {
    if (inUtente.value != "") {
        return true
    }
    alert("INSERIRE UN UTENTE")
    return false
}


function visualizza () {
    boxAula.innerHTML = ""
    for (let pc of arrayPc) {
        let div = document.createElement('div')
        div.textContent = pc.codicePc + ": " + pc.stato
        if (pc.stato == "occupato") {
            div.textContent += " da " + pc.utente
        }
        boxAula.append(div)
    }
}

function aggiornaArrayPc (pcToDelete) {
    let newArrayPc = []
    for (let pc of arrayPc) {
        if (pc != pcToDelete) {
            newArrayPc.push(pc)
        }
    }
    arrayPc = newArrayPc
}

visualizza()


btnOccupa.addEventListener("click", () => {
    if (issetCod() && issetUtente()) {
        let pc = pcByCod(inCod.value)
        if (pc != null) {
            if (pc.stato == "libero") {
                pc.stato = "occupato"
                pc.utente = inUtente.value
                visualizza()
            } else {
                alert("PC GIA' OCCUPATO DA " + pc.utente)
            }
        }
    }
})

btnLibera.addEventListener("click", () => {
    if (issetCod()) {
        let pc = pcByCod(inCod.value)
        if(pc != null) {
            pc.stato = "libero"
            pc.utente = ""
            visualizza()
        }
    }
})

btnElimina.addEventListener("click", () => {
    if (issetCod()) {
        let pc = pcByCod(inCod.value)
        if (pc != null) {
            aggiornaArrayPc(pc)
            visualizza()
        }
    }
})
