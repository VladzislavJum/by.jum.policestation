package by.jum.policestation.bullet;


import by.jum.policestation.resourse.PathImage;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletView extends JComponent {

    private BufferedImage image;

    public BulletView() {
        try {
            image = ImageIO.read(new File(PathImage.BULLET.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(image, 0, 0, 40, 93, this);
    }


}
