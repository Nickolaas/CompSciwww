// Fig. 17.23: FileChannelTest.java
// Demonstrates FileChannel and ByteBuffer.
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class FileChannelTest {
   private FileChannel fileChannel;

   // no-arg constructor
   public FileChannelTest()
   {
      // create random access file and get file channel
      try {
         RandomAccessFile file = new RandomAccessFile( "Test", "rw" );
         fileChannel = file.getChannel();
      }
      catch ( IOException ioException ) {
         ioException.printStackTrace();
      }

   } // end constructor FileChannelTest

   // write to writeChannel
   public void writeToFile() throws IOException
   {
      // create buffer for writing
      ByteBuffer buffer = ByteBuffer.allocate( 14 );

      // write an int, a char and a double to buffer
      buffer.putInt( 100 );
      buffer.putChar( 'A' );
      buffer.putDouble( 12.34 );

      // flip buffer and write buffer to fileChannel
      buffer.flip();
      fileChannel.write( buffer );
   } 

   // read from readChannel
   public void readFromFile() throws IOException
   {
      String content = "";

      // create buffer for read
      ByteBuffer buffer = ByteBuffer.allocate( 14 );
      
      // read buffer from fileChannel
      fileChannel.position( 0 );
      fileChannel.read( buffer );

      // flip buffer for reading
      buffer.flip();

      // obtain content
      content += buffer.getInt() + ", " + buffer.getChar() + ", " + 
         buffer.getDouble();

      System.out.println( "File contains: " + content );

      // close fileChannel
      fileChannel.close();

   } // end method readFromFile

   public static void main( String[] args ) 
   {
      FileChannelTest application = new FileChannelTest();
      
      // write to file and then read from file
      try {
         application.writeToFile();
         application.readFromFile();
      } 
      catch ( IOException ioException ) {
         ioException.printStackTrace();
      }
   } 

} // end class FileChannelTest


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
 