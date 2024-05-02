
package main.gamemain;

import main.monster.GreenSlime;
import main.player.Player;
import main.tile.TileManager;
import main.ui.BattleScreen;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {

    /**
     * .
     * 16x16のタイル プレイヤーやNPC,背景などのサイズ
     */
    private final int originalTileSize = 16;

    /**
     * .
     * scale スケーリング
     */
    private final int scale = 3;

    /**
     * .
     * 48x48のタイル
     */
    private int tileSize = originalTileSize * scale;

    /**
     * .
     * 横タイル16個
     */
    private final int maxScreenRow = 16;

    /**
     * .
     * 縦タイル12個
     */
    private final int maxScreenCol = 12;

    /**
     * .
     * ゲーム画面の横のサイズ768ピクセル
     */
    private final int screenWidth = tileSize * maxScreenRow;

    /**
     * .
     * ゲーム画面の高さは576ピクセル
     */
    private final int screenHeight = tileSize * maxScreenCol;

    /**
     * .
     * 最大横タイル50個
     */
    private final int maxWorldRow = 50;

    /**
     * .
     * 最大縦タイル50個
     */
    private final int maxWorldCol = 50;

    /**
     * .
     * FPS
     */
    private final int fps = 60;

    /**
     * .
     * 10憶ナノ秒
     */
    private final int nanosecond = 1000000000;

    /**
     * .
     * ゲームスレッド
     */
    private Thread gameThread;

    /**
     * .
     * ゲームの状態
     */
    private int gameState;

    /**
     * .
     * バトルの状態
     */
    private int battleState = 1;

    /**
     * .
     * プレイヤーの状態
     */
    private int playState = 0;

    /**
     * .
     * モンスターの種類
     */
    private final int monsterType = 10;

    /**
     * .
     * AssetSetterをインスタンス化
     */
    private final AssetSetter assetSetter = new AssetSetter(this);

    /**
     * .
     * KeyHandlerをインスタンス化
     */
    private KeyHandler keyHandler = new KeyHandler(this);

    /**
     * .
     * GreenSlime[]をインスタンス化
     */
    private final GreenSlime[] monsterGreenSlime = new GreenSlime[monsterType];

    /**
     * .
     * Playerをインスタンス化
     */
    private final Player player = new Player(this, monsterGreenSlime, keyHandler);

    /**
     * .
     * BattleScreenをインスタンス化
     */
    private BattleScreen battleScreen = new BattleScreen(this, assetSetter, player, monsterGreenSlime);


    /**
     * .
     * TileManagerをインスタンス化
     */
    private final TileManager tileManager = new TileManager(this);

    /**
     * .
     * CollisionCheckerをインスタンス化
     */
    private final CollisionChecker cChecker = new CollisionChecker(this);

    /**
     * .
     * EventHandlerをインスタンス化
     */
    private final EventHandler eventHandler = new EventHandler(this, assetSetter, player, monsterGreenSlime);

    /**
     * .
     * GamePanelコンストラクタを作成し,初期化。
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.setupGame();
        this.startGameThread();
    }

    /**
     * .
     * セットしたモンスターやNPCを呼び出す
     */
    public void setupGame() {

        assetSetter.setMonster();

    }

    /**
     * .
     * Threadをインスタンス化して,gameThreadを開始する
     */

    public void startGameThread() {

        gameThread = new Thread(this);
        // runメソッドが自動的に呼ばれる
        gameThread.start();

    }

    /**
     * .
     * runメソッドの中で1秒間に60回画像更新
     */

    @Override
    public void run() {
        double drawInterval = nanosecond / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;


        while (gameThread != null) {

            currentTime = System.nanoTime();
            // 1ループごとに経過時間をdrawIntervalで割っている
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= nanosecond) {
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    /**
     * .
     * プレイヤーやNPCやモンスターなどの画像を更新
     */

    public void update() {

        if (gameState == playState) {

            //　プレイヤー
            player.update();

            for (int i = 0; i < monsterGreenSlime.length; i++) {
                if (monsterGreenSlime[i] != null) {
                    monsterGreenSlime[i].update();
                }
            }
        }
    }

    /**
     * .
     * 画像を描画
     *
     * @param g the <code>Graphics</code> object to protect
     */

    public void paintComponent(final Graphics g) {

        Random random = new Random();

        int randomHitCol = 0;
        int randomHitRow = 0;

        int enemyRandom = 50;

        randomHitCol = random.nextInt(enemyRandom);
        randomHitRow = random.nextInt(enemyRandom);

        // superというのはこのクラスの親クラスこの場合JPanelとなる
        super.paintComponent(g);
        //  GraphicsをGraphics2Dに変換したことを意味している
        Graphics2D g2 = (Graphics2D) g;

        if (gameState == playState) {
            tileManager.draw(g2);
            player.draw(g2);
            eventHandler.draw(g2);
        } else if (gameState == battleState) {

            // 戦闘画面表示
            battleScreen.draw(34, 11, getBattleState(), g2);
            for (GreenSlime greenSlime : monsterGreenSlime) {
                if (greenSlime != null) {
                    greenSlime.draw(g2);
                }
            }
        }
    }

    /**
     * .
     * ゲッター getTileSize
     *
     * @return tileSize = 48;
     */

    public int getTileSize() {
        return this.tileSize;
    }

    /**
     * .
     * セッター setTileSize
     *
     * @param size = tileSize
     * @return this.tileSize;
     */

    public int setTileSize(final int size) {
        this.tileSize = size;
        return this.tileSize;
    }

    /**
     * .
     * ゲッター getGameState
     *
     * @return this.gameState;
     */
    public int getGameState() {
        return this.gameState;
    }

    public int setGameState(int state) {
        this.gameState = state;
        return this.gameState;
    }

    /**
     * .
     * ゲッター getBattleState
     *
     * @return this.battleState;
     */

    public int getBattleState() {
        return this.battleState;
    }

    /**
     * .
     * セッター getBattleState
     *
     * @param state = battleState
     * @return this.battleState;
     */

    public int setBattleState(int state) {
        this.battleState = state;
        return this.battleState;
    }


    /**
     * .
     * ゲッター getScreenWidth
     *
     * @return this.screenWidth;
     */

    public int getScreenWidth() {
        return this.screenWidth;
    }

    /**
     * .
     * ゲッター getScreenHeight
     *
     * @return this.screenHeight;
     */

    public int getScreenHeight() {
        return this.screenHeight;
    }

    /**
     * .
     * ゲッター getBattleScreen
     *
     * @return this.battleScreen;
     */

    public BattleScreen getBattleScreen() {
        return this.battleScreen;
    }

    /**
     * .
     * ゲッター getPlayer
     *
     * @return this.player;
     */

    public Player getPlayer() {
        return this.player;
    }

    /**
     * .
     * ゲッター getMaxWorldCol
     *
     * @return this.maxWorldCol;
     */

    public int getMaxWorldCol() {
        return this.maxWorldCol;
    }

    /**
     * .
     * ゲッター getMaxWorldRow
     *
     * @return this.maxWorldRow;
     */

    public int getMaxWorldRow() {
        return this.maxWorldRow;
    }

    /**
     * .
     * ゲッター getTileManager
     *
     * @return this.tileManager
     */

    public TileManager getTileManager() {
        return this.tileManager;
    }

    /**
     * .
     * ゲッター getCchecker
     *
     * @return this.cChecker
     */

    public CollisionChecker getCchecker() {
        return this.cChecker;
    }

    /**
     * .
     * ゲッター getGreenSlime
     *
     * @return this.monsterGreenSlime
     */

    public GreenSlime[] getGreenSlime() {
        return this.monsterGreenSlime;
    }

    /**
     * .
     * ゲッター getEventHandler
     *
     * @return this.eventHandler;
     */

    public EventHandler getEventHandler() {
        return this.eventHandler;
    }

    /**
     * .
     * プレイヤーの状態
     * ゲッター getPlayState
     *
     * @return this.playState;
     */

    public int getPlayState() {
        return this.playState;
    }
}