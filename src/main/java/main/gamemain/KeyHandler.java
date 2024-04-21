package main.gamemain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    /**
     * .
     * gamePanelをインスタンス変数宣言
     */
    private final GamePanel gamePanel;

    /**
     * .
     * キー　upPressed;
     */
    private boolean upPressed;

    /**
     * .
     * キー　downPressed;
     */
    private boolean downPressed;

    /**
     * .
     * キー　leftPressed;
     */
    private boolean leftPressed;

    /**
     * .
     * キー　rightPressed;
     */
    private boolean rightPressed;

    /**
     * .
     * キー　enterPressed;
     */
    private boolean enterPressed;

    /**
     * .
     * KeyHandlerコンストラクタを作成し,初期化
     *
     * @param panel = gamePanel
     */
    public KeyHandler(final GamePanel panel) {
        this.gamePanel = panel;
    }

    /**
     * .
     * keyTypedは使わない
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(final KeyEvent e) {

    }

    /**
     * .
     * keyPressedは押されたときに反応
     *
     * @param e the event to be processed
     */

    @Override
    public void keyPressed(final KeyEvent e) {

        int code = e.getKeyCode();

        if (gamePanel.getGameState() == gamePanel.getPlayState()) {
            checkPlayStateKeyPressed(code);
        } else if (gamePanel.getGameState() == gamePanel.getBattleState()) {
            checkBattleStateKeyPressed(code);
        }
    }

    private void checkBattleStateKeyPressed(int code) {
        if (gamePanel.getBattleState() == 0) {
            checkBattleScreenKeyPressed(code);
        } else if (gamePanel.getBattleState() == 1) {
            checkBattleENTERScreenKeyPressed(code);
        } else if (gamePanel.getBattleState() == 2) {
            checkBattleENTERattackKeyPressed(code);
        }
    }

    private void checkBattleScreenKeyPressed(int code) {
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
    }

    private void checkBattleENTERScreenKeyPressed(int code) {
        if (code == KeyEvent.VK_ENTER) {
            // コマンド番号 コマンド番号がゼロの場合、次のコマンドを選択。
            if (gamePanel.getBattleScreen().getCommandNum() == 0) {
                gamePanel.getBattleScreen().setBattleScreenState(1);
                if (gamePanel.getBattleScreen().getCommandNum() < 0) {
                    gamePanel.getBattleScreen().setCommandNum(3);
                }
                if (gamePanel.getBattleScreen().getCommandNum() > 3) {
                    gamePanel.getBattleScreen().setCommandNum(0);
                }
            }
        }
        checkBattleENTERattackKeyPressed(code);
    }

    private void checkBattleENTERattackKeyPressed(int code) {
        if (code == KeyEvent.VK_SPACE) {
            gamePanel.getBattleScreen().setCommandNum(gamePanel.getBattleScreen().getCommandNum() + 1);
            if (gamePanel.getBattleScreen().getCommandNum() == 1) {
                gamePanel.getBattleScreen().setBattleScreenState(2);
            }
        }
    }


    private void checkPlayStateKeyPressed(int code) {
        checkMovementKeys(code);
    }

    private void checkMovementKeys(int code) {
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
        if (code == KeyEvent.VK_SPACE) {
            enterPressed = true;
        }
    }

    /**
     * .
     * keyReleasedは離した時に反応
     *
     * @param e the event to be released
     */

    @Override
    public void keyReleased(final KeyEvent e) {

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
        if (code == KeyEvent.VK_SPACE) {
            enterPressed = false;
        }
    }


    /**
     * .
     * ゲッター getUp
     *
     * @return this.upPressed;
     */
    public Boolean getUp() {
        return this.upPressed;
    }

    /**
     * .
     * ゲッター getDown
     *
     * @return this.upPressed;
     */
    public Boolean getDown() {
        return this.downPressed;
    }

    /**
     * .
     * ゲッター getLeft
     *
     * @return this.upPressed;
     */
    public Boolean getLeft() {
        return this.leftPressed;
    }

    /**
     * .
     * ゲッター getRight
     *
     * @return this.upPressed;
     */
    public Boolean getRight() {
        return this.rightPressed;
    }

    /**
     * .
     * ゲッター getEnter
     *
     * @return this.upPressed;
     */
    public Boolean getEnter() {
        return this.enterPressed;
    }
}