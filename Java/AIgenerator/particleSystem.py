import pygame
import random
import math
import numpy as np

# Inizializzazione
pygame.init()
WIDTH, HEIGHT = 1200, 800
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Generative Particle Universe")
clock = pygame.time.Clock()

# Colori di sfondo gradienti
def background_gradient():
    for y in range(HEIGHT):
        # Interpolazione lineare tra due colori
        r = int(10 + (y/HEIGHT)*50)
        g = int(20 + (y/HEIGHT)*30)
        b = int(30 + (y/HEIGHT)*70)
        pygame.draw.line(screen, (r,g,b), (0,y), (WIDTH,y))

class Particle:
    def __init__(self, x=None, y=None):
        self.x = x if x else random.randint(0, WIDTH)
        self.y = y if y else random.randint(0, HEIGHT)
        self.size = random.uniform(1.5, 4.0)
        self.color = (
            random.randint(100, 255),
            random.randint(100, 255),
            random.randint(100, 255),
            random.randint(150, 230)  # Alpha per effetti di blending
        )
        self.speed = random.uniform(0.2, 1.5)
        self.angle = random.uniform(0, 2 * math.pi)
        self.life = random.randint(200, 500)  # Durata in frames

    def move(self, mouse_pos):
        mx, my = mouse_pos
        
        # Fisica delle particelle
        dx = mx - self.x
        dy = my - self.y
        dist = max(1, math.sqrt(dx*dx + dy*dy))
        
        # Attrazione/repulsione dal mouse
        if dist < 150:
            force = -0.5  # Repulsione
        else:
            force = 0.02  # Attrazione debole
            
        self.angle = math.atan2(dy, dx) + force
        self.x += math.cos(self.angle) * self.speed
        self.y += math.sin(self.angle) * self.speed
        
        # Riduci vita e rimpicciolisci
        self.life -= 1
        self.size *= 0.995
        
        # Cambia colore gradualmente
        self.color = (
            random.randint(200, 255),
            random.randint(50, 150),
            random.randint(0, 50),
            random.randint(180, 220)
        )
        
        # Rimbalzo sui bordi
        if self.x < 0 or self.x > WIDTH:
            self.angle = math.pi - self.angle
        if self.y < 0 or self.y > HEIGHT:
            self.angle = -self.angle

# Creazione particelle
particles = [Particle() for _ in range(300)]

# Main loop
running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        elif event.type == pygame.MOUSEBUTTONDOWN:
            # Aggiungi esplosione di particelle al click
            for _ in range(50):
                particles.append(Particle(*pygame.mouse.get_pos()))
    
    # Disegna sfondo
    background_gradient()
    
    # Aggiorna e disegna particelle
    for p in particles[:]:
        p.move(pygame.mouse.get_pos())
        
        # Usa una surface per l'alpha blending
        particle_surface = pygame.Surface((int(p.size*2), int(p.size*2)), pygame.SRCALPHA)
        pygame.draw.circle(
            particle_surface, 
            p.color, 
            (int(p.size), int(p.size)), 
            int(p.size)
        )
        screen.blit(particle_surface, (int(p.x-p.size), int(p.y-p.size)))
        
        # Rimuovi particelle "morte"
        if p.life <= 0 or p.size < 0.1:
            particles.remove(p)
    
    # Aggiungi continuamente nuove particelle
    if random.random() < 0.3:
        particles.append(Particle())
    
    pygame.display.flip()
    clock.tick(60)

pygame.quit()