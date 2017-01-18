//********************************************************************
//  Age.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of an if statement.
//********************************************************************

import cs1.Keyboard;

public class Age
{
   //-----------------------------------------------------------------
   //  Reads the user's age and prints comments accordingly.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      final int MINOR = 21;

      System.out.print ("Enter your age: ");
      int age = Keyboard.readInt();

      System.out.println ("You entered: " + age);

      if (age < MINOR)
         System.out.println ("Youth is a wonderful thing. Enjoy.");

      System.out.println ("Age is a state of mind.");
   }
}
