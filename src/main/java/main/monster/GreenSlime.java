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

    public int worldX;

    public int worldY;

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

    public void update() {

    }

    public int getWorldX() {
        return worldX;
    }

    public void draw(Graphics2D graphics2D, GamePanel gamePanel) {
        graphics2D.drawImage(image, 90, 200, gamePanel.getTileSize() * 3, gamePanel.getTileSize() * 3, null);
    }
}