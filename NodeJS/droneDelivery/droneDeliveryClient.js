/*

TASK 1: Ricarica droni scarichi
Consegna
Scrivi una funzione async che ricarica automaticamente tutti i droni con batteria bassa.
Requisiti
1. Recupera tutti i droni con GET /drones
2. Filtra i droni con battery minore di 40
3. Per ogni drone filtrato, ricarica la batteria di 30 punti usando PUT
/drones/:droneId/battery
4. Per ogni drone ricaricato, salva droneId, batteryPrima e batteryDopo
5. Ritorna array di questi oggetti
Esempio output
[
{ droneId: &quot;D-003&quot;, batteryPrima: 18, batteryDopo: 48 },
{ droneId: &quot;D-006&quot;, batteryPrima: 35, batteryDopo: 65 }
]
Note: - Consulta la documentazione per sapere quale campo serve nel body del PUT -
batteryPrima è il valore letto dal GET iniziale - batteryDopo è il valore che trovi nella
risposta del PUT

*/

async function ricaricaDrone(){

    const rispostaDrone = await fetch('http://localhost:3000'+ '/drones');

    const dronesData = await rispostaDrone.json();

    let droniScarichi = [];

    for(const drone of dronesData.drones){

        if(drone.battery < 40){
            
            const batteryPrima = drone.battery;
            const incremento = 10;
            
             const putResponse = await fetch('http://localhost:3000' + '/drones/' + drone.id + '/battery', {
                method: 'PUT',
                headers: {
            'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                charge: incremento
            })
        });

        const putData = await putResponse.json();
        const batteryDopo = putData.drone.battery;
        
        droniScarichi.push({
            droneId: drone.id,
            batteryPrima: batteryPrima,
            batteryDopo: batteryDopo
        });       
        }

       
    }

        return droniScarichi;
}


/*
TASK 2: Pulizia consegne vecchie
Consegna
Scrivi una funzione async che cancella le consegne pending troppo vecchie.
Requisiti
1. Recupera tutte le consegne con GET /deliveries
2. Filtra le consegne che hanno:
– status === &quot;pending&quot;
– timeline.created più vecchio di 48 ore rispetto al momento attuale
3. Per ogni consegna filtrata, cancellala con DELETE /deliveries/:deliveryId
4. Restituisce il numero totale di consegne cancellate

Esercizi DDN parte 2

Esempio output
Un numero intero che rappresenta quante consegne sono state cancellate
Note: - Per calcolare differenza ore:
(Date.now() - new Date(timeline.created).getTime()) / (1000 * 60 * 60) - 48 ore
= 48 * 60 * 60 * 1000 millisecondi
Leggi la risposta del DELETE per verificare che success === true
*/


async function puliziaConsegne() {

    const responseDeliveries = await fetch('http://localhost:3000/deliveries');
    const deliveriesData = await responseDeliveries.json();

    const now = Date.now();
    const oreIn48 = 48 * 60 * 60 * 1000;

    let conteggioEliminati = 0;

    for (const delivery of deliveriesData.deliveries) {

        if (delivery.status === 'pending') {

            const createdTime = new Date(delivery.timeline.created);
            const differenza = now - createdTime.getTime();

            if (differenza > oreIn48) {

                const deleteResponse = await fetch(
                    'http://localhost:3000/deliveries/' + delivery.id,
                    { method: 'DELETE' }
                );

                const deleteData = await deleteResponse.json();

                if (deleteData.success === true) {
                    conteggioEliminati++;
                }
            }
        }
    }

    return conteggioEliminati;
}



async function test() {
  console.log('------- task 1 --------')
  const task1 = await ricaricaDrone();
  console.log(task1);
  console.log('');

  console.log('------ task 2-------')
  const task2 = await puliziaConsegne();
  console.log('Consegne eliminate: ' + task2);

}

test();