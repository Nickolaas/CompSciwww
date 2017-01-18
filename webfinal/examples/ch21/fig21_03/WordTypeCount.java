// Fig. 21.3: WordTypeCount.java
// Count the number of occurrences of each word in a string.
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class WordTypeCount extends JFrame {
   private JTextArea inputField;
   private JLabel prompt;
   private JTextArea display;
   private JButton goButton;
   
   private Hashtable table;

   public WordTypeCount()
   {
      super( "Word Type Count" );
      inputField = new JTextArea( 3, 20 );
      
      table = new Hashtable();
      
      goButton = new JButton( "Go" );
      goButton.addActionListener(

         new ActionListener() { // anonymous inner class

            public void actionPerformed( ActionEvent event )
            {
               createTable();
               display.setText( createOutput() );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      prompt = new JLabel( "Enter a string:" );
      display = new JTextArea( 15, 20 );
      display.setEditable( false );

      JScrollPane displayScrollPane = new JScrollPane( display );

      // add components to GUI
      Container container = getContentPane();
      container.setLayout( new FlowLayout() );
      container.add( prompt );
      container.add( inputField );
      container.add( goButton );
      container.add( displayScrollPane );

      setSize( 400, 400 );
      setVisible( true );

   } // end constructor
   
   // create table from user input
   private void createTable() {
      String input = inputField.getText();
      StringTokenizer words = new StringTokenizer( input, " \n\t\r" );
               
       while ( words.hasMoreTokens() ) {
         String word = words.nextToken().toLowerCase(); // get word
                  
         // if the table contains the word
         if ( table.containsKey( word ) ) {
            
            Integer count = (Integer) table.get( word ); // get value
                     
            // and increment it
            table.put( word, new Integer( count.intValue() + 1 ) );
         }
         else // otherwise add the word with a value of 1
            table.put( word, new Integer( 1 ) );
                  
       } // end while
      
   } // end method createTable
   
   // create string containing table values
   private String createOutput() {      
      String output = "";
      Enumeration keys = table.keys();
               
      // iterate through the keys
      while ( keys.hasMoreElements() ) {
         Object currentKey = keys.nextElement();
                  
         // output the key-value pairs
         output += currentKey + "\t" + table.get( currentKey ) + "\n";
      }
      
      output += "size: " + table.size() + "\n";
      output += "isEmpty: " + table.isEmpty() + "\n";
      
      return output;
               
   } // end method createOutput

   public static void main( String args[] )
   {
      WordTypeCount application = new WordTypeCount();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // end class WordTypeCount


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
