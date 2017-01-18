// Fig. 14.13: JTabbedPaneDemo.java
// Demonstrating JTabbedPane.
import java.awt.*;
import javax.swing.*;

public class JTabbedPaneDemo extends JFrame  {

   // set up GUI
   public JTabbedPaneDemo()
   {
      super( "JTabbedPane Demo " );

      // create JTabbedPane 
      JTabbedPane tabbedPane = new JTabbedPane();

      // set up pane11 and add it to JTabbedPane 
      JLabel label1 = new JLabel( "panel one", SwingConstants.CENTER );
      JPanel panel1 = new JPanel();
      panel1.add( label1 ); 
      tabbedPane.addTab( "Tab One", null, panel1, "First Panel" ); 
      
      // set up panel2 and add it to JTabbedPane
      JLabel label2 = new JLabel( "panel two", SwingConstants.CENTER );
      JPanel panel2 = new JPanel();
      panel2.setBackground( Color.YELLOW );
      panel2.add( label2 );
      tabbedPane.addTab( "Tab Two", null, panel2, "Second Panel" ); 

      // set up panel3 and add it to JTabbedPane
      JLabel label3 = new JLabel( "panel three" );
      JPanel panel3 = new JPanel();
      panel3.setLayout( new BorderLayout() );  
      panel3.add( new JButton( "North" ), BorderLayout.NORTH );
      panel3.add( new JButton( "West" ), BorderLayout.WEST );
      panel3.add( new JButton( "East" ), BorderLayout.EAST );
      panel3.add( new JButton( "South" ), BorderLayout.SOUTH );
      panel3.add( label3, BorderLayout.CENTER );
      tabbedPane.addTab( "Tab Three", null, panel3, "Third Panel" );

      // add JTabbedPane to container
      getContentPane().add( tabbedPane );

      setSize( 250, 200 );
      setVisible( true );

   } // end constructor

   public static void main( String args[] )
   {
      JTabbedPaneDemo tabbedPaneDemo = new JTabbedPaneDemo();
      tabbedPaneDemo.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // end class JTabbedPaneDemo

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
