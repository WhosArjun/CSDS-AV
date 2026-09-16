package TryCatch;

class Triangle {
    double side1,side2,side3;
    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException{
        if(side1+side2<=side3 || side1+side3<=side2 || side2+side3<=side1){
            throw new IllegalTriangleException("The sum of any two sides must be greater than the third side.");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
}

class IllegalTriangleException extends Exception{
    public IllegalTriangleException(String message){
        super(message);
    }
}

public class TriangleDriver{
    public static void main(String[] args){
        try{
            Triangle triangle1 = new Triangle(3,4,5);
        } catch (IllegalTriangleException e){
            System.out.println("Caught triangle exception");
        }

        try{
            Triangle triangle2 = new Triangle(1,2,3);
        } catch (IllegalTriangleException e){
            System.out.println("Triangle 2 is invalid");
            System.out.println("Caught triangle exception");
        }
    }
}
