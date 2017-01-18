// Fig. 14.15: BoxLayoutDemo.java
// Demonstrating BoxLayout.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoxLayoutDemo extends JFrame {

   // set up GUI
   public BoxLayoutDemo()
   {
      super( "Demostrating BoxLayout" );

      // create Box containers with BoxLayout
      Box horizontal1 = Box.createHorizontalBox();
      Box vertical1 = Box.createVerticalBox();
      Box horizontal2 = Box.createHorizontalBox();
      Box vertical2 = Box.createVerticalBox();

      final int SIZE = 3; // number of buttons on each Box

      // add buttons to Box horizontal1
      for ( int count = 0; count < SIZE; count++ )
         horizontal1.add( new JButton( "Button " + count ) );

      // create strut and add buttons to Box vertical1
      for ( int count = 0; count < SIZE; count++ ) {
         vertical1.add( Box.createVerticalStrut( 25 ) );
         vertical1.add( new JButton( "Button " + count ) );
      }

      // create horizontal glue and add buttons to Box horizontal2
      for ( int count = 0; count < SIZE; count++ ) {
         horizontal2.add( Box.createHorizontalGlue() );
         horizontal2.add( new JButton( "Button " + count ) );
      }

      // create rigid area and add buttons to Box vertical2
      for ( int count = 0; count < SIZE; count++ ) {
         vertical2.add( Box.createRigidArea( new Dimension( 12, 8 ) ) );
         vertical2.add( new JButton( "Button " + count ) );
      }

      // create vertical glue and add buttons to panel
      JPanel panel = new JPanel();
      panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );

      for ( int count = 0; count < SIZE; count++ ) {
         panel.add( Box.createGlue() );
         panel.add( new JButton( "Button " + count ) );
      }

      // create a JTabbedPane
      JTabbedPane tabs = new JTabbedPane( 
         JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT ); 

      // place each container on tabbed pane
      tabs.addTab( "Horizontal Box", horizontal1 );
      tabs.addTab( "Vertical Box with Struts", vertical1 );
      tabs.addTab( "Horizontal Box with Glue", horizontal2 );
      tabs.addTab( "Vertical Box with Rigid Areas", vertical2 );
      tabs.addTab( "Vertical Box with Glue", panel );

      getContentPane().add( tabs );  // place tabbed pane on content pane

      setSize( 400, 220 );
      setVisible( true );

   } // end constructor

   public static void main( String args[] )
   {
      BoxLayoutDemo application = new BoxLayoutDemo();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // end class BoxLayoutDemo

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
