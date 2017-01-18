// Fig. 22.6: Sort1.java
// Using algorithm sort.
import java.util.*;

public class Sort1 {
   private static final String suits[] = 
      { "Hearts", "Diamonds", "Clubs", "Spades" };

   // display array elements
   public void printElements()
   {
      // create ArrayList
      List list = new ArrayList( Arrays.asList( suits ) );
      
      // output list
      System.out.println( "Unsorted array elements:\n" + list );

      Collections.sort( list ); // sort ArrayList

      // output list
      System.out.println( "Sorted array elements:\n" + list );
   }

   public static void main( String args[] )
   {
      new Sort1().printElements();
   }   

} // end class Sort1


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
