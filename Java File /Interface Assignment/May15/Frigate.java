package May15;

public class Frigate implements SeaVessel{

    int maxPassenger;
    double maxSpeed;
    double Displacement;
    String name;

    @Override
    public void setDisplacement(double displacement) {
        Displacement = displacement;
    }

    @Override
    public void launch() {
        System.out.println("Bruh");
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

    public void fireGun(){
        System.out.println("aim set BOOM");
    }
    public String toString(){
        return "Ok no more, name " + name + " displacement = " + Displacement + " Passengers = " + maxPassenger + " Speed = " + maxSpeed;
    }
}
