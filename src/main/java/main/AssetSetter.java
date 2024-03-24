package main;

import main.monster.GreenSlime;


public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setMonster() {
        gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel);
        gamePanel.monsterGreenSlime[1] = new GreenSlime(gamePanel);
        gamePanel.monsterGreenSlime[2] = new GreenSlime(gamePanel);
        gamePanel.monsterGreenSlime[3] = new GreenSlime(gamePanel);
        gamePanel.monsterGreenSlime[4] = new GreenSlime(gamePanel);
        gamePanel.monsterGreenSlime[5] = new GreenSlime(gamePanel);
    }
}
