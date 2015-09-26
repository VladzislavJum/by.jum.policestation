package by.jum.policestation.window;

import by.jum.policestation.resourse.Path;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ShootingPanel extends JPanel {
    private BufferedImage policeStationImage;

    public ShootingPanel() {
        setLayout(null);
        try {
            policeStationImage = ImageIO.read(new File(Path.POLICE_STATION.getPath()));
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null, "ERROR! Image not found", "Information", JOptionPane.CLOSED_OPTION);
            System.exit(0);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.red);
        g.drawImage(policeStationImage, 0, 0, null);
    }
}
