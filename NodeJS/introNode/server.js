//terminale: ctrl + j
//node --watch server.js serve ad aggiornare il server in auto

const http = require("http");


const PORT = 80; //
const HOSTNAME = "localhost";
const random = (Math.random()*100)+1;
const random2 = Math.random()*

//esercizio:
// creare endpoint /number: che restituisce al client un numero random tra 1 e 100
// creare endpoint /number/N che restituisce un numero tra 1 e N
//metodi supportati su ogni endpoint: GET
//non permettere: POST, DELETE -> restuituite una rappresesntazione JSON del problema


const server = http.createServer((req, res) =>{

    if(req.url === "/" && req.method === "GET"){
        res.statusCode = 200;
        res.setHeader("Content-Type", "text/plain");
        res.end("ciao, benvenuto");
    
    }else if (req.url === "/" && req.method === "POST"){
        res.statusCode = 405; //method not allowed
        res.setHeader("Allow", "GET");
        res.end("POST NOT ALLOWED");
    
    }else if(req.url === "/users" && req.method === "GET"){

        res.statuscode = 200;
        res.setHeader("Content-Type", "application/json");
        res.end(JSON.stringify(
            [
                {User : "vero", ID: 1},
                {User : "bob", ID : 2}
            ]
        ));

    }else if(req.url === "/" && req.method === "DELETE"){
        res.statusCode = 405; //method not allowed
        res.setHeader("Allow", "GET");
        res.end("DELETE NOT ALLOWED");

    }else if(req.url === "/number" && req.method === "GET"){
        res.statusCode = 200;
        res.setHeader("Content-Type", "text/plain");
        res.end(random.) //numero random tra 1 e 100
        
    }else if(req.url === "/number/N", req.method === "GET"){

        res.statusCode = 200;
        res.setHeader("Content-Type", "text/plain");
        res.end(random.)

    }else{

        res.statusCode = 404;
        res.setHeader("Content-Type", "application/json");
        res.end(JSON.stringify({error : req.url + " Not found"}));

    }

})

server.listen(PORT, HOSTNAME, () => {
    console.log("online su http:/"+HOSTNAME+ ":" +PORT);
})

