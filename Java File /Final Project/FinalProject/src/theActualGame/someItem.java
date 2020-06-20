package theActualGame;

public class someItem implements Item {
    private String Name;
    private int Value;

    someItem(){
        this.Name = "";
        this.Value = 0;
    }

    someItem(String Name, int Value){
        this.Name = Name;
        this.Value = Value;
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
