package test.ex062;

import java.awt.Color;
import java.awt.font.TextHitInfo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 메인 쓰레드는 바쁨 ~ 키보드 이벤트를 처리하기 바쁨
// 백그라운드에서 관찰
public class BackgroundPlayerService implements Runnable {

    private Player player;
    private BufferedImage image;

    public BackgroundPlayerService(Player player) {
        this.player = player;

        File file = new File("image/test.png");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            Color color = new Color(image.getRGB(player.getX(), player.getY()));

            System.out.println("보글이의 위치의 빨간색상 : " + color.getRed());
            System.out.println("보글이의 위치의 초록색상 : " + color.getGreen());
            System.out.println("보글이의 위치의 블루색상 : " + color.getBlue());
            System.out.println("보글이의 x값 : " + player.getX());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
