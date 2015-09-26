package by.jum.policestation.controller;

import by.jum.policestation.car.CarController;
import by.jum.policestation.window.ShootingPanelModel;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.util.Observable;
import java.util.Observer;

public class LoseController implements Observer {
    private CarController carController;
    private ShootingPanelModel shootingPanelModel;
    private int live;

    public LoseController(CarController carController, ShootingPanelModel shootingPanelModel) {
        this.carController = carController;
        this.shootingPanelModel = shootingPanelModel;
        live = 0;
    }


    @Override
    public void update(Observable o, Object arg) {
        shootingPanelModel.diffLive();
        if (++live == 3) {
            carController.stopCar();
            showLooseDialog();
            live = 0;
            return;
        }
        carController.setRandomPositionCar();
    }

    private void showLooseDialog() {
        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null, "Try Again?", "                             " +
                        "Your Score " + shootingPanelModel.getScore(),
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.exit(0);
        } else if (response == JOptionPane.YES_OPTION) {
            shootingPanelModel.resetScoreAndLiveLable();
            carController.setStandartSpeedAndCount();
            carController.runCar();
            carController.setRandomPositionCar();
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
    }
}
