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

    public GreenSlime(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
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

    public void draw(Graphics2D graphics2D) {
        for (int i = 0; i < 6; i++) {
            int screenXmonster = (gamePanel.getScreenWidth() - 240) - gamePanel.getTileSize() * i;
            int screenYmonster = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
            graphics2D.drawImage(image, screenXmonster, screenYmonster, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        }
    }
}