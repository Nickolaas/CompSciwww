// Fig. 19.6: LoadAudioAndPlay.java
// Load an audio clip and play it.

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoadAudioAndPlay extends JApplet {
   private AudioClip sound1, sound2, currentSound;  
   private JButton playSound, loopSound, stopSound;
   private JComboBox chooseSound;

   // load the image when the applet begins executing
   public void init()
   {
      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      String choices[] = { "Welcome", "Hi" };
      chooseSound = new JComboBox( choices );

      chooseSound.addItemListener(

         new ItemListener() {

            // stop sound and change to sound to user's selection
            public void itemStateChanged( ItemEvent e )
            {
               currentSound.stop();

               currentSound =
                  chooseSound.getSelectedIndex() == 0 ? sound1 : sound2;
            }

         } // end anonymous inner class

      ); // end addItemListener method call

      container.add( chooseSound );

      // set up button event handler and buttons
      ButtonHandler handler = new ButtonHandler();

      playSound = new JButton( "Play" );
      playSound.addActionListener( handler );
      container.add( playSound );

      loopSound = new JButton( "Loop" );
      loopSound.addActionListener( handler );
      container.add( loopSound );

      stopSound = new JButton( "Stop" );
      stopSound.addActionListener( handler );
      container.add( stopSound );

      // load sounds and set currentSound
      sound1 = getAudioClip( getDocumentBase(), "welcome.wav" );
      sound2 = getAudioClip( getDocumentBase(), "hi.au" );
      currentSound = sound1;

   } // end method init

   // stop the sound when the user switches Web pages
   public void stop()
   {
      currentSound.stop();
   }

   // private inner class to handle button events
   private class ButtonHandler implements ActionListener {

      // process play, loop and stop button events
      public void actionPerformed( ActionEvent actionEvent )
      {
         if ( actionEvent.getSource() == playSound ) 
            currentSound.play();

         else if ( actionEvent.getSource() == loopSound ) 
            currentSound.loop();

         else if ( actionEvent.getSource() == stopSound ) 
            currentSound.stop();
      }

   } // end class ButtonHandler

} // end class LoadAudioAndPlay

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
