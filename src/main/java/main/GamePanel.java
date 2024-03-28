package main;

import main.monster.GreenSlime;
import main.player.Player;
import main.ui.BattleScreen;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // 16x16のタイル プレイヤーやNPC,背景などのサイズ
    private final int originalTileSize = 16;

    // scale スケーリング
    private final int scale = 3;

    // 48x48のタイル
    private int tileSize = originalTileSize * scale;

    // 水平に16　垂直に12
    // 画面比率は 4 : 3

    //横タイル16個
    private final int maxScreenRow = 16;

    //縦タイル12個
    private final int maxScreenCol = 12;

    // ゲーム画面の横のサイズ768ピクセル
    private final int screenWidth = tileSize * maxScreenRow;

    // ゲーム画面の高さは576ピクセル
    private final int screenHeight = tileSize * maxScreenCol;

    // FPS
    private int FPS = 60;

    private Thread gameThread;

    private int gameState;

    private final int battleState = 1;

    private final int playState = 0;

    private BattleScreen battleScreen = new BattleScreen(this);

    private KeyHandler keyHandler = new KeyHandler(this);

    private Player player = new Player(this, keyHandler);

    public GreenSlime[] monsterGreenSlime = new GreenSlime[10];

    public AssetSetter assetSetter = new AssetSetter(this);

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));

        this.setBackground(Color.BLACK);

        this.setDoubleBuffered(true);

        this.addKeyListener(keyHandler);

        this.setFocusable(true);
    }

    public void setupGame() {

        assetSetter.setMonster();

    }

    public void startGameThread() {

        gameThread = new Thread(this);
        // runメソッドが自動的に呼ばれる
        gameThread.start();

    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
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

            if (timer >= 1000000000) {
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

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

    public void paintComponent(Graphics g) {

        // superというのはこのクラスの親クラスこの場合JPanelとなる
        super.paintComponent(g);
        //  GraphicsをGraphics2Dに変換したことを意味している
        Graphics2D g2 = (Graphics2D) g;

        if (gameState == playState) {
            player.draw(g2);
        }
        // 戦闘画面表示
        if (gameState == battleState) {
            battleScreen.draw(g2);
            for (GreenSlime greenSlime : monsterGreenSlime) {
                if (greenSlime != null) {
                    greenSlime.draw(g2);
                }
            }
        }
    }


    public int getTileSize() {
        return tileSize;
    }

    public int setTileSize(int tileSize) {
        return this.tileSize = tileSize;
    }

    public int getGameState() {
        return gameState;
    }

    public int getBattleState() {
        return battleState;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public BattleScreen getBattleScreen() {
        return battleScreen;
    }

    public Player getPlayer() {
        return player;
    }
}