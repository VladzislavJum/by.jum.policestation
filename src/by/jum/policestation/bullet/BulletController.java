package by.jum.policestation.bullet;

public class BulletController {
    private BulletView bulletView;
    private BulletModel bulletModel;

    public BulletController(BulletView bulletView, BulletModel bulletModel) {
        this.bulletView = bulletView;
        this.bulletModel = bulletModel;
    }

    public void runBullet() {
        bulletModel.startBullet(bulletView);
    }

    public void stopBullet() {
        bulletView.setVisible(false);
        bulletModel.stopBullet();
    }
}
