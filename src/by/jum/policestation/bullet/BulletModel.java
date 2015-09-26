package by.jum.policestation.bullet;

import by.jum.policestation.resourse.Position;

import javax.swing.Timer;

public class BulletModel {
    private Timer timer;

    public void startBullet(BulletView bullet) {
        timer = new Timer(10, e -> {
            bullet.setBounds((int) bullet.getBounds().getX(), (int) bullet.getBounds().getY() - 7, 10, 15);
            checkOut(bullet);
        });
        timer.start();
    }

    public void stopBullet() {
        timer.stop();
    }

    private void checkOut(BulletView bullet) {
        if (bullet.getY() < Position.BULLET_OUT.getPosition()) {
            bullet.setVisible(false);
            stopBullet();
        }
    }
}
