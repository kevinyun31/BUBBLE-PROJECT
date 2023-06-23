package test.ex05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {

    // 위치 상태
    private int x;
    private int y;

    // 플레이어의 방향 상태
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    // 플레이어의 스피드
    private final int SPEED = 10; // x 축
    private final int JUMPSPEED = 5; // y 축

    private ImageIcon playerR, playerL;

    public Player() {
        initObject();
        initSetting();
    }

    private void initObject() {
        playerR = new ImageIcon("image/playerR.png");
        playerL = new ImageIcon("image/playerL.png");
    }

    private void initSetting() {
        x = 70;
        y = 535;

        left = false;
        right = false;
        up = false;
        down = false;

        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y);
    }

    // 이벤트 핸들러
    public void left() {
        System.out.println("레프트");
        left = true;
        new Thread(() -> {
            while (left) {
                setIcon(playerL);
                x = x - SPEED;
                setLocation(x, y);

                try {
                    Thread.sleep(10); // 0.01초
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void right() {
        System.out.println("라이트");
        right = true;
        new Thread(() -> {
            while (right) {
                setIcon(playerR);
                x = x + SPEED;
                setLocation(x, y);

                try {
                    Thread.sleep(10); // 0.01초
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void up() {
        System.out.println("위로");
        up = true;
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                y = y - JUMPSPEED;
                setLocation(x, y);
                try {
                    Thread.sleep(5); // 0.01초
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            up = false;
            down();
        }).start();
    }

    public void down() {
        System.out.println("아래로");
        down = true;
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                y = y + JUMPSPEED;
                setLocation(x, y);
                try {
                    Thread.sleep(2); // 0.01초
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            down = false;
        }).start();

    }

    ////////////////////////////////////// getter, setter
    ////////////////////////////////////// /////////////////////////////
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public ImageIcon getPlayerR() {
        return playerR;
    }

    public void setPlayerR(ImageIcon playerR) {
        this.playerR = playerR;
    }

    public ImageIcon getPlayerL() {
        return playerL;
    }

    public void setPlayerL(ImageIcon playerL) {
        this.playerL = playerL;
    }

}
