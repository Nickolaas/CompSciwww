//********************************************************************
//  CircleStats.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the formatting of decimal values using the
//  DecimalFormat class.
//********************************************************************

import cs1.Keyboard;
import java.text.DecimalFormat;

public class CircleStats
{
   //-----------------------------------------------------------------
   //  Calculates the area and circumference of a circle given its
   //  radius.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      int radius;
      double area, circumference;

      System.out.print ("Enter the circle's radius: ");
      radius = Keyboard.readInt();

      area = Math.PI * Math.pow(radius, 2);
      circumference = 2 * Math.PI * radius;

      // Round the output to three decimal places
      DecimalFormat fmt = new DecimalFormat ("0.###");

      System.out.println ("The circle's area: " + fmt.format(area));
      System.out.println ("The circle's circumference: "
                          + fmt.format(circumference));
   }
}
