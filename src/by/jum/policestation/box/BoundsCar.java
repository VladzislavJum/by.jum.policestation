package by.jum.policestation.box;

import java.awt.Rectangle;
import java.util.Random;


public class BoundsCar {
    private Random random;
    private int alignmentX;

    public BoundsCar() {
        random = new Random();

    }

    public Rectangle getBounds(){
        int numberBox = random.nextInt(7) + 1;
        System.out.println(numberBox);
        switch (numberBox){
            case 1: alignmentX = 170; break;
            case 2: alignmentX = 380; break;
            case 3: alignmentX = 580; break;
            case 4: alignmentX = 780; break;
            case 5: alignmentX = 980; break;
            case 6: alignmentX = 1180; break;
            case 7: alignmentX = 1380; break;
        }
        System.out.println(alignmentX);
        return new Rectangle(alignmentX, 170, 40, 99);
    }
}
