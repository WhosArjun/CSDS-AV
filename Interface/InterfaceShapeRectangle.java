package Interface;

public class InterfaceShapeRectangle {
    public static void main(String[] args){
        Shape rectangle = new Rectangle(6,7);
        Shape circle = new Circle(6.7);
        Shape triangle = new Triangle(6, 7);

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
    private double base;
    private double height;

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    public double area(){
        return (base*height)/2.0;
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

