//servizio node http dove:

/*
get /numbers : restituiamo tutti i numeri salvati sul server
post /numbers : aggiungiamo un numero sul server
    - cosa mi puo inviare il client?
    -validazione?
get /numbers/n : restituisce l ennesimo numero salvato sul server
una qualunque chiamata a /: reubduruzza a /numbers

*/

const http = require("http")

const PORT = 1533
const HOSTNAME  = "localhost"
let numbers = [1, 2, 3, 4, 5]


const server = http.createServer((req, res) => {

    if (req.url === "/"){
        res.statusCode = 302;
        res.setHeader("Location", "/numbers");
        return res.end();
    }
    if(req.url === "/nubers" && req.method === "GET"){
        //restituisce tutti i numeri
        res.statusCode = 200;
        res.setHeader("Content-Type", "application/json") //mime type
        return res.end(JSON.stringify({ numbers : numbers}))
    }
    if(req.url === "/numbers" && req.method === "POST"){
        //Fintanto che il client mi sta inviando dati...
        let body = "";
        
        req.on("data", (chunk) => {
            body += chunk
        })

        req.on("end", () => {
            let value = Number(body);

            if(isNaN(value)){
                res.statusCode = 400;
                res.setHeader("Content-Type", "application/json");
                return res.end(JSON.stringify({error: "il body deve essere un numero"}))
            }

            numbers.push(value);
            res.status = 201;
            res.setHeader("Location", "/numbers" + (numbers.length -1));
            return res.end();
        })
    }
    


})


server.listen(PORT, HOSTNAME, () => {

    console.log("ONLINE");

})

