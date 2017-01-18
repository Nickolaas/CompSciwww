// Fig. 14.2: CustomPanel.java
// A customized JPanel class.
import java.awt.*;
import javax.swing.*;

public class CustomPanel extends JPanel {
   public final static int CIRCLE = 1, SQUARE = 2;
   private int shape;

   // use shape to draw an oval or rectangle
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      if ( shape == CIRCLE )
         g.fillOval( 50, 10, 60, 60 );
      else if ( shape == SQUARE )
         g.fillRect( 50, 10, 60, 60 );
   }

   // set shape value and repaint CustomPanel
   public void draw( int shapeToDraw )
   {
      shape = shapeToDraw;
      repaint();
   }

} // end class CustomPanel



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
