// Fig. 14.20: GridBagDemo2.java
// Demonstrating GridBagLayout constants.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridBagDemo2 extends JFrame { 
   private GridBagLayout layout;
   private GridBagConstraints constraints;
   private Container container;
    
   // set up GUI
   public GridBagDemo2()
   {
      super( "GridBagLayout" );

      container = getContentPane();
      layout = new GridBagLayout();
      container.setLayout( layout );   

      // instantiate gridbag constraints
      constraints = new GridBagConstraints();

      // create GUI components
      String metals[] = { "Copper", "Aluminum", "Silver" };
      JComboBox comboBox = new JComboBox( metals );

      JTextField textField = new JTextField( "TextField" );

      String fonts[] = { "Serif", "Monospaced" };
      JList list = new JList( fonts );

      String names[] = { "zero", "one", "two", "three", "four" };
      JButton buttons[] = new JButton[ names.length ];

      for ( int count = 0; count < buttons.length; count++ )
         buttons[ count ] = new JButton( names[ count ] );

      // define GUI component constraints for textField
      constraints.weightx = 1;
      constraints.weighty = 1;  
      constraints.fill = GridBagConstraints.BOTH;
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( textField );

      // buttons[0] -- weightx and weighty are 1: fill is BOTH
      constraints.gridwidth = 1;
      addComponent( buttons[ 0 ] );

      // buttons[1] -- weightx and weighty are 1: fill is BOTH
      constraints.gridwidth = GridBagConstraints.RELATIVE;
      addComponent( buttons[ 1 ] );

      // buttons[2] -- weightx and weighty are 1: fill is BOTH
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( buttons[ 2 ] );

      // comboBox -- weightx is 1: fill is BOTH
      constraints.weighty = 0;
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( comboBox );
      
      // buttons[3] -- weightx is 1: fill is BOTH
      constraints.weighty = 1;
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( buttons[ 3 ] ); 

      // buttons[4] -- weightx and weighty are 1: fill is BOTH
      constraints.gridwidth = GridBagConstraints.RELATIVE;
      addComponent( buttons[ 4 ] );

      // list -- weightx and weighty are 1: fill is BOTH
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( list );

      setSize( 300, 200 );
      setVisible( true );
  
   }  // end constructor

   // add a component to the container
   private void addComponent( Component component ) 
   {
      layout.setConstraints( component, constraints );
      container.add( component );      // add component
   }   

   public static void main( String args[] )
   {
      GridBagDemo2 application = new GridBagDemo2();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

}  // end class GridBagDemo2

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
