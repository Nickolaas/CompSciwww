// Fig. 20.14: QueueTest.java
// Class QueueTest.
import com.deitel.jhtp5.ch20.Queue;
import com.deitel.jhtp5.ch20.EmptyListException;

public class QueueTest {

   public static void main( String args[] )
   {
      Queue queue = new Queue();  

      // create objects to store in queue
      Boolean bool = Boolean.TRUE;
      Character character = new Character( '$' );
      Integer integer = new Integer( 34567 );
      String string = "hello";

      // use enqueue method
      queue.enqueue( bool );
      queue.print();
      queue.enqueue( character );
      queue.print();
      queue.enqueue( integer );
      queue.print();
      queue.enqueue( string );
      queue.print();

      // remove objects from queue
      try {
         Object removedObject = null;

         while ( true ) {
            removedObject = queue.dequeue(); // use dequeue method
            System.out.println( removedObject.toString() + " dequeued" );
            queue.print();
         }
      }

      // process exception if queue is empty when item removed
      catch ( EmptyListException emptyListException ) {
         emptyListException.printStackTrace();
      }
   }

} // end class QueueTest


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
