// Fig. 18.6: Server.java
// Server that receives and sends packets from/to a client.
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame {
   private JTextArea displayArea;
   private DatagramSocket socket;

   // set up GUI and DatagramSocket
   public Server()
   {
      super( "Server" );

      displayArea = new JTextArea();
      getContentPane().add( new JScrollPane( displayArea ),
         BorderLayout.CENTER );
      setSize( 400, 300 );
      setVisible( true );

      // create DatagramSocket for sending and receiving packets
      try {
         socket = new DatagramSocket( 5000 );
      }

      // process problems creating DatagramSocket
      catch( SocketException socketException ) {
         socketException.printStackTrace();
         System.exit( 1 );
      }

   } // end Server constructor

   // wait for packets to arrive, display data and echo packet to client
   private void waitForPackets()
   {
      while ( true ) { // loop forever

         // receive packet, display contents, return copy to client
         try {

            // set up packet
            byte data[] = new byte[ 100 ];
            DatagramPacket receivePacket = 
               new DatagramPacket( data, data.length );

            socket.receive( receivePacket ); // wait for packet

            // display information from received packet 
            displayMessage( "\nPacket received:" + 
               "\nFrom host: " + receivePacket.getAddress() + 
               "\nHost port: " + receivePacket.getPort() + 
               "\nLength: " + receivePacket.getLength() + 
               "\nContaining:\n\t" + new String( receivePacket.getData(), 
                  0, receivePacket.getLength() ) );

            sendPacketToClient( receivePacket ); // send packet to client
         }

         // process problems manipulating packet
         catch( IOException ioException ) {
            displayMessage( ioException.toString() + "\n" );
            ioException.printStackTrace();
         }

      } // end while

   } // end method waitForPackets

   // echo packet to client
   private void sendPacketToClient( DatagramPacket receivePacket ) 
      throws IOException
   {
      displayMessage( "\n\nEcho data to client..." );

      // create packet to send
      DatagramPacket sendPacket = new DatagramPacket( 
         receivePacket.getData(), receivePacket.getLength(), 
         receivePacket.getAddress(), receivePacket.getPort() );

      socket.send( sendPacket ); // send packet
      displayMessage( "Packet sent\n" );
   }

   // utility method called from other threads to manipulate 
   // displayArea in the event-dispatch thread
   private void displayMessage( final String messageToDisplay )
   {
      // display message from event-dispatch thread of execution
      SwingUtilities.invokeLater(
         new Runnable() {  // inner class to ensure GUI updates properly

            public void run() // updates displayArea
            {
               displayArea.append( messageToDisplay );
               displayArea.setCaretPosition( 
                  displayArea.getText().length() );
            }

         }  // end inner class

      ); // end call to SwingUtilities.invokeLater
   }

   public static void main( String args[] )
   {
      Server application = new Server();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      application.waitForPackets();
   }

} // end class Server

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