// Fig. 22.4: ListTest.java
// Using LinkLists.
import java.util.*;

public class ListTest {
   private static final String colors[] = { "black", "yellow", 
      "green", "blue", "violet", "silver" };
   private static final String colors2[] = { "gold", "white", 
      "brown", "blue", "gray", "silver" };
                  
   // set up and manipulate LinkedList objects
   public ListTest()
   {
      List link = new LinkedList();
      List link2 = new LinkedList();

      // add elements to each list
      for ( int count = 0; count < colors.length; count++ ) {
         link.add( colors[ count ] );
         link2.add( colors2[ count ] );   
      }

      link.addAll( link2 );           // concatenate lists
      link2 = null;                   // release resources

      printList( link );

      uppercaseStrings( link );

      printList( link );

      System.out.print( "\nDeleting elements 4 to 6..." );
      removeItems( link, 4, 7 );

      printList( link );

      printReversedList( link );

   } // end constructor ListTest

   // output List contents
   public void printList( List list )
   {
      System.out.println( "\nlist: " );
   
      for ( int count = 0; count < list.size(); count++ )
         System.out.print( list.get( count ) + " " );

      System.out.println();
   }                                                    

   // locate String objects and convert to uppercase
   private void uppercaseStrings( List list )
   {
      ListIterator iterator = list.listIterator();

      while ( iterator.hasNext() ) {
         Object object = iterator.next();  // get item

         if ( object instanceof String )   // check for String
            iterator.set( ( ( String ) object ).toUpperCase() ); 
      }
   }

   // obtain sublist and use clear method to delete sublist items
   private void removeItems( List list, int start, int end )
   {
      list.subList( start, end ).clear();  // remove items
   }

   // print reversed list
   private void printReversedList( List list )
   {
      ListIterator iterator = list.listIterator( list.size() );

      System.out.println( "\nReversed List:" );

      // print list in reverse order
      while( iterator.hasPrevious() ) 
         System.out.print( iterator.previous() + " " ); 
   }
   
   public static void main( String args[] )
   {
      new ListTest();
   }                                           
   
} // end class ListTest

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