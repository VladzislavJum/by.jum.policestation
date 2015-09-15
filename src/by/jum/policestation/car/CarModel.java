package by.jum.policestation.car;

import by.jum.policestation.resourse.PathImage;
import by.jum.policestation.window.MainMenuWindow;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.io.File;
import java.io.IOException;

public class CarModel {
    private Timer timer;
    private CarView carView;

    public CarModel(CarView carView) {
        this.carView = carView;
        carView.setBounds(780, 170, 40, 99);
        timer = new Timer(2, e -> {
            carView.setBounds((int) carView.getBounds().getX(), (int) carView.getBounds().getY() + 1, 40, 99);
            if (carView.getY() == 650) {
                carView.setBounds(780, 170, 40, 99);
            }
        });
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void setBoomImage() {
        try {
            carView.setImage(ImageIO.read(new File(PathImage.CAR_BOOM.getPath())));
            carView.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStandartImage() {
        try {
            carView.setImage(ImageIO.read(new File(PathImage.CAR.getPath())));
            carView.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
