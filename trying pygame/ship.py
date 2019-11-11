import pygame
from pygame.sprite import Sprite


class Ship(Sprite):
    def __init__(self, ai_settings, screen):
        super(Ship,self).__init__()
        self.screen = screen
        self.ai_settings = ai_settings

        self.image = pygame.image.load("space ship.png")
        self.rect = self.image.get_rect()
        self.screen_rect = screen.get_rect()

        self.rect.centerx = self.screen_rect.centerx
        self.rect.centery = self.screen_rect.centery
        self.rect.bottom = self.screen_rect.bottom

        self.center = float(self.rect.centerx)
        self.center = float(self.rect.centery)
        # movement flag
        self.moving_right = False
        self.moving_left = False
        self.moving_up = False
        self.moving_down = False

    def update(self):
        if self.moving_right and self.rect.right < self.screen_rect.right:
            self.center += self.ai_settings.ship_speed_factor
            self.rect.x += 30
        elif self.moving_left and self.rect.left > 0:
            self.center -= self.ai_settings.ship_speed_factor
            self.rect.x -= 30
        elif self.moving_up and self.rect.top > 0:
            self.center -= self.ai_settings.ship_speed_factor
            self.rect.y -= 30
        elif self.moving_down and self.rect.bottom < self.screen_rect.bottom:
            self.center += self.ai_settings.ship_speed_factor
            self.rect.y += 30
        # self.rect.x = self.center
        # self.rect.y = self.center

    def blitme(self):
        self.screen.blit(self.image, self.rect)

    def center_ship(self):
        self.center = self.screen_rect.centerx