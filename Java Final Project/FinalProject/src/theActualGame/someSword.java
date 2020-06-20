package theActualGame;

public class someSword implements Weapon, Item {
    private String Name;
    private int Attack;
    private int Value;

    someSword(){
        this.Name = "Wood Sword";
        this.Attack = 5;
        this.Value = 5;
    }

    someSword(String Name, int Attack, int Value){
        this.Name = Name;
        this.Attack = Attack;
        this.Value = Value;
    }

    @Override
    public void setAttack(int Attack) {
        this.Attack = Attack;
    }

    @Override
    public int getAttack() {
        return Attack;
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
