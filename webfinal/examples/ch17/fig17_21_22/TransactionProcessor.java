// Fig. 17.21: TransactionProcessor.java
// A transaction processing program using random-access files.
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import javax.swing.*;

import com.deitel.jhtp5.ch17.*;

public class TransactionProcessor extends JFrame {
   
   private BankUI userInterface;
   private JMenuItem newItem, updateItem, deleteItem, openItem, exitItem;
   private JTextField fields[];
   private JTextField accountField, transactionField;
   private JButton actionButton, cancelButton;
   private FileEditor dataFile;
   private RandomAccessAccountRecord record;
    
   public TransactionProcessor()
   {
      super( "Transaction Processor" );
      
      // set up desktop, menu bar and File menu
      userInterface = new BankUI( 5 );
      getContentPane().add( userInterface );
      userInterface.setVisible( false );
      
      // set up the action button
      actionButton = userInterface.getDoTask1Button();
      actionButton.setText( "Save Changes" );
      actionButton.setEnabled( false );
      
      // register action button listener
      actionButton.addActionListener( 
      
         new ActionListener() { // anonymous inner class
            
            public void actionPerformed( ActionEvent event )
            {
               String action = event.getActionCommand();
               performAction( action );
               
            } // end method actionPerformed
            
         } // end anonymous inner class
      
      ); // end call to addActionListener
      
      // set up the cancel button
      cancelButton = userInterface.getDoTask2Button();
      cancelButton.setText( "Cancel" );
      cancelButton.setEnabled( false );
      
      // register cancel button listener
      cancelButton.addActionListener( 
      
         new ActionListener() { // anonymous inner class
            
            // clear the fields
            public void actionPerformed( ActionEvent event ) 
            {
               userInterface.clearFields();
            }
            
         } // end anonymous inner class
      
      ); // end call to addActionListener
      
      // set up the listener for the account field
      fields = userInterface.getFields();
      accountField = fields[ BankUI.ACCOUNT ];
      accountField.addActionListener( 
      
         new ActionListener() { // anonymous inner class
            
            public void actionPerformed( ActionEvent event )
            {
               displayRecord( "0" );
            }
            
         } // end anonymous inner class
      
      ); // end call to addActionListener
      
      // create reference to the transaction field
      transactionField = fields[ BankUI.TRANSACTION ];
      
      // register transaction field listener
      transactionField.addActionListener( 
      
         new ActionListener() { // anonymous inner class
            
            // update the GUI fields
            public void actionPerformed( ActionEvent event ) 
            {
               displayRecord( transactionField.getText() );
            }
            
         } // end anonymous inner class
      
      ); // end call to addActionListener

      JMenuBar menuBar = new JMenuBar(); // set up the menu
      setJMenuBar( menuBar );

      JMenu fileMenu = new JMenu( "File" );
      menuBar.add( fileMenu );
      
      // set up menu item for adding a record
      newItem = new JMenuItem( "New Record" ); 
      newItem.setEnabled( false );
      
      // register new item listener
      newItem.addActionListener( 
      
         new ActionListener() { // anonymous inner class
         
            public void actionPerformed( ActionEvent event ) 
            {
            
               // set up the GUI fields for editing
               fields[ BankUI.ACCOUNT ].setEnabled( true );
               fields[ BankUI.FIRSTNAME ].setEnabled( true );
               fields[ BankUI.LASTNAME ].setEnabled( true );
               fields[ BankUI.BALANCE ].setEnabled( true );
               fields[ BankUI.TRANSACTION ].setEnabled( false );
               
               actionButton.setEnabled( true );
               actionButton.setText( "Create" );
               cancelButton.setEnabled( true );
            
               userInterface.clearFields(); // reset the textfields
               
            } // end method actionPerformed
            
         } // end anonymous inner class
      
      ); // end call to addActionListener
      
      // set up menu item for updating a record
      updateItem = new JMenuItem( "Update Record" );
      updateItem.setEnabled( false );
      
      // register update item listener
      updateItem.addActionListener( 
      
         new ActionListener() { // anonymous inner class
            
            public void actionPerformed( ActionEvent event ) 
            {
               // set up the GUI fields for editing
               fields[ BankUI.ACCOUNT ].setEnabled( true );
               fields[ BankUI.FIRSTNAME ].setEnabled( false );
               fields[ BankUI.LASTNAME ].setEnabled( false );
               fields[ BankUI.BALANCE ].setEnabled( false );
               fields[ BankUI.TRANSACTION ].setEnabled( true );
               
               actionButton.setEnabled( true );
               actionButton.setText( "Update" );
               cancelButton.setEnabled( true );
            
               userInterface.clearFields(); // reset the textfields
               
            } // end method actionPerformed
            
         } // end anonymous inner class
      
      ); // end call to addActionListener
      
      // set up menu item for deleting a record
      deleteItem = new JMenuItem( "Delete Record" );
      deleteItem.setEnabled( false );
      
      // register delete item listener
      deleteItem.addActionListener( 
      
         new ActionListener() { // anonymous inner class
            
            public void actionPerformed( ActionEvent event ) 
            {
               // set up the GUI fields for editing
               fields[ BankUI.ACCOUNT ].setEnabled( true );
               fields[ BankUI.FIRSTNAME ].setEnabled( false );
               fields[ BankUI.LASTNAME ].setEnabled( false );
               fields[ BankUI.BALANCE ].setEnabled( false );
               fields[ BankUI.TRANSACTION ].setEnabled( false );
               
               actionButton.setEnabled( true );
               actionButton.setText( "Delete" );
               cancelButton.setEnabled( true );
            
               userInterface.clearFields(); // reset the textfields
               
            } // end method actionPerformed
            
         } // end anonymous inner class
      
      ); // end call to addActionListener

      // set up menu item for opening file
      openItem = new JMenuItem( "New/Open File" );
      
      // register open item listener
      openItem.addActionListener( 
      
         new ActionListener() { // anonymous inner class
            
            public void actionPerformed( ActionEvent event ) 
            {
               // try to open the file
               if ( !openFile() )
                  return;
            
               // set up the menu items
               newItem.setEnabled( true );
               updateItem.setEnabled( true );
               deleteItem.setEnabled( true );
               openItem.setEnabled( false );
            
               // set the interface
               userInterface.setVisible( true );
               fields[ BankUI.ACCOUNT ].setEnabled( false );
               fields[ BankUI.FIRSTNAME ].setEnabled( false );
               fields[ BankUI.LASTNAME ].setEnabled( false );
               fields[ BankUI.BALANCE ].setEnabled( false );
               fields[ BankUI.TRANSACTION ].setEnabled( false );
               
            } // end method actionPerformed
            
         } // end anonymous inner class
      
      ); // end call to addActionListener
      
      // set up menu item for exiting program
      exitItem = new JMenuItem( "Exit" );
      
      // register exit item listener
      exitItem.addActionListener( 
      
         new ActionListener() { // anonyomus inner class
         
            public void actionPerformed( ActionEvent event ) 
            {
               try {
                  dataFile.closeFile(); // close the file
               }
               
               catch ( IOException ioException ) {
                  JOptionPane.showMessageDialog( 
                     TransactionProcessor.this, "Error closing file", 
                     "IO Error", JOptionPane.ERROR_MESSAGE );
               }
               
               finally {
                  System.exit( 0 ); // exit the program
               }
               
            } // end method actionPerformed
            
         } // end anonymous inner class
      
      ); // end call to addActionListener
        
      // attach menu items to File menu
      fileMenu.add( openItem );
      fileMenu.add( newItem );
      fileMenu.add( updateItem );
      fileMenu.add( deleteItem );
      fileMenu.addSeparator();
      fileMenu.add( exitItem );

      setSize( 400, 250  );
      setVisible( true );
      
    } // end constructor
    
