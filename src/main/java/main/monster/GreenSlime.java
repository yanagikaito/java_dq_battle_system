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
            screenXmonsterA = 20;
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
        } else if (screenXmonsterB > screenXmonsterC) {
            screenXmonsterA = 20;
            screenXmonsterB = 140;
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterB, screenYmonsterB, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
        } else if (screenXmonsterC > screenXmonsterD) {
            screenXmonsterA = 20;
            screenXmonsterB = 140;
            screenXmonsterC = 260;
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterB, screenYmonsterB, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterC, screenYmonsterC, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
        } else if (screenXmonsterD > screenXmonsterE) {
            screenXmonsterA = 20;
            screenXmonsterB = 140;
            screenXmonsterC = 260;
            screenXmonsterD = 380;
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterB, screenYmonsterB, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterC, screenYmonsterC, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterD, screenYmonsterD, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
        } else if (screenXmonsterE > screenXmonsterF) {
            screenXmonsterA = 20;
            screenXmonsterB = 140;
            screenXmonsterC = 260;
            screenXmonsterD = 380;
            screenXmonsterE = 500;
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterB, screenYmonsterB, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterC, screenYmonsterC, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterD, screenYmonsterD, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterE, screenYmonsterE, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
        } else if (screenXmonsterF > screenXmonsterA) {
            screenXmonsterA = 20;
            screenXmonsterB = 140;
            screenXmonsterC = 260;
            screenXmonsterD = 380;
            screenXmonsterE = 500;
            screenXmonsterF = 620;
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterB, screenYmonsterB, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterC, screenYmonsterC, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterD, screenYmonsterD, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterE, screenYmonsterE, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
            graphics2D.drawImage(image, screenXmonsterF, screenYmonsterF, gamePanel.getTileSize() * 2, gamePanel.getTileSize() * 2, null);
        }
    }
}