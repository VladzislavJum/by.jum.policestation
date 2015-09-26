package by.jum.policestation.bullet;


import by.jum.policestation.resourse.Path;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletView extends JComponent {

    private BufferedImage image;

    public BulletView() {
        try {
            image = ImageIO.read(new File(Path.BULLET.getPath()));
        } catch (IOException e) {
            JOptionPane.showConfirmDialog(null, "ERROR! Image not found", "Information", JOptionPane.CLOSED_OPTION);
            System.exit(0);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(image, 0, 0, 40, 93, this);
    }


}
