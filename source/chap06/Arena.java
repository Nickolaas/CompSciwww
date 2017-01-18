//********************************************************************
// Arena.java         Author: Lewis/Loftus/Cocking
//
// Represents a bumper car arena with cars in it.
//********************************************************************

import java.util.ArrayList;

public class Arena
{
    // The size of the arena
    private int length;
    private int width;

    // A 2-d array representing the arena. The upper-left corner is
    // position 0,0. A null entry indicates that that position in the
    // arena is unoccupied.
    private Car[][] arena;

    //----------------------------------------------------------------
    // Create an Arena of the given dimensions.
    //----------------------------------------------------------------
    public Arena(int length_, int width_)
    {
        length = length_;
        width = width_;
        arena = new Car[length][width];
    }

    //----------------------------------------------------------------
    // Returns the length of this arena.
    //----------------------------------------------------------------
    public int getLength()
    {
        return length;
    }

    //----------------------------------------------------------------
    // Returns the width of this arena.
    //----------------------------------------------------------------
    public int getWidth()
    {
        return width;
    }
    //----------------------------------------------------------------
    // Add a car to the arena at the position given.
    //----------------------------------------------------------------
    public void addCar(Car car, int len, int wid)
    {
        // If the positions given are out of bounds, an
        // exception will automatically be thrown.
        arena[len][wid] = car;
    }

    //----------------------------------------------------------------
    // Let all cars take a turn to move.
    //----------------------------------------------------------------
    public void step()
    {
        // Use an ArrayList to keep track of which cars have gone
        // already, so that no car will go more than once.
        ArrayList movedAlready = new ArrayList();

        for (int len=0; len < length; len++)
        {
            for (int wid=0; wid < width; wid++)
            {
                if ((arena[len][wid] != null) &&
                    (!movedAlready.contains(arena[len][wid])))
                {
                    System.out.println("Arena:  car at " + len + ","
                                       + wid + " is going.");
                    movedAlready.add(arena[len][wid]);
                    arena[len][wid].go();
                }
            }
        }

        System.out.println("Arena:  1 step taken.");
    }

    //---------------------------------------------------------------
    // Display the arena in a textual format.
    //---------------------------------------------------------------
    public void printArena()
    {
        // Print a top line
        for (int wid=0; wid < width; wid++)
            System.out.print("-");
        System.out.println();
        // Print the cars in the arena
        for (int len=0; len < length; len++)
        {
            for (int wid=0; wid < width; wid++)
            {
                if (arena[len][wid] == null)
                    System.out.print(" ");
                else
                    System.out.print(arena[len][wid].carAsChar());
            }
            System.out.println();
        }

        // Print a bottom line
        for (int wid=0; wid < width; wid++)
            System.out.print("-");
        System.out.println();
    }

    //---------------------------------------------------------------
    // A main so that this class can be tested and debugged alone.
    //---------------------------------------------------------------
    public static void main(String[] args)
    {
        Arena arena = new Arena(10, 10);
        Car car = new Car(arena);
        Driver driver = new RandomDriver(car);
        car.setDriver(driver);
        car.turnLeft();
        arena.addCar(car, 0, 0);

        car = new Car(arena);
        driver = new RandomDriver(car);
        car.setDriver(driver);
        car.turnAround();
        arena.addCar(car, 9, 9);

        car = new Car(arena);
        driver = new RandomDriver(car);
        car.setDriver(driver);
        arena.addCar(car, 0, 9);

        car = new Car(arena);
        driver = new RandomDriver(car);
        car.setDriver(driver);
        arena.addCar(car, 9, 0);

        car = new Car(arena);
        car.turnRight();
        driver = new RandomDriver(car);
        car.setDriver(driver);
        arena.addCar(car, 7, 4);

        // Do some steps
        arena.printArena();
        arena.step();

        arena.printArena();
        arena.step();

        arena.printArena();
    }
}
