package main.player;

import main.GamePanel;
import main.KeyHandler;
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

        setSolidAreaDefaultX(8);
        setSolidAreaDefaultY(16);

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

        speed = 4;
        direction = "down";
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

        if (keyHandler.upPressed == true || keyHandler.downPressed == true ||
                keyHandler.leftPressed == true || keyHandler.rightPressed == true || keyHandler.enterPressed == true) {
            if (keyHandler.upPressed == true) {
                direction = "up";


            } else if (keyHandler.downPressed == true) {
                direction = "down";


            } else if (keyHandler.leftPressed == true) {
                direction = "left";

            } else if (keyHandler.rightPressed == true) {
                direction = "right";

            }
            setCollisionOn(false);
        }
        if (setCollisionOn(false)) {

            switch (direction) {
                case "up":
                    setWorldY(getWorldY() - speed); // プレイヤーのY座標からプレイヤーの速度の値を引く形になります。
                    break;
                case "down":
                    setWorldY(getWorldY() + speed); // プレイヤーのY座標からプレイヤーの速度の値を足す形になります。
                    break;
                case "left":
                    setWorldX(getWorldX() - speed); // プレイヤーのX座標からプレイヤーの速度の値を引く形になります。
                    break;
                case "right":
                    setWorldX(getWorldX() + speed); // プレイヤーのX座標からプレイヤーの速度の値を足す形になります。
                    break;

            }
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;


        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":

                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }

        }

        g2.drawImage(image, playerScreenX, playerScreenY, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
    }

    public int getPlayerScreenX() {
        return playerScreenX;
    }

    public int getPlayerScreenY() {
        return playerScreenY;
    }
}