create database if not exists eserciziRandom;



create table if not exists ricercatore(
nome varchar(20) not null,
cognome varchar(20) not null,
cod int primary key,
data_nascita date,
citta varchar(20),
nazione varchar(20)
);

create table if not exists progetto(
nome varchar(20) not null,
cod int primary key,
ambito varchar(20) not null,
ruolo varchar(20) not null,
responsabile varchar(20) not null,

constraint fk_progetto_ricercatore
	foreign key (cod)
    references ricercatore(cod)
	
);

create table if not exists docente(
nome varchar(20) not null,
cognome varchar(20) not null,
cf varchar(16) primary key,
data_nascita date not null,
citta varchar(20) not null,
nazione varchar(20) not null
);

create table if not exists pubblicazione(
cod int primary key,
titolo varchar(20) not null,
docente varchar(16) not null,
anno int not null check(anno > 1000),

constraint fk_pubblicazione_docente 
	foreign key (docente)
    references docente(cf)
	

);

create table if not exists progetto_pubblicazione(
progetto int,
pubblicazione int,

constraint pk_progetto_pubblicazione 
	primary key (progetto, pubblicazione),

constraint fk_progetto_pubblicazione_progetto 
	foreign key (progetto) 
    references progetto(cod),
    
constraint fk_progetto_pubblicazione_pubblicazione
	foreign key (pubblicazione)
    references pubblicazione(cod)

)


