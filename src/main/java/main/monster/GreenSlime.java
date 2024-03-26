package main.monster;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GreenSlime {

    private String name = "Green Slime";
    private GamePanel gamePanel;
    private BufferedImage image;
    private List<Point> monsterPositions = new ArrayList<>();

    // Pointクラスはオブジェクトに保持されているx座標及びy座標をそれぞれ取得する方法
    public GreenSlime(GamePanel gamePanel, Point... positions) {
        this.gamePanel = gamePanel;
        for (Point position : positions) {
            monsterPositions.add(position);
        }
        loadImage();
    }

    private void loadImage() {
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("monster/greenSlime.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
    }

    public void draw(Graphics2D graphics2D) {
        for (Point position : monsterPositions) {
            graphics2D.drawImage(image, position.x, position.y, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        }
    }
}