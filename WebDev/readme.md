flowchart TB

    U[Utente Web Mobile]
    UI[Interfaccia Web Mobile]
    
    API[Backend Python NodeJS]
    AUTH[Autenticazione]
    PROFILE[Profilo Utente]
    FORUM[Forum Salute]
    AI[Assistente AI]

    DB[(Database Relazionale)]

    MODEL[Modello AI Open Source]

    U --> UI
    UI --> API

    API --> AUTH
    API --> PROFILE
    API --> FORUM
    API --> AI

    AUTH --> DB
    PROFILE --> DB
    FORUM --> DB

    AI --> MODEL
    MODEL --> AI

    API --> UI
