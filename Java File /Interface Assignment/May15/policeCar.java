package May15;

public class policeCar implements LandVehicle, IsEmergency {

    int wheels;
    int maxPassenger;
    double maxSpeed;
    String name;

    @Override
    public void soundSiren() {
        System.out.println("WEEEWOOOOWEEEWOOOO");
    }

    @Override
    public void setNumWheels(int Wheels) {
        wheels = Wheels;
    }

    @Override
    public void drive() {
        System.out.println("THIS IS THE POLICE");
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
        return "Police have " + maxPassenger + "max passengers, with speed of " + maxSpeed +
                "oh and have " + wheels + "wheels, and its name is " + name;
    }
}
