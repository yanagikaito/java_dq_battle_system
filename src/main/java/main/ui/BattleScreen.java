package main.ui;

import main.GamePanel;

import java.awt.*;

public class BattleScreen {

    GamePanel gamePanel;

    Graphics2D graphics2D;

    // フォント 80BはBOLD
    Font arial_40, arial_80B;

    private int battleScreenState = 0;

    private String currentDialogue = "";

    private int commandNum = 0;

    public BattleScreen(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        // ゲームループが開始する前にインスタンス化を完了できるようにする。
        arial_40 = new Font("エリア", Font.PLAIN, 40);
        arial_80B = new Font("エリア", Font.BOLD, 80);
    }

    public void draw(Graphics2D graphics2D) {

        // このクラスの他のメソッドでこのg2を使用できるようになります。
        this.graphics2D = graphics2D;


        // フォント設定 arialエリア
        // 色は白色に設定
        graphics2D.setFont(arial_40);
        graphics2D.setColor(Color.white);

        // 戦闘画面
        if (gamePanel.getGameState() == gamePanel.getBattleState()) {
            drawBattleScreen();
            drawDialogueScreen();
            drawCommandScreen();
        }
    }

    public void drawBattleScreen() {

        // バトル画面の状態をチェックする。
        if (battleScreenState == 0) {

            graphics2D.setColor(new Color(0, 0, 0));
            graphics2D.fillRect(0, 0, gamePanel.getScreenWidth(), gamePanel.getScreenHeight());

            graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 45F));

            String playerText = "勇者";
            String playerHpText = "HP100";
            String playerCommandBattle = "たたかう";
            String playerCommandFlee = "にげる";
            String selectCommandBattle = ">";
            String selectCommandFlee = ">";

            int playerTextX = getXforCenteredText(playerText);
            int playerTextY = gamePanel.getTileSize() * 2;

            int playerHpTextX = gamePanel.getTileSize() * 2;
            int playerHpTextY = gamePanel.getTileSize() * 3;

            int commandBattleX = gamePanel.getTileSize() * 2;
            int commandBattleY = gamePanel.getTileSize() * 9;

            int commandFleeX = gamePanel.getTileSize() * 2;
            int commandFleeY = gamePanel.getTileSize() * 11;

            int playerSelectCommandBattleX = gamePanel.getTileSize() + 28;
            int playerSelectCommandBattleY = gamePanel.getTileSize() * 9;

            int playerSelectCommandFleeX = gamePanel.getTileSize() + 28;
            int playerSelectCommandFleeY = gamePanel.getTileSize() * 11;

            graphics2D.setColor(Color.white);

            // 文字列をxとyに描画する。
            graphics2D.drawString(playerText, playerTextX, playerTextY);
            graphics2D.drawString(playerHpText, playerHpTextX, playerHpTextY);
            graphics2D.drawString(playerCommandBattle, commandBattleX, commandBattleY);
            graphics2D.drawString(playerCommandFlee, commandFleeX, commandFleeY);
            if (commandNum == 0) {
                graphics2D.drawString(selectCommandBattle, playerSelectCommandBattleX, playerSelectCommandBattleY);
            }
            if (commandNum == 1) {
                graphics2D.drawString(selectCommandFlee, playerSelectCommandFleeX, playerSelectCommandFleeY);
            }
        } else if (battleScreenState == 1) {

            graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 45F));

            String playerText = "勇者";
            String playerHpText = "HP100";
            String playerCommandAttack = "こうげき";
            String selectCommandAttack = ">";

            int playerTextX = getXforCenteredText(playerText);
            int playerTextY = gamePanel.getTileSize() * 2;

            int playerHpTextX = gamePanel.getTileSize() * 2;
            int playerHpTextY = gamePanel.getTileSize() * 3;

            int commandAttackX = gamePanel.getTileSize() * 2;
            int commandAttackY = gamePanel.getTileSize() * 9;

            int playerSelectCommandAttackX = gamePanel.getTileSize() + 28;
            int playerSelectCommandAttackY = gamePanel.getTileSize() * 9;

            graphics2D.setColor(Color.white);

            graphics2D.drawString(playerText, playerTextX, playerTextY);
            graphics2D.drawString(playerHpText, playerHpTextX, playerHpTextY);
            graphics2D.drawString(playerCommandAttack, commandAttackX, commandAttackY);
            graphics2D.drawString(selectCommandAttack, playerSelectCommandAttackX, playerSelectCommandAttackY);
        }
    }

    public void drawDialogueScreen() {

        // ウィンドウ
        int x = gamePanel.getTileSize();
        int y = gamePanel.getTileSize() / 2;
        int width = gamePanel.getScreenWidth() - (gamePanel.getTileSize() * 11);
        int height = gamePanel.getTileSize() * 3;

        drawSubWindow(x, y, width, height);

        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 28F));
        x += gamePanel.getTileSize();
        y += gamePanel.getTileSize();

        for (String line : currentDialogue.split("\n")) {
            graphics2D.drawString(line, x, y);
            y += 40;
        }
    }

    public void drawCommandScreen() {

        // ウィンドウ
        int x = gamePanel.getTileSize();
        int y = gamePanel.getTileSize() * 8;
        int width = gamePanel.getScreenWidth() - (gamePanel.getTileSize() * 10);
        int height = gamePanel.getTileSize() * 4;

        drawCommandWindow(x, y, width, height);

        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 28F));
        x += gamePanel.getTileSize();
        y += gamePanel.getTileSize();

        for (String line : currentDialogue.split("\n")) {
            graphics2D.drawString(line, x, y);
            y += 40;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height) {

        // new Color(int,int,int) = Create an RGB color(red green blue)
        // 4番目はアルファ値と呼ばれ透明度,不透明のレベルを表す値
        // アルファ値は数字が低いほど透明なります
        Color c = new Color(0, 0, 0, 0);
        graphics2D.setColor(c);

        // ラウンドレクト丸い四角形を描画
        // fillRoundRect(x,y,width,height,arcWidth,arcHeight);
        // arc 円弧 円周の一部
        graphics2D.fillRoundRect(x, y, width, height, 35, 35);

        // RGBの白色の番号
        c = new Color(255, 255, 255);
        graphics2D.setColor(c);
        // width - BasicStrokeの幅。
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);

    }

    public void drawCommandWindow(int x, int y, int width, int height) {

        Color c = new Color(0, 0, 0, 0);
        graphics2D.setColor(c);

        graphics2D.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        graphics2D.setColor(c);

        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);

    }

    public int getXforCenteredText(String text) {
        int length = (int) graphics2D.getFontMetrics().getStringBounds(text, graphics2D).getWidth();
        int x = gamePanel.getScreenWidth() / 6 - length / 6;
        return x;
    }

    public int getCommandNum() {
        return commandNum;
    }

    public int setCommandNum(int commandNum) {
        return this.commandNum = commandNum;
    }

    public int getBattleScreenState() {
        return battleScreenState;
    }

    public int setBattleScreenState(int battleScreenState) {
        return this.battleScreenState = battleScreenState;
    }
}
