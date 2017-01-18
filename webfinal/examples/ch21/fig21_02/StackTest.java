// Fig. 21.2: StackTest.java
// Program to test java.util.Stack.
import java.util.*;

public class StackTest {

   public StackTest()
   {
      Stack stack = new Stack();  

      // create objects to store in the stack
      Boolean bool = Boolean.TRUE;
      Character character = new Character( '$' );
      Integer integer = new Integer( 34567 );
      String string = "hello";

      // use push method
      stack.push( bool );
      printStack( stack );
      stack.push( character );
      printStack( stack );
      stack.push( integer );
      printStack( stack );
      stack.push( string );
      printStack( stack );

      // remove items from stack
      try {
         Object removedObject = null;

         while ( true ) {
            removedObject = stack.pop(); // use pop method
            System.out.println( removedObject.toString() + " popped" );
            printStack( stack );
         }
      }

      // catch exception if stack is empty when item popped
      catch ( EmptyStackException emptyStackException ) {
         emptyStackException.printStackTrace();
      }
   }
   
   private void printStack( Stack stack )
   {
      if ( stack.isEmpty() )
         System.out.print( "stack is empty" ); // the stack is empty
      
      else {
         System.out.print( "stack contains: " );      
         Enumeration items = stack.elements();
         
         // iterate through the elements
         while ( items.hasMoreElements() )
            System.out.print( items.nextElement() + " " );
      }
      
      System.out.println( "\n" ); // go to the next line
   }
   
   public static void main( String args[] )
   {
      new StackTest();
   }

} // end class StackTest


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
