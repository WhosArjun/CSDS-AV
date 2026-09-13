package TryCatch;
/**
Question 1: Compile the program and report any compile-time error you found.
Question 2: Is MyException a runtime exception or compile-time exception?
Question 3: If we want to deal with the exception in method third, what should we do?
Question 4: If we want to deal with the exception in method second, what should we do?
Question 5: If we want to deal with the exception in method first, what should we do?
Question 6: If we want to deal with the exception in method main, what should we do?
*/

/*
    1) No compile time errors in the program
    2) MyException is a compile time checked exception, because it extends the Exception class
    3) If we want to deal with the exception in the method third(), we need to have a try statement which has throw new MyException ("yours"), and then we need to catch that in the same method. Catch(Exception e), and then print the catch statement.
    4) If we want to deal with the exception in the method second(), third() needs a throws statement of MyException, and then in second we need to try third(), and then catch.
    5) If we want to deal with the exception in the method first(), second() needs a throw statement of MyException, and then in first we need to try second(), and thne catch.
    6) If we want to deal with the exception in the method main(), we need first(), second(), and third() to have throws statements for MyException, and then try first() in main, and catch it.

 */
public class Ex2
{
   //Question 5 deal with the exception in first()
   public static void first() throws MyException 
   {
    try{
        second();
    }
    catch(Exception e){
        System.out.println("Caught exception in first()");
    }
   } // first

   //Question 4 deal with the exception in second()
   public static void second() throws MyException
   {
    try{
        third();
    }
    catch(Exception e){
        System.out.println("Caught exception in second()");
    }
      
   } // second
   
   //Question 3 deal with the exception in third()
   public static void third() throws MyException 
   {
    try{
        throw new MyException ("yours");   
    }
    catch(Exception e){
        System.out.println("Caught exception in third()");
    }
   } // third
   
   //Question 6 deal with the exception in main()
   public static void main (String [] args)
   {
    try{
        first();
    }
    catch(Exception e){
        System.out.println("Caught exception in main");
    }
      System.out.println ("In main and after first");
   }
}  // Ex2

/* Define a subclass of Exception */
class MyException extends Exception {
    
    /** Constructor: an instance with message m*/
   public MyException(String m) {
      super(m);
   }
    
    /** Constructor: an instance with no message */
   public MyException() {
      super();
   }
}



