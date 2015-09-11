package by.jum.policestation;

import by.jum.policestation.box.BoundsCar;
import by.jum.policestation.box.Car;
import by.jum.policestation.path.Constant;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ShootingPanel extends JPanel {
    private BufferedImage policeStationImage;
    private BoundsCar bounds;
    private Bullet bullet;

    public ShootingPanel() {
        bounds = new BoundsCar();
        setLayout(null);
        try {
            policeStationImage = ImageIO.read(new File(Constant.POLICE_STATION.getPath()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.red);
        g.drawImage(policeStationImage, 0, 0, null);
    }

    public void addEnemies(JFrame frame){
        Car car = new Car();
        Terrorist terrorist = new Terrorist();
      //  Bullet bullet = new Bullet();

        car.setBounds(bounds.getBounds());
        terrorist.setBounds(780, 747, 40, 93);

        add(car);
        add(terrorist);
       // add(bullet);

        car.start();



        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'd') {
                    terrorist.setBounds((int) terrorist.getBounds().getX() + 200, (int) terrorist.getBounds().getY(), 40, 93);
                } else if (e.getKeyChar() == 'a') {
                    terrorist.setBounds((int) terrorist.getBounds().getX() - 200, (int) terrorist.getBounds().getY(), 40, 93);
                } else if (e.getKeyChar() == 'w') {
                    terrorist.setBounds((int) terrorist.getBounds().getX(), (int) terrorist.getBounds().getY() - 20, 40, 93);
                } else if (e.getKeyChar() == 's') {
                    terrorist.setBounds((int) terrorist.getBounds().getX(), (int) terrorist.getBounds().getY() + 20, 40, 93);
                } else if (e.getKeyChar() == ' ') {
                    bullet = new Bullet();
                    add(bullet);
                    bullet.setBounds(terrorist.getX() + 16, terrorist.getY() - 11, 10, 15);
                    bullet.start();
                    car.setBounds(bounds.getBounds());
                }

            }

        });
    }



}
