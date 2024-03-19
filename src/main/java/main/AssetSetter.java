package main;

import main.monster.GreenSlime;

public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setMonster() {

        gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel);
        gamePanel.monsterGreenSlime[0].worldX = gamePanel.getTileSize() * 23;
        gamePanel.monsterGreenSlime[0].worldY = gamePanel.getTileSize() * 40;

        gamePanel.monsterGreenSlime[1] = new GreenSlime(gamePanel);
        gamePanel.monsterGreenSlime[1].worldX = gamePanel.getTileSize() * 23;
        gamePanel.monsterGreenSlime[1].worldY = gamePanel.getTileSize() * 46;
    }
}
