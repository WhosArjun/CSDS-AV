package Interface;

public class InterfaceShapeRectangle {
    public static void main(String[] args){
        Shape rectangle = new Rectangle(6,7);
        Shape circle = new Circle(6.7);
        Shape triangle = new Triangle(3,4,2);

        System.out.println(rectangle.area());
        System.out.println(triangle.area());
        System.out.println(circle.area());
    }
}

interface Shape{
    double area();
}

class Rectangle implements Shape{
    private double width;
    private double length;

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    public double area(){
        return width*length;
    }
}


class Triangle implements Shape{
    private double s1;
    private double s2;
    private double s3;
    private double s;
    
    public Triangle(double s1, double s2, double s3){
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s = (s1+s2+s3)/2.0;
    }

    public double area(){
        return Math.sqrt(s*(s-1)*(s-2)*(s-3));
    }
}


class Circle implements Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double area(){
        return Math.PI * Math.pow(radius,2);
    }
}

