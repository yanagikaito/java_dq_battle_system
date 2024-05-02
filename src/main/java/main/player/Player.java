
package main.player;

import main.gamemain.GamePanel;
import main.gamemain.KeyHandler;
import main.entity.Entity;
import main.monster.GreenSlime;

import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player extends Entity {

    /**
     * .
     * gamePanelをインスタンス変数宣言
     */
    private final GamePanel gamePanel;

    /**
     * .
     * keyHandlerをインスタンス変数宣言
     */
    private final KeyHandler keyHandler;

    /**
     * .
     * playerのScreenXをインスタンス変数宣言
     */
    private final int pScreenX;

    /**
     * .
     * playerのScreenYをインスタンス変数宣言
     */
    private final int pScreenY;

    /**
     * .
     * プレイヤーの実体の座標X
     */
    private final int playerSolidAreaX = 8;

    /**
     * .
     * プレイヤーの実体の座標Y
     */
    private final int playerSolidAreaY = 16;

    /**
     * .
     * Rectangleの幅
     */

    private final int rWidth = 32;

    /**
     * .
     * Rectangleの高さ
     */

    private final int rHeight = 32;

    /**
     * .
     * mapの配列の横の23番目
     */

    private final int mapXplayer = 23;

    /**
     * .
     * mapの配列の縦の21番目
     */

    private final int mapYplayer = 21;

    /**
     * .
     * プレイヤーのスピード
     */

    private final int playerSpeed = 6;

    /**
     * .
     * プレイヤーの画像切り替え
     */
    private final int spriteChange = 12;

    private Random random = new Random();

    private List<String> monsterDamageText = Arrays.asList("グリーンスライムAに",
            "グリーンスライムBに",
            "グリーンスライムCに",
            "グリーンスライムDに",
            "グリーンスライムEに",
            "グリーンスライムFに",
            "グリーンスライムGに",
            "グリーンスライムHに");

    private final int index = random.nextInt(monsterDamageText.size());
    private final String result = monsterDamageText.get(index);

    private GreenSlime[] monsterGreenSlime;

    private static final int MAX_DAMAGE = 10;

    private final int playerDamage = Math.min(random.nextInt(MAX_DAMAGE) + 1, MAX_DAMAGE);

    private String monsterAttackTextName = "";


    /**
     * .
     * Playerのコンストラクタを作成し,gamePanelとkeyHandlerを初期化
     *
     * @param panel   = gamePanel
     * @param key     = keyHandler
     * @param monster = monsterGreenSlime
     */
    public Player(final GamePanel panel, final GreenSlime[] monster, final KeyHandler key) {
        super(panel);
        this.gamePanel = panel;
        this.keyHandler = key;
        this.monsterGreenSlime = monster;
        pScreenX = (gamePanel.getScreenWidth() / 2) - gamePanel.getTileSize();
        pScreenY = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();

        // この四角形をインスタンス化するときにコンストラクタに4つのパラメーターを渡せる。
        setSolidArea(new Rectangle());
        getSolidArea().x = playerSolidAreaX;
        getSolidArea().y = playerSolidAreaY;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getSolidArea().width = rWidth;
        getSolidArea().height = rHeight;

        // コンストラクタの中にメソッド宣言すれば初期値が設定される。
        setDefaultValues();
        loadPlayerImage();
    }

    public final int setAction() {
        final int monsterResult = getMonsterMaxHP() - playerDamage;
        if (setMonsterHP(monsterResult) < 0) {
            if (getMonsterHP() < 0) {
                setPlayerHP(0);
            }
        }
        return getMonsterHP();
    }

    /**
     * .
     * プレイヤーの開始位置の座標の設定
     */
    public void setDefaultValues() {

        // 開始位置の座標
        // worldX 1104 worldY 1008
        setWorldX(gamePanel.getTileSize() * mapXplayer);
        setWorldY(gamePanel.getTileSize() * mapYplayer);

        setSpeed(playerSpeed);
        setDirection("down");

        setPlayerMaxHP(getPlayerMaxHP());
        setPlayerHP(getPlayerMaxHP());
    }

    /**
     * .
     * プレイヤーの画像を読み込む
     */
    public void loadPlayerImage() {


        try {

            setUp1(ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-up-1.gif")));
            setUp2(ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-up-2.gif")));
            setDown1(ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-down-1.gif")));
            setDown2(ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-down-2.gif")));
            setLeft1(ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-left-1.gif")));
            setLeft2(ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-left-2.gif")));
            setRight1(ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-right-1.gif")));
            setRight2(ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/image-right-2.gif")));


        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * .
     * それぞれのキーが押されるたびにプレイヤーを更新する
     */
    public void update() {
        if (keyHandler.getUp() || keyHandler.getDown()
                || keyHandler.getLeft() || keyHandler.getRight()) {

            if (keyHandler.getUp()) {
                setDirection("up");
            } else if (keyHandler.getDown()) {
                setDirection("down");
            } else if (keyHandler.getLeft()) {
                setDirection("left");
            } else {
                setDirection("right");
            }
            setCollisionOn(false);
            gamePanel.getCchecker().checkTile(this);
            gamePanel.getEventHandler().checkEvent();
            if (!collisionOn) {

                switch (getDirection()) {
                    case "up" -> setWorldY(getWorldY() - getSpeed()); // プレイヤーのY座標からプレイヤーの速度の値を引く形。
                    case "down" -> setWorldY(getWorldY() + getSpeed()); // プレイヤーのY座標からプレイヤーの速度の値を足す形。
                    case "left" -> setWorldX(getWorldX() - getSpeed()); // プレイヤーのX座標からプレイヤーの速度の値を引く形。
                    case "right" -> setWorldX(getWorldX() + getSpeed()); // プレイヤーのX座標からプレイヤーの速度の値を足す形。
                }
            }
            // spriteCounterは、1フレーム（1ループ）ごとに1増加し,このカウンターを使って、
            // 10フレームごとにプレイヤーのアニメーションを変更。

            spriteCounter++; // 1フレーム(ループ)ごとにこのカウンターが1増加する。

            // spriteNum 1と2の切り替えはスライムモンスターのup1とup2を切り替える
            // これにより、プレイヤーの画像が交互に表示されることでアニメーションが実現。

            if (spriteCounter > spriteChange) { // 10フレームごとにプレイヤーの画像が変わる。
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0; // spriteCounterをリセット。
            }
        }
    }

    /**
     * .
     * プレイヤーの画像をそれぞれ表示する
     *
     * @param g2 = Graphics2D
     */

    public void draw(final Graphics2D g2) {

        BufferedImage image = null;


        switch (getDirection()) {
            case "up":
                if (spriteNum == 1) {
                    image = getUp1();
                } else if (spriteNum == 2) {
                    image = getUp2();
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = getDown1();
                } else if (spriteNum == 2) {
                    image = getDown2();
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = getLeft1();
                } else if (spriteNum == 2) {
                    image = getLeft2();
                }
                break;
            case "right":

                if (spriteNum == 1) {
                    image = getRight1();
                } else if (spriteNum == 2) {
                    image = getRight2();
                }
        }

        g2.drawImage(image, pScreenX, pScreenY, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
    }

//        デバッグ
//        g2.setColor(Color.red);
//        g2.drawRect(pScreenX + solidArea.x, pScreenY + solidArea.y, solidArea.width, solidArea.height);
//    }

    /**
     * .
     * ゲッター プレイヤーのスクリーンX
     *
     * @return pScreenX;
     */
    public int getPlayerScreenX() {
        return pScreenX;
    }

    /**
     * .
     * ゲッター プレイヤーのスクリーンY
     *
     * @return pScreenY;
     */
    public int getPlayerScreenY() {
        return pScreenY;
    }

    public final String playerAttack() {
        return setMonsterAttackTextName(result);
    }

    public int getPlayerDamage() {
        return playerDamage;
    }

    public String getMonsterAttackTextName() {
        return this.monsterAttackTextName;
    }

    public final String setMonsterAttackTextName(final String attackName) {
        this.monsterAttackTextName = attackName;
        return this.monsterAttackTextName;
    }
}
