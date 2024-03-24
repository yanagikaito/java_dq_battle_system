package main.monster;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

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

        Random random = new Random();

        int screenXmonster = random.nextInt(620) + 80;
        int screenYmonster = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();

        for (int i = 0; i < 6; i++) {
            graphics2D.drawImage(image, screenXmonster, screenYmonster, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        }
    }
}
