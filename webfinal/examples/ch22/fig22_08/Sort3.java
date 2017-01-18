// Fig. 22.8: Sort3.java
// Creating a custom Comparator class.
import java.util.*;

public class Sort3 {

   public void printElements()
   {
      List list = new ArrayList();

      list.add( new Time2(  6, 24, 34 ) );
      list.add( new Time2( 18, 14, 05 ) );
      list.add( new Time2( 12, 07, 58 ) );
      list.add( new Time2(  6, 14, 22 ) );
      list.add( new Time2(  8, 05, 00 ) );
      
      // output List elements
      System.out.println( "Unsorted array elements:\n" + list );

      // sort in order using a comparator
      Collections.sort( list, new TimeComparator() ); 

      // output List elements
      System.out.println( "Sorted list elements:\n" + list );
   }
 
   public static void main( String args[] )
   {
      new Sort3().printElements();
   } 
   
   private class TimeComparator implements Comparator {
      int hourCompare, minuteCompare, secondCompare;
      Time2 time1, time2;
      
      public int compare( Object object1, Object object2 )
      {
         // cast the objects
         time1 = ( Time2 ) object1;
         time2 = ( Time2 ) object2;
         
         hourCompare = new Integer( time1.getHour() ).compareTo( 
                       new Integer( time2.getHour() ) );
         
         // test the hour first
         if ( hourCompare != 0 )
            return hourCompare;
         
         minuteCompare = new Integer( time1.getMinute() ).compareTo( 
                         new Integer( time2.getMinute() ) );
         
         // then test the minute
         if ( minuteCompare != 0 )
            return minuteCompare;
         
         secondCompare = new Integer( time1.getSecond() ).compareTo( 
                         new Integer( time2.getSecond() ) );

         return secondCompare; // return result of comparing seconds      
      }
      
   } // end class TimeComparator
                                          
} // end class Sort2


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
