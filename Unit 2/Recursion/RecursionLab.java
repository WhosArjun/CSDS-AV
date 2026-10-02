/*

Arjun Arunkumar : Period 1 

1. Challenges and debugging : 
Describe a specific bug or logic error : One of the logic errors that stumped me a lot was the reverse method especially with what I had to return. I wasnt able to think of x modulo 10 + reverse(x/10), but after drawing a lot of recursive diagram on paper so I could visualize them I realized what I needed to do.
What did I learn from the errorrs : What I learned from my errors was to always do it on paper first so the code doesn't get messy, drawing diagrams and writing out base cases is also very useful in avaoiding errors. Knoweing how to approach certain types of problems also helps.
How was your time management : I did it the night before the class we worked on them, because I had a Calc test that I had to prepare for. My time management was good, once I found out the logic for each method i took a break and then impleented it in my code.
2. Growth 
What is your biggest take away? My biggest take away is how logical programming is, especially in recursive methods. Learning when and how to apply what logic allowed me to push through these problems. I really enjoyed drawing loads of diagrams on scratch paper with eager in solving these problems.
 */

import java.util.Scanner;

public class RecursionLab
{
    // Pre: c is a lower case letter
    // Post: all lower case letters a-char c are printed
    public static void letters(char c)
    {
        if(c == 'a'){
            System.out.print("a");
        }
        else{
            letters((char)(c - 1));
            System.out.print(c);
        }
    }

    // Pre: none
    // Post: returns number of factors of 2 in x
    public static int twos(int x)
    {
        if(x == 0 || x % 2 != 0){
            return 0;
        }
        return 1 + twos(x / 2);
    }

    // Pre: none
    // Post: returns if x is a power of 3
    public static boolean powerof3(int x)
    {
        if(x == 1){
            return true;
        }
        if(x <= 0 || x % 3 != 0){
            return false;
        }
        return powerof3(x / 3);
    }

    // Pre: none
    // Post: returns String of x reversed
    public static String reverse(long x)
    {
        if(x < 0){
            return "-" + reverse(-x);
        }
        if(x < 10){
            return "" + x;
        }
        return (x % 10) + reverse(x / 10);
    }

    // Pre: x is nonnegative
    // Post: prints x in base 5
    public static void base5(int x)
    {
        if(x >= 5){
            base5(x / 5);
        }
        System.out.print(x % 5);
    }

    // Pre: x is nonnegative
    // Post: prints x with commas
    public static void printWithCommas(long x)
    {
        if(x < 1000){
            System.out.print(x);
        }
        else{
            printWithCommas(x / 1000);

            long remainder = x % 1000;

            if(remainder < 10){
                System.out.print(",00" + remainder);
            }
            else if(remainder < 100){
                System.out.print(",0" + remainder);
            }
            else{
                System.out.print("," + remainder);
            }
        }
    }

    public static void main(String []args)
    {
        Scanner scan = new Scanner(System.in);
        int choice;

        do
        {
            System.out.println("\n\n1)Letters" +
                               "\n2)Twos" +
                               "\n3)Power Of 3" +
                               "\n4)Reverse" +
                               "\n5)Base 5" +
                               "\n6)Print With Commas" +
                               "\n7)Exit");

            choice = scan.nextInt();

            if(choice == 1)
            {
                System.out.println("Enter a letter");
                char charA = scan.next().charAt(0);

                if(charA < 'a' || charA > 'z')
                {
                    System.out.println("That letter not valid");
                }
                else
                {
                    letters(charA);
                    System.out.println();
                }
            }

            else if(choice == 2)
            {
                System.out.println("Enter a number");
                System.out.println(twos(scan.nextInt()));
            }

            else if(choice == 3)
            {
                System.out.println("Enter a number");
                System.out.println(powerof3(scan.nextInt()));
            }

            else if(choice == 4)
            {
                System.out.println("Enter a number");
                System.out.println(reverse(scan.nextLong()));
            }

            else if(choice == 5)
            {
                System.out.println("Enter a number");
                int number = scan.nextInt();

                if(number >= 0)
                {
                    base5(number);
                    System.out.println();
                }
                else
                {
                    System.out.println("That number is not valid");
                }
            }

            else if(choice == 6)
            {
                System.out.println("Enter a number");
                long number = scan.nextLong();

                if(number >= 0)
                {
                    printWithCommas(number);
                    System.out.println();
                }
                else
                {
                    System.out.println("That number is not valid");
                }
            }

        } while(choice != 7);
    }
}