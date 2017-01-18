// Fig. 21.1: VectorTest.java
// Using the Vector class.
import java.util.*;

public class VectorTest {
   private static final String colors[] = { "red", "white", "blue" };

   public VectorTest()
   {
      Vector vector = new Vector();
      printVector( vector ); // print vector

      // add elements to the vector
      vector.add( "magenta" ); 

      for ( int count = 0; count < colors.length; count++ )
         vector.add( colors[ count ] );         

      vector.add( "cyan" );
      printVector( vector ); // print vector
      
      // output the first and last elements
      try {
         System.out.println( "First element: " + vector.firstElement() );
         System.out.println( "Last element: " + vector.lastElement() );
      }
      
      // catch exception if vector is empty
      catch ( NoSuchElementException exception ) {
         exception.printStackTrace();
      }
      
      // does vector contain "red"?
      if ( vector.contains( "red" ) )
         System.out.println( "\n\"red\" found at index " + 
            vector.indexOf( "red" ) + "\n" );
      else
         System.out.println( "\n\"red\" not found\n" );
      
      vector.remove( "red" ); // remove the string "red"
      System.out.println( "\"red\" has been removed" );
      printVector( vector ); // print vector
      
      // does vector contain "red" after remove operation?
      if ( vector.contains( "red" ) )
         System.out.println( "\"red\" found at index " + 
            vector.indexOf( "red" ) );
      else
         System.out.println( "\"red\" not found" );
      
      // print the size and capacity of vector
      System.out.println( "\nSize: " + vector.size() + 
         "\nCapacity: " + vector.capacity() );

   } // end constructor
   
   private void printVector( Vector vectorToOutput )
   {
      if ( vectorToOutput.isEmpty() ) 
         System.out.print( "vector is empty" ); // vectorToOutput is empty
      
      else { // iterate through the elements
         System.out.print( "vector contains: " );      
         Enumeration items = vectorToOutput.elements(); 

         while ( items.hasMoreElements() )
            System.out.print( items.nextElement() + " " );
      }
      
      System.out.println( "\n" ); 
   }

   public static void main( String args[] )
   {
      new VectorTest(); // create object and call its constructor
   } 

} // end class VectorTest


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
