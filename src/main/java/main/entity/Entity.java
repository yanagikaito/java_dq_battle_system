package main.entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    GamePanel gamePanel;

    private int worldX;

    private int worldY;

    public int speed;

    public String direction = "down";

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

    private int solidAreaDefaultX;
    private int solidAreaDefaultY;

    public int spriteCounter = 0;

    public int spriteNum = 1;

    private boolean collisionOn = false;

    private Rectangle solidArea;

    public Entity(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void update() {

        switch (direction) {
            case "up":
                worldY -= speed; // プレイヤーのY座標からプレイヤーの速度の値を引く形。
                break;
            case "down":
                worldY += speed; // プレイヤーのY座標からプレイヤーの速度の値を足す形。
                break;
            case "left":
                worldX -= speed; // プレイヤーのX座標からプレイヤーの速度の値を引く形。
                break;
            case "right":
                worldX += speed; // プレイヤーのX座標からプレイヤーの速度の値を足す形。
                break;

        }
        // 1フレーム(ループ)ごとにこのカウンターが1増加する。
        spriteCounter++;
        // 10フレームごとにプレイヤーの画像が変わる。
        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            // spriteCounterをリセット。
            spriteCounter = 0;
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
}
