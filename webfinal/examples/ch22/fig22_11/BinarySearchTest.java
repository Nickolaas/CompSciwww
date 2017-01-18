// Fig. 22.11: BinarySearchTest.java
// Using algorithm binarySearch.
import java.util.*;

public class BinarySearchTest {
   private static final String colors[] = { "red", "white",  
      "blue", "black", "yellow", "purple", "tan", "pink" };
   private List list;        // ArrayList reference

   // create, sort and output list 
   public BinarySearchTest()
   {
      list = new ArrayList( Arrays.asList( colors ) );  
      Collections.sort( list );   // sort the ArrayList
      System.out.println( "Sorted ArrayList: " + list );
   }

   // search list for various values
   private void printSearchResults()
   {
      printSearchResultsHelper( colors[ 3 ] ); // first item
      printSearchResultsHelper( colors[ 0 ] ); // middle item
      printSearchResultsHelper( colors[ 7 ] ); // last item
      printSearchResultsHelper( "aardvark" );  // below lowest
      printSearchResultsHelper( "goat" );      // does not exist
      printSearchResultsHelper( "zebra" );     // does not exist
   }

   // helper method to perform searches
   private void printSearchResultsHelper( String key )
   {
      int result = 0;

      System.out.println( "\nSearching for: " + key );
      result = Collections.binarySearch( list, key );
      System.out.println( ( result >= 0 ? "Found at index " + result :
         "Not Found (" + result + ")" ) );
   }

   public static void main( String args[] )
   {
      new BinarySearchTest().printSearchResults();
   }       

} // end class BinarySearchTest

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