   public static void main( String args[] )
   { 
      new TransactionProcessor();
   }

   // get the file name and open the file
   private boolean openFile()
   {
      // display dialog so user can select file
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );

      int result = fileChooser.showOpenDialog( this );

      // if user clicked Cancel button on dialog, return
      if ( result == JFileChooser.CANCEL_OPTION )
         return false;
      
      // obtain selected file
      File fileName = fileChooser.getSelectedFile(); 
      
      // display error if file name invalid
      if ( fileName == null || fileName.getName().equals( "" ) ) {
         JOptionPane.showMessageDialog( this, "Invalid File Name",
            "Bad File Name", JOptionPane.ERROR_MESSAGE );
         return false;
      }
       
      try {
         // call the helper method to open the file
         dataFile = new FileEditor( fileName ); 
      }
            
      catch( IOException ioException ) {
         JOptionPane.showMessageDialog( this, "Error Opening File",
            "IO Error", JOptionPane.ERROR_MESSAGE );
         return false;
      }
       
      return true;
      
   } // end method openFile

   // create, update or delete the record
   private void performAction( String action )
   {
      try {
         
         // get the textfield values
         String[] values = userInterface.getFieldValues();
     
         int accountNumber = Integer.parseInt( values[ BankUI.ACCOUNT ] );
         String firstName = values[ BankUI.FIRSTNAME ];
         String lastName = values[ BankUI.LASTNAME ];
         double balance = Double.parseDouble( values[ BankUI.BALANCE ] );
         
         if ( action.equals( "Create" ) )
            dataFile.newRecord( accountNumber, // create a new record
               firstName, lastName, balance );
         
         else if ( action.equals( "Update" ) )
            dataFile.updateRecord( accountNumber, // update record
               firstName, lastName, balance );
         
         else if ( action.equals( "Delete" ) )
            dataFile.deleteRecord( accountNumber ); // delete record
         
         else
            JOptionPane.showMessageDialog( this, "Invalid Action", 
               "Error executing action", JOptionPane.ERROR_MESSAGE );

      } // end try
      
      catch( NumberFormatException format ) {
         JOptionPane.showMessageDialog( this, "Bad Input",
            "Number Format Error", JOptionPane.ERROR_MESSAGE );
      }
      
      catch( IllegalArgumentException badAccount ) {
         JOptionPane.showMessageDialog( this, badAccount.getMessage(),
            "Bad Account Number", JOptionPane.ERROR_MESSAGE );
      }
      catch( IOException ioException ) {
         JOptionPane.showMessageDialog( this, "Error writing to the file",
            "IO Error", JOptionPane.ERROR_MESSAGE );
      }
      
   } // end method performAction
   
   //  input a record in the textfields and update the balance
   private void displayRecord( String transaction )
   {
      try {
         // get the account number
         int accountNumber = Integer.parseInt( 
            userInterface.getFieldValues()[ BankUI.ACCOUNT ] );
      
         // get the associated record
         RandomAccessAccountRecord record =
            dataFile.getRecord( accountNumber );
         
         if ( record.getAccount() == 0 )
            JOptionPane.showMessageDialog( this, "Record does not exist", 
               "Bad Account Number",  JOptionPane.ERROR_MESSAGE );
         
         // get the transaction
         double change = Double.parseDouble( transaction );
     
         // create a string array to send to the textfields
         String[] values = { String.valueOf( record.getAccount() ),
            record.getFirstName(), record.getLastName(),
            String.valueOf( record.getBalance() + change ),
            "Charge(+) or payment (-)" };
     
         userInterface.setFieldValues( values );

      } // end try
      
      catch( NumberFormatException format ) {
         JOptionPane.showMessageDialog( this, "Bad Input",
            "Number Format Error", JOptionPane.ERROR_MESSAGE );
      }
      
      catch ( IllegalArgumentException badAccount ) {
         JOptionPane.showMessageDialog( this, badAccount.getMessage(),
            "Bad Account Number", JOptionPane.ERROR_MESSAGE );
      }
      
      catch( IOException ioException ) {
         JOptionPane.showMessageDialog( this, "Error reading the file",
            "IO Error", JOptionPane.ERROR_MESSAGE );
      }
      
   } // end method displayRecord
   
} // end class TransactionProcessor


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