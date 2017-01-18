// Fig. 22.10: Algorithms1.java
// Using algorithms reverse, fill, copy, min and max.
import java.util.*;

public class Algorithms1 {
   private String letters[] = { "P", "C", "M" }, lettersCopy[];
   private List list, copyList;

   // create a List and manipulate it with methods from Collections
   public Algorithms1()
   {
      list = Arrays.asList( letters );     // get List
      lettersCopy = new String[ 3 ];
      copyList = Arrays.asList( lettersCopy );

      System.out.println( "Initial list: " );
      output( list );

      Collections.reverse( list );         // reverse order
      System.out.println( "\nAfter calling reverse: " );
      output( list );

      Collections.copy( copyList, list );  // copy List
      System.out.println( "\nAfter copying: " );
      output( copyList );

      Collections.fill( list, "R" );       // fill list with Rs
      System.out.println( "\nAfter calling fill: " );
      output( list );

   } // end constructor

   // output List information
   private void output( List listRef )
   {
      System.out.print( "The list is: " );

      for ( int k = 0; k < listRef.size(); k++ )
         System.out.print( listRef.get( k ) + " " );

      System.out.print( "\nMax: " + Collections.max( listRef ) );
      System.out.println( "  Min: " + Collections.min( listRef ) );
   }

   public static void main( String args[] )
   {
      new Algorithms1();
   } 
                                          
} // end class Algorithms1


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
