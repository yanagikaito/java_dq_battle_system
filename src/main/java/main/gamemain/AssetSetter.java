package main.gamemain;

import main.monster.GreenSlime;

import java.awt.Point;
import java.util.Random;

public class AssetSetter {
    GamePanel gamePanel;

    private final int MAX_MONSTERS = 8;
    private final int SPACING = 48;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setMonster() {
        Random random = new Random();

        // GreenSlimeのインスタンス数を最大8体に固定
        int numberOfMonsters = Math.min(random.nextInt(MAX_MONSTERS) + 1, MAX_MONSTERS);

        // 画面中央のX座標を計算
        int centerX = gamePanel.getScreenWidth() / 2;

        // 最初のGreenSlimeが配置されるX座標を計算（中央からのオフセットを考慮）
        int startX = centerX - (numberOfMonsters / 2 * SPACING) + (numberOfMonsters % 2 == 0 ? SPACING / 2 : 0);

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
}