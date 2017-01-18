// Fig. 15.3: UsingExceptions.java
// Demonstration of the try-catch-finally exception handling mechanism.
public class UsingExceptions {

   public static void main( String args[] )
   {
      try { 
         throwException(); // call method throwException
      }

      // catch Exceptions thrown by method throwException
      catch ( Exception exception ) {
         System.err.println( "Exception handled in main" );
      }

      doesNotThrowException();
   }

   // demonstrate try/catch/finally
   public static void throwException() throws Exception
   {
      // throw an exception and immediately catch it
      try { 
         System.out.println( "Method throwException" );
         throw new Exception();  // generate exception
      }

      // catch exception thrown in try block
      catch ( Exception exception ) {
         System.err.println(
            "Exception handled in method throwException" );
         throw exception;  // rethrow for further processing

         // any code here would not be reached
      }

      // this block executes regardless of what occurs in try/catch
      finally {
         System.err.println( "Finally executed in throwException" );
      }

      // any code here would not be reached

   } // end method throwException

   // demonstrate finally when no exception occurs
   public static void doesNotThrowException()
   {
      // try block does not throw an exception
      try { 
         System.out.println( "Method doesNotThrowException" );
      }

      // catch does not execute, because no exception thrown
      catch( Exception exception ) {
         System.err.println( exception );
      }

      // this clause executes regardless of what occurs in try/catch
      finally {
         System.err.println( 
            "Finally executed in doesNotThrowException" );
      }

      System.out.println( "End of method doesNotThrowException" );

   } // end method doesNotThrowException

} // end class UsingExceptions

