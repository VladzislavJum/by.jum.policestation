package by.jum.policestation.bullet;

import javax.swing.Timer;

public class BulletModel {
    private Timer timer;

    public void startBullet(BulletView bullet) {
        timer = new Timer(10, e -> {
            bullet.setBounds((int) bullet.getBounds().getX(), (int) bullet.getBounds().getY() - 7, 10, 15);
            if (bullet.getY() < 160) {
                bullet.setVisible(false);
                stopBullet();
            }
        });
        timer.start();
    }

    public void stopBullet() {
        timer.stop();
    }
}
