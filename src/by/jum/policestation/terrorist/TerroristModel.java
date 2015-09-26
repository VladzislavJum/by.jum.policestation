package by.jum.policestation.terrorist;

import by.jum.policestation.controller.Control;
import by.jum.policestation.resourse.Position;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TerroristModel {
    public void moveTerrorist(JFrame frame, TerroristView terrorist) {
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == Control.RIGHT) {
                    if (terrorist.getBounds().getX() == 1380) {
                        terrorist.setBounds((int) terrorist.getBounds().getX() - Position.NEXT_BOX_DIFF.getPosition() * 6,
                                (int) terrorist.getBounds().getY(), 40, 93);
                        return;
                    }
                    terrorist.setBounds((int) terrorist.getBounds().getX() + Position.NEXT_BOX_DIFF.getPosition(),
                            (int) terrorist.getBounds().getY(), 40, 93);

                } else if (e.getKeyCode() == Control.LEFT) {
                    if (terrorist.getBounds().getX() == 180) {
                        terrorist.setBounds((int) terrorist.getBounds().getX() + Position.NEXT_BOX_DIFF.getPosition() * 6,
                                (int) terrorist.getBounds().getY(), 40, 93);
                        return;
                    }
                    terrorist.setBounds((int) terrorist.getBounds().getX() - Position.NEXT_BOX_DIFF.getPosition(),
                            (int) terrorist.getBounds().getY(), 40, 93);

                }
            }
        });
    }


}
