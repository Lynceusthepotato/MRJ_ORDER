package May12020;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    Rectangle(){}

    Rectangle(double width, double length){}

    Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "A Rectangle with width " + width + " and length = " + length + ", which is a subclass of " + super.toString();
    }
}
