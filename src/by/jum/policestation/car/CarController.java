package by.jum.policestation.car;

public class CarController {
    private CarView carView;
    private CarModel carModel;
    private BoxGenerator boxGenerator;

    public CarController(CarView carView, CarModel carModel, int countCar) {
        this.carView = carView;
        this.carModel = carModel;
        boxGenerator = new BoxGenerator(countCar);
    }

    public void runCar() {
        carModel.start();
    }

    public void stopCar() {
        carModel.stop();
    }


    public void setRandomPositionCar() {
        carView.setBounds(boxGenerator.getRandomBoundsCar());
    }

    public int getAlignmentX() {
        return carView.getX();
    }

    public int getAlignmentY() {
        return carView.getY();
    }

    public void setBoomCar() {
        carModel.setBoomImage();
    }

    public void setStandartCar() {
        carModel.setStandartImage();
    }
}
