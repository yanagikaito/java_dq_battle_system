package main.gamemain;

import main.ui.BattleScreen;

import java.awt.*;
import java.util.Random;

public class EventHandler {
    GamePanel gamePanel;

    Graphics2D graphics2D;

    BattleScreen battleScreen;

    // 2次元の配列として使用し、コンストラクタの中でインスタンス化します。
    EventRect eventRect[][];

    boolean canTouchEvent = true;

    // 以前のイベント

    int previousEventX, previousEventY;

    Random random = new Random();

    public EventHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        battleScreen = new BattleScreen(gamePanel);
        // マップ上のすべてのタイルにイベント矩形ができる。
        // このソリッドエリアをeventRect[][]に設定。
        eventRect = new EventRect[gamePanel.getMaxWorldCol()][gamePanel.getMaxWorldRow()];

        int col = 0;
        int row = 0;
        while (col < gamePanel.getMaxWorldCol() && row < gamePanel.getMaxWorldRow()) {

            eventRect[col][row] = new EventRect();
            eventRect[col][row].x = 23;
            eventRect[col][row].y = 23;
            eventRect[col][row].width = 2;
            eventRect[col][row].height = 2;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;

            col++;
            if (col == gamePanel.getMaxWorldRow()) {
                col = 0;
                row++;
            }
        }
    }

    public void checkEvent() {
        int randomHitCol = 0;
        int randomHitRow = 0;

        int enemyRandom = 50;

        randomHitCol = random.nextInt(enemyRandom);
        randomHitRow = random.nextInt(enemyRandom);

        // プレイヤーキャラクターが最後のイベントから1タイル以上離れているかチェック。
        // mass absはこの絶対値を返す
        // この計算により、たとえ負の数であっても正の数として返される。
        int xDistance = Math.abs(gamePanel.getPlayer().getWorldX() - previousEventX);
        int yDistance = Math.abs(gamePanel.getPlayer().getWorldY() - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if (distance > gamePanel.getTileSize()) {
            canTouchEvent = true;
        }

        if (hit(34, 11, "どれか")) {
            battleScreen.draw(34, 11, gamePanel.setGameState(gamePanel.getBattleState()), graphics2D);
        }
    }


    // イベントの衝突をチェックするメソッドで、オブジェクトと似たような働きをする。
    public boolean hit(int col, int row, String reqDirection) {

        boolean hit = false;

        gamePanel.getPlayer().solidArea.x = gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().solidArea.x;
        gamePanel.getPlayer().solidArea.y = gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().solidArea.y;
        eventRect[col][row].x = col * gamePanel.getTileSize() + eventRect[col][row].x;
        eventRect[col][row].y = row * gamePanel.getTileSize() + eventRect[col][row].y;

        // intersexメソッドを使い、プレイヤーが衝突しているかどうかをチェック。
        if (gamePanel.getPlayer().solidArea.intersects(eventRect[col][row]) && eventRect[col][row].eventDone == false) {
            // プレーヤーの方向をチェックできて,どちらのイベントが起こるかを選択。
            if (gamePanel.getPlayer().getDirection().contentEquals(reqDirection) || reqDirection.contentEquals("どれか")) {
                hit = true;
                // プレイヤーキャラクターがイベントの矩形から1タイル分離れるまで
                // 二度と起きないようにすれば、イベントが繰り返し起きるのを防げる
                previousEventX = gamePanel.getPlayer().getWorldX();
                previousEventY = gamePanel.getPlayer().getWorldY();
            }
        }
        // 最後に、プレーヤーとイベント矩形をリセット。
        gamePanel.getPlayer().solidArea.x = gamePanel.getPlayer().solidAreaDefaultX;
        gamePanel.getPlayer().solidArea.y = gamePanel.getPlayer().solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;
        // 衝突している場合はtrueを返す。
        return hit;
    }

    public void draw(Graphics2D g2) {

        int randomHitColRow = 0;

        int enemyRandom = 50;

        randomHitColRow = random.nextInt(enemyRandom) + 1;

        // このクラスの他のメソッドでこのg2を使用できる。
        this.graphics2D = g2;

        // バトル画面
        if (gamePanel.getGameState() == gamePanel.getBattleState()) {
            battleScreen.draw(34, 11, gamePanel.setGameState(gamePanel.getBattleState()), g2);
        }
    }
}
