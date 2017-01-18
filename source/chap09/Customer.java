//*******************************************************************
// Customer.java        Author: Lewis/Loftus/Cocking
//
// Encapsulates a customer
//*******************************************************************

public class Customer
{
   int id;
   
   //----------------------------------------------------------------
   // Creates a customer with ID = number
   //----------------------------------------------------------------
   public Customer(int number)
   {
      id = number;
   }
   
   public String toString()
   {
      return "Customer " + id;
   }
}