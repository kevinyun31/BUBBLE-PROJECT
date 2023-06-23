package test.ex07_Test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

// class Player -> new 가능한 애들!! 게임에 존재할 수 있음. (추상메서드를 가질 수 없다.)
public class Player extends JLabel {

    // 위치 상태
    private int x;
    private int y;

    // 플레이어의 방향 상태
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    private boolean leftWallCrash;
    private boolean rightWallCrash;

    // class Player -> new 가능한 애들!! 게임에 존재할 수 있음. ()

    @Getter
    @Setter

    private ImageIcon playerR, playerL;

    public Player() {
        initObject();
        initSetting();
        new Thread(new BackgroundPlayerService()).start();
    }

    private void initObject() {
        playerR = new ImageIcon("image/playerR.png");
        playerL = new ImageIcon("image/playerL.png");
    }

    private void initSetting() {
        x = 55;
        y = 535;

        left = false;
        right = false;
        up = false;
        left = false;

        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y);
    }

    // 이벤트 핸들러
    public void left() {
        System.out.println("left 메서드 실행됨");
        left = true;
        new Thread(() -> {
            while (left) {
                setIcon(playerL);
                x = x - 10;
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
        System.out.println("right 메서드 실행됨");
        right = true;
        new Thread(() -> {
            while (right) {
                setIcon(playerR);
                x = x + 10;
                setLocation(x, y);

                try {
                    Thread.sleep(10); // 0.01초
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
