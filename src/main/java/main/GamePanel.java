package main;

import main.ui.BattleScreen;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // 16x16のタイル プレイヤーやNPC,背景などのサイズ
    private final int originalTileSize = 16;

    // scale スケーリング
    private final int scale = 3;

    // 48x48のタイル
    private final int tileSize = originalTileSize * scale;

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

    private final int battleState = 0;

    private BattleScreen battleScreen = new BattleScreen(this);

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));

        this.setBackground(Color.BLACK);

        this.setDoubleBuffered(true);

        this.setFocusable(true);
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

    }

    public void paintComponent(Graphics g) {

        // superというのはこのクラスの親クラスこの場合JPanelとなる
        super.paintComponent(g);
        //  GraphicsをGraphics2Dに変換したことを意味している
        Graphics2D g2 = (Graphics2D) g;

        // スクリーンタイトル
        if (gameState == battleState) {
            battleScreen.draw(g2);

        }
    }

    public int getTileSize() {
        return tileSize;
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
}