package by.jum.policestation.window;

import by.jum.policestation.car.CarController;
import by.jum.policestation.car.CarModel;
import by.jum.policestation.car.CarView;
import by.jum.policestation.terrorist.ShootController;
import by.jum.policestation.terrorist.TerroristController;
import by.jum.policestation.terrorist.TerroristModel;
import by.jum.policestation.terrorist.TerroristView;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class ShootingPanelModel {
    private int countBox;
    private JLabel scoreLabel;

    public void addMovingEnemies(JFrame frame, ShootingPanel shootingPanel) {
        CarView car = new CarView();
        CarModel carModel = new CarModel(car);
        CarController carController = new CarController(car, carModel, countBox);
        carController.runCar();
        shootingPanel.add(car);

        TerroristView terrorist = new TerroristView();
        TerroristModel terroristModel = new TerroristModel();
        TerroristController terroristController = new TerroristController(frame, terrorist, terroristModel);
        terrorist.setBounds(780, 747, 40, 93);
        terroristController.addMovingTerrorist();
        shootingPanel.add(terrorist);

        ShootController shootController = new ShootController(shootingPanel, terrorist, carController, this);
        shootController.addMovingBullet(frame);

    }

    public void addScoreLabel(ShootingPanel shootingPanel) {
        scoreLabel = new JLabel("0");
        scoreLabel.setBounds(1450, 15, 150, 100);
        scoreLabel.setFont(new Font("Calibri", Font.BOLD, 80));
        scoreLabel.setForeground(Color.WHITE);

        shootingPanel.add(scoreLabel);
    }

    public void setCountBox(int countBox) {
        this.countBox = countBox;
    }

    public void addScore() {
        scoreLabel.setText(String.valueOf(Integer.parseInt(scoreLabel.getText()) + 1));
    }


}

