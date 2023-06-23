package test.ex00_Test;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Bubble extends JFrame {

    private JLabel backgroundMap;
    private Play play;

    public Bubble() {
        initObject();
        initListener();
        initSetting();
        setVisible(true);

    }

    private void initObject() {
        backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
        setContentPane(backgroundMap);

        play = new Play();
        add(play);

    }

    private void initSetting() {
        setSize(1000, 640);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initListener() {
        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    play.right();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    play.left();
                }
            }
        });
    }

    public static void main(String[] args) {
        new Bubble();
    }

}
