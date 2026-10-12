import java.util.Scanner;
import java.io.*;
 public class AreaFill_shell
 {
 public static char[][] grid = null;
  
  public static void main(String[] args) throws FileNotFoundException
 {
    Scanner sc = new Scanner(System.in);
    System.out.print("Filename: ");
    String filename = sc.next();
    grid = read(filename + ".txt");
    display(grid);
    System.out.print("\nEnter ROW COL to fill from: ");
    int row = sc.nextInt();
    int col = sc.nextInt(); 
     fill(grid, row, col, grid[row][col]);
     display(grid);
    sc.close();
  }
  public static char[][] read(String filename) throws FileNotFoundException
  {
     Scanner sc = new Scanner(new File(filename));
      char[][] board = new char[sc.nextInt()][sc.nextInt()];
      for(int i = 0; i < board.length; i++) {
         String row = sc.next();
         board[i] = row.toCharArray();
      }
      return board;
   }   
   public static void display(char[][] g)
   {              
     for(int i = 0; i < g.length; i++) {
        for(int j = 0; j < g[i].length; j++) {
           System.out.print(g[i][j]);
         }
         System.out.println();
      }
        }
    
           /**
         * pre: method called in main method
        * post: modifies char[][] g and replaces characters of the 
        * index indicated on the grid with a *
        * @param g
        * @param r
         *@param c
        * @param ch
        */

    public static void fill(char[][] g, int r, int c, char ch) //recursive method
    {       
     Scanner console = new Scanner(System.in);
     System.out.println("What is your fillChar");
     char fillChar = console.next().charAt(0);
     if(fillChar == ch){
      return;
     }
     fillHelper(g, r, c, ch, fillChar);
    }  
   public static void fillHelper(char[][] g, int r, int c, char ch, char fillChar){
      if(r<0 || r>=g.length || c<0 || c>=g[r].length){
         return;
      }
      if(g[r][c] != ch){
        return;
      }
      g[r][c] = fillChar;
      
      fillHelper(g, r+1, c, ch, fillChar);
      fillHelper(g, r, c+1, ch, fillChar);
      fillHelper(g, r-1, c, ch, fillChar);
      fillHelper(g, r, c-1, ch, fillChar);
   }
 }
