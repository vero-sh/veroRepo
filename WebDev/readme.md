```mermaid
flowchart TB
    U[Utente Web/Mobile]
    UI[Interfaccia Web/Mobile<br/>HTML / CSS / JavaScript]
    API[Backend Python<br/>(FastAPI / Flask)]
    AUTH[Modulo Autenticazione]
    PROFILE[Gestione Profilo Utente]
    BMI[Calcolo BMI]
    AI[Assistente AI]
    DB[(Database Relazionale<br/>MySQL / SQLite)]

    U --> UI
    UI --> API
    API --> AUTH
    API --> PROFILE
    API --> BMI
    API --> AI
    AUTH --> DB
    PROFILE --> DB
    BMI --> DB
