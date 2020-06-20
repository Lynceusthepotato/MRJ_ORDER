package theActualGame;

public class Monster implements Character {
    private String name;
    private int Hp;
    private int Mp;
    private int atk;
    private int Def;
    private int Gold;
    private String filename;

    public Monster() {
        this.name = "Spooder";
        this.Hp = 25;
        this.Mp = 5;
        this.atk = 7;
        this.Def = 2;
        this.Gold = 15;
        this.filename = ".//images//Spider.png";
    }

    public Monster(String name, int atk, int Hp, int Mp, int Def, int Gold, String filename) {
        this.name = name;
        this.Hp = Hp;
        this.Mp = Mp;
        this.atk = atk;
        this.Def = Def;
        this.Gold = Gold;
        this.filename = filename;
    }

    public void setFilename(String filename){
        this.filename = filename;
    }

    public String getFilename(){
        return this.filename;
    }

    @Override
    public void setName(String Name) {
        this.name = Name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setHP(int HP) {
        this.Hp = HP;

    }

    @Override
    public int getHP() {
        return Hp;
    }

    @Override
    public void setMP(int MP) {
        this.Mp = MP;
    }

    @Override
    public int getMP() {
        return Mp;
    }

    @Override
    public void setAttack(int Attack) {
        this.atk = Attack;
    }

    @Override
    public int getAttack() {
        return atk;
    }

    @Override
    public void setDefense(int Defense) {
        this.Def = Defense;
    }

    @Override
    public int getDefense() {
        return Def;
    }

    @Override
    public void setGold(int Gold) {
        this.Gold = Gold;
    }

    @Override
    public int getGold() {
        return Gold;
    }

    @Override
    public void getDamaged(int damage) {
        Hp -= damage;
    }
}
