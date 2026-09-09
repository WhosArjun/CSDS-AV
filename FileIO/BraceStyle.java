package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class BraceStyle
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File("FileIO/Test.java"));
        PrintStream output = new PrintStream(new File("NextLineBraceStyleTest.txt"));

        String previousLine = input.nextLine();
        while (input.hasNextLine())
        {
            String currentLine = input.nextLine();
            Scanner line = new Scanner(currentLine);
            if (line.hasNext() && line.next().equals("{"))
            {
                output.println(previousLine + " {");
                previousLine = null;
            }
            else
            {
                if (previousLine != null)
                {
                    output.println(previousLine);
                }

                previousLine = currentLine;
            }
            line.close();
        }
        if (previousLine != null)
        {
            output.println(previousLine);
        }
        input.close();
        output.close();
    }
}

/* OUTPUT ---
package FileIO;

public class Test {
    public static void main(String[] args) {
        
    }
}
 */