// Fig. 17.7: AccountRecord.java
// A class that represents one record of information.
package com.deitel.jhtp5.ch17;

import java.io.Serializable;

public class AccountRecord implements Serializable {
   private int account;
   private String firstName;
   private String lastName;
   private double balance;
   
   // no-argument constructor calls other constructor with default values
   public AccountRecord() 
   {
      this( 0, "", "", 0.0 );
   }
  
   // initialize a record
   public AccountRecord( int acct, String first, String last, double bal )
   {
      setAccount( acct );
      setFirstName( first );
      setLastName( last );
      setBalance( bal );
   }

   // set account number   
   public void setAccount( int acct )
   {
      account = acct;
   }

   // get account number   
   public int getAccount() 
   { 
      return account; 
   }
   
   // set first name   
   public void setFirstName( String first )
   {
      firstName = first;
   }

   // get first name   
   public String getFirstName() 
   { 
      return firstName; 
   }
   
   // set last name   
   public void setLastName( String last )
   {
      lastName = last;
   }

   // get last name   
   public String getLastName() 
   {
      return lastName; 
   }
   
   // set balance  
   public void setBalance( double bal )
   {
      balance = bal;
   }

   // get balance   
   public double getBalance() 
   { 
      return balance; 
   }

} // end class AccountRecord


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
