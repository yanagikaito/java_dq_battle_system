package main.entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gamePanel;
    public BufferedImage image;
    public int screenXmonsterA;
    public int screenYmonsterA;
    public int screenXmonsterB;
    public int screenYmonsterB;
    public int screenXmonsterC;
    public int screenYmonsterC;
    public int screenXmonsterD;
    public int screenYmonsterD;
    public int screenXmonsterE;
    public int screenYmonsterE;
    public int screenXmonsterF;
    public int screenYmonsterF;

    public Entity(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, (gamePanel.getScreenWidth() / 2) * 6, (gamePanel.getScreenHeight() / 2) * 6,
                gamePanel.getTileSize(), gamePanel.getTileSize(), null);
    }
}