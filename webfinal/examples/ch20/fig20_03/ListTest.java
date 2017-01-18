// Fig. 20.5: ListTest.java
// ListTest class to demonstrate List capabilities.
import com.deitel.jhtp5.ch20.List;
import com.deitel.jhtp5.ch20.EmptyListException;

public class ListTest {

   public static void main( String args[] )
   {
      List list = new List();  // create the List container

      // objects to store in list
      Boolean bool = Boolean.TRUE;
      Character character = new Character( '$' );
      Integer integer = new Integer( 34567 );
      String string = "hello";

      // insert references to objects in list
      list.insertAtFront( bool );
      list.print();
      list.insertAtFront( character );
      list.print();
      list.insertAtBack( integer );
      list.print();
      list.insertAtBack( string );
      list.print();

      // remove objects from list; print after each removal
      try { 
         Object removedObject = list.removeFromFront();
         System.out.println( removedObject.toString() + " removed" );
         list.print();

         removedObject = list.removeFromFront();
         System.out.println( removedObject.toString() + " removed" );
         list.print();

         removedObject = list.removeFromBack();
         System.out.println( removedObject.toString() + " removed" );
         list.print();

         removedObject = list.removeFromBack();
         System.out.println( removedObject.toString() + " removed" );
         list.print();

      } // end try block

      // catch exception if remove is attempted on an empty List 
      catch ( EmptyListException emptyListException ) {
         emptyListException.printStackTrace();
      }
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
