package by.jum.policestation.window;

import javax.swing.JFrame;

public class ShootingPanelController {

    private ShootingPanel shootingPanel;
    private ShootingPanelModel shootingPanelModel;
    private JFrame frame;

    public ShootingPanelController(ShootingPanel shootingPanel, ShootingPanelModel shootingPanelModel, JFrame frame) {
        this.shootingPanelModel = shootingPanelModel;
        this.shootingPanel = shootingPanel;
        this.frame = frame;
    }

    public void addEnemies() {
        shootingPanelModel.addMovingEnemies(frame, shootingPanel);
    }

    public void setCountBox(int count) {
        shootingPanelModel.setCountBox(count);
    }

    public void addScoreLabel() {
        shootingPanelModel.addScoreLabel(shootingPanel);
    }

    public void addLiveLable(){
        shootingPanelModel.addLiveLabel(shootingPanel);
    }

    public void addHeart(){
        shootingPanelModel.addHeart(shootingPanel);
    }
}
