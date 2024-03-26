import java.util.Random;

public class Sample {
    public static void main(String[] args) {
        Random random = new Random();

        // GreenSlimeのインスタンス数を最大8体に固定
        int numberOfMonsters = Math.min(random.nextInt(8) + 1, 8);

        // 画面中央のX座標を計算
        int centerX = 768;

        int startX = centerX - (numberOfMonsters / 2 * 44) + (numberOfMonsters % 2 == 0 ? 44 / 2 : 0);
        System.out.println(1 / 2 * 44);
        System.out.println(2 / 2 * 44);
        System.out.println(3 / 2 * 44);
        System.out.println(4 / 2 * 44);
        System.out.println(5 / 2 * 44);
        System.out.println(6 / 2 * 44);
        System.out.println(7 / 2 * 44);
        System.out.println(8 / 2 * 44);
        System.out.println("startX = " + startX);
        System.out.println(centerX / 48);
    }
}