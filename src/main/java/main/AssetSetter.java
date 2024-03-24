package main;

import main.monster.GreenSlime;

public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setMonster() {

        gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel);
        gamePanel.monsterGreenSlime[0].screenXmonsterA = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
        gamePanel.monsterGreenSlime[0].screenYmonsterA = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
        gamePanel.monsterGreenSlime[1] = new GreenSlime(gamePanel);
        gamePanel.monsterGreenSlime[1].screenXmonsterB = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
        gamePanel.monsterGreenSlime[1].screenYmonsterB = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
        gamePanel.monsterGreenSlime[2] = new GreenSlime(gamePanel);
        gamePanel.monsterGreenSlime[2].screenXmonsterC = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
        gamePanel.monsterGreenSlime[2].screenYmonsterC = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
        gamePanel.monsterGreenSlime[3] = new GreenSlime(gamePanel);
        gamePanel.monsterGreenSlime[3].screenXmonsterD = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
        gamePanel.monsterGreenSlime[3].screenYmonsterD = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
        gamePanel.monsterGreenSlime[4] = new GreenSlime(gamePanel);
        gamePanel.monsterGreenSlime[4].screenXmonsterE = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
        gamePanel.monsterGreenSlime[4].screenYmonsterE = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
        gamePanel.monsterGreenSlime[5] = new GreenSlime(gamePanel);
        gamePanel.monsterGreenSlime[5].screenXmonsterF = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
        gamePanel.monsterGreenSlime[5].screenYmonsterF = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
    }
}
