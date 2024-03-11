package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

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

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));

        this.setBackground(Color.BLACK);

        this.setDoubleBuffered(true);

        this.setFocusable(true);
    }
}
