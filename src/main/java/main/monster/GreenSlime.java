
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

    private List<Point> monsterPositions = new ArrayList<>();

    private static final int MAX_DAMAGE = 10;

    private final int monsterDamage = Math.min(random.nextInt(MAX_DAMAGE) + 1, MAX_DAMAGE);


    // Pointクラスはオブジェクトに保持されているx座標及びy座標をそれぞれ取得する方法
    public GreenSlime(GamePanel gamePanel, Player player, Point... positions) {
        super(gamePanel);
        this.gamePanel = gamePanel;
        this.player = new Player(gamePanel, keyHandler);
        for (Point position : positions) {
            monsterPositions.add(position);
        }
        init();
        loadImage();
    }

    private void loadImage() {
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("monster/greenSlime.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        setMonsterMaxHP(getMonsterMaxHP());
        setMonsterHP(getMonsterHP());
    }

    public void update() {
    }

    public final int setAction() {
        final int playerResult = player.getPlayerMaxHP() - monsterDamage;
        if (player.setPlayerHP(playerResult) < 0) {
            if (player.getPlayerHP() < 0) {
                setPlayerHP(0);
            }
        }
        return player.getPlayerHP();
    }

    public final String monsterAttack() {
        return setMonsterAttackName(result);
    }

    public void draw(Graphics2D graphics2D) {
        for (Point position : monsterPositions) {
            graphics2D.drawImage(image, position.x, position.y, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        }
    }

    public int getMonsterDamege() {
        return monsterDamage;
    }

    public String getMonsterAttackName() {
        return this.monsterAttackName;
    }

    public final String setMonsterAttackName(final String attackName) {
        this.monsterAttackName = attackName;
        return this.monsterAttackName;
    }
}