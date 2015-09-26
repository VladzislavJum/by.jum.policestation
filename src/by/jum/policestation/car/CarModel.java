package by.jum.policestation.car;

import by.jum.policestation.resourse.Path;
import by.jum.policestation.resourse.Position;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

public class CarModel extends Observable {
    private Timer timer;
    private CarView carView;
    private int speed = 0;
    private int count = 0;


    public CarModel(CarView carView) {
        this.carView = carView;
        carView.setStandartBounds();
        timer = new Timer(6, e -> {
            carView.setBounds((int) carView.getBounds().getX(), (int) carView.getBounds().getY() + speed, 40, 99);
            checkAlive();
        });
    }

    public void start() {
        if (count++ % 10 == 0 && count < 30) {
            speed++;
        }
        timer.start();
    }

    public void stop() {
        timer.stop();

    }

    public void setBoomImage() {
        try {
            carView.setImage(ImageIO.read(new File(Path.CAR_BOOM.getPath())));
        } catch (IOException e) {
            showEror();
        }
    }

    public void setStandartImage() {
        try {
            carView.setImage(ImageIO.read(new File(Path.CAR.getPath())));
            carView.repaint();
        } catch (IOException e) {
            showEror();
        }
    }

    private void checkAlive() {
        if (carView.getY() > Position.CAR_OUT.getPosition()) {
            super.setChanged();
            notifyObservers();
        }
    }

    public void setStartSpeedAndCount() {
        speed = 0;
        count = 0;
    }

    private void showEror() {
        JOptionPane.showConfirmDialog(null, "ERROR! Image Bullet not found", "Information", JOptionPane.OK_OPTION);
        System.exit(0);
    }
}
