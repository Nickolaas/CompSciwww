// Fig. 21.4: PropertiesTest.java
// Demonstrates class Properties of the java.util package.
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class PropertiesTest extends JFrame {
   private JLabel statusLabel;
   private Properties table;
   private JTextArea displayArea;
   private JTextField valueField, nameField;

   // set up GUI to test Properties table
   public PropertiesTest()
   {
      super( "Properties Test" );

      table = new Properties(); // create Properties table

      Container container = getContentPane();

      // set up NORTH of window's BorderLayout
      JPanel northSubPanel = new JPanel(); 

      northSubPanel.add( new JLabel( "Property value" ) );
      valueField = new JTextField( 10 );
      northSubPanel.add( valueField );

      northSubPanel.add( new JLabel( "Property name (key)" ) );
      nameField = new JTextField( 10 );
      northSubPanel.add( nameField );

      JPanel northPanel = new JPanel();
      northPanel.setLayout( new BorderLayout() );
      northPanel.add( northSubPanel, BorderLayout.NORTH );

      statusLabel = new JLabel();
      northPanel.add( statusLabel, BorderLayout.SOUTH );

      container.add( northPanel, BorderLayout.NORTH );

      // set up CENTER of window's BorderLayout
      displayArea = new JTextArea( 4, 35 );     
      container.add( new JScrollPane( displayArea ),
         BorderLayout.CENTER );

      // set up SOUTH of window's BorderLayout
      JPanel southPanel = new JPanel();
      southPanel.setLayout( new GridLayout( 1, 5 ) );

      // button to put a name-value pair in Properties table
      JButton putButton = new JButton( "Put" );
      southPanel.add( putButton );

      putButton.addActionListener(

         new ActionListener() { // anonymous inner class

            // put name-value pair in Properties table
            public void actionPerformed( ActionEvent event )
            {
               Object value = table.setProperty(  
                  nameField.getText(), valueField.getText() );

               if ( value == null )
                  showstatus( "Put: " + nameField.getText() +
                     " " + valueField.getText() );

               else
                  showstatus( "Put: " + nameField.getText() + " " + 
                     valueField.getText() + "; Replaced: " + value );

               listProperties();
            }

         } // end anonymous inner class

      ); // end call to addActionListener 

      // button to empty contents of Properties table
      JButton clearButton = new JButton( "Clear" );
      southPanel.add( clearButton );

      clearButton.addActionListener(

         new ActionListener() { // anonymous inner class

            // use method clear to empty table
            public void actionPerformed( ActionEvent event )
            {
               table.clear();
               showstatus( "Table in memory cleared" );
               listProperties();
            }

         } // end anonymous inner class

      ); // end call to addActionListener 

      // button to get value of a property
      JButton getPropertyButton = new JButton( "Get property" );
      southPanel.add( getPropertyButton );

      getPropertyButton.addActionListener(

         new ActionListener() { // anonymous inner class

            // use method getProperty to obtain a property value
            public void actionPerformed( ActionEvent event )
            {
               Object value = table.getProperty( 
                  nameField.getText() );
             
               if ( value != null )
                  showstatus( "Get property: " + nameField.getText() + 
                     " " + value.toString() );

               else
                  showstatus( "Get: " + nameField.getText() + 
                     " not in table" );

               listProperties();
            }

         } // end anonymous inner class

      ); // end call to addActionListener 

      // button to save contents of Properties table to file
      JButton saveButton = new JButton( "Save" );
      southPanel.add( saveButton );

      saveButton.addActionListener(

         new ActionListener() { // anonymous inner class

            // use method save to place contents in file
            public void actionPerformed( ActionEvent event )
            {
               // save contents of table
               try {
                  FileOutputStream output =
                     new FileOutputStream( "props.dat" );
                  
                  table.store( output, "Sample Properties" );
                  output.close();

                  listProperties();
               }
           
               // process problems with file output
               catch( IOException ioException ) {
                  ioException.printStackTrace();
               }
            }

         } // end anonymous inner class

      ); // end call to addActionListener 

      // button to load contents of Properties table from file
      JButton loadButton = new JButton( "Load" );
      southPanel.add( loadButton );

      loadButton.addActionListener(

         new ActionListener() { // anonymous inner class

            // use method load to read contents from file
            public void actionPerformed( ActionEvent event )
            {
               // load contents of table
               try {
                  FileInputStream input = 
                     new FileInputStream( "props.dat" );
                  
                  table.load( input );
                  input.close();
                  listProperties();
               }
           
               // process problems with file input
               catch( IOException ioException ) {
                  ioException.printStackTrace();
               }
            }

         } // end anonymous inner class

      ); // end call to addActionListener 

      container.add( southPanel, BorderLayout.SOUTH );

      setSize( 550, 225 );
      setVisible( true );

   } // end constructor

   // output property values
   public void listProperties()
   {
      StringBuffer buffer = new StringBuffer();
      String name, value;

      Enumeration enumeration = table.propertyNames();

      while ( enumeration.hasMoreElements() ) {
         name = enumeration.nextElement().toString();
         value = table.getProperty( name );

         buffer.append( name ).append( '\t' );
         buffer.append( value ).append( '\n' );
      }

      displayArea.setText( buffer.toString() );
   }

   // display String in statusLabel label
   public void showstatus( String s )
   {
      statusLabel.setText( s );
   }

   public static void main( String args[] )
   {
      PropertiesTest application = new PropertiesTest();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // end class PropertiesTest

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
