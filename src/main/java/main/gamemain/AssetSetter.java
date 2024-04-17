package main.gamemain;

import main.monster.GreenSlime;

import java.awt.Point;
import java.util.Random;

public class AssetSetter {
    private GamePanel gamePanel;

    private Random random = new Random();

    private final int MAX_MONSTERS = 8;
    private final int SPACING = 48;

    // GreenSlimeのインスタンス数を最大8体に固定
    private int numberOfMonsters = Math.min(random.nextInt(MAX_MONSTERS) + 1, MAX_MONSTERS);

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setMonster() {

        // 画面中央のX座標を計算
        final int centerX = gamePanel.getScreenWidth() / 2;

        // 最初のGreenSlimeが配置されるX座標を計算（中央からのオフセットを考慮）
        final int startX = centerX - (numberOfMonsters / 2 * SPACING) + (numberOfMonsters % 2 == 0 ? SPACING / 2 : 0);
        for (int i = 0; i < numberOfMonsters; i++) {
            gamePanel.getGreenSlime()[i] = createGreenSlime(startX, i);
        }
    }

    private GreenSlime createGreenSlime(final int startX, final int index) {
        int screenY = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
        // 各モンスターのX座標を等間隔に設定
        int screenX = startX + index * SPACING;

        Point position = new Point(screenX, screenY);

        return new GreenSlime(gamePanel, new Point[]{position});
    }

    public int getNumberOfMonsters() {
        return this.numberOfMonsters;
    }
}