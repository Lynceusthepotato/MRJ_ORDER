package May15;

public class Jeep implements LandVehicle {

    int wheels;
    int maxPassenger;
    double maxSpeed;
    String name;

    @Override
    public void setNumWheels(int Wheels) {
        wheels = Wheels;
    }

    @Override
    public void drive() {
        System.out.println("Jeep goes down the hill");
    }

    @Override
    public void setName(String Name) {
        name = Name;
    }

    @Override
    public void setMaxPassengers(int Passengers) {
        maxPassenger = Passengers;
    }

    @Override
    public void setMaxSpeed(double Speed) {
        maxSpeed = Speed;
    }

    public String toString() {
       return "Jeep have " + wheels + " Wheels, with maximum of " +
               maxPassenger + " passengers, and with the maximum speed of " + maxSpeed + ". I named it " + name;
    }
}
