package theActualGame;

public class someConsumable implements Consumable {
    private String Name;
    private int Value;
    private int Plus;

    someConsumable(){
        this.Name = "Lesser Potion";
        this.Value = 15;
        this.Plus = 20;
    }

    someConsumable(String Name, int Value, int Plus){
        this.Name = Name;
        this.Value = Value;
        this.Plus = Plus;
    }

    @Override
    public void setPlus(int Plus) {
        this.Plus = Plus;
    }

    @Override
    public int getPlus() {
        return Plus;
    }

    @Override
    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setValue(int Value) {
        this.Value = Value;
    }

    @Override
    public int getValue() {
        return Value;
    }
}
