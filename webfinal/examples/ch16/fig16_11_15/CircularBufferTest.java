// Fig. 16.15: CircularBufferTest.java
// CircularBufferTest shows two threads manipulating a circular buffer.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// set up the producer and consumer threads and start them
public class CircularBufferTest extends JFrame {
   JTextArea outputArea;

   // set up GUI
   public CircularBufferTest()
   {
      super( "Demonstrating Thread Synchronizaton" );
        
      outputArea = new JTextArea( 20,30 );
      outputArea.setFont( new Font( "Monospaced", Font.PLAIN, 12 ) );
      getContentPane().add( new JScrollPane( outputArea ) );
        
      setSize( 310, 500 );
      setVisible( true );
        
      // create shared object used by threads; we use a CircularBuffer
      // reference rather than a Buffer reference so we can invoke 
      // CircularBuffer method createStateOutput
      CircularBuffer sharedLocation = new CircularBuffer( outputArea );

      // display initial state of buffers in CircularBuffer
      SwingUtilities.invokeLater( new RunnableOutput( outputArea, 
         sharedLocation.createStateOutput() ) );

      // set up threads
      Producer producer = new Producer( sharedLocation, outputArea );
      Consumer consumer = new Consumer( sharedLocation, outputArea );
        
      producer.start();  // start producer thread
      consumer.start();  // start consumer thread

   } // end constructor
    
   public static void main ( String args[] )
   {
      CircularBufferTest application = new CircularBufferTest();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // end class CirclularBufferTest


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
