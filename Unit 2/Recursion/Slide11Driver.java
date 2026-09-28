
public class Slide11Driver {
   public static void main(String[] args) {
      // 1. Print an integer backward
      System.out.print("Integer backward (12345): ");
      RecursiveSolutions.printIntegerBackward(12345);
      System.out.println();
   
      // 2. Find max in array
      int[] nums = {3, 9, 1, 7, 5};
      int maxVal = RecursiveSolutions.findMax(nums, 0);
      System.out.println("Max value: " + maxVal);
   
      // 3. Print array backward
      System.out.print("Array backward: ");
      RecursiveSolutions.printArrayBackward(nums, nums.length - 1);
      System.out.println();
   
      // 4. Check palindrome
      String s1 = "racecar";
      String s2 = "hello";
      System.out.println("Is '" + s1 + "' palindrome? " +
             RecursiveSolutions.isPalindrome(s1, 0, s1.length() - 1));
      System.out.println("Is '" + s2 + "' palindrome? " +
             RecursiveSolutions.isPalindrome(s2, 0, s2.length() - 1));
   
      // 5. Sum of array
      int sum = RecursiveSolutions.sumArray(nums, 0);
      System.out.println("Sum of array: " + sum);
   
      // 6. Log base 2
      System.out.println("log2(4) = " + RecursiveSolutions.logBase2(4));
      System.out.println("log2(5) = " + RecursiveSolutions.logBase2(5));
      System.out.println("log2(32) = " + RecursiveSolutions.logBase2(32));
   } // main 
}


class RecursiveSolutions {

    /**
     * Prints the digits of a positive integer in reverse order.
     * Precondition: n >= 0
     * Postcondition: All digits of n are printed backward to standard output; no return value.
     */
   public static void printIntegerBackward(int n) {
    if(n<10){
      System.out.print(n);
      return;
    }
    System.out.print(n%10);
    printIntegerBackward(n/10);
   }

    /**
     * Recursively finds the maximum value in an integer array.
     * Precondition: arr is not null, arr.length > 0, and 0 <= index < arr.length
     * Postcondition: Returns the largest integer among arr[index..arr.length-1].
     */
   public static int findMax(int[] arr, int index) {
    if(index == arr.length-1){
      return arr[index];
    }
    int maxOfRest = findMax(arr, index+1);
    if(arr[index] > maxOfRest){
      return arr[index];
    }
    else{
      return maxOfRest;
    }
   }

    /**
     * Prints the contents of an integer array backward from a given index.
     * Precondition: arr is not null, -1 <= index < arr.length
     * Postcondition: Elements arr[index..0] are printed in reverse order separated by spaces.
     */
   public static void printArrayBackward(int[] arr, int index) {
    if(index == 0){
      System.out.print(arr[index]);
      return;
    }
    System.out.print(arr[index] + " ");
    printArrayBackward(arr, index-1);
   }

    /**
     * Checks whether a substring of s defined by [left, right] is a palindrome.
     * Precondition: s is not null, 0 <= left <= right < s.length()
     * Postcondition: Returns true if s[left..right] is a palindrome, false otherwise.
     */
   public static boolean isPalindrome(String s, int left, int right) {
   }

    /**
     * Sums all the values in an integer array recursively.
     * Precondition: arr is not null, 0 <= index <= arr.length
     * Postcondition: Returns the total of arr[index..arr.length-1].
     */
   public static int sumArray(int[] arr, int index) {
   }

    /**
     * Computes floor(log2(n)) recursively.
     * Precondition: n > 0
     * Postcondition: Returns the greatest integer k such that 2^k <= n.
     */
   public static int logBase2(int n) {
   }
}
