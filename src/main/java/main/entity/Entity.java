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

    public boolean collisionOn = false;

    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);

    public Entity(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void update() {

        collisionOn = false;

        gamePanel.collisionChecker.checkTile(this);

        if (!collisionOn) {

            switch (direction) {
                case "up" -> worldY -= speed; // プレイヤーのY座標からプレイヤーの速度の値を引く形になります。
                case "down" -> worldY += speed; // プレイヤーのY座標からプレイヤーの速度の値を足す形になります。
                case "left" -> worldX -= speed; // プレイヤーのX座標からプレイヤーの速度の値を引く形になります。
                case "right" -> worldX += speed; // プレイヤーのX座標からプレイヤーの速度の値を足す形になります。
            }
        }

        spriteCounter++; // 1フレーム(ループ)ごとにこのカウンターが1増加することになります。
        if (spriteCounter > 12) { // 10フレームごとにプレイヤーの画像が変わるということです。
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0; // spriteCounterをリセットします。
        }
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
