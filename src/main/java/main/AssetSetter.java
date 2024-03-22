package main;

import main.monster.GreenSlime;

import java.util.Random;

public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setMonster() {

        Random random = new Random();

        int randomMonster = random.nextInt(3) + 1;

        int screenXmonsterA = 80;
        int screenYmonsterA = 200;

        int screenXmonsterB = 230;
        int screenYmonsterB = 200;

        int screenXmonsterC = 380;
        int screenYmonsterC = 200;

        if (randomMonster == 1) {
            gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
        } else if (randomMonster == 2) {
            gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
            gamePanel.monsterGreenSlime[1] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
        } else if (randomMonster == 3) {
            gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
            gamePanel.monsterGreenSlime[1] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
            gamePanel.monsterGreenSlime[2] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
        }
    }
}

