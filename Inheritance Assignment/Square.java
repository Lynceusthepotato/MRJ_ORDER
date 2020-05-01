package May12020;

public class Square extends Rectangle {
    private double side = 4;
    Square(){}

    Square(double side){
        this.side = side;
    }

    Square(double side, String color, boolean filled){
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "A Square with side " + side + ", which is a subclass of " + super.toString();
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }
}
