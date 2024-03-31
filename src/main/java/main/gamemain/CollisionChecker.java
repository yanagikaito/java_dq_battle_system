package main.gamemain;

import main.entity.Entity;
import main.gamemain.GamePanel;

public class CollisionChecker {
    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity) {

        // solidArea 固体領域で正方形の形
        // solidArea.x = 8
        // solidArea.y = 16
        // solidArea.width = 32
        // solidArea.height = 32

        int entityLeftWorldX = entity.getWorldX() + entity.getSolidArea().x;

        int entityRightWorldX = entity.getWorldX() + entity.getSolidArea().x + entity.getSolidArea().width;

        int entityTopWorldY = entity.getWorldY() + entity.getSolidArea().y;

        int entityBottomWorldY = entity.getWorldY() + entity.getSolidArea().y + entity.getSolidArea().height;

        int entityLeftCol = entityLeftWorldX / gamePanel.getTileSize();
        int entityRightCol = entityRightWorldX / gamePanel.getTileSize();
        int entityTopRow = entityTopWorldY / gamePanel.getTileSize();
        int entityBottomRow = entityBottomWorldY / gamePanel.getTileSize();

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gamePanel.getTileSize();
                tileNum1 = gamePanel.getTileManager().mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.getTileManager().mapTileNum[entityRightCol][entityTopRow];

                if (gamePanel.getTileManager().tile[tileNum1].collision == true || gamePanel.getTileManager().tile[tileNum2].collision == true) {
                    entity.setCollisionOn(true);
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gamePanel.getTileSize();

                tileNum1 = gamePanel.getTileManager().mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.getTileManager().mapTileNum[entityRightCol][entityBottomRow];

                if (gamePanel.getTileManager().tile[tileNum1].collision == true || gamePanel.getTileManager().tile[tileNum2].collision == true) {
                    entity.setCollisionOn(true);
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gamePanel.getTileSize();

                tileNum1 = gamePanel.getTileManager().mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.getTileManager().mapTileNum[entityLeftCol][entityBottomRow];

                if (gamePanel.getTileManager().tile[tileNum1].collision == true || gamePanel.getTileManager().tile[tileNum2].collision == true) {
                    entity.setCollisionOn(true);
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gamePanel.getTileSize();

                tileNum1 = gamePanel.getTileManager().mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.getTileManager().mapTileNum[entityRightCol][entityBottomRow];

                if (gamePanel.getTileManager().tile[tileNum1].collision == true || gamePanel.getTileManager().tile[tileNum2].collision == true) {
                    entity.setCollisionOn(true);
                }
                break;
        }
    }
}

