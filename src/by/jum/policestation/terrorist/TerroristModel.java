package by.jum.policestation.terrorist;

import by.jum.policestation.resourse.Control;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TerroristModel {
    public void moveTerrorist(JFrame frame, TerroristView terrorist) {
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == Control.RIGHT) {
                    terrorist.setBounds((int) terrorist.getBounds().getX() + 200, (int) terrorist.getBounds().getY(), 40, 93);
                } else if (e.getKeyCode() == Control.LEFT) {
                    terrorist.setBounds((int) terrorist.getBounds().getX() - 200, (int) terrorist.getBounds().getY(), 40, 93);
                }
            }
        });
    }


}
