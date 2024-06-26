
package main.monster;

import main.entity.Entity;
import main.gamemain.GamePanel;
import main.gamemain.KeyHandler;
import main.player.Player;

import javax.imageio.ImageIO;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GreenSlime extends Entity {

    private Random random = new Random();

    private String name = "Green Slime";

    private List<String> monsterAttackText = Arrays.asList("グリーンスライムAのこうげき",
            "グリーンスライムBのこうげき",
            "グリーンスライムCのこうげき",
            "グリーンスライムDのこうげき",
            "グリーンスライムEのこうげき",
            "グリーンスライムFのこうげき",
            "グリーンスライムGのこうげき",
            "グリーンスライムHのこうげき");

    private final int index = random.nextInt(monsterAttackText.size());
    private final String result = monsterAttackText.get(index);

    private String monsterAttackName = "";
    private GamePanel gamePanel;
    private BufferedImage image;

    private Player player;

    private KeyHandler keyHandler;

    private GreenSlime[] greenSlime;

    private List<Point> monsterPositions = new ArrayList<>();

    private static final int MAX_DAMAGE = 10;

    private int monsterDamage = Math.min(random.nextInt(MAX_DAMAGE) + 1, MAX_DAMAGE);


    // Pointクラスはオブジェクトに保持されているx座標及びy座標をそれぞれ取得する方法
    public GreenSlime(GamePanel gamePanel, Player player, Point... positions) {
        super(gamePanel);
        this.gamePanel = gamePanel;
        this.player = new Player(gamePanel, greenSlime, keyHandler);
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

    public int setAction() {
       
        int monsterResult = setMonsterDamage(monsterDamage);
        int playerResult = player.getPlayerMaxHP() - monsterResult;
        if (player.setPlayerHP(playerResult) < 0) {
            if (player.getPlayerHP() < 0) {
                player.setPlayerHP(0);
            }
        }
        return player.setPlayerHP(playerResult);
    }


    public final String monsterAttack() {
        return setMonsterAttackName(result);
    }

    public void draw(Graphics2D graphics2D) {
        for (Point position : monsterPositions) {
            graphics2D.drawImage(image, position.x, position.y, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        }
    }

    public int getMonsterDamage() {
        return monsterDamage;
    }

    public int setMonsterDamage(int damage) {
        this.monsterDamage = damage;
        return this.monsterDamage;
    }

    public String getMonsterAttackName() {
        return this.monsterAttackName;
    }

    public final String setMonsterAttackName(final String attackName) {
        this.monsterAttackName = attackName;
        return this.monsterAttackName;
    }
}