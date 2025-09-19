// Animazioni e interattività
document.addEventListener('DOMContentLoaded', function() {
    // Imposta il nome utente
    const username = localStorage.getItem('labUsername') || 'Operatore';
    document.getElementById('username').textContent = username;
    
    // Simula attività recenti
    const activities = [
        {
            icon: 'fas fa-ruler-combined',
            title: 'Bilancia AX200 calibrata',
            time: '10 minuti fa'
        },
        {
            icon: 'fas fa-truck',
            title: 'Spedizione #4521 inviata',
            time: '1 ora fa'
        },
        {
            icon: 'fas fa-box-open',
            title: 'Nuovo strumento aggiunto all\'inventario',
            time: '3 ore fa'
        },
        {
            icon: 'fas fa-exclamation-triangle',
            title: 'Calibrazione in scadenza per PH-100',
            time: '1 giorno fa'
        }
    ];
    
    const activityList = document.querySelector('.activity-list');
    activities.forEach(activity => {
        const item = document.createElement('div');
        item.className = 'activity-item';
        item.innerHTML = `
            <div class="activity-icon">
                <i class="${activity.icon}"></i>
            </div>
            <div class="activity-content">
                <div class="activity-title">${activity.title}</div>
                <div class="activity-time">${activity.time}</div>
            </div>
        `;
        activityList.appendChild(item);
    });
    
    // Effetto hover avanzato per le card
    const statCards = document.querySelectorAll('.stat-card');
    statCards.forEach(card => {
        card.addEventListener('mouseenter', function() {
            this.style.transform = 'translateY(-5px)';
            this.style.boxShadow = '0 6px 12px rgba(0,0,0,0.1)';
        });
        
        card.addEventListener('mouseleave', function() {
            this.style.transform = '';
            this.style.boxShadow = '0 4px 6px rgba(0,0,0,0.05)';
        });
    });
    
    // Cambio tema chiaro/scuro
    const themeToggle = document.createElement('div');
    themeToggle.className = 'theme-toggle';
    themeToggle.innerHTML = '<i class="fas fa-moon"></i>';
    themeToggle.style.position = 'fixed';
    themeToggle.style.bottom = '20px';
    themeToggle.style.right = '20px';
    themeToggle.style.backgroundColor = 'var(--primary)';
    themeToggle.style.color = 'white';
    themeToggle.style.width = '40px';
    themeToggle.style.height = '40px';
    themeToggle.style.borderRadius = '50%';
    themeToggle.style.display = 'flex';
    themeToggle.style.alignItems = 'center';
    themeToggle.style.justifyContent = 'center';
    themeToggle.style.cursor = 'pointer';
    themeToggle.style.boxShadow = '0 2px 10px rgba(0,0,0,0.1)';
    themeToggle.style.zIndex = '100';
    document.body.appendChild(themeToggle);
    
    themeToggle.addEventListener('click', function() {
        document.body.classList.toggle('dark-theme');
        const icon = this.querySelector('i');
        if (document.body.classList.contains('dark-theme')) {
            icon.className = 'fas fa-sun';
        } else {
            icon.className = 'fas fa-moon';
        }
    });
});