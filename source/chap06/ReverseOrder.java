//********************************************************************
//  ReverseOrder.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates array index processing.
//********************************************************************

import cs1.Keyboard;

public class ReverseOrder
{
   //-----------------------------------------------------------------
   //  Reads a list of numbers from the user, storing them in an
   //  array, then prints them in the opposite order.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      double[] numbers = new double[10];

      System.out.println ("The size of the array: " + numbers.length);

      for (int index = 0; index < numbers.length; index++)
      {
         System.out.print ("Enter number " + (index+1) + ": ");
         numbers[index] = Keyboard.readDouble();
      }
      
      System.out.println ("The numbers in reverse order:");

      for (int index = numbers.length-1; index >= 0; index--)
         System.out.print (numbers[index] + "  ");
      
      System.out.println ();
   }
}
