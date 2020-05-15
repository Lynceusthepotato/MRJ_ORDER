package May15;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Jeep> Jeep = new ArrayList<>();
        ArrayList<Frigate> Frigate = new ArrayList<>();
        ArrayList<hoverCraft> Hovercraft = new ArrayList<>();
        ArrayList<policeCar> PoliceCar = new ArrayList<>();

        Jeep a1 = new Jeep();
        a1.setName("Pooter");
        a1.setMaxPassengers(4);
        a1.setMaxSpeed(555);
        a1.setNumWheels(4);
        a1.drive();
        System.out.println(a1.toString());

        Jeep a2 = new Jeep();
        a2.setName("BOER");
        a2.setMaxPassengers(4);
        a2.setMaxSpeed(666);
        a2.setNumWheels(4);
        System.out.println(a2.toString());

        Jeep.add(a1);
        Jeep.add(a2);

    }
}
