import java.util.Scanner;

public class Pd1ArjunArunkumarPolygonDriver{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Polygon[] polygons = new Polygon[9];

        System.out.println("Input 3 sides of the triangle");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        polygons[0] = new Triangle(side1, side2, side3);

        System.out.println("Enter the base and the equal side lengths of the Isoceles Triangle");
        double base = input.nextDouble();
        double equalSide = input.nextDouble();

        polygons[1] = new IsocelesTriangle(base, equalSide);

        System.out.println("Enter the equal side length of your Equilateral Triangle");
        double equalSides = input.nextDouble();

        polygons[2] = new EquilateralTriangle(equalSides);


        System.out.println("Enter the four sides and diagonal of the quadrilateral");
        double q1 = input.nextDouble();
        double q2 = input.nextDouble();
        double q3 = input.nextDouble();
        double q4 = input.nextDouble();
        double diagonal = input.nextDouble();

        polygons[4] = new Quadrilateral(q1, q2, q3, q4, diagonal);


        System.out.println("Enter the width and length of your rectangle");
        double length = input.nextDouble();
        double width = input.nextDouble();

        polygons[4] = new Rectangle(length, width);

    }
}

interface Polygon {
    double area();
    double perimeter();
}

class Triangle implements Polygon{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double perimeter(){
        return side1 + side2 + side3;
    }

    public double area(){
        double s = perimeter()/2.0;
        return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
    }
}

class Quadrilateral implements Polygon{
    private double side1;
    private double side2;
    private double side3;
    private double side4;
    private double diagonal;

    public Quadrilateral(double side1, double side2, double side3, double side4, double diagonal){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
        this.diagonal = diagonal;
    }

    public double perimeter(){
        return side1 + side2 + side3 + side4;
    }

    public double area(){
        double s1 = (side1 + side2 + diagonal) / 2.0;
        double area1 = Math.sqrt(s1*(s1-side1)*(s1-side2)*(s1-diagonal));

        double s2 = (side3 + side4 + diagonal) / 2.0;
        double area2 = Math.sqrt(s2*(s2-side3)*(s2-side4)*(s2-diagonal));

        return area1 + area2;
    }
}

    class Pentagon implements Polygon{
        private double side1;

        public Pentagon(double side1){
            this.side1 = side1;
        }

        public double perimeter(){
            return side1 * 5;
        }

        public double area(){
            return (Math.sqrt(25+10*Math.sqrt(5))*side1 * side1 / 4.0);
        }
    }

    class Hexagon implements Polygon{
        private double side1;

        public Hexagon(double side1){
            this.side1 = side1;
        }

        public double perimeter(){
            return side1 * 6;
        }

        public double area(){
            return (3*Math.sqrt(3)/2)*Math.pow(side1,2);
        }
    }

    class Octagon implements Polygon{
        private double side1;

        public Octagon(double side1){
            this.side1 = side1;
        }

        public double perimeter(){
            return side1*8;
        }

        public double area(){
            return 2 *(1 + Math.sqrt(2))*Math.pow(side1,2);
        }
    }

    class IsocelesTriangle extends Triangle{
        private double base;
        private double equalSides;

        public IsocelesTriangle(double base, double equalSides){
            super(base, equalSides, equalSides);
            this.base = base;
            this.equalSides = equalSides;
        }

        public double area(){
            double height = Math.sqrt(Math.pow(equalSides,2)- (base/2.0)*(base/2.0));
            return (height*base)/2;
        }
    }

    class EquilateralTriangle extends Triangle{
        private double equalSides;

        public EquilateralTriangle(double equalSides){
            super(equalSides, equalSides, equalSides);
            this.equalSides = equalSides;
        }

        public double area(){
            return (Math.sqrt(3)/4)*Math.pow(equalSides,2);
        }
    }

    class Rectangle extends Quadrilateral{
        private double length;
        private double width;

        public Rectangle(double length, double width){
            super(length, width, length, width, Math.sqrt(length*length + width*width));
            this.length = length;
            this.width = width;
        }

        public double area(){
            return length * width;
        }

        public double perimeter(){
            return length*2 + width*2;
        }
    }

    class Square extends Rectangle{
        private double side;

        public Square(double side){
            super(side, side);
            this.side = side;
        }

        public double area(){
            return Math.pow(side,2);
        }

        public double perimeter(){
            return side*4;
        }
    }

}