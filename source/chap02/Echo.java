//********************************************************************
//  Echo.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of the readString method of the Keyboard
//  class.
//********************************************************************

import cs1.Keyboard;

public class Echo
{
   //-----------------------------------------------------------------
   //  Reads a character string from the user and prints it.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      String message;

      System.out.println ("Enter a line of text:");

      message = Keyboard.readString();

      System.out.println ("You entered: \"" + message + "\"");
   }
}
