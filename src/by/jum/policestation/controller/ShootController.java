package by.jum.policestation.controller;

import by.jum.policestation.bullet.BulletController;
import by.jum.policestation.bullet.BulletModel;
import by.jum.policestation.bullet.BulletView;
import by.jum.policestation.car.CarController;
import by.jum.policestation.resourse.Path;
import by.jum.policestation.terrorist.TerroristView;
import by.jum.policestation.window.ShootingPanelModel;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

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
                    playShoot();
                    if (carController.getAlignmentY() + 99 < terrorist.getY() - 11) {
                        bullet = new BulletView();
                        bullet.setBounds(terrorist.getX() + 16, terrorist.getY() - 11, 10, 15);
                        panel.add(bullet);

                        BulletController bulletController = new BulletController(bullet, new BulletModel());
                        bulletController.runBullet();

                        int distance = bullet.getY() - carController.getAlignmentY() - 80;
                        long time = (long) distance;
                        if (carController.getAlignmentX() + 16 == bullet.getX()) {
                            makeBoom(bulletController, time);
                            thread.start();
                        }
                    }
                }
            }
        });
    }

    private void playShoot() {
        try {
            Clip c = AudioSystem.getClip();
            AudioInputStream shootSteram = AudioSystem.getAudioInputStream(new File(Path.BOOM_AUDIO.getPath()));
            c.open(shootSteram);
            c.loop(0);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            JOptionPane.showConfirmDialog(null, "ERROR! Audio not found", "Information", JOptionPane.CLOSED_OPTION);
            System.exit(0);
        }
    }

    private void makeBoom(BulletController bulletController, long time) {
        thread = new Thread(() -> {
            try {
                Thread.sleep(time);
                bulletController.stopBullet();
                carController.setBoomCar();
                carController.stopCar();
                shootingPanelModel.addScore();
                Thread.sleep(100);
                carController.setStandartCar();
                carController.setRandomPositionCar();
                carController.runCar();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
    }


}
