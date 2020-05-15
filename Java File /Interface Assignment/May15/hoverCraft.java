package May15;

public class hoverCraft implements LandVehicle, SeaVessel {

    int wheels;
    int maxPassenger;
    double maxSpeed;
    double Displacement;
    String name;

    @Override
    public void setNumWheels(int Wheels) {
        wheels = Wheels;
    }

    @Override
    public void drive() {
        System.out.println("Hovercraft goes down and up");
    }

    @Override
    public void setDisplacement(double displacement) {
        Displacement = displacement;
    }

    @Override
    public void launch() {
        System.out.println("ocean man");
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

    public String toString(){
        return "Hovercraft stats (name = " + name + "\nmax passengers = " + maxPassenger +
                "\nmax speed = " + maxSpeed + "\nwheels = " + wheels + "\ndisplacement = " + Displacement;
    }
}
