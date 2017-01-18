// Fig. 14.1: TextAreaDemo.java
// Copying selected text from one textarea to another. 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextAreaDemo extends JFrame {
   private JTextArea textArea1, textArea2;
   private JButton copyButton;

   // set up GUI
   public TextAreaDemo() 
   {
      super( "TextArea Demo" );

      Box box = Box.createHorizontalBox();

      String string = "This is a demo string to\n" + 
         "illustrate copying text\nfrom one textarea to \n" +
         "another textarea using an\nexternal event\n";

      // set up textArea1
      textArea1 = new JTextArea( string, 10, 15 );
      box.add( new JScrollPane( textArea1 ) );

      // set up copyButton
      copyButton = new JButton( "Copy >>>" );
      box.add( copyButton );
      copyButton.addActionListener(

         new ActionListener() {  // anonymous inner class 

            // set text in textArea2 to selected text from textArea1
            public void actionPerformed( ActionEvent event )
            {
               textArea2.setText( textArea1.getSelectedText() );
            }

         } // end anonymous inner class
 
      ); // end call to addActionListener

      // set up textArea2
      textArea2 = new JTextArea( 10, 15 );
      textArea2.setEditable( false );
      box.add( new JScrollPane( textArea2 ) );

      // add box to content pane
      Container cont