alter table progetto 
modify ambito varchar(7) check(ambito = 'Interno' or ambito = 'Esterno' );

select nome, cognome, cod from ricercatore where data_nascita > '2010-01-01' and data_nascita < '2017-01-01';

select p.nome, r.nome, r.cognome  
from progetto p 
join ricercatore r 