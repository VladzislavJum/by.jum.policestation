package by.jum.policestation.window;

import by.jum.policestation.controller.LoseController;
import by.jum.policestation.car.CarController;
import by.jum.policestation.car.CarModel;
import by.jum.policestation.car.CarView;
import by.jum.policestation.controller.ShootController;
import by.jum.policestation.resourse.Path;
import by.jum.policestation.terrorist.TerroristController;
import by.jum.policestation.terrorist.TerroristModel;
import by.jum.policestation.terrorist.TerroristView;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class ShootingPanelModel {
    private int countBox;
    private JLabel scoreLabel;
    private JLabel liveLable;

    public void addMovingEnemies(JFrame frame, ShootingPanel shootingPanel) {
        CarView car = new CarView();
        CarModel carModel = new CarModel(car);
        CarController carController = new CarController(car, carModel, countBox);
        carController.runCar();
        shootingPanel.add(car);

        LoseController loseController = new LoseController(carController, this);
        carModel.addObserver(loseController);

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

    public void addLiveLabel(ShootingPanel shootingPanel){
        liveLable = new JLabel("3");
        liveLable.setBounds(150, 15, 150, 100);
        liveLable.setFont(new Font("Calibri", Font.BOLD, 80));
        liveLable.setForeground(Color.WHITE);

        shootingPanel.add(liveLable);
    }

    public void setCountBox(int countBox) {
        this.countBox = countBox;
    }

    public void addScore() {
        scoreLabel.setText(String.valueOf(Integer.parseInt(scoreLabel.getText()) + 1));
    }

    public void diffLive() {
        liveLable.setText(String.valueOf(Integer.parseInt(liveLable.getText()) - 1));
    }

    public void resetScoreAndLiveLable(){
        scoreLabel.setText("0");
        liveLable.setText("3");
    }

    public String getScore(){
        return scoreLabel.getText();
    }

    public void addHeart(ShootingPanel shootingPanel){
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(Path.HEART_ICON.getPath()));
        label.setBounds(20, 3, 100, 100);

        shootingPanel.add(label);
    }

}

