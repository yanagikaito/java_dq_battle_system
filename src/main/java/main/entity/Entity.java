package main.entity;

import main.gamemain.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    GamePanel gamePanel;

    private int worldX;

    private int worldY;

    private int speed;

    private String direction = "down";

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

    public int solidAreaDefaultX;
    public int solidAreaDefaultY;

    public int spriteCounter = 0;

    public int spriteNum = 1;

    public int standCounter;

    private boolean collisionOn;

    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);

    public Entity(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void update() {

        setCollisionOn(false);

        gamePanel.collisionChecker.checkTile(this);
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public int setWorldX(int worldX) {
        return this.worldX = worldX;
    }

    public int setWorldY(int worldY) {
        return this.worldY = worldY;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public Rectangle setSolidArea(Rectangle solidArea) {
        return this.solidArea = solidArea;
    }

    public int getSolidAreaDefaultX() {
        return solidAreaDefaultX;
    }

    public int getSolidAreaDefaultY() {
        return solidAreaDefaultY;
    }

    public int setSolidAreaDefaultX(int solidAreaDefaultX) {
        return this.solidAreaDefaultX = solidAreaDefaultX;
    }

    public int setSolidAreaDefaultY(int solidAreaDefaultY) {
        return this.solidAreaDefaultY = solidAreaDefaultY;
    }

    public boolean getCollisionOn() {
        return false;
    }

    public boolean setCollisionOn(boolean collisionOn) {
        return this.collisionOn = collisionOn;
    }

    public int getSpeed() {
        return speed;
    }

    public int setSpeed(int speed) {
        return this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public String setDirection(String direction) {
        return this.direction = direction;
    }
}
