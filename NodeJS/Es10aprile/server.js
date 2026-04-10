const express = require("express") //import 

const PORT = 3000;

//creare server

const server = express()


server.use(express.json()) //setta di default json negli header content-type

//MW globale che stampa info per ogni richiesta(REQ)
server.use((req, res, next) => {
    console.log("[GLOBAL.MW]" +req.method + " - " +req.url);
    
    next()
})

server.use("/clienti", (req, res, next) => {
    //controlla se header custom esiste 
    //prendo un header
    const tessera = req.headers["x-tessera"]

    if(!tessera){
        return res.status(400).json({ err :" niente tessera, niente ingresso"})
    }

    next()
})

server.use("/clienti", (req, res, next) => {

    const gettoni = parseInt(req.headers["x-gettoni"]) 

    if(gettoni && !isNaN(gettoni)) {
        req.gettoni = gettoni
    }else{
        req.gettoni = 0;
    }

    console.log(gettoni)

    next()
})

server.get("/clienti", (req, res) => {
    res.status(200).json({msg: "test"})

})



//listen
server.listen(PORT, () => {
    console.log("ONLINE");
})
