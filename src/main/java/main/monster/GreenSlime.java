package main.monster;

import main.GamePanel;
import main.entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class GreenSlime extends Entity {

    private String name;

    public GreenSlime(GamePanel gamePanel) {
        super(gamePanel);
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
}
