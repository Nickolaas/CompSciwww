//********************************************************************
// RandomDriver.java         Author: Lewis/Loftus/Cocking
//
// Represents a driver whose moves are chosen randomly.
//********************************************************************

import java.util.Random;

public class RandomDriver implements Driver
{
    // Share a random number generator among all the RandomDrivers.
    private static Random randGen = new Random();

    private Car car;

    public RandomDriver(Car aCar)
    {
        car = aCar;
    }

    //----------------------------------------------------------------
    // Drive the car one unit. The random driver chooses a move
    // randomly.
    //----------------------------------------------------------------
    public void drive()
    {
        if (Simulation.DEBUG)
            System.out.println("RandomDriver: drive");

        // Move forward 70% of the time. Turn to face another direction
        // 30% of the time. (Equal probability for each of the three
        // remaining directions.)
        final int moveForwardProb = 70;
        int probability = randGen.nextInt(100);

        if (probability < moveForwardProb)
            car.moveForward();
        else {
            int turnWhichWay = randGen.nextInt(3);
            if (turnWhichWay == 0)
                car.turnLeft();
            else if (turnWhichWay == 1)
                car.turnRight();
            else /* turnWhichWay == 2 */
                car.turnAround();
        }
    }
}
