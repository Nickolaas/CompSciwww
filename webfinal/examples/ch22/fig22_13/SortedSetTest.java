// Fig. 22.13: SortedSetTest.java
// Using TreeSet and SortedSet.
import java.util.*;

public class SortedSetTest {
   private static final String names[] = { "yellow", "green",
       "black", "tan", "grey", "white", "orange", "red", "green" };
   
   // create a sorted set with TreeSet, then manipulate it
   public SortedSetTest()
   {
      SortedSet tree = new TreeSet( Arrays.asList( names ) );

      System.out.println( "set: " );
      printSet( tree );

      // get headSet based upon "orange"
      System.out.print( "\nheadSet (\"orange\"):  " );
      printSet( tree.headSet( "orange" ) );

      // get tailSet based upon "orange"
      System.out.print( "tailSet (\"orange\"):  " );
      printSet( tree.tailSet( "orange" ) );

      // get first and last elements
      System.out.println( "first: " + tree.first() );
      System.out.println( "last : " + tree.last() );
   }

   // output set
   private void printSet( SortedSet set )
   {
      Iterator iterator = set.iterator();

      while ( iterator.hasNext() )     
         System.out.print( iterator.next() + " " );

      System.out.println();
   } 

   public static void main( String args[] )
   {
      new SortedSetTest();
   }  
 
} // end class SortedSetTest

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
