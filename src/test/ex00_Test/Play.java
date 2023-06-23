package test.ex00_Test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Play extends JLabel {

    private int x;
    private int y;

    private ImageIcon playR, playL;

    public Play() {
        initObject();
        initSetting();
    }

    private void initObject() {
        playR = new ImageIcon("image/playR.png");
        playL = new ImageIcon("image/playL.png");
    }

    private void initSetting() {
        x = 70;
        y = 535;

        setIcon(playR);
        setSize(50, 50);
        setLocation(x, y);
    }

}
