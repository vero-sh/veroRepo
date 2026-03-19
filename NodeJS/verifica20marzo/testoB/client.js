
const URL = 'http://localhost:3000';

async function mostraTuttiMinerali() {

    const response = await fetch(URL + '/minerali');

    const minerali = await response.json();

    const totale = minerali.length;
   
    let array = [];
    let critici = 0;

    for (const minerale of minerali) {
        array.push(minerale);

        if (minerale.tonnellate < 10) {
            critici++;
        }
    }
    console.log(array);
    console.log('Totale minerali: ' + totale + ' - Minerali critici: ' + critici);
    
}

async function cercaMineralePerID(){

    const id = 999;
    const idBackup = 5;

    const response = await fetch(URL + '/minerali/' + id);
   
    if (response.status === 404) {
        console.log('Minerale con ID ' + id + ' non trovato. Provo con ID ' + idBackup);
        const responseBackup = await fetch(URL + '/minerali/' + idBackup);
        
        if (responseBackup.status === 404) {
            console.log('Minerale con ID ' + idBackup + ' non trovato.');
        } else {
            const mineraleBackup = await responseBackup.json();
            console.log('Nome: ' + mineraleBackup.nome + ' Tonnellate: ' + mineraleBackup.tonnellate);
        }

    } else {
        const minerale = await response.json();
        console.log(minerale);
        console.log('Nome: ' + minerale.nome + ' Tonnellate: ' + minerale.tonnellate);
    }
    
    
}


async function aggiungiMinerale() {
    const nuovoMinerale = {
        nome: 'gallio',
        categoria: 'metalli',
        tonnellate: 20,
        creditiPerTonnellata: 100,
        zona: 'sud'
    };

    const response = await fetch(URL + '/minerali', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(nuovoMinerale)
    });
    const mineraleAggiunto = await response.json();
    console.log('Minerale aggiunto: ', mineraleAggiunto);

}

async function contaMineraliCategoria() {
    const categoria = 'cristalli';

    const response = await fetch(URL + '/minerali/categoria/' + categoria);
    
    if (response.status === 404) {
        
        console.log('Nessun minerale trovato per la categoria ' + categoria);
        const response2 = await fetch(URL + '/minerali/categoria/metalli');
        const mineraliMetalli = await response2.json();
        const totaleMetalli = mineraliMetalli.length;
        console.log('Minerali della categoria ' + 'metalli' + ': ', totaleMetalli);

    }else {
        
        const minerali = await response.json();
        
        const totale = minerali.length;
        console.log('Minerali della categoria ' + categoria + ': ' + totale);

    }
   
}

async function calcolaValoreTotale() {

    const response = await fetch(URL + '/minerali')
    const minerali = await response.json()

    console.log(minerali)

    let valoreTotale = 0;
    let valoreSingolo = 0;
    let arrayValori = [];

    for(const minerale of minerali){
        valoreSingolo = minerale.tonnellate * minerale.creditiPerTonnellata;
        valoreTotale += valoreSingolo
        arrayValori.push(valoreSingolo);
    }

    let Max = 0;
    for(const valore of arrayValori){
    if(valore > Max) Max = valore;
    }

    const indexMax = arrayValori.indexOf(Max);
    console.log("valore totale inventario: "+valoreTotale)
    console.log("minerale piu prezioso: "+minerali[indexMax].nome+" con valore "+Max);
}

async function trovaMineraliCritici() {

    const response = await fetch(URL + '/minerali');
    const minerali = await response.json();
    let r = 'minerali critici nella zona cratere: ';

    for(const minerale of minerali){
        if(minerale.zona === 'cratere' && minerale.tonnellate < 10){
            r += minerale.nome+ ', ';
        }
    }
    console.log(r);
}


function test() {
    //console.log('Test 1');
    //mostraTuttiMinerali();
    //console.log('-----------------------------');
    //console.log('Test 2');
    //cercaMineralePerID();
    //console.log('-----------------------------');
    //console.log('Test 3');
    //aggiungiMinerale();
    //mostraTuttiMinerali();
    //console.log('-----------------------------');
    //console.log('Test 4');
    //contaMineraliCategoria();    
    //calcolaValoreTotale();
    trovaMineraliCritici();
}

test();