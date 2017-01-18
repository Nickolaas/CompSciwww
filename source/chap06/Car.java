//********************************************************************
// Car.java         Author: Lewis/Loftus/Cocking
//
// Represents a car in a bumper car arena.
//********************************************************************

public class Car
{
    private Arena arena; // the arena this car is in
    private Driver driver = null; // the driver controlling this car
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
    // Returns the number of times that this car has bumped into
    // other cars or a wall.
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
        System.out.println("Car:  moved forward");
    }

    //----------------------------------------------------------------
    // Turn to the left. The turn left, right, and around functions
    // are used by the driver to control the car.
    //----------------------------------------------------------------
    public void turnLeft()
    {
        System.out.println("Car:  turned left");
    }

    //----------------------------------------------------------------
    // Turn to the right.
    //----------------------------------------------------------------
    public void turnRight()
    {
        System.out.println("Car:  turned right");
    }

    //----------------------------------------------------------------
    // Turn around.
    //----------------------------------------------------------------
    public void turnAround()
    {
        System.out.println("Car:  turned around");
    }

    //----------------------------------------------------------------
    // Returns a one-character string representing this car.
    //----------------------------------------------------------------
    public String carAsChar()
    {
        return "C";
    }

}
