// Fig. 16.3: ThreadTester.java
// Multiple threads printing at different intervals.

public class ThreadTester {

   public static void main( String [] args )
   {
      // create and name each thread
      PrintThread thread1 = new PrintThread( "thread1" );
      PrintThread thread2 = new PrintThread( "thread2" );
      PrintThread thread3 = new PrintThread( "thread3" );
        
      System.err.println( "Starting threads" );
        
      thread1.start(); // start thread1 and place it in ready state
      thread2.start(); // start thread2 and place it in ready state
      thread3.start(); // start thread3 and place it in ready state
        
      System.err.println( "Threads started, main ends\n" );
        
   } // end main
    
} // end class ThreadTester

// class PrintThread controls thread execution
class PrintThread extends Thread {
   private int sleepTime;
    
   // assign name to thread by calling superclass constructor
   public PrintThread( String name )
   {
      super( name );
        
      // pick random sleep time between 0 and 5 seconds
      sleepTime = ( int ) ( Math.random() * 5001 );
   }        
    
   // method run is the code to be executed by new thread
   public void run()
   {
      // put thread to sleep for sleepTime amount of time
      try {
         System.err.println( 
            getName() + " going to sleep for " + sleepTime );
            
         Thread.sleep( sleepTime );
      }
        
      // if thread interrupted during sleep, print stack trace
      catch ( InterruptedException exception ) {
         exception.printStackTrace();
      }
        
      // print thread name
      System.err.println( getName() + " done sleeping" );
    
   } // end method run
    
} // end class PrintThread



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
