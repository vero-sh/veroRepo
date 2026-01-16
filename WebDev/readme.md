flowchart TB
    %% Client
    U[Utente Web/Mobile]
    UI[Interfaccia Web/Mobile<br/>HTML / CSS / JavaScript]

    %% Backend
    API[Backend Python<br/>(Flask / FastAPI / Django)]
    AUTH[Modulo Autenticazione<br/>Login & Registrazione]
    BMI[Modulo Calcolo BMI]
    PROFILE[Gestione Profilo Utente<br/>Peso / Altezza / Dati]
    AI[Servizio AI<br/>Modello Open-Source]

    %% Database
    DB[(Database Relazionale<br/>MySQL / SQLite)]

    %% Flow
    U --> UI
    UI -->|REST API / HTTPS| API

    API --> AUTH
    API --> PROFILE
    API --> BMI
    API --> AI

    AUTH --> DB
    PROFILE --> DB
    BMI --> DB

    AI -->|Prompt + Dati Utente| MODEL[Modello LLM Open-Source<br/>(LLaMA / Mistral / Falcon)]
    MODEL --> AI

    API --> UI
