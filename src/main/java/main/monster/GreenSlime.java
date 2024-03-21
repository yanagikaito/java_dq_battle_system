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

    public int worldX;

    public int worldY;

    public GreenSlime(GamePanel gamePanel, int screenXmonsterA, int screenYmonsterA,
                      int screenXmonsterB, int screenYmonsterB, int screenXmonsterC, int screenYmonsterC) {
        this.gamePanel = gamePanel;
        this.screenXmonsterA = screenXmonsterA;
        this.screenYmonsterA = screenYmonsterA;
        this.screenXmonsterB = screenXmonsterB;
        this.screenYmonsterB = screenYmonsterB;
        this.screenXmonsterC = screenXmonsterC;
        this.screenYmonsterC = screenYmonsterC;
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
        if (screenXmonsterA == 80 || screenXmonsterB == 350 || screenXmonsterC == 500) {
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize() * 3, gamePanel.getTileSize() * 3, null);
        }
        if (screenXmonsterA == 80 || screenXmonsterB == 350 || screenXmonsterC == 500) {
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize() * 3, gamePanel.getTileSize() * 3, null);
            graphics2D.drawImage(image, screenXmonsterB, screenYmonsterB, gamePanel.getTileSize() * 3, gamePanel.getTileSize() * 3, null);
        }
        if (screenXmonsterA == 80 || screenXmonsterB == 350 || screenXmonsterC == 500) {
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize() * 3, gamePanel.getTileSize() * 3, null);
            graphics2D.drawImage(image, screenXmonsterB, screenYmonsterB, gamePanel.getTileSize() * 3, gamePanel.getTileSize() * 3, null);
            graphics2D.drawImage(image, screenXmonsterC, screenYmonsterC, gamePanel.getTileSize() * 3, gamePanel.getTileSize() * 3, null);
        } else {
            graphics2D.drawImage(image, screenXmonsterA, screenYmonsterA, gamePanel.getTileSize() * 3, gamePanel.getTileSize() * 3, null);
            graphics2D.drawImage(image, screenXmonsterB, screenYmonsterB, gamePanel.getTileSize() * 3, gamePanel.getTileSize() * 3, null);
            graphics2D.drawImage(image, screenXmonsterC, screenYmonsterC, gamePanel.getTileSize() * 3, gamePanel.getTileSize() * 3, null);
        }
    }
}
