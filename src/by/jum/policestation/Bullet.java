package by.jum.policestation;

import by.jum.policestation.path.Constant;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bullet extends JComponent implements Going{

    private BufferedImage image;

    public Bullet() {
        try {
            image = ImageIO.read(new File(Constant.BULLET.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(image, 0, 0, 40, 93, this);
    }

    @Override
    public void start() {
        Timer timer = new Timer(10, e ->
                this.setBounds((int) this.getBounds().getX(), (int) this.getBounds().getY() - 7, 10, 15));
        timer.stop();
        timer.start();
    }
}
