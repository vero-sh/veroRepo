
create table if not exists utente(

id_utente int not null primary key,
nome varchar(20) not null,
cognome varchar(20) not null,
email varchar(20) not null unique,
eta int check(eta >= 14)

);

create table if not exists libro(

id_libro int not null primary key,
titolo varchar(20) not null,
autore varchar(20) not null,
isbn int unique,
anno_pub int not null check(anno_pub >= 1500)

);

create table if not exists prestito(

id_prestito int auto_increment null primary key,
id_utente int not null,
id_libro int not null,

constraint fk_prestiti_utente  
	foreign key (id_utente)
    references utente(id_utente),

constraint fk_prestiti_libro
	foreign key (id_libro)
    references libro(id_libro)
    
);