// Fig. 21.13: BitSetTest.java
// Using a BitSet to demonstrate the Sieve of Eratosthenes.
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class BitSetTest extends JFrame {
   private BitSet sieve;
   private JLabel statusLabel;
   private JTextField inputField;

   // set up GUI
   public BitSetTest()
   {
      super( "BitSets" );

      sieve = new BitSet( 1024 );

      Container container = getContentPane();

      statusLabel = new JLabel( "" );
      container.add( statusLabel, BorderLayout.SOUTH );

      JPanel inputPanel = new JPanel();
      inputPanel.add( new JLabel( "Enter a value from 2 to 1023" ) );

      // textfield for user to input a value from 2 to 1023
      inputField = new JTextField( 10 );
      inputPanel.add( inputField );
      container.add( inputPanel, BorderLayout.NORTH );

      inputField.addActionListener(

         new ActionListener() { // inner class

            // determine whether value is prime number
            public void actionPerformed( ActionEvent event )
            {
               int value = Integer.parseInt( inputField.getText() );

               if ( sieve.get( value ) )
                  statusLabel.setText( value + " is a prime number" );

               else
                  statusLabel.setText( value + " is not a prime number" );
            }

         } // end inner class

      ); // end call to addActionListener 

      JTextArea primesArea = new JTextArea();

      container.add( new JScrollPane( primesArea ), BorderLayout.CENTER );

      int size = sieve.size(); // set all bits from 2 to 1023

      for ( int i = 2; i < size; i++ )
         sieve.set( i );

      // perform Sieve of Eratosthenes
      int finalBit = ( int ) Math.sqrt( size);

      for ( int i = 2; i < finalBit; i++ ) 

         if ( sieve.get( i ) ) 

            for ( int j = 2 * i; j < size; j += i ) 
               sieve.clear( j );

      int counter = 0; // display prime numbers from 2 to 1023

      for ( int i = 2; i < size; i++ )

         if ( sieve.get( i ) ) {
            primesArea.append( String.valueOf( i ) );
            primesArea.append( ++counter % 7 == 0 ? "\n" : "\t" );
         }

      setSize( 600, 450 );
      setVisible( true );

   } // end constructor

   public static void main( String args[] )
   {
      BitSetTest application = new BitSetTest();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // end class BitSetTest

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
