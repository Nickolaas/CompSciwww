// Fig. 23.26: DisplayAuthors.java
// Displaying the contents of the authors table.
 
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class DisplayAuthors extends JFrame {
   
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.ibm.db2j.jdbc.DB2jDriver";
   static final String DATABASE_URL = "jdbc:db2j:books";
   
   // declare Connection and Statement for accessing 
   // and querying database
   private Connection connection;
   private Statement statement;
   
   // constructor connects to database, queries database, processes 
   // results and displays results in window
   public DisplayAuthors() 
   {
      super( "Authors Table of Books Database" );
      
      // connect to database books and query database
      try {
         
         // specify location of database on filesystem
         System.setProperty( "db2j.system.home", "C:/Cloudscape_5.0" );
         
         // load database driver class
         Class.forName( JDBC_DRIVER );

         // establish connection to database
         connection = DriverManager.getConnection( DATABASE_URL );

         // create Statement for querying database
         statement = connection.createStatement();
         
         // query database
         ResultSet resultSet = 
            statement.executeQuery( "SELECT * FROM authors" );
         
         // process query results
         StringBuffer results = new StringBuffer();
         ResultSetMetaData metaData = resultSet.getMetaData();
         int numberOfColumns = metaData.getColumnCount();
         
         for ( int i = 1; i <= numberOfColumns; i++ )
            results.append( metaData.getColumnName( i ) + "\t" );
         
         results.append( "\n" );
         
         while ( resultSet.next() ) {
            
            for ( int i = 1; i <= numberOfColumns; i++ )
               results.append( resultSet.getObject( i ) + "\t" );
            
            results.append( "\n" );
         }

         // set up GUI and display window
         JTextArea textArea = new JTextArea( results.toString() );
         Container container = getContentPane();

         container.add( new JScrollPane( textArea ) );
         
         setSize( 300, 100 );  // set window size
         setVisible( true );   // display window

      }  // end try
      
      // detect problems interacting with the database
      catch ( SQLException sqlException ) {
         JOptionPane.showMessageDialog( null, sqlException.getMessage(), 
            "Database Error", JOptionPane.ERROR_MESSAGE );
         
         System.exit( 1 );
      }
      
      // detect problems loading database driver
      catch ( ClassNotFoundException classNotFound ) {
         JOptionPane.showMessageDialog( null, classNotFound.getMessage(), 
            "Driver Not Found", JOptionPane.ERROR_MESSAGE );            

         System.exit( 1 );
      }
      
      // ensure statement and connection are closed properly
      finally {
         
         try {
            statement.close();
            connection.close();            
         }
         
         // handle exceptions closing statement and connection
         catch ( SQLException sqlException ) {
            JOptionPane.showMessageDialog( null, 
               sqlException.getMessage(), "Database Error", 
               JOptionPane.ERROR_MESSAGE );
         
            System.exit( 1 );
         }
      }

   }  // end DisplayAuthors constructor
   
   // launch the application
   public static void main( String args[] )
   {
      DisplayAuthors window = new DisplayAuthors();      
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

}  // end class DisplayAuthors


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
 