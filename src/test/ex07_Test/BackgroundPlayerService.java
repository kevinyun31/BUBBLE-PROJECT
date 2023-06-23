package test.ex07_Test;

public class BackgroundPlayerService implements Runnable {

    private BufferedImage image;
    private Player player;

    @Override
    public void run() {
        // 실의 길이
        while (true) {
            // 색상 확인
            Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
            Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
            // System.out.println("leftColor : "+leftColor);
            // System.out.println("rightColor : "+rightColor);

            if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
                System.out.println("왼쪽 벽에 충돌함");
            } else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
                System.out.println("오른쪽 벽에 충돌함");
            }

            try {
                System.out.println("나 이제 쉴꼐");
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
