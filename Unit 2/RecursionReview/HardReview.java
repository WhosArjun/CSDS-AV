public class HardReview {
    public static void main(String[] args){
        exhaustiveSearch(0, 0, 1, 2);
    }

    public static void exhaustiveSearch(int startX, int startY, int endX, int endY){
        if(startX == endX && startY == endY){
            System.out.println("Found a path");
            return;
        }
        if(startX > endX || startY > endY){
            return;
        }
        exhaustiveSearch(startX + 1, startY, endX, endY); // east
        exhaustiveSearch(startX, startY + 1, endX, endY); // north
        exhaustiveSearch(startX + 1, startY + 1, endX, endY); // north east
    }
}
