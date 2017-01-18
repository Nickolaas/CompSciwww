// Fig. 16.14: CircularBuffer.java
// CircularBuffer synchronizes access to an array of shared buffers.
import javax.swing.*;

public class CircularBuffer implements Buffer {

   // each array element is a buffer 
   private int buffers[] = { -1, -1, -1 };
    
   // occupiedBufferCount maintains count of occupied buffers
   private int occupiedBufferCount = 0;
    
   // variables that maintain read and write buffer locations
   private int readLocation = 0, writeLocation = 0;
    
   // reference to GUI component that displays output
   private JTextArea outputArea;
    
   // constructor
   public CircularBuffer( JTextArea output )
   {
      outputArea = output;
   }
   
   // place value into buffer
   public synchronized void set( int value )
   {
      // for output purposes, get name of thread that called this method
      String name = Thread.currentThread().getName();

      // while there are no empty locations, place thread in waiting state
      while ( occupiedBufferCount == buffers.length ) {
         
         // output thread information and buffer information, then wait
         try {
            SwingUtilities.invokeLater( new RunnableOutput( outputArea, 
               "\nAll buffers full. " + name + " waits." ) );                
            wait();
         }

         // if waiting thread interrupted, print stack trace
         catch ( InterruptedException exception )
         {
            exception.printStackTrace();
         }

      } // end while
        
      // place value in writeLocation of buffers
      buffers[ writeLocation ] = value;
        
      // update Swing GUI component with produced value
      SwingUtilities.invokeLater( new RunnableOutput( outputArea, 
         "\n" + name + " writes " + buffers[ writeLocation ] + " ") );
        
      // just produced a value, so increment number of occupied buffers
      ++occupiedBufferCount;
        
      // update writeLocation for future write operation
      writeLocation = ( writeLocation + 1 ) % buffers.length;
        
      // display contents of shared buffers
      SwingUtilities.invokeLater( new RunnableOutput( 
         outputArea, createStateOutput() ) );
        
      notify(); // return waiting thread (if there is one) to ready state
        
   } // end method set
   
   // return value from buffer
   public synchronized int get()
   {  
      // for output purposes, get name of thread that called this method
      String name = Thread.currentThread().getName();

      // while no data to read, place thread in waiting state
      while ( occupiedBufferCount == 0 ) {
        
         // output thread information and buffer information, then wait
         try {
            SwingUtilities.invokeLater( new RunnableOutput( outputArea, 
               "\nAll buffers empty. " + name + " waits.") );
            wait();
         }
            
         // if waiting thread interrupted, print stack trace
         catch ( InterruptedException exception ) {
            exception.printStackTrace();
         }

      } // end while
        
      // obtain value at current readLocation
      int readValue = buffers[ readLocation ];
        
      // update Swing GUI component with consumed value
      SwingUtilities.invokeLater( new RunnableOutput( outputArea, 
         "\n" + name + " reads " + readValue + " ") );
        
      // just consumed a value, so decrement number of occupied buffers
      --occupiedBufferCount;
        
      // update readLocation for future read operation
      readLocation = ( readLocation + 1 ) % buffers.length;

      // display contents of shared buffers
      SwingUtilities.invokeLater( new RunnableOutput( 
         outputArea, createStateOutput() ) );
             
      notify(); // return waiting thread (if there is one) to ready state
        
      return readValue;
        
   } // end method get
    
   // create state output
   public String createStateOutput()
   {
      // first line of state information
      String output = 
         "(buffers occupied: " + occupiedBufferCount + ")\nbuffers: ";

      for ( int i = 0; i < buffers.length; i++ )
         output += " " + buffers[ i ] + "  ";

      // second line of state information
      output += "\n         ";

      for ( int i = 0; i < buffers.length; i++ )
         output += "---- ";

      // third line of state information
      output += "\n         ";

      // append readLocation (R) and writeLocation (W)
      // indicators below appropriate buffer locations
      for ( int i = 0; i < buffers.length; i++ )

         if ( i == writeLocation && writeLocation == readLocation )
            output += " WR  ";
         else if ( i == writeLocation )
            output += " W   ";
         else if ( i == readLocation )
            output += "  R  ";
         else 
            output += "     ";

      output += "\n";

      return output;

   } // end method createStateOutput
    
} // end class CircularBuffer



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