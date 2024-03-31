package main.player;

import main.gamemain.GamePanel;
import main.gamemain.KeyHandler;
import main.entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gamePanel;

    KeyHandler keyHandler;

    private final int playerScreenX;
    private final int playerScreenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        super(gamePanel);
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        playerScreenX = (gamePanel.getScreenWidth() / 2) - gamePanel.getTileSize();
        playerScreenY = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();

        // この四角形をインスタンス化するときにコンストラクタに4つのパラメーターを渡せる。
        setSolidArea(new Rectangle());
        getSolidArea().x = 8;
        getSolidArea().y = 16;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getSolidArea().width = 32;
        getSolidArea().height = 32;

        // コンストラクタの中にメソッド宣言すれば初期値が設定される。
        setDefaultValues();
        loadPlayerImage();
    }

    public void setDefaultValues() {

        // 開始位置の座標
        // worldX 1104 worldY 1008
        setWorldX(gamePanel.getTileSize() * 23);
        setWorldY(gamePanel.getTileSize() * 21);

        setSpeed(4);
        setDirection("down");
    }

    public void loadPlayerImage() {


        try {

            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-up-1.gif"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-up-2.gif"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-down-1.gif"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-down-2.gif"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-left-1.gif"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-left-2.gif"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-right-1.gif"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-right-2.gif"));


        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void update() {

        if (keyHandler.upPressed || keyHandler.downPressed ||
                keyHandler.leftPressed || keyHandler.rightPressed) {

            if (keyHandler.upPressed) {
                setDirection("up");
                setWorldY(getWorldY() - getSpeed());

            } else if (keyHandler.downPressed) {
                setDirection("down");
                setWorldY(getWorldY() + getSpeed());

            } else if (keyHandler.leftPressed) {
                setDirection("left");
                setWorldX(getWorldX() - getSpeed());

            } else {
                setDirection("right");
                setWorldX(getWorldX() + getSpeed());
            }
            setCollisionOn(getCollisionOn());
        }
        // spriteCounterは、1フレーム（1ループ）ごとに1増加し,このカウンターを使って、
        // 10フレームごとにプレイヤーのアニメーションを変更。

        spriteCounter++; // 1フレーム(ループ)ごとにこのカウンターが1増加する。

        // spriteNum 1と2の切り替えはスライムモンスターのup1とup2を切り替える
        // これにより、プレイヤーの画像が交互に表示されることでアニメーションが実現。

        if (spriteCounter > 12) { // 10フレームごとにプレイヤーの画像が変わる。
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0; // spriteCounterをリセット。
        }
    }


    public void draw(Graphics2D g2) {

        BufferedImage image = null;


        switch (getDirection()) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                } else if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                } else if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":

                if (spriteNum == 1) {
                    image = right1;
                } else if (spriteNum == 2) {
                    image = right2;
                }
        }

        g2.drawImage(image, playerScreenX, playerScreenY, gamePanel.getTileSize(), gamePanel.getTileSize(), null);

//        デバッグ
        g2.setColor(Color.red);
        g2.drawRect(playerScreenX + solidArea.x, playerScreenY + solidArea.y, solidArea.width, solidArea.height);
    }

    public int getPlayerScreenX() {
        return playerScreenX;
    }

    public int getPlayerScreenY() {
        return playerScreenY;
    }
}