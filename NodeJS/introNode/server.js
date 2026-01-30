// terminale: ctrl + j
// node --watch server.js  -> serve ad aggiornare il server in auto

const http = require("http");

const PORT = 80;
const HOSTNAME = "localhost";

// funzione per numero random tra 1 e max
const randomNumber = (max) => Math.floor(Math.random() * max) + 1;

const server = http.createServer((req, res) => {

    // HOME
    if (req.url === "/" && req.method === "GET") {
        res.statusCode = 200;
        res.setHeader("Content-Type", "text/plain");
        res.end("ciao, benvenuto");

    // BLOCCO METODI NON CONSENTITI SU /
    } else if (req.url === "/" && req.method !== "GET") {
        res.statusCode = 405;
        res.setHeader("Content-Type", "application/json");
        res.setHeader("Allow", "GET");
        res.end(JSON.stringify({ error: "Metodo non consentito" }));

    // USERS
    } else if (req.url === "/users" && req.method === "GET") {
        res.statusCode = 200;
        res.setHeader("Content-Type", "application/json");
        res.end(JSON.stringify([
            { user: "vero", id: 1 },
            { user: "bob", id: 2 }
        ]));

    // /number → 1-100
    } else if (req.url === "/number" && req.method === "GET") {
        res.statusCode = 200;
        res.setHeader("Content-Type", "text/plain");
        res.end(randomNumber(100).toString());

    // /number/N → 1-N
    } else if (req.url.startsWith("/number/") && req.method === "GET") {
        const parts = req.url.split("/");
        const N = parseInt(parts[2]);

        if (isNaN(N) || N <= 0) {
            res.statusCode = 400;
            res.setHeader("Content-Type", "application/json");
            res.end(JSON.stringify({ error: "N deve essere un numero positivo" }));
        } else {
            res.statusCode = 200;
            res.setHeader("Content-Type", "text/plain");
            res.end(randomNumber(N).toString());
        }

    // METODI NON CONSENTITI SU /number
    } else if (req.url.startsWith("/number") && req.method !== "GET") {
        res.statusCode = 405;
        res.setHeader("Content-Type", "application/json");
        res.setHeader("Allow", "GET");
        res.end(JSON.stringify({ error: "Metodo non consentito" }));

    // 404
    } else {
        res.statusCode = 404;
        res.setHeader("Content-Type", "application/json");
        res.end(JSON.stringify({ error: req.url + " not found" }));
    }
});

server.listen(PORT, HOSTNAME, () => {
    console.log(`online su http://${HOSTNAME}:${PORT}`);
});
