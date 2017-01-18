// Fig. 22.1: UsingArrays.java
// Using Java arrays.
import java.util.*;

public class UsingArrays {
   private int intValues[] = { 1, 2, 3, 4, 5, 6 };
   private double doubleValues[] = { 8.4, 9.3, 0.2, 7.9, 3.4 };
   private int filledInt[], intValuesCopy[];

   // initialize arrays
   public UsingArrays()
   {
      filledInt = new int[ 10 ];
      intValuesCopy = new int[ intValues.length ];

      Arrays.fill( filledInt, 7 );   // fill with 7s

      Arrays.sort( doubleValues );   // sort doubleValues ascending

      // copy array intValues into array intValuesCopy
      System.arraycopy( intValues, 0, intValuesCopy,
         0, intValues.length );
   }

   // output values in each array
   public void printArrays()
   {     
      System.out.print( "doubleValues: " );

      for ( int count = 0; count < doubleValues.length; count++ )
         System.out.print( doubleValues[ count ] + " " );

      System.out.print( "\nintValues: " );

      for ( int count = 0; count < intValues.length; count++ )
         System.out.print( intValues[ count ] + " " );

      System.out.print( "\nfilledInt: " );

      for ( int count = 0; count < filledInt.length; count++ )
         System.out.print( filledInt[ count ] + " " );

      System.out.print( "\nintValuesCopy: " );

      for ( int count = 0; count < intValuesCopy.length; count++ )
         System.out.print( intValuesCopy[ count ] + " " );

      System.out.println();

   } // end method printArrays

   // find value in array intValues
   public int searchForInt( int value )
   {  
      return Arrays.binarySearch( intValues, value );
   }

   // compare array contents
   public void printEquality()
   {
      boolean b = Arrays.equals( intValues, intValuesCopy );

      System.out.println( "intValues " + ( b ? "==" : "!=" ) +
         " intValuesCopy" );

      b = Arrays.equals( intValues, filledInt );

      System.out.println( "intValues " + ( b ? "==" : "!=" ) + 
         " filledInt" );
   }

   public static void main( String args[] )
   {
      UsingArrays usingArrays = new UsingArrays();

      usingArrays.printArrays();
      usingArrays.printEquality();

      int location = usingArrays.searchForInt( 5 );
      System.out.println( ( location >= 0 ? "Found 5 at element " + 
         location : "5 not found" ) + " in intValues" );

      location = usingArrays.searchForInt( 8763 );
      System.out.println( ( location >= 0 ? "Found 8763 at element " + 
         location : "8763 not found" ) + " in intValues" ); 
   }  
                                         
} // end class UsingArrays

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
