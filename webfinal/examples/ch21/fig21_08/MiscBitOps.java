// Fig. 21.8: MiscBitOps.java
// Using the bitwise operators.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MiscBitOps extends JFrame {
   private JTextField input1Field, input2Field, 
      bits1Field, bits2Field, bits3Field, resultField;
   private int value1, value2;

   // set up GUI
   public MiscBitOps()
   {
      super( "Bitwise operators" );

      JPanel inputPanel = new JPanel();
      inputPanel.setLayout( new GridLayout( 4, 2 ) );

      inputPanel.add( new JLabel( "Enter 2 ints" ) );
      inputPanel.add( new JLabel( "" ) );

      inputPanel.add( new JLabel( "Value 1" ) );
      input1Field = new JTextField( 8 );
      inputPanel.add( input1Field );

      inputPanel.add( new JLabel( "Value 2" ) );
      input2Field = new JTextField( 8 );
      inputPanel.add( input2Field );

      inputPanel.add( new JLabel( "Result" ) );
      resultField = new JTextField( 8 );
      resultField.setEditable( false );
      inputPanel.add( resultField );

      JPanel bitsPanel = new JPanel();
      bitsPanel.setLayout( new GridLayout( 4, 1 ) );
      bitsPanel.add( new JLabel( "Bit representations" ) );

      bits1Field = new JTextField( 33 );
      bits1Field.setEditable( false );
      bitsPanel.add( bits1Field );

      bits2Field = new JTextField( 33 );
      bits2Field.setEditable( false );
      bitsPanel.add( bits2Field );

      bits3Field = new JTextField( 33 );
      bits3Field.setEditable( false );
      bitsPanel.add( bits3Field );

      JPanel buttonPanel = new JPanel();

      // button to perform bitwise AND
      JButton andButton = new JButton( "AND" );
      buttonPanel.add( andButton );

      andButton.addActionListener(

         new ActionListener() { // anonymous inner class

            // perform bitwise AND and display results
            public void actionPerformed( ActionEvent event )
            {
               setFields();
               resultField.setText( Integer.toString( value1 & value2 ) );
               bits3Field.setText( getBits( value1 & value2 ) );
            }

         } // end anonymous inner class

      ); // end call to addActionListener 

      // button to perform bitwise inclusive OR
      JButton inclusiveOrButton = new JButton( "Inclusive OR" );
      buttonPanel.add( inclusiveOrButton );

      inclusiveOrButton.addActionListener(

         new ActionListener() { // anonymous inner class

            // perform bitwise inclusive OR and display results
            public void actionPerformed( ActionEvent event )
            {
               setFields();
               resultField.setText( Integer.toString( value1 | value2 ) );
               bits3Field.setText( getBits( value1 | value2 ) );
            }

         } // end anonymous inner class

      ); // end call to addActionListener 

      // button to perform bitwise exclusive OR
      JButton exclusiveOrButton = new JButton( "Exclusive OR" );
      buttonPanel.add( exclusiveOrButton );

      exclusiveOrButton.addActionListener(

         new ActionListener() { // anonymous inner class

            // perform bitwise exclusive OR and display results
            public void actionPerformed( ActionEvent event )
            {
               setFields();
               resultField.setText( Integer.toString( value1 ^ value2 ) );
               bits3Field.setText( getBits( value1 ^ value2 ) );
            }

         } // end anonymous inner class

      ); // end call to addActionListener 
               
      // button to perform bitwise complement
      JButton complementButton = new JButton( "Complement" );
      buttonPanel.add( complementButton );

      complementButton.addActionListener(

         new ActionListener() { // anonymous inner class

            // perform bitwise complement and display results
            public void actionPerformed( ActionEvent event )
            {
               input2Field.setText( "" );
               bits2Field.setText( "" );

               int value = Integer.parseInt( input1Field.getText() );

               resultField.setText( Integer.toString( ~value ) );
               bits1Field.setText( getBits( value ) );
               bits3Field.setText( getBits( ~value ) );
            }

         } // end anonymous inner class

      ); // end call to addActionListener 

      Container container = getContentPane();
      container.add( inputPanel, BorderLayout.WEST );
      container.add( bitsPanel, BorderLayout.EAST );
      container.add( buttonPanel, BorderLayout.SOUTH );

      setSize( 600, 150 );
      setVisible( true );

   } // end constructor

   // display numbers and their bit form
   private void setFields()
   {
      value1 = Integer.parseInt( input1Field.getText() );
      value2 = Integer.parseInt( input2Field.getText() );

      bits1Field.setText( getBits( value1 ) );
      bits2Field.setText( getBits( value2 ) );
   }

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
      MiscBitOps application = new MiscBitOps();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // end class MiscBitOps

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
