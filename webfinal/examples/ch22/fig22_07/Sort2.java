// Fig. 22.7: Sort2.java
// Using a Comparator object with algorithm sort.
import java.util.*;

public class Sort2 {
   private static final String suits[] = 
      { "Hearts", "Diamonds", "Clubs", "Spades" };

   // output List elements
   public void printElements()
   {
      List list = Arrays.asList( suits ); // create List

      // output List elements
      System.out.println( "Unsorted array elements:\n" + list );

      // sort in descending order using a comparator
      Collections.sort( list, Collections.reverseOrder() ); 

      // output List elements
      System.out.println( "Sorted list elements:\n" + list );
   }
 
   public static void main( String args[] )
   {
      new Sort2().printElements();
   } 
                                          
} // end class Sort2


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
