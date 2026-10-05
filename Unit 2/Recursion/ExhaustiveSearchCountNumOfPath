//Problem 1 : 5 possible paths
//Problem 2 : 51 possible paths
//3 Base cases : When the startpoints of both the y and x are greater than the desired points of y and x. Also when the starting points of y and x, are equal to the desired points of x and y.

public class ExhaustiveSearchCountNumOfPath
{
   public static void main (String [] args)
   {
      
      System.out.println ("# of path: " + explore (1,2, 0, 0));
   } // main

   private static int explore (int targetX, int targetY,
                               int currentX, int currentY)
   {
      if(currentX == targetX && currentY == targetY){
        return 1;
      }
      if(currentX>targetX || currentY>targetY){
        return 0;
      }
      int north = explore(targetX, targetY, currentX, currentY+1);
      int east = explore(targetX, targetY, currentX+1, currentY);
      int northEast = explore(targetX, targetY, currentX+1, currentY+1);
        return north + east + northEast;

   } // explore

}

