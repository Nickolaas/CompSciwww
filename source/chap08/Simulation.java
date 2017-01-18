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
    public static final boolean DEBUG = false;

    private Arena arena;
    private ArrayList allCars;

    public Simulation(int numCars, Arena theArena)
    {
        allCars = new ArrayList();
        arena = theArena;
        int arenaNSsize = arena.getNSsize();
        int arenaEWsize = arena.getEWsize();

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
            allCars.add(car);
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
    // Prints the bump count totals for all the drivers as text.
    //----------------------------------------------------------------
    public void printBumpCounts()
    {
        System.out.println("Bump Counts:");
        int total = 0;

        // 'AB' way using ListIterator
        /*
        ListIterator listIterator = allCars.listIterator();
        while (listIterator.hasNext())
        {
            Car car = (Car)(listIterator.next());
            System.out.println(car.getBumpCount());
            total += car.getBumpCount();
        }
        */

        // 'A' way not using ListIterator
        for (int c=0; c < allCars.size(); c++)
        {
            Car car = (Car)(allCars.get(c));
            System.out.println(car.getBumpCount());
            total += car.getBumpCount();
        }

        System.out.println("Average bump count: " +
                           total / allCars.size());
    }
}
