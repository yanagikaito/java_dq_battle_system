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

        int screenXmonsterA = random.nextInt(500) + 80;
        int screenYmonsterA = 200;

        int screenXmonsterB = random.nextInt(500) + 80;
        int screenYmonsterB = 200;

        int screenXmonsterC = random.nextInt(500) + 80;
        int screenYmonsterC = 200;

        if (screenXmonsterA == 80 || screenXmonsterB == 350 || screenXmonsterC == 500) {
            gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
        }
        if (screenXmonsterA == 80 || screenXmonsterB == 350 || screenXmonsterC == 500) {
            gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
            gamePanel.monsterGreenSlime[1] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
        }
        if (screenXmonsterA == 80 || screenXmonsterB == 350 || screenXmonsterC == 500) {
            gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
            gamePanel.monsterGreenSlime[1] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
            gamePanel.monsterGreenSlime[2] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
        } else {
            gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
            gamePanel.monsterGreenSlime[1] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
            gamePanel.monsterGreenSlime[2] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC);
        }
    }
}
