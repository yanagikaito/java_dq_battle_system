
package main.gamemain;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    /**
     * .
     * GamePanelをインスタンス化。
     */
    private final GamePanel gamePanel = new GamePanel();

    /**
     * .
     * GameFrameコンストラクタを作成し,初期化
     */
    public GameFrame() {
        // Xボタン追加 ウィンドウを閉じることができる。
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ウィンドウサイズを固定
        super.setResizable(false);
        super.setTitle("2D DQ");

        super.add(gamePanel);
        super.pack();

        //ウィンドウがスクリーンの中央に固定
        super.setLocationRelativeTo(null);
        // ウィンドウが画面に表示されるようになる
        super.setVisible(true);
    }
}
