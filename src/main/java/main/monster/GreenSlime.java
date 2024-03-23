package main.monster;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GreenSlime {

    private String name;

    private GamePanel gamePanel;

    private BufferedImage image;

    private int screenXmonsterA;
    private int screenYmonsterA;

    private int screenXmonsterB;
    private int screenYmonsterB;

    private int screenXmonsterC;
    private int screenYmonsterC;

    private int screenXmonsterD;
    private int screenYmonsterD;

    private int screenXmonsterE;
    private int screenYmonsterE;

    private int screenXmonsterF;
    private int screenYmonsterF;


    public int worldX;

    public int worldY;

    public GreenSlime(GamePanel gamePanel, int screenXmonsterA, int screenYmonsterA,
                      int screenXmonsterB, int screenYmonsterB, int screenXmonsterC, int screenYmonsterC,
                      int screenXmonsterD, int screenYmonsterD, int screenXmonsterE, int screenYmonsterE,
                      int screenXmonsterF, int screenYmonsterF) {
        this.gamePanel = gamePanel;
        this.screenXmonsterA = screenXmonsterA;
        this.screenYmonsterA = screenYmonsterA;
        this.screenXmonsterB = screenXmonsterB;
        this.screenYmonsterB = screenYmonsterB;
        this.screenXmonsterC = screenXmonsterC;
        this.screenYmonsterC = screenYmonsterC;
        this.screenXmonsterD = screenXmonsterD;
        this.screenYmonsterD = screenYmonsterD;
        this.screenXmonsterE = screenXmonsterE;
        this.screenYmonsterE = screenYmonsterE;
        this.screenXmonsterF = screenXmonsterF;
        this.screenYmonsterF = screenYmonsterF;
        name = "Green Slime";
        getImage();
    }

    public void getImage() {


        try {

            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("monster/greenSlime.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

    }


    public void draw(Graphics2D graphics2D) {
        // 画像を指定された座標に描画
        if (screenXmonsterA > screenXmonsterB) {
            screenXmonsterA = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 6;
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        } else if (screenXmonsterB > screenXmonsterC) {
            screenXmonsterA = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 6;
            screenXmonsterB = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 5;
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterB, screenYmonsterB, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        } else if (screenXmonsterC > screenXmonsterD) {
            screenXmonsterA = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 6;
            screenXmonsterB = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 5;
            screenXmonsterC = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 4;
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterB, screenYmonsterB, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterC, screenYmonsterC, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        } else if (screenXmonsterD > screenXmonsterE) {
            screenXmonsterA = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 6;
            screenXmonsterB = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 5;
            screenXmonsterC = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 4;
            screenXmonsterD = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 3;
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterB, screenYmonsterB, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterC, screenYmonsterC, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterD, screenYmonsterD, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        } else if (screenXmonsterE > screenXmonsterF) {
            screenXmonsterA = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 6;
            screenXmonsterB = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 5;
            screenXmonsterC = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 4;
            screenXmonsterD = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 3;
            screenXmonsterE = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 2;
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterB, screenYmonsterB, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterC, screenYmonsterC, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterD, screenYmonsterD, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterE, screenYmonsterE, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        } else if (screenXmonsterF > screenXmonsterA) {
            screenXmonsterA = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 6;
            screenXmonsterB = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 5;
            screenXmonsterC = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 4;
            screenXmonsterD = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 3;
            screenXmonsterE = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * 2;
            screenXmonsterF = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize();
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterB, screenYmonsterB, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterC, screenYmonsterC, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterD, screenYmonsterD, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterE, screenYmonsterE, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            graphics2D.drawImage(image, screenXmonsterF, screenYmonsterF, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        }
    }
}
