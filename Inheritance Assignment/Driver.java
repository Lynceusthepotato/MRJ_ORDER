package May12020;

public class Driver {
    public static void main(String[] args) {

        Shape q1 = new Shape();
        q1.setColor("Green");
        System.out.println(q1.toString());

        Circle q2 = new Circle();
        System.out.println(q2.toString());

        Rectangle q3 = new Rectangle();
        System.out.println(q3.toString());

        Square q4 = new Square();
        System.out.println(q4.toString());
    }
}
