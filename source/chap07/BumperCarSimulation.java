//********************************************************************
// BumperCarSimulation.java      Author: Lewis/Loftus/Cocking
//
// This program runs a bumper car simulation.
//********************************************************************

import cs1.Keyboard;

public class BumperCarSimulation
{

    //----------------------------------------------------------------
    // Creates a Simulation object to control the bumper car
    // simulation. The user specifies the size of the arena and
    // how many bumper cars are in the arena. The simulation
    // continues until the user decides to stop it.
    //----------------------------------------------------------------
    public static void main(String[] args)
    {
        System.out.println("Bumper Cars Simulation");
        int ew = 0;
        int ns = 0;
        int numCars = 0;
        boolean badInput = true;

        // Get the number of cars and size of the arena from the user.
        while (badInput) {
            System.out.println("How many cars?");
            numCars = Keyboard.readInt();
            System.out.println("Size of the arena's north-south"
                               + " dimension?");
            ns = Keyboard.readInt();
            System.out.println("Size of the arena's east-west "
                               + "dimension?");
            ew = Keyboard.readInt();
            if (numCars > ew*ns)
            {
                System.out.println("Too many cars to fit in that "
                                   + "size arena!");
                System.out.println("Please enter the information "
                                   + "again:");
            }
            else if (numCars <= 0)
            {
                System.out.println("The number of cars must be greater"
                                   + " than 0!");
                System.out.println("Please enter the information "
                                   + "again:");
            }
            else
                badInput = false;
        }

        Arena arena = new Arena(ns, ew);
        Simulation sim = new Simulation(numCars, arena);

        int iterations = 0;
        String keepGoing;
        arena.printArena();
        System.out.println("Keep going? Type 'y' for yes or 'n' for"
                           + " no.");
        keepGoing = Keyboard.readString();
        while (keepGoing.equalsIgnoreCase("y"))
        {
            sim.step();
            iterations++;
            arena.printArena();
            System.out.println("Keep going? Type 'y' for yes or 'n'"
                               + " for no.");
            keepGoing = Keyboard.readString();
        }

        System.out.println("Number of iterations: " + iterations);
        sim.printBumpCounts();
    }
}
