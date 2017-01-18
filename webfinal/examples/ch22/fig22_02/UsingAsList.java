// Fig. 22.2: UsingAsList.java
// Using method asList.
import java.util.*;

public class UsingAsList {
   private static final String values[] = { "red", "white", "blue" };
   private List list;

   // initialize List and set value at location 1
   public UsingAsList()
   {
      list = Arrays.asList( values );   // get List
      list.set( 1, "green" );           // change a value
   }

   // output List and array
   public void printElements()
   {
      System.out.print( "List elements : " );

      for ( int count = 0; count < list.size(); count++ )
         System.out.print( list.get( count ) + " " );

      System.out.print( "\nArray elements: " );

      for ( int count = 0; count < values.length; count++ )
         System.out.print( values[ count ] + " " );

      System.out.println();
   }

   public static void main( String args[] )
   {
      new UsingAsList().printElements();
   }   
                                        
} // end class UsingAsList


/**************************************************************************
 * (C) Copyright 1992-2003 by Deitel & Associates, Inc. and               *
 * Prentice Hall. All Rights Reserved.                                    *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
