package by.jum.policestation.car;

import by.jum.policestation.resourse.Position;

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
        return new Rectangle(Position.FIRST_BOX_POSITION.getPosition() + numberBox * 200, 170, 40, 99);
    }
}
