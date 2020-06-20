package theActualGame;

public class someArmor implements Armor {
    private String Name;
    private int Defense;
    private int Value;
    private int Special;

    someArmor(){
        this.Name = "BEST ARMOR";
        this.Defense = 0;
        this.Value = 0;
        this.Special = 0;

    }

    someArmor(String Name, int Defense, int Value, int Special){
        this.Name = Name;
        this.Defense = Defense;
        this.Value = Value;
        this.Special = Special;
    }


    @Override
    public void setDefense(int Defense) {
        this.Defense = Defense;
    }

    @Override
    public int getDefense() {
        return Defense;
    }

    @Override
    public void setSpecial(int Special) {
        this.Special = Special;
    }

    @Override
    public int getSpecial() {
        return Special;
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
