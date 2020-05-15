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
        a2.soundHorn();
        System.out.println(a2.toString());

        Jeep.add(a1);
        Jeep.add(a2);

        policeCar b1 = new policeCar();
        b1. setName("Bumbum");
        b1.setMaxPassengers(4);
        b1.setMaxSpeed(420);
        b1.setNumWheels(4);
        b1.madcops();
        System.out.println(b1.toString());

        PoliceCar.add(b1);

        Frigate c1 = new Frigate();
        c1.fireGun();

        hoverCraft d1 = new hoverCraft();
        d1.EnterLand();
        d1.EnterSea();

    }
}
