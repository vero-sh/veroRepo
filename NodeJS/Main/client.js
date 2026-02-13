const BASE_URI = "http://localhost:3000";

const REFRESH_RATE = 5000; //5 secondi

async function getSolarPanels(){

    const resp = await fetch(BASE_URI + "/station/status");

    if (resp.ok){
        const json = await resp.json();
        console.log(json);
        const totalPanels = json.power.solar.panels; //oggetto 
        const totalPanelsLength = json.power.solar.panels.length; //lunghezza dell'oggetto
        console.log(totalPanels);

        let count = 0;
        for(const panel of totalPanels){
            if(panel.status === "nominal"){
                count++;
            }
        }

        const percentage = (count / totalPanelsLength) * 100;
        
        return {
            totalPanels: totalPanels,
            operational: count,
            percentage: percentage
        }

    }
}


/*

Scrivi una funzione JS che:
Recupera /station/modules
Per ogni modulo, controlla i suoi subsystems
Se trova almeno un subsystem con status !== "nominal", aggiungi il modulo ad una lista
Ritorna array di oggetti: { moduleId, degradedSystemNames: [...] }.


*/
async function getStationModules(){

    const resp = await fetch(BASE_URI + "/station/modules")

    if(resp.ok){

        const json = await resp.json();
        console.log(json);
        const degradedModules = [];

        let count = 0;
        for(const module of json.modules){
            const degradedSystemNames = [];
            for(const subsystem of module.crew.subsystems){
                if(subsystem.status !== "nominal"){
                    degradedSystemNames.push(subsystem.name);
                }
            }
            if(degradedSystemNames.length > 0){
                degradedModules.push({
                    moduleId: module.id,
                    degradedSystemNames: degradedSystemNames
                });
            }
        }
        return { degradedModules: degradedModules };
    }
}


async function startStationMonitor(){

    /*
    console.clear();
    let task1result = await getSolarPanels();
    console.log("Total Panels: "+task1result.totalPanels);
    console.log("Operational: "+task1result.operational);
    console.log("Percentage: "+task1result.percentage);
    */

    console.clear();
    let task2result = await getStationModules();
    console.log("Degraded Modules: ", task2result.degradedModules);
}

setInterval(startStationMonitor, REFRESH_RATE); //5 SECONDI X SIMULARE L INFINITO MONITORAGGIO DELLA STAZIONE SPAZIALE
