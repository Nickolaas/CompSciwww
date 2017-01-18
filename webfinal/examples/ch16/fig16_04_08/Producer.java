// Fig. 16.5: Producer.java
// Producer's run method controls a thread that
// stores values from 1 to 4 in sharedLocation.

public class Producer extends Thread {
   private Buffer sharedLocation; // reference to shared object

   // constructor
   public Producer( Buffer shared )
   {
       super( "Producer" );
       sharedLocation = shared;
   }

   // store values from 1 to 4 in sharedLocation
   public void run()
   {
      for ( int count = 1; count <= 4; count++ ) {  
         
         // sleep 0 to 3 seconds, then place value in Buffer
         try {
            Thread.sleep( ( int ) ( Math.random() * 3001 ) );
            sharedLocation.set( count );  
         }

         // if sleeping thread interrupted, print stack trace
         catch ( InterruptedException exception ) {
            exception.printStackTrace();
         }

      } // end for

      System.err.println( getName() + " done producing." + 
         "\nTerminating " + getName() + ".");

   } // end method run

} // end class Producer


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
