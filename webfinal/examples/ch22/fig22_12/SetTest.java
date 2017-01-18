// Fig. 22.12: SetTest.java
// Using a HashSet to remove duplicates.
import java.util.*;

public class SetTest {
   private static final String colors[] = { "red", "white", "blue",
      "green", "gray", "orange", "tan", "white", "cyan",
      "peach", "gray", "orange" };
                  
   // create and output ArrayList
   public SetTest()
   {
      List list = new ArrayList( Arrays.asList( colors ) );
      System.out.println( "ArrayList: " + list );
      printNonDuplicates( list );
   }

   // create set from array to eliminate duplicates
   private void printNonDuplicates( Collection collection )
   {
      // create a HashSet and obtain its iterator
      Set set = new HashSet( collection );   
      Iterator iterator = set.iterator(); 

      System.out.println( "\nNonduplicates are: " );

      while ( iterator.hasNext() )
         System.out.print( iterator.next() + " " );

      System.out.println();
   }

   public static void main( String args[] )
   {
      new SetTest();
   }   
                                        
} // end class SetTest


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
