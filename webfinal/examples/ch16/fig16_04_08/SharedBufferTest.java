// Fig. 16.8: SharedBufferTest.java
// SharedBufferTest creates producer and consumer threads.

public class SharedBufferTest {

    public static void main( String [] args )
    {
        // create shared object used by threads
        Buffer sharedLocation = new UnsynchronizedBuffer();

        // create producer and consumer objects
        Producer producer = new Producer( sharedLocation );
        Consumer consumer = new Consumer( sharedLocation );

        producer.start();  // start producer thread
        consumer.start();  // start consumer thread

    } // end main

} // end class SharedCell



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
