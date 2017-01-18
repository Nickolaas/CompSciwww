//********************************************************************
// Car.java         Author: Lewis/Loftus/Cocking
//
// Represents a car in a bumper car arena.
//********************************************************************

public class Car
{
    private Arena arena; // the arena this car is in
    private Driver driver = null; // the driver controlling this car
    private Direction direction = Direction.NORTH;
    private int bumpCount;

    //----------------------------------------------------------------
    // Create a Car.
    //----------------------------------------------------------------
    public Car(Arena theArena)
    {
        bumpCount = 0;
        arena = theArena;
    }

    //----------------------------------------------------------------
    // Sets the driver of this car.
    //----------------------------------------------------------------
    public void setDriver(Driver theDriver)
    {
        driver = theDriver;
    }

    //----------------------------------------------------------------
    // Returns the direction this car is facing. This function,
    // though not used currently, could be useful to drivers as they
    // decide what to do next.
    //----------------------------------------------------------------
    public Direction getDirection()
    {
        return direction;
    }

    //----------------------------------------------------------------
    // Returns the number of times that this car has bumped into
    // obstacles (either other cars or a wall).
    //----------------------------------------------------------------
    public int getBumpCount()
    {
        return bumpCount;
    }

    //----------------------------------------------------------------
    // Tell the driver to drive. This function is called by the
    // Arena when it is this car's turn to go.
    //----------------------------------------------------------------
    public void go()
    {
        if (driver != null)
            driver.drive();
    }

    //----------------------------------------------------------------
    // Move forward one unit. This function is used by the driver.
    //----------------------------------------------------------------
    public void moveForward()
    {
        arena.carMove(this, direction);
    }

    //----------------------------------------------------------------
    // Called when another car bumps into this car.
    //----------------------------------------------------------------
    public void gotBumped()
    {
        bumpCount++;
    }

    //----------------------------------------------------------------
    // Turn to face the given direction.
    //----------------------------------------------------------------
    public void turn(Direction newDirection)
    {
        direction = newDirection;
    }

    //----------------------------------------------------------------
    // Turn to the left. The turn left, right, and around functions
    // are used by the driver to control the car.
    //----------------------------------------------------------------
    public void turnLeft()
    {
        if (Simulation.DEBUG)
            System.out.println("Car:  turned left");
        turn(direction.toLeft());
    }

    //----------------------------------------------------------------
    // Turn to the right.
    //----------------------------------------------------------------
    public void turnRight()
    {
        if (Simulation.DEBUG)
            System.out.println("Car:  turned right");

        turn(direction.toRight());
    }

    //----------------------------------------------------------------
    // Turn around.
    //----------------------------------------------------------------
    public void turnAround()
    {
        if (Simulation.DEBUG)
            System.out.println("Car:  turned around");

        turn(direction.toOpposite());
    }

    //----------------------------------------------------------------
    // Returns a one-character string representing this car. The
    // character returned indicates which direction the car is facing.
    //----------------------------------------------------------------
    public String carAsChar()
    {
        if (direction.equals(Direction.NORTH)) return "^";
        else if (direction.equals(Direction.EAST)) return ">";
         else if (direction.equals(Direction.SOUTH)) return "v";
         else /* WEST */ return "<";
    }
}
