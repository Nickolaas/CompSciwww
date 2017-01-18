// Fig. 20.12: StackComposition.java
// Class StackComposition definition with composed List object.
package com.deitel.jhtp5.ch20;

public class StackComposition {
   private List stackList;

   // construct stack
   public StackComposition() 
   { 
      stackList = new List( "stack" ); 
   }

   // add object to stack
   public synchronized void push( Object object )
   { 
      stackList.insertAtFront( object ); 
   }

   // remove object from stack
   public synchronized Object pop() throws EmptyListException
   { 
      return stackList.removeFromFront(); 
   }

   // determine if stack is empty
   public synchronized boolean isEmpty() 
   { 
      return stackList.isEmpty(); 
   }

   // output stack contents
   public synchronized void print() 
   { 
      stackList.print(); 
   }

} // end class StackComposition


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
