//********************************************************************
//  Quadratic.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates a calculation based on user input.
//********************************************************************

import cs1.Keyboard;

public class Quadratic
{
   //-----------------------------------------------------------------
   //  Determines the roots of a quadratic equation.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      int a, b, c;  // ax^2 + bx + c

      System.out.print ("Enter the coefficient of x squared: ");
      a = Keyboard.readInt();

      System.out.print ("Enter the coefficient of x: ");
      b = Keyboard.readInt();

      System.out.print ("Enter the constant: ");
      c = Keyboard.readInt();

      // Use the quadratic formula to compute the roots.
      // Assumes a positive discriminant.

      double discriminant = Math.pow(b, 2) - (4 * a * c);
      double root1 = ((-1 * b) + Math.sqrt(discriminant)) / (2 * a);
      double root2 = ((-1 * b) - Math.sqrt(discriminant)) / (2 * a);

      System.out.println ("Root #1: " + root1);
      System.out.println ("Root #2: " + root2);
   }
}
