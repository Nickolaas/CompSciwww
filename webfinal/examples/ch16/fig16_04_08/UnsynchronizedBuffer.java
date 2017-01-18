// Fig. 16.7: UnsynchronizedBuffer.java
// UnsynchronizedBuffer represents a single shared integer.

public class UnsynchronizedBuffer implements Buffer {
   private int buffer = -1; // shared by producer and consumer threads

   // place value into buffer
   public void set( int value )
   {
      System.err.println( Thread.currentThread().getName() +
         " writes " + value );

      buffer = value;
   }

   // return value from buffer
   public int get()
   {
      System.err.println( Thread.currentThread().getName() +
         " reads " + buffer );

      return buffer; 
   }

} // end class UnsynchronizedBuffer



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
