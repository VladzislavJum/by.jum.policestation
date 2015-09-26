package by.jum.policestation.car;

import by.jum.policestation.resourse.Path;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CarView extends JComponent {

    private BufferedImage image;

    public CarView() {
        try {
            image = ImageIO.read(new File(Path.CAR.getPath()));
        } catch (IOException e) {
            JOptionPane.showConfirmDialog(null, "ERROR! Image not found", "Information", JOptionPane.CLOSED_OPTION);
            System.exit(0);
        }
        setStandartBounds();

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), this);
    }

    public void setImage(BufferedImage bufferedImage){
        image = bufferedImage;
        setBounds(getX() - 30, getY(), 100, 123);
        repaint();
    }

    public void setStandartBounds(){
        setBounds(780, 170, 40, 99);
    }

}
