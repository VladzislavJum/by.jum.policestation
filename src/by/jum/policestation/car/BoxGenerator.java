package by.jum.policestation.car;

import java.awt.Rectangle;
import java.util.Random;

public class BoxGenerator {
    private Random random;
    private int countBox;

    public BoxGenerator(int countBox) {
        this.countBox = countBox;
        random = new Random();
    }

    public Rectangle getRandomBoundsCar() {
        int numberBox = random.nextInt(countBox);
        return new Rectangle(180 + numberBox * 200, 170, 40, 99);
    }
}
