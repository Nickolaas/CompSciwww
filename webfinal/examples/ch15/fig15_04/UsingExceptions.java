// Fig. 15.4: UsingExceptions.java
// Demonstration of stack unwinding.
public class UsingExceptions {

   public static void main( String args[] )
   {
      // call throwException to demonstrate stack unwinding
      try { 
         throwException();
      }

      // catch exception thrown in throwException
      catch ( Exception exception ) {
         System.err.println( "Exception handled in main" );
      }
   }

   // throwException throws exception that is not caught in this method
   public static void throwException() throws Exception
   {
      // throw an exception and catch it in main
      try { 
         System.out.println( "Method throwException" );
         throw new Exception();      // generate exception
      }

      // catch is incorrect type, so Exception is not caught
      catch( RuntimeException runtimeException ) {
         System.err.println( 
            "Exception handled in method throwException" );
      }

      // finally clause always executes 
      finally { 
         System.err.println( "Finally is always executed" );
      }

   } // end method throwException

} // end class UsingExceptions

