// Fig. 8.6: Time2.java
// Time class definition with set and get methods

// Java packages
import java.text.DecimalFormat;  

public class Time2 {
   private int hour;     // 0 - 23
   private int minute;   // 0 - 59
   private int second;   // 0 - 59

   // Time3 constructor initializes each instance variable
   // to zero. Ensures that Time object starts in a 
   // consistent state.
   public Time2() 
   { 
      setTime( 0, 0, 0 ); 
   }

   // Time3 constructor: hour supplied, minute and second
   // defaulted to 0
   public Time2( int h ) 
   { 
      setTime( h, 0, 0 ); 
   }

   // Time3 constructor: hour and minute supplied, second
   // defaulted to 0
   public Time2( int h, int m ) 
   { 
      setTime( h, m, 0 ); 
   }

   // Time3 constructor: hour, minute and second supplied
   public Time2( int h, int m, int s ) 
   { 
      setTime( h, m, s ); 
   }

   // Time3 constructor: another Time3 object supplied
   public Time2( Time2 time )
   {
      setTime( time.getHour(), time.getMinute(),
         time.getSecond() );
   }

   // Set Methods
   // Set a new time value using universal time. Perform 
   // validity checks on data. Set invalid values to zero.
   public void setTime( int h, int m, int s )
   {
      setHour( h );    // set the hour
      setMinute( m );  // set the minute
      setSecond( s );  // set the second
   }

   // validate and set hour 
   public void setHour( int h ) 
   { 
      hour = ( ( h >= 0 && h < 24 ) ? h : 0 ); 
   }

   // validate and set minute 
   public void setMinute( int m ) 
   { 
      minute = ( ( m >= 0 && m < 60 ) ? m : 0 ); 
   }

   // validate and set second 
   public void setSecond( int s ) 
   { 
      second = ( ( s >= 0 && s < 60 ) ? s : 0 ); 
   }

   // Get Methods
   // get hour value
   public int getHour() 
   { 
      return hour; 
   }

   // get minute value
   public int getMinute() 
   { 
      return minute; 
   }

   // get second value
   public int getSecond() 
   { 
      return second; 
   }

   // convert to String in universal-time format
   public String toString()
   {
      DecimalFormat twoDigits = new DecimalFormat( "00" );

      return twoDigits.format( getHour() ) + ":" +
         twoDigits.format( getMinute() ) + ":" +
         twoDigits.format( getSecond() );
   }

}  // end class Time3

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
 