//********************************************************************
// Simulation.java         Author: Lewis/Loftus/Cocking
//
// The class used to control the simulation of the bumper car arena.
//********************************************************************

import java.util.Random;
import java.util.ListIterator;
import java.util.ArrayList;

public class Simulation
{
    private Arena arena;

    public Simulation(int numCars, int arenaNSsize, int arenaEWsize)
    {
        arena = new Arena(arenaNSsize, arenaEWsize);

        Random randomGen = new Random();
        Car car;
        Driver driver;
        int ns, ew;

        // Create the given number of cars and place them in the arena.
        for (int k=0; k < numCars; k++)
        {
            // Create a car-driver pair with a randomly-generated
            // position in the arena.
            ns = randomGen.nextInt(arenaNSsize);
            ew = randomGen.nextInt(arenaEWsize);
            // Assume that numCars < arenaNSsize * arenaEWsize
            // If not, the loop below would go on forever once the
            // arena is filled!
            while (arena.occupiedBy(ns, ew) != Arena.EMPTY)
            {
                ns = randomGen.nextInt(arenaNSsize);
                ew = randomGen.nextInt(arenaEWsize);
            }

            car = new Car(arena);
            // Turn the car to face a random direction
            car.turn(Direction.randomDirection());
            driver = new RandomDriver(car);
            car.setDriver(driver);
            arena.addCar(car, ns, ew);
        }
    }

    //----------------------------------------------------------------
    // Perform one step in the simulation.
    //----------------------------------------------------------------
    public void step()
    {
        arena.step();
    }

    //----------------------------------------------------------------
    // Prints the bump count totals for all the drivers in a
    // textual format.
    //----------------------------------------------------------------
    public void printBumpCounts()
    {
        // not implemented yet
    }
}
