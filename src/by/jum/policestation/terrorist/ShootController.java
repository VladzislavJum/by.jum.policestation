package by.jum.policestation.terrorist;

import by.jum.policestation.bullet.BulletController;
import by.jum.policestation.bullet.BulletModel;
import by.jum.policestation.bullet.BulletView;
import by.jum.policestation.car.CarController;
import by.jum.policestation.resourse.Control;
import by.jum.policestation.window.ShootingPanelModel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ShootController {
    private JPanel panel;
    private TerroristView terrorist;
    private CarController carController;
    private Thread thread;
    private ShootingPanelModel shootingPanelModel;

    private BulletView bullet;

    public ShootController(JPanel panel, TerroristView terrorist, CarController carController, ShootingPanelModel shootingPanelModel) {
        this.panel = panel;
        this.terrorist = terrorist;
        this.carController = carController;
        this.shootingPanelModel = shootingPanelModel;
    }

    public void addMovingBullet(JFrame frame) {

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == Control.FIRE) {
                    bullet = new BulletView();
                    bullet.setBounds(terrorist.getX() + 16, terrorist.getY() - 11, 10, 15);
                    panel.add(bullet);

                    BulletController bulletController = new BulletController(bullet, new BulletModel());
                    bulletController.runBullet();

                    int distance = bullet.getY() - carController.getAlignmentY() - 80;
                    System.out.println(distance + " " + carController.getAlignmentY());

                    long time = (long) (distance / 1.1);
                    if (carController.getAlignmentX() + 16 == bullet.getX()) {
                        makeBoom(bulletController, time);
                        thread.start();
                        addCarScore();
                    }
                }

            }

        });
    }

    private void makeBoom(BulletController bulletController, long time) {
        thread = new Thread(() -> {
            try {
                Thread.sleep(time);
                bulletController.stopBullet();
                carController.setBoomCar();
                carController.stopCar();
                Thread.sleep(100);
                carController.setStandartCar();
                carController.setRandomPositionCar();
                carController.runCar();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
    }


    private void addCarScore() {
        shootingPanelModel.addScore();
    }

}
