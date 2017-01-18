// Fig. 17.14: WriteRandomFile.java
// This program uses textfields to get information from the user at the 
// keyboard and writes the information to a random-access file.
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import com.deitel.jhtp5.ch17.*;

public class WriteRandomFile extends JFrame {   
   private RandomAccessFile output;
   private BankUI userInterface;
   private JButton enterButton, openButton;
   
   private static final int NUMBER_RECORDS = 100;
  
   // set up GUI
   public WriteRandomFile()
   {
      super( "Write to random access file" );

      // create instance of reusable user interface BankUI
      userInterface = new BankUI( 4 );  // four textfields
      getContentPane().add( userInterface,
         BorderLayout.CENTER );

      // get reference to generic task button doTask1 in BankUI
      openButton = userInterface.getDoTask1Button();
      openButton.setText( "Open..." );

      // register listener to call openFile when button pressed
      openButton.addActionListener(

         // anonymous inner class to handle openButton event
         new ActionListener() {

            // allow user to select file to open
            public void actionPerformed( ActionEvent event )
            {
               openFile();
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // register window listener for window closing event
      addWindowListener(

         // anonymous inner class to handle windowClosing event
         new WindowAdapter() {

            // add record in GUI, then close file
            public void windowClosing( WindowEvent event )
            {
               if ( output != null ) 
                  addRecord();

               closeFile();
            }

         } // end anonymous inner class

      ); // end call to addWindowListener

      // get reference to generic task button doTask2 in BankUI
      enterButton = userInterface.getDoTask2Button();
      enterButton.setText( "Enter" );
      enterButton.setEnabled( false );

      // register listener to call addRecord when button pressed
      enterButton.addActionListener(

         // anonymous inner class to handle enterButton event
         new ActionListener() {

            // add record to file
            public void actionPerformed( ActionEvent event )
            {
               addRecord();
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      setSize( 300, 150 );
      setVisible( true );  
   }

   // enable user to choose file to open
   private void openFile()
   {
      // display file dialog so user can select file
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );

      int result = fileChooser.showOpenDialog( this );
     
      // if user clicked Cancel button on dialog, return
      if ( result == JFileChooser.CANCEL_OPTION )
         return;

      // obtain selected file
      File fileName = fileChooser.getSelectedFile();

      // display error if file name invalid
      if ( fileName == null || fileName.getName().equals( "" ) )
         JOptionPane.showMessageDialog( this, "Invalid File Name", 
            "Invalid File Name", JOptionPane.ERROR_MESSAGE );

      else {

         // open file
         try {
            output = new RandomAccessFile( fileName, "rw" );
            enterButton.setEnabled( true );
            openButton.setEnabled( false );
         }

         // process exception while opening file
         catch ( IOException ioException ) {
            JOptionPane.showMessageDialog( this, "File does not exist",
               "Invalid File Name", JOptionPane.ERROR_MESSAGE );
         } 
         
      } // end else

   } // end method openFile

   // close file and terminate application
   private void closeFile() 
   {
      // close file and exit
      try {
         if ( output != null )
            output.close();

         System.exit( 0 );
      }

      // process exception while closing file
      catch( IOException ioException ) {
         JOptionPane.showMessageDialog( this, "Error closing file",
            "Error", JOptionPane.ERROR_MESSAGE );

         System.exit( 1 );
      }

   } // end method closeFile

   // add one record to file
   private void addRecord()
   {
      int accountNumber = 0;
      String fields[] = userInterface.getFieldValues();
      RandomAccessAccountRecord record = new RandomAccessAccountRecord();
      
      // ensure account field has a value
      if ( ! fields[ BankUI.ACCOUNT ].equals( "" ) ) {
      
         // output values to file
         try {
            accountNumber = Integer.parseInt( fields[ BankUI.ACCOUNT ] );

            if ( accountNumber > 0 && accountNumber <= NUMBER_RECORDS ) { 
               
               record.setAccount( accountNumber );
      
               record.setFirstName( fields[ BankUI.FIRSTNAME ] );
               record.setLastName( fields[ BankUI.LASTNAME ] );
               record.setBalance( Double.parseDouble(
                  fields[ BankUI.BALANCE ] ) );

               output.seek( ( accountNumber - 1 ) *
                  RandomAccessAccountRecord.SIZE );
               record.write( output );
            }
            else
            {
                JOptionPane.showMessageDialog( this,
                   "Account must be between 0 and 100",
                    "Invalid account number", JOptionPane.ERROR_MESSAGE );
            }
            
            userInterface.clearFields();  // clear TextFields

         } // end try

         // process improper account number or balance format
         catch ( NumberFormatException formatException ) {
                JOptionPane.showMessageDialog( this,
                   "Bad account number or balance",
                   "Invalid Number Format", JOptionPane.ERROR_MESSAGE );
         }

         // process exceptions while writing to file
         catch ( IOException ioException ) {
             JOptionPane.showMessageDialog( this,
                "Error writing to the file", "IO Exception",
                JOptionPane.ERROR_MESSAGE );
            closeFile();
         }

      } // end if

   } // end method addRecord
   
   public static void main( String args[] )
   {
      new WriteRandomFile();
   }

} // end class WriteRandomFile

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
 
