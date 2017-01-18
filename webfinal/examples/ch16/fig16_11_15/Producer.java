// Fig. 16.12: Producer.java
// Producer’s run method controls a thread that 
// stores values from 11 to 20 in sharedLocation.
import javax.swing.*;

public class Producer extends Thread {
   private Buffer sharedLocation;
   private JTextArea outputArea;
    
   // constructor
   public Producer( Buffer shared, JTextArea output )
   {
      super( "Producer" );
      sharedLocation = shared;
      outputArea = output;
   }
    
   // store values from 11-20 and in sharedLocation's buffer
   public void run()
   {
      for ( int count = 11; count <= 20; count ++ ) {
        
         // sleep 0 to 3 seconds, then place value in Buffer
         try {
            Thread.sleep( ( int ) ( Math.random() * 3000 ) );
            sharedLocation.set( count );
         }

         // if sleeping thread interrupted, print stack trace
         catch ( InterruptedException exception ) {
            exception.printStackTrace();
         }
      }
        
      String name = getName();
      SwingUtilities.invokeLater( new RunnableOutput( outputArea, "\n" + 
         name + " done producing.\n" + name + " terminated.\n" ) );
        
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
