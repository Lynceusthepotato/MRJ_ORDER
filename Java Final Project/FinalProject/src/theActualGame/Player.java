package theActualGame;

public class Player implements Character {
    private String name;
    private int maxHP;
    private int HP;
    private int maxMP;
    private int MP;
    private int Attack;
    private int Defense;
    private int Gold;
    Weapon weapon_Equipped;
    Armor Armor_Equipped;

    Player(){
        this.name = "Bruh you didn't fill your name";
        this.maxHP = 75;
        this.HP = this.maxHP;
        this.maxMP = 20;
        this.MP = this.maxMP;
        this.Attack = 5;
        this.Defense = 2;
        this.Gold = 0;
        this.weapon_Equipped = new someSword("Fist", 0 , 0);
        this.Armor_Equipped = new someArmor("Clothes",1,5,0);
    }

    Player(String name, int HP, int MP, int Attack, int Defense, int Gold){
        this.name = name;
        this.maxHP = HP;
        this.HP = this.maxHP;
        this.maxMP = MP;
        this.MP = this.maxMP;
        this.Attack = Attack;
        this.Defense = Defense;
        this.Gold = Gold;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }

    @Override
    public void setMP(int MP) {
        this.MP = MP;
    }

    @Override
    public int getMP() {
        return MP;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getAttack() {
        return Attack;
    }

    public void setDefense(int defense) {
        Defense = defense;
    }

    public int getDefense() {
        return Defense;
    }

    public void setWeapon(Weapon weapon) {
        weapon_Equipped = weapon;
    }

    public Weapon getWeapon() {
        return weapon_Equipped;
    }

    public void setGold(int gold) {
        Gold = gold;
    }

    public int getGold() {
        return Gold;
    }

    public void equipWeapon(Weapon weapon){
        if(weapon_Equipped != null){
            unequipWeapon();
        }
        weapon_Equipped = weapon;
        Attack += weapon.getAttack();
    }

    public void unequipWeapon(){
        if(weapon_Equipped != null){
            Attack -= weapon_Equipped.getAttack();
            weapon_Equipped = null;
        }
    }

    public void useitem(Consumable consumable) {
        HP += consumable.getPlus();
        if(HP > maxHP){
            HP = maxHP;
        }
    }

    public void equipArmor(Armor armor){
        if(Armor_Equipped != null){
            unequipArmor();
        }
        Armor_Equipped = armor;
        Defense += armor.getDefense();
        Defense += armor.getSpecial();
    }

    public void unequipArmor(){
        if(Armor_Equipped != null){
            Defense -= Armor_Equipped.getDefense();
            Armor_Equipped = null;
        }
    }

    public void getDamaged(int damage){
        HP -= damage;
    }

    public void plusGold(int Gold){
        this.Gold += Gold;
    }

    public void removeGold(int Gold){
        this.Gold -= Gold;
    }

}
