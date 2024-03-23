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

        int screenXmonsterA = random.nextInt(620) + 80;
        int screenYmonsterA = 200;

        int screenXmonsterB = random.nextInt(620) + 80;
        int screenYmonsterB = 200;

        int screenXmonsterC = random.nextInt(620) + 80;
        int screenYmonsterC = 200;

        int screenXmonsterD = random.nextInt(620) + 80;
        int screenYmonsterD = 200;

        int screenXmonsterE = random.nextInt(620) + 80;
        int screenYmonsterE = 200;

        int screenXmonsterF = random.nextInt(620) + 80;
        int screenYmonsterF = 200;

        if (screenXmonsterA > screenXmonsterB) {
            gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
        } else if (screenXmonsterB > screenXmonsterC) {
            gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[1] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
        } else if (screenXmonsterC > screenXmonsterB) {
            gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[1] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[2] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
        } else if (screenXmonsterD > screenXmonsterE) {
            gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[1] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[2] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[3] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
        } else if (screenXmonsterE > screenXmonsterF) {
            gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[1] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[2] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[3] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[4] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
        } else if (screenXmonsterF > screenXmonsterA) {
            gamePanel.monsterGreenSlime[0] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[1] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[2] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[3] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[4] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
            gamePanel.monsterGreenSlime[5] = new GreenSlime(gamePanel, screenXmonsterA, screenYmonsterA,
                    screenXmonsterB, screenYmonsterB, screenXmonsterC, screenYmonsterC, screenXmonsterD, screenYmonsterD,
                    screenXmonsterE, screenYmonsterE, screenXmonsterF, screenYmonsterF);
        }
    }
}