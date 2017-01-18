// Fig. 16.13: Consumer.java
// Consumer’s run method controls a thread that loops ten
// times and reads a value from sharedLocation each time.
import javax.swing.*;

public class Consumer extends Thread {
   private Buffer sharedLocation; // reference to shared object
   private JTextArea outputArea;
    
   // constructor
   public Consumer( Buffer shared, JTextArea output )
   {
      super( "Consumer" );
      sharedLocation = shared;
      outputArea = output;
   }
    
   // read sharedLocation's value ten times and sum the values
   public void run()
   {
      int sum = 0;

      for ( int count = 1; count <= 10; count++ ) {
         
         // sleep 0 to 3 seconds, read value from Buffer and add to sum
         try {
            Thread.sleep( ( int ) ( Math.random() * 3001 ) );    
            sum += sharedLocation.get();
         }

         // if sleeping thread interrupted, print stack trace
         catch ( InterruptedException exception ) {
            exception.printStackTrace();
         }
      }
        
      String name = getName();
      SwingUtilities.invokeLater( new RunnableOutput( outputArea, 
         "\nTotal " + name + " consumed: " + sum + ".\n" + 
         name + " terminated.\n ") );
        
   } // end method run
    
} // end class Consumer


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
