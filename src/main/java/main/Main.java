package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        // Xボタン追加 ウィンドウを閉じることができる。
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ウィンドウサイズを固定
        window.setResizable(false);
        window.setTitle("2D DQ");
    }
}