// Fig. 20.13: Queue.java
// Class Queue.
package com.deitel.jhtp5.ch20;

public class Queue {
   private List queueList;

   // construct queue
   public Queue() 
   { 
      queueList = new List( "queue" ); 
   }

   // add object to queue
   public synchronized void enqueue( Object object )
   { 
      queueList.insertAtBack( object ); 
   }

   // remove object from queue
   public synchronized Object dequeue() throws EmptyListException
   { 
      return queueList.removeFromFront(); 
   }

   // determine if queue is empty
   public synchronized boolean isEmpty()
   {
      return queueList.isEmpty();
   }

   // output queue contents
   public synchronized void print()
   {
      queueList.print();
   }

} // end class Queue


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
