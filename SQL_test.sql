
CREATE TABLE IF NOT EXISTS dipendenti (
    id_dipendente INT NOT NULL,
    nome VARCHAR(16) NOT NULL,
    cognome VARCHAR(16) NOT NULL,
    data_assunzione DATE NOT NULL,
    stipendio DECIMAL NOT NULL CHECK (stipendio >= 1200 AND stipendio <= 5000),
    telefono VARCHAR(10) NOT NULL UNIQUE,
    mansione VARCHAR(255) NOT NULL DEFAULT 'impiegato',
    PRIMARY KEY (id_dipendente)
);

CREATE TABLE IF NOT EXISTS clienti (
    id_cliente INT NOT NULL,
    denominazione VARCHAR(255) NOT NULL,
    p_iva VARCHAR(16) NOT NULL UNIQUE,
    indirizzo VARCHAR(255) NOT NULL,
    telefono VARCHAR(10) NOT NULL UNIQUE,
    PRIMARY KEY (id_cliente)
);




  
  
