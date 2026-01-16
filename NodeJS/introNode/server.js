//terminale: ctrl + j
//node --watch server.js serve ad aggiornare il server in auto

const http = require("http");


const PORT = 80; //
const HOSTNAME = "localhost";


const server = http.createServer((req, res) =>{

    if(req.url === "/" && req.method === "GET"){
        res.statusCode = 200;
        res.setHeader("Content-Type", "text/plain");
        res.end("ciao, benvenuto");
    
    }if (req.url === "/" && req.method === "POST"){
        res.statusCode = 405; //method not allowed
        res.setHeader("Allow", "GET");
        res.end()
    }
    else{

        res.statusCode = 404;
        res.setHeader("Content-Type", "application/json");
        res.end(JSON.stringify({error : req.url + " Not found"}));

    }

})

server.listen(PORT, HOSTNAME, () => {
    console.log("online su http:/"+HOSTNAME+ ":" +PORT);
})

