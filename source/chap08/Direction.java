//********************************************************************
// Direction.java         Author: Lewis/Loftus/Cocking
//
// Represents a compass direction.
//********************************************************************

import java.util.Random;

public class Direction
{

    public static final Direction NORTH = new Direction();
    public static final Direction EAST =  new Direction();
    public static final Direction SOUTH = new Direction();
    public static final Direction WEST =  new Direction();

    // For generating random numbers
    private static Random randGen = new Random();

    //----------------------------------------------------------------
    // The constructor is private so that Directions cannot be
    // created. The public Direction constants NORTH, EAST, SOUTH
    // and WEST should be used.
    //----------------------------------------------------------------
    private Direction()
    {
    }

    //----------------------------------------------------------------
    // Returns the direction to the right of this direction.
    //----------------------------------------------------------------
    public Direction toRight()
    {
        if (NORTH.equals(this)) return EAST;
        else if (EAST.equals(this)) return SOUTH;
        else if (SOUTH.equals(this)) return WEST;
        else /* WEST */ return NORTH;
    }

    //----------------------------------------------------------------
    // Returns the direction to the left of this direction.
    //----------------------------------------------------------------
    public Direction toLeft()
    {
        if (NORTH.equals(this)) return WEST;
        else if (EAST.equals(this)) return NORTH;
        else if (SOUTH.equals(this)) return EAST;
        else /* WEST */ return SOUTH;
    }

    //----------------------------------------------------------------
    // Returns the direction that is opposite this direction.
    //----------------------------------------------------------------
    public Direction toOpposite()
    {
        if (NORTH.equals(this)) return SOUTH;
        else if (EAST.equals(this)) return WEST;
        else if (SOUTH.equals(this)) return NORTH;
        else /* WEST */ return EAST;
    }

    //----------------------------------------------------------------
    // Returns a randomly-generated direction.
    //----------------------------------------------------------------
    public static Direction randomDirection()
    {
        int rand = randGen.nextInt(4);
        if (rand == 0) return NORTH;
        else if (rand == 1) return EAST;
        else if (rand == 2) return SOUTH;
        else /* rand == 3 */ return WEST;
    }
}
