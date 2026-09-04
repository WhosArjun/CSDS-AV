package FileIO;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class FileCount {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(new File("FileIO/file.txt"));
        Scanner console2 = new Scanner(new File("FileIO/file.txt"));

        int charCount = 0;
        int words = 0;
        int lines = 0;

        while(console.hasNext()){
            String word = console.next();
            words++;
            charCount += word.length();
        }

        console.close();

        while(console2.hasNextLine()){
            String line = console2.nextLine();
            lines++;
        }

        console2.close();

        System.out.println("Number of characters: " + charCount);
        System.out.println("Number of words: " + words);
        System.out.println("Number of lines: " + lines);

    }
}
