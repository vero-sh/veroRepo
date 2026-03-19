const api = "https://jsonplaceholder.typicode.com/usersXXX/3";

fetch(api)
     .then(response => {
    if (!response.ok) {
      throw new Error("HTTP error " + response.status);
    }
    return response.json();
    })
    .then(data => {
    console.log(data);
    })
    .catch(error => {
    console.log("Errore nella richiesta:", error.message);
    });