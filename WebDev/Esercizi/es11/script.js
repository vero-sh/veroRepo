let spese = [];

function aggiungi() {
  let nome = nomeInput.value.trim();
  let imp = parseFloat(importo.value);
  if (!nome || isNaN(imp)) return alert("Dati non validi");
  spese.push({nome, imp});
  lista.innerHTML = spese.map(s => `<li>${s.nome}: €${s.imp}</li>`).join('');
  nomeInput.value = importo.value = '';
}

const nomeInput = document.getElementById('nome');
const importo = document.getElementById('importo');
const lista = document.getElementById('lista');
const risultato = document.getElementById('risultato');

function calcola() {
    
  if (!spese.length) return;
  let totali = {}, somma = 0;
  spese.forEach(s => { totali[s.nome]=(totali[s.nome]||0)+s.imp; somma+=s.imp; });
  let media = somma / Object.keys(totali).length;
  let deb = [], cred = [];
  for (let [n,a] of Object.entries(totali)) {
    let diff = a - media;
    if (diff < -0.01) deb.push({n, d:-diff});
    if (diff > 0.01) cred.push({n, c:diff});
  }
  let txt = `Totale: €${somma.toFixed(2)}\nMedia: €${media.toFixed(2)}\n\n`;
  for (let [n,a] of Object.entries(totali)) txt += `${n} ha speso €${a.toFixed(2)}\n`;
  txt += `\nTransazioni:\n`;
  while (deb.length && cred.length) {
    let d = deb[0], c = cred[0];
    let x = Math.min(d.d, c.c);
    txt += `${d.n} → ${c.n}: €${x.toFixed(2)}\n`;
    d.d -= x; c.c -= x;
    if (d.d < 0.01) deb.shift();
    if (c.c < 0.01) cred.shift();
  }
  risultato.textContent = txt;
}