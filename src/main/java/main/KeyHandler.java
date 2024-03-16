package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gamePanel;

    private boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;

    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            gamePanel.getBattleScreen().setCommandNum(gamePanel.getBattleScreen().getCommandNum() - 1);
            if (gamePanel.getBattleScreen().getCommandNum() < 0) {
                gamePanel.getBattleScreen().setCommandNum(3);
            }
        }
        if (code == KeyEvent.VK_S) {
            gamePanel.getBattleScreen().setCommandNum(gamePanel.getBattleScreen().getCommandNum() + 1);
            if (gamePanel.getBattleScreen().getCommandNum() > 3) {
                gamePanel.getBattleScreen().setCommandNum(0);
            }
        }

        if (code == KeyEvent.VK_W) {
            upPressed = true;

        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        //キーを離した時の反応
        if (code == KeyEvent.VK_W) {
            upPressed = false;

        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = false;
        }
    }
}