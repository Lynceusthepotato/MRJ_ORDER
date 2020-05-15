package May12020;

public class Circle extends Shape{
    private double radius = 1.0;

    Circle(){}

    Circle(double radius){}

    Circle(double radius, String color, boolean filled){
        super(color, filled);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public String toString() {
        return "A Circle with radius = " + radius + " which a subclass of " + super.toString();
    }
}
