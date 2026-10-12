public class RecursionMethods {
    public static void main(String[] args){
        System.out.println(factorial(5));
        System.out.println(power(2,3));
        System.out.println(multiply(4,3));
        System.out.println(countDigits(12345));
        System.out.println(reverse("Hello World"));
        System.out.println(countChar("Hello World", 'o'));
        System.out.println(letters('d'));
        System.out.println(twos(1234567890));
        System.out.println(powerOf3(27));
        System.out.println(reverseLong(1234567890));
        base5(136);
        System.out.println();
        printWithCommas(1234567890);
        System.out.println();
        reverseLongString(1234567890);
        reverseLongStringWithCommas(1234567890);
        System.out.println();
        printIntegerBackwards(67);
        System.out.println();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(maxValueInAnArray(arr));
        printContentOf1DArrayBackwards(arr);
        System.out.println();
        System.out.println(isPallindrome("racecar"));
        System.out.println(isPallindrome("HelloolleH"));
        int[] arr2 = {6,7,6,7,6,7};
        printRecur(arr2, 1);
        System.out.println();
        System.out.println(sumArray(arr2));
        System.out.println(found(arr2, 5));
        printHashtagAmount(5);
        printHashtagAmountBackward(1, 5);
        System.out.println(elfish("Hello World"));
        reverseWordInAString("The cat is running");
        System.out.println();
        System.out.println(xlsh("dude", "duke"));
        System.out.println();
        reverseWordInAStringWithSplitString("The cat is running");
        System.out.println();
        reverseWord2("Hello");
        System.out.println();
        System.out.println(division(27,3));
        System.out.println(power2(5,3));
        System.out.println(factorial2(6));

    }

    public static double factorial(double a){
        if(a == 1){
            return 1;
        }
        return a * factorial(a-1);
    }

    public static double power(double a, double b){
        if(b == 1){
            return a;
        }
        return a * power(a, b-1);
    }

    public static double multiply(double a, double b){
        if(b == 1){
            return a;
        }
        return a + multiply(a, b-1);
    }
    public static int countDigits(int n){
        if(n<10){
            return 1;
        }
        return 1 + countDigits(n/10);
    }
    public static String reverse(String str){
        if(str.length() == 1){ //base case if the string is only one character long
            return str; //return the string
        }
        String str1 = str.substring(1); //get the string without the first character 
        return reverse(str1) + str.substring(0,1); //return the reversed string plus the first character of the original string
    }
    /* 
    public static int countChar(String str, char ch){
        int indexOfChar = str.indexOf(ch);
        if(indexOfChar == -1){
            return 0;
        }
        str = str.substring(indexOfChar);
        return 1 + countChar(str, ch);
    }
    */

    public static int countChar(String str, char ch){
        int indexOfChar = str.indexOf(ch);
        if(indexOfChar != -1){
            return 1 + countChar(str.substring(indexOfChar+1), ch);
        }
        return 0;
    }

    /* 
    public static String letters(char ch){
        int resultDif = (int)ch - (int)'a';
        int IdA = (int)'a';
        if(resultDif == 0){
            return "a";
        }
        return (char)(IdA + 1) + letters((char)(ch-1));
    }
    */
   public static String letters(char ch){
        int resultDifference = (int)ch - (int)'a';
        if(resultDifference == 0){
            return "a";
        }
        return letters((char)(ch-1)) + ch;
   }

   public static int twos(int n){
        if(n<10){
            if(n%2 == 0){
                return 1;
            }
            return 0;
        }
        if(n%2 == 0){
            return 1 + twos(n/10);
        }
        else{
            return twos(n/10);
        }
   }

   public static boolean powerOf3(int n){
    if(n==3){
        return true;
    }
    if(n%3 == 0){
        return powerOf3(n/3);
    }
    else{
        return false;
    }
   }

   public static long reverseLong(long n){
    return reverseLongHelper(n, 0);
   }
   public static long reverseLongHelper(long n, long reversed){
    if(n == 0){
        return reversed;
    }
    return reverseLongHelper(n/10, reversed * 10 + n%10);
   }

   public static void reverseLongString(long n){
    if(n<10){
        System.out.print(n);
    }
    else{
        System.out.print(n%10);
        reverseLongString(n/10);
    }
   }

   public static void base5(int n){
    if(n==0){
        return;
    }
    base5(n/5);
    System.out.print(n%5);
   }

   public static void printWithCommas(int n){
    if(n<1000){
        System.out.print(n);
    }
    else{
        printWithCommas(n/1000);
        long remainder = n%1000;
        if(n<10){
            System.out.print("," + 0 + 0 + remainder);
        }
        else if(n<100){
            System.out.print("," + 0 + remainder);
        }
        else{
            System.out.print("," + remainder);
        }
    }
   }

   public static void printLongWithCommas(long n){
    if(n<1000){
        System.out.print(n);
    }
    else{
        printLongWithCommas(n/1000);
        long remainder = n%1000;
        if(n<10){
            System.out.print("," + 0 + 0 + remainder);
        }
        else if(n<100){
            System.out.print("," + 0 + remainder);
        }
        else{
            System.out.print("," + remainder);
        }
    }
   }

   public static void reverseLongStringWithCommas(long n){
    long a = reverseLong(n);
    System.out.println();
    printLongWithCommas(a);
   }

   public static void printIntegerBackwards(int n){
    if(n<10){
        System.out.print(n);
    }
    else{
        System.out.print(n%10);
        printIntegerBackwards(n/10);
    }
   }

   public static int maxValueInAnArray(int[] arr){
    return maxValueInArrayHelper(arr, 0, 0);
   }
   public static int maxValueInArrayHelper(int[] arr, int index, int max){
    if(index == arr.length-1){
        if(arr[index] < max){
            return arr[max];
        }
        else{
            return arr[index];
        }
    }
    else{
        if(arr[max]<arr[index+1]){
            return maxValueInArrayHelper(arr, index+1, index+1);
        }
        else{
            return maxValueInArrayHelper(arr, index+1, max);
        }
    }
   }

   public static void printContentOf1DArrayBackwards(int[] arr){
    printContentOf1DArrayBackwardsHelper(arr, 0);
   }  
   public static void printContentOf1DArrayBackwardsHelper(int[] arr, int index){
     if(index == arr.length - 1){
       System.out.print(arr[index]);
     }
     else{
        printContentOf1DArrayBackwardsHelper(arr, index+1);
        System.out.print(arr[index]);
     }
   }

   public static boolean isPallindrome(String str){
    String frontHalf = str.substring(0,str.length()/2);
    String backHalf = str.substring(str.length()/2);
   // int backHalfIndex = backHalf.length()-1;
    int frontHalfIndex = 0;
    if(str.length() % 2 == 1){
        backHalf = backHalf.substring(1);
    }

    int backHalfIndex = backHalf.length()-1;

    return isPallindromeHelper(backHalf, frontHalf, frontHalfIndex, backHalfIndex);
   }
   /* 
   public static boolean isPallindromeHelper(String backHalf, String frontHalf, int index){
    if(index == backHalf.length() - 1 && index == frontHalf.length() - 1){
        if(backHalf.charAt(index) == frontHalf.charAt(index)){
            return true;
        }
        return false;
    }
    else{
        if(backHalf.charAt(index) == frontHalf.charAt(index)){
            return isPallindromeHelper(backHalf, frontHalf, index+1);
        }
        else{
            return false;
        }
    }
   }
    */
   public static boolean isPallindromeHelper(String backHalf, String frontHalf, int frontHalfIndex, int backHalfIndex){
    if(frontHalfIndex == frontHalf.length() -1){
        if(frontHalf.charAt(frontHalfIndex) == backHalf.charAt(backHalfIndex)){
            return true;
        }
        else{
            return false;
        }
    }
    else{
        if(frontHalf.charAt(frontHalfIndex) == backHalf.charAt(backHalfIndex)){
            return isPallindromeHelper(backHalf, frontHalf, frontHalfIndex+1, backHalfIndex-1);
        }
        else{
            return false;
        }
    }
   }

   public static void printRecur(int[] arr, int index){
    if(index == arr.length - 1){
        System.out.print(arr[index]);
        return;
    }
    System.out.print(arr[index]);
    printRecur(arr, index+1);
   }

   public static int sumArray(int[] arr){
    return sumArrayHelper(arr, 0, 0);
   }
   public static int sumArrayHelper(int[] arr, int index, int total){
    if(index == arr.length -1){
        total+= arr[index];
        return total;
    }
    else{
        total+=arr[index];
        return sumArrayHelper(arr, index+1, total);
    }
   }

   public static boolean found(int[] arr, int target){
    return foundHelper(arr, target, 0);
   }
   public static boolean foundHelper(int[] arr, int target, int index){
    if(index == arr.length -1){
        if(arr[index] == target){
            return true;
        }
        return false;
    }
    else{
        if(arr[index] == target){
            return true;
        }
        else{
            return foundHelper(arr, target, index +1);
        }
    }
   }

   public static void printHashtagAmount(int amount){
    if(amount == 0){
        return;
    }
    else{
        int i = 0;
        while(i<amount){
            System.out.print("#");
            i++;
        }
        System.out.println();
        printHashtagAmount(amount-1);
    }
   }

   public static void printHashtagAmountBackward(int iteration ,int amount){
    if(iteration>amount){
        return;
    }
    else{
        int i = 0;
        while(i<iteration){
            System.out.print("#");
            i++;
        }
        System.out.println();
        printHashtagAmountBackward(iteration+1, amount);
    }
   }

   public static boolean elfish(String word){
    boolean eFound = false;
    boolean fFound = false;
    boolean lFound = false;
    return elfishHelper(word, eFound, fFound, lFound);
   }
   public static boolean elfishHelper(String word, boolean eFound, boolean fFound, boolean lFound){
    if(eFound == true && fFound == true && lFound == true){
        return true;
    }
    if(word.length() == 0){
        return false;
    }
    char firstChar = word.charAt(0);
    return elfishHelper(word.substring(1), eFound || firstChar == 'e', fFound || firstChar == 'f', lFound || firstChar == 'l');
   }

   public static void reverseWordInAString(String word){
    if(word.indexOf(" ") == -1){
        System.out.print(word + " ");
        return;
    }
   
        reverseWordInAString(word.substring(word.indexOf(" ") + 1)); //The cat is running
        System.out.print(word.substring(0, word.indexOf(" ")) + " ");
    
   }

   public static void reverseWordInAStringWithSplitString(String word){
    String[] words = word.split(" ");
    reverseWordInAStringWithSplitStringHelper(word, words, 0);
   }
   public static void reverseWordInAStringWithSplitStringHelper(String word, String[] words, int index){
    if(index == words.length-1){   //Base case if statement
        System.out.print(words[index] + " ");
    }
    else{    //Instead of adding the else statement you could also add a return statement in the base case if statement
        reverseWordInAStringWithSplitStringHelper(word, words, index+1);
        System.out.print(words[index] + " ");
    }
   }

   public static void reverseWord2(String word){
    if(word.length() == 1){
        System.out.print(word);
        return;
    }
    reverseWord2(word.substring(1));
    System.out.print(word.substring(0,1));
   }

   public static boolean xlsh(String word1, String word2){
    
    if(word1.length() == 0){
        return true;
    }
    else{
        char currChar = word1.charAt(0);
        if(word2.indexOf(currChar) == -1){
            return false;
        }
        else{
            return xlsh(word1.substring(1), word2);
        }
    }

    /* 
   public static boolean xlshHelper(String word1, String word2, boolean isTrue){
    if(word1.length() == 0){
        return true;
    }
    else{
        int i = 0;
        char currChar = word1.charAt(0);
        while(i<word2.length()){
            if(currChar != word2.charAt(i)){
                isTrue = false;
            }
            if(currChar == word2.charAt(i)){
                isTrue = true;
            }
            i++;
        }
    }
   }
    */

        
   }

   public static double multiply2(double n, double b){
        if(b==1){
            return n;
        }
        return n + multiply(n, b-1);
    }

    public static int division(int n, int b){
        if(n<b){
            return 0;
        }
        return 1 + division(n-b, b);
    }
    
    public static double power2(double a, double b){
        if(b==1){
            return a;
        }
        return a * power2(a, b-1);
    }

    public static double factorial2(double n){
        if(n==1){
            return n;
        }
        return n * factorial(n-1);
    }

   
}


