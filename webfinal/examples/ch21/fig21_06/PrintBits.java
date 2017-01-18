// Fig. 21.6: PrintBits.java
// Printing an unsigned integer in bits.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrintBits extends JFrame {
   private JTextField outputField;

   // set up GUI
   public PrintBits()
   {
      super( "Printing bit representations for numbers" );

      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      container.add( new JLabel( "Enter an integer " ) );

      // textfield to read value from user
      JTextField inputField = new JTextField( 10 );
      container.add( inputField );

      inputField.addActionListener(

         new ActionListener() { // anonymous inner class

            // read integer and get bitwise representation
            public void actionPerformed( ActionEvent event )
            {
               int value = Integer.parseInt( event.getActionCommand() );
               outputField.setText( getBits( value ) );
            }

         } // end anonymous inner class

      ); // end call to addActionListener 

      container.add( new JLabel( "The integer in bits is" ) );

      // textfield to display integer in bitwise form
      outputField = new JTextField( 33 );
      outputField.setEditable( false );
      container.add( outputField );

      setSize( 720, 70 );
      setVisible( true );

   } // end constructor

   // display bit representation of specified int value
   private String getBits( int value )
   {
      // create int value with 1 in leftmost bit and 0s elsewhere
      int displayMask = 1 << 31;

      StringBuffer buffer = new StringBuffer( 35 ); // buffer for output

      // for each bit append 0 or 1 to buffer
      for ( int bit = 1; bit <= 32; bit++ ) {

         // use displayMask to isolate bit
         buffer.append( ( value & displayMask ) == 0 ? '0' : '1' );

         value <<= 1; // shift value one position to left 

         if ( bit % 8 == 0 )
            buffer.append( ' ' ); // append space to buffer every 8 bits
      }

      return buffer.toString();

   } // end method getBits

   public static void main( String args[] )
   {
      PrintBits application = new PrintBits();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // end class PrintBits


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
