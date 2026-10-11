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



}
