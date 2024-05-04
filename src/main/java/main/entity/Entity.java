package main.entity;

import main.gamemain.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    private GamePanel gamePanel;

    private int worldX;

    private int worldY;

    private int speed;

    private String direction = "down";

    private BufferedImage up1;
    private BufferedImage up2;
    private BufferedImage down1;
    private BufferedImage down2;
    private BufferedImage left1;
    private BufferedImage left2;
    private BufferedImage right1;
    private BufferedImage right2;

    public int solidAreaDefaultX;
    public int solidAreaDefaultY;

    public int spriteCounter = 0;

    public int spriteNum = 1;

    public int standCounter;

    private static final int MIN = 0;


    public boolean collisionOn = false;

    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);

    public Entity(GamePanel panel) {
        this.gamePanel = panel;

    }

    public void update() {

        collisionOn = false;

        gamePanel.getCchecker().checkTile(this);

        if (!collisionOn) {

            switch (direction) {
                case "up" -> worldY -= speed; // プレイヤーのY座標からプレイヤーの速度の値を引く形。
                case "down" -> worldY += speed; // プレイヤーのY座標からプレイヤーの速度の値を足す形。
                case "left" -> worldX -= speed; // プレイヤーのX座標からプレイヤーの速度の値を引く形。
                case "right" -> worldX += speed; // プレイヤーのX座標からプレイヤーの速度の値を足す形。
            }
        }

        spriteCounter++; // 1フレーム(ループ)ごとにこのカウンターが1増加する。
        if (spriteCounter > 12) { // 10フレームごとにプレイヤーの画像が変わる。
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0; // spriteCounterをリセット。
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

    /**
     * .
     * ゲッター getUp1
     *
     * @return this.up1;
     */
    public BufferedImage getUp1() {
        return this.up1;
    }

    /**
     * .
     * セッター setUp1
     *
     * @param up = up1;
     * @return this.up1;
     */
    public BufferedImage setUp1(final BufferedImage up) {
        this.up1 = up;
        return this.up1;
    }

    /**
     * .
     * ゲッター getUp2
     *
     * @return this.up2;
     */
    public BufferedImage getUp2() {
        return this.up2;
    }

    /**
     * .
     * セッター setUp2
     *
     * @param up = up2;
     * @return this.up2;
     */
    public BufferedImage setUp2(final BufferedImage up) {
        this.up2 = up;
        return this.up2;
    }

    /**
     * .
     * ゲッター getDown1
     *
     * @return this.down1;
     */
    public BufferedImage getDown1() {
        return this.down1;
    }

    /**
     * .
     * セッター setDown1
     *
     * @param down = down1;
     * @return this.down1;
     */
    public BufferedImage setDown1(final BufferedImage down) {
        this.down1 = down;
        return this.down1;
    }

    /**
     * .
     * ゲッター getDown2
     *
     * @return this.down2;
     */
    public BufferedImage getDown2() {
        return this.down2;
    }

    /**
     * .
     * セッター setDown2
     *
     * @param down = down2;
     * @return this.down2;
     */
    public BufferedImage setDown2(final BufferedImage down) {
        this.down2 = down;
        return this.down2;
    }

    /**
     * .
     * ゲッター getLeft1
     *
     * @return this.left1;
     */
    public BufferedImage getLeft1() {
        return this.left1;
    }

    /**
     * .
     * セッター setLeft1
     *
     * @param left = left1;
     * @return this.left1;
     */
    public BufferedImage setLeft1(final BufferedImage left) {
        this.left1 = left;
        return this.left1;
    }

    /**
     * .
     * ゲッター getLeft2
     *
     * @return this.left2;
     */
    public BufferedImage getLeft2() {
        return this.left2;
    }

    /**
     * .
     * セッター setLeft2
     *
     * @param left = left2;
     * @return this.left2;
     */
    public BufferedImage setLeft2(final BufferedImage left) {
        this.left2 = left;
        return this.left2;
    }

    /**
     * .
     * ゲッター getRight1
     *
     * @return this.right1;
     */
    public BufferedImage getRight1() {
        return this.right1;
    }

    /**
     * .
     * セッター setRight1
     *
     * @param right = right1;
     * @return this.right1;
     */
    public BufferedImage setRight1(final BufferedImage right) {
        this.right1 = right;
        return this.right1;
    }

    /**
     * .
     * ゲッター getRight2
     *
     * @return this.right2;
     */
    public BufferedImage getRight2() {
        return this.right2;
    }

    /**
     * .
     * セッター setRight2
     *
     * @param right = right2;
     * @return this.right2;
     */
    public BufferedImage setRight2(final BufferedImage right) {
        this.right2 = right;
        return this.right2;
    }
}
