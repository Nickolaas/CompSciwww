// Fig. 21.11: BitShift.java
// Using the bitwise shift operators.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BitShift extends JFrame {
   private JTextField bitsField, valueField;

   // set up GUI
   public BitShift()
   {
      super( "Shifting bits" );

      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      container.add( new JLabel( "Integer to shift " ) );

      // textfield for user to input integer
      valueField = new JTextField( 12 ); 
      container.add( valueField );      

      valueField.addActionListener(

         new ActionListener() { // anonymous inner class

            // read value and display its bitwise representation
            public void actionPerformed( ActionEvent event )
            {
               int value = Integer.parseInt( valueField.getText() );
               bitsField.setText( getBits( value ) );
            }

         } // end anonymous inner class

      ); // end call to addActionListener                  
      
      // textfield to display bitwise representation of an integer
      bitsField = new JTextField( 33 );
      bitsField.setEditable( false );
      container.add( bitsField );      

      // button to shift bits left by one position
      JButton leftButton = new JButton( "<<" );
      container.add( leftButton ); 

      leftButton.addActionListener(

         new ActionListener() { // anonymous inner class

            // left shift one position and display new value
            public void actionPerformed( ActionEvent event )
            {
               int value = Integer.parseInt( valueField.getText() );
               value <<= 1;
               valueField.setText( Integer.toString( value ) );
               bitsField.setText( getBits( value ) );
            }

         } // end anonymous inner class

      ); // end call to addActionListener 

      // button to signed right shift value one position
      JButton rightSignButton = new JButton( ">>" );
      container.add( rightSignButton ); 

      rightSignButton.addActionListener(

         new ActionListener() { // anonymous inner class

            // right shift one position and display new value
            public void actionPerformed( ActionEvent event )
            {
               int value = Integer.parseInt( valueField.getText() );
               value >>= 1;
               valueField.setText( Integer.toString( value ) );
               bitsField.setText( getBits( value ) );
            }

         } // end anonymous inner class

      ); // end call to addActionListener     

      // button to unsigned right shift value one position
      JButton rightZeroButton = new JButton( ">>>" );
      container.add( rightZeroButton );

      rightZeroButton.addActionListener(

         new ActionListener() { // anonymous inner class

            // right shift one position and display new value
            public void actionPerformed( ActionEvent event )
            {
               int value = Integer.parseInt( valueField.getText() );
               value >>>= 1;
               valueField.setText( Integer.toString( value ) );

               bitsField.setText( getBits( value ) );
            }

         } // end anonymous inner class

      ); // end call to addActionListener 

      setSize( 400, 120 );
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
      BitShift application = new BitShift();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // end class BitShift

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
