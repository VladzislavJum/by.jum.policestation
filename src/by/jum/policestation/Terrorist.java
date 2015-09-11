package by.jum.policestation;

import by.jum.policestation.path.Constant;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Terrorist extends JComponent {

    BufferedImage image;

    public Terrorist() {
        try {
            image = ImageIO.read(new File(Constant.TERRORIST.getPath()));
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
