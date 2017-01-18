//********************************************************************
// Arena.java         Author: Lewis/Loftus/Cocking
//
// Represents a bumper car arena with cars in it.
//********************************************************************

import java.util.ArrayList;

public class Arena
{
    // Constants returned by the occupiedBy() method
    public static final int EMPTY = 0;
    public static final int CAR = 1;
    public static final int WALL = 2;

    // The size of the arena
    private int nsSize;
    private int ewSize;

    // A 2-d array representing the arena. The NW corner is position
    // 0,0. A null entry indicates that that position in the arena
    // is unoccupied.
    private Car[][] arena;

    //----------------------------------------------------------------
    // Create an Arena of the given dimensions.
    //----------------------------------------------------------------
    public Arena(int nsSize_, int ewSize_)
    {
        nsSize = nsSize_;
        ewSize = ewSize_;
        arena = new Car[nsSize][ewSize];
    }

    //----------------------------------------------------------------
    // Returns the north-south size of this arena.
    //----------------------------------------------------------------
    public int getNSsize()
    {
        return nsSize;
    }

    //----------------------------------------------------------------
    // Returns the east-west size of this arena.
    //----------------------------------------------------------------
    public int getEWsize()
    {
        return ewSize;
    }

    //----------------------------------------------------------------
    // Add a car to the arena at the position given.
    //----------------------------------------------------------------
    public void addCar(Car car, int ns, int ew)
    {
        // If the positions given are out of bounds, an
        // exception will automatically be thrown.
        arena[ns][ew] = car;
    }

    //----------------------------------------------------------------
    // Let all cars take a turn to move. The order in which they
    // get to move is determined by scanning from west to east,
    // starting with the north-most row and continuing south after
    // each west-east scan.
    //----------------------------------------------------------------
    public void step()
    {
        // Use an ArrayList to keep track of which cars have gone
        // already. If a car moves east or south, it will come up again
        // in our search, but we don't want to move it again.
        ArrayList movedAlready = new ArrayList();

        for (int ns=0; ns < nsSize; ns++)
        {
            for (int ew=0; ew < ewSize; ew++)
            {
                if ((arena[ns][ew] != null) &&
                    (!movedAlready.contains(arena[ns][ew])))
                {
                    if (Simulation.DEBUG)
                        System.out.println("Arena: car at " + ns + ","
                                           + ew + " is going.");
                    movedAlready.add(arena[ns][ew]);
                    arena[ns][ew].go();
                }
            }
        }

        if (Simulation.DEBUG)
            System.out.println("Arena: 1 step taken.");
    }

    //----------------------------------------------------------------
    // Called by a car when it wants to move forward. If there is no
    // obstacle in front of the car, it moves forward. Otherwise,
    // it bumps into something and stays where it is.
    //----------------------------------------------------------------
    public void carMove(Car car, Direction dir)
    {
        int[] posTo = null;
        int nsFrom = 0;
        int ewFrom = 0;
        // First find where the car is to begin with
        for (int ns=0; ns < nsSize; ns++)
        {
            for (int ew=0; ew < ewSize; ew++)
            {
                if ((arena[ns][ew] != null) &&
                    (arena[ns][ew].equals(car)))
                {
                    // Found the car
                    nsFrom = ns;
                    ewFrom = ew;
                    posTo = newPos(ns, ew, dir);
                }
            }
        }

        // Try to move the car
        if (posTo != null)
        {
            int nsTo = posTo[0];
            int ewTo = posTo[1];
            // See if the car runs into a wall
            if (occupiedBy(nsTo, ewTo) == WALL)
                arena[nsFrom][ewFrom].gotBumped();
            // See if the car bumps another car
            else if (occupiedBy(nsTo, ewTo) == CAR)
            {
                arena[nsTo][ewTo].gotBumped();
                arena[nsFrom][ewFrom].gotBumped();
            }
            // Move the car
            else
            {
                arena[nsTo][ewTo] = arena[nsFrom][ewFrom];
                arena[nsFrom][ewFrom] = null;
            }
        }
    }

    //----------------------------------------------------------------
    // Returns a constant indicating what the given position in the
    // arena is occupied by - either EMPTY, CAR, or WALL.
    //----------------------------------------------------------------
    public int occupiedBy(int ns, int ew)
    {
        if (ns < 0 || ns >= nsSize || ew < 0 || ew >= ewSize)
            return WALL;
        else if (arena[ns][ew] != null)
            return CAR;
        else
            return EMPTY;
    }

    //----------------------------------------------------------------
    // Display the arena in a textual format.
    //----------------------------------------------------------------
    public void printArena()
    {
        // Print a top line
        for (int ew=0; ew < ewSize; ew++)
            System.out.print("-");
        System.out.println();

        // Print the cars in the arena
        for (int ns=0; ns < nsSize; ns++)
        {
            for (int ew=0; ew < ewSize; ew++)
            {
                if (arena[ns][ew] == null)
                    System.out.print(" ");
                else
                    System.out.print(arena[ns][ew].carAsChar());
            }
            System.out.println();
        }

        // Print a bottom line
        for (int ew=0; ew < ewSize; ew++)
            System.out.print("-");
        System.out.println();
    }

    //----------------------------------------------------------------
    // Returns the position that is in the direction indicated from
    // the given position.
    //----------------------------------------------------------------
    private int[] newPos(int ns, int ew, Direction dir)
    {
        int[] pos = new int[2];
        pos[0] = ns;
        pos[1] = ew;
        if (dir.equals(Direction.NORTH)) pos[0] = ns - 1;
        else if (dir.equals(Direction.EAST)) pos[1] = ew + 1;
        else if (dir.equals(Direction.SOUTH)) pos[0] = ns + 1;
        else /* WEST */ pos[1] = ew - 1;

        return pos;
    }
}
