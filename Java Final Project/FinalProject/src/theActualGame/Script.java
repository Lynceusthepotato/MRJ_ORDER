package theActualGame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

public class Script {

    Game game;
    Screen sc;
    visibilityManager vm;
    Player player;
    Item[] playerInventory = new Item[8];
    Item[] ShopItem = new Item[8];

    Consumable lesserPotion = new someConsumable();
    Consumable Apple = new someConsumable("Apple",2,5);
    Consumable epicPotion = new someConsumable("Epic Potion", 50, 150);

    Consumable[] FoodandDrinks = new someConsumable[8];

    public void setFoodandDrinks() {
        FoodandDrinks[0] = new someConsumable("Beer", 20, -5);
        FoodandDrinks[1] = new someConsumable("Roasted Chicken", 40, 25);
        FoodandDrinks[2] = new someConsumable("Waffle", 15, 7);
        FoodandDrinks[3] = new someConsumable("Ice cream", 5, 5);
        FoodandDrinks[4] = new someConsumable("Toast", 20, 10);
        FoodandDrinks[5] = new someConsumable("Waffle", 15, 7);
        FoodandDrinks[6] = new someConsumable("Doubious Camoran Throne",100,75);
        FoodandDrinks[7] = new someConsumable("Gin", 40, -20);
    }

    Item ironNugget = new someItem("Iron Nugget", 15);
    Item roughCloth = new someItem("Rough Cloth", 3);
    Item spoon = new someItem("Spoon",5);

    Item[] itemDrop = new Item[3];

    public void setItemDrop() {
        itemDrop[0] = ironNugget;
        itemDrop[1] = roughCloth;
        itemDrop[2] = spoon;
    }



    Weapon woodSword = new someSword();
    Weapon steelSword = new someSword("Steel Sword", 7, 25);
    Weapon gramSword = new someSword("Gram", 10, 50);
    Weapon chunchunMaru = new someSword("Chunchunmaru", 100, 1000);

    Armor leatherArmor = new someArmor("Leather Armor", 2, 15,0);
    Armor ironArmor = new someArmor("Iron Armor", 3, 20, 0);
    Armor xivkyn = new someArmor("Xivkyn", 5, 78, 2);
    Armor kyoukaArmor = new someArmor("Kyouya's Armor", 7, 100, 2 );

    Monster[] monster = new Monster[2];

    public void setMonster(){
        monster[0] = new Monster();
        monster[1] = new Monster("Goblin", 10, 45,5,3,10,".//images//Goblin.png");
    }

    someItem emptySlot = new someItem();

    Random rand = new Random();

    String text, response, current_Location;
    String battle_Location = "";
    int counter, randomstuff, enemyEncounter, damageDone, damageShield, damageAfterCalculate, cost, reward;
    int itemSlot, battleCount = 0;
    boolean table, forest, town, equipItem, shop, sellingItem, removeItem, buyItem, playingMaze, talkToCreep, buyFoodandDrink, afterBattle = false;
    Weapon tempWeapon;
    Armor tempArmor;
    Item tempItem;
    Monster theEnemy = new Monster();

    int[][] Map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 9, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    int x = 1;
    int y = 1;



    public Script(Game g, Screen screen, visibilityManager visibilityManager, Player p){

        game = g;
        sc = screen;
        vm = visibilityManager;
        player = p;

    }

    Timer tm = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            char[] character = text.toCharArray();
            int array = character.length;

            String addedCharacter = "";
            String blank = "";

            addedCharacter = blank + character[counter];
            sc.main_Text.append(addedCharacter);
            sc.opt_Text.append(addedCharacter);

            counter++;

            if(counter == array){
                counter = 0;
                tm.stop();
            }
        }
    });


    void textReader(){
        sc.main_Text.setText("");
        sc.opt_Text.setText("");
        tm.start();
    }

    public void inventoryStart(){
        playerInventory[0] = emptySlot;
        playerInventory[1] = emptySlot;
        playerInventory[2] = emptySlot;
        playerInventory[3] = emptySlot;
        playerInventory[4] = emptySlot;
        playerInventory[5] = emptySlot;
        playerInventory[6] = emptySlot;
        playerInventory[7] = emptySlot;

    }

    public void shopItemStart(){
        ShopItem[0] = lesserPotion;
        ShopItem[1] = epicPotion;
        ShopItem[2] = leatherArmor;
        ShopItem[3] = ironArmor;
        ShopItem[4] = steelSword;
        ShopItem[5] = gramSword;
        ShopItem[6] = xivkyn;
        ShopItem[7] = kyoukaArmor;
    }

    public void readInventoryName(){
        sc.item_Button_1.setText(playerInventory[0].getName());
        sc.item_Button_2.setText(playerInventory[1].getName());
        sc.item_Button_3.setText(playerInventory[2].getName());
        sc.item_Button_4.setText(playerInventory[3].getName());
        sc.item_Button_5.setText(playerInventory[4].getName());
        sc.item_Button_6.setText(playerInventory[5].getName());
        sc.item_Button_7.setText(playerInventory[6].getName());
        sc.item_Button_8.setText(playerInventory[7].getName());

    }

    public void readShopItemName(){
        sc.item_Button_1.setText(ShopItem[0].getName() + " || " + ShopItem[0].getValue() * 3 + " Gold");
        sc.item_Button_2.setText(ShopItem[1].getName() + " || " + ShopItem[1].getValue() * 3 + " Gold");
        sc.item_Button_3.setText(ShopItem[2].getName() + " || " + ShopItem[2].getValue() * 3 + " Gold");
        sc.item_Button_4.setText(ShopItem[3].getName() + " || " + ShopItem[3].getValue() * 3 + " Gold");
        sc.item_Button_5.setText(ShopItem[4].getName() + " || " + ShopItem[4].getValue() * 3 + " Gold");
        sc.item_Button_6.setText(ShopItem[5].getName() + " || " + ShopItem[5].getValue() * 3 + " Gold");
        sc.item_Button_7.setText(ShopItem[6].getName() + " || " + ShopItem[6].getValue() * 3 + " Gold");
        sc.item_Button_8.setText(ShopItem[7].getName() + " || " + ShopItem[7].getValue() * 3 + " Gold");
    }

    public void readFoodandDrinksName(){
        sc.item_Button_1.setText(FoodandDrinks[0].getName() + " || " + FoodandDrinks[0].getValue() + " Gold");
        sc.item_Button_2.setText(FoodandDrinks[1].getName() + " || " + FoodandDrinks[1].getValue() + " Gold");
        sc.item_Button_3.setText(FoodandDrinks[2].getName() + " || " + FoodandDrinks[2].getValue() + " Gold");
        sc.item_Button_4.setText(FoodandDrinks[3].getName() + " || " + FoodandDrinks[3].getValue() + " Gold");
        sc.item_Button_5.setText(FoodandDrinks[4].getName() + " || " + FoodandDrinks[4].getValue() + " Gold");
        sc.item_Button_6.setText(FoodandDrinks[5].getName() + " || " + FoodandDrinks[5].getValue() + " Gold");
        sc.item_Button_7.setText(FoodandDrinks[6].getName() + " || " + FoodandDrinks[6].getValue() + " Gold");
        sc.item_Button_8.setText(FoodandDrinks[7].getName() + " || " + FoodandDrinks[7].getValue() + " Gold");
    }
    public void updateStats(){
        sc.player_Attack_Number_Label.setText("" + player.getAttack());
        sc.hp_Number_Label.setText("" + player.getHP());
        sc.weapon_Name_Label.setText(player.weapon_Equipped.getName());
        sc.enemy_Name_Label.setText(theEnemy.getName());
        sc.enemy_Hp_Number_label.setText("" + theEnemy.getHP());
    }

    public void changeScreen(String screen){
        sc.choice_1.setForeground(Color.BLACK);
        sc.choice_2.setForeground(Color.BLACK);
        sellingItem = false;
        removeItem = false;
        equipItem = false;
        buyItem = false;
        switch (screen){
            case "enteringNameForPlayer":
                enteringNameForPlayer();
                break;
            case "homeNew":
                homeNew();
                break;
            case "home":
                home();
                break;
            case "Inventory":
                Inventory();
                break;
            case "Table":
                Table();
                break;
            case "map":
                map();
                break;
            case "Search":
                Search();
                break;
            case "Battle":
                Battle();
                break;
            case "Forest":
                Forest();
                break;
            case "playerAttack":
                playerAttack();
                break;
            case "enemyAttack":
                enemyAttack();
                break;
            case "run":
                run();
                break;
            case "EquipItem":
                EquipItem();
                break;
            case "RemoveItem":
                RemoveItem();
                break;
            case "Town":
                Town();
                break;
            case "Shop":
                Shop();
                break;
            case "BuyItem":
                shopBuy();
                break;
            case "SellItem":
                shopSell();
                break;
            case "GoUp":
                goUp();
                break;
            case "GoDown":
                goDown();
                break;
            case "GoRight":
                goRight();
                break;
            case "GoLeft":
                goLeft();
                break;
            case "Bar":
                Bar();
                break;
            case "CreepyGuy":
                creepyGuy();
                break;
            case "EaD":
                barFoodandDrink();
                break;
            case "oneRound":
                oneRound();
                break;
            case "threeRound":
                threeRound();
                break;
            case "fiveRound":
                fiveRound();
                break;
            case "Hold":
                hold();
                break;
            case "Arena":
                Arena();
                break;
            case "playerDefend":
                playerDefend();
                break;


        }
    }

    public void itemChoice(int item){
        if(playerInventory[item] instanceof Weapon){
            tempWeapon = player.weapon_Equipped;
            player.equipWeapon((Weapon) playerInventory[item]);
            if (playerInventory[item] == tempWeapon){
                playerInventory[item] = emptySlot;
            } else {
                playerInventory[item] = tempWeapon;
            }
        } else if(playerInventory[item] instanceof Consumable){
            player.useitem((Consumable) playerInventory[item]);
            playerInventory[item] = emptySlot;
        } else if(playerInventory[item] instanceof Armor){
            tempArmor = player.Armor_Equipped;
            player.equipArmor((Armor) playerInventory[item]);
            if (playerInventory[item] == tempArmor){
                playerInventory[item] = emptySlot;
            } else {
                playerInventory[item] = tempArmor;
            }
        }

       // This is to update the list
       sc.player_Attack_Number_Label.setText("" + player.getAttack());
       sc.weapon_Name_Label.setText(player.weapon_Equipped.getName());
       sc.hp_Number_Label.setText("" + player.getHP());
       sc.armour_Name_Label.setText(player.Armor_Equipped.getName());
       readInventoryName();

    }

    public void removeItemChoice(int item){
        if(sellingItem){
            player.plusGold(playerInventory[item].getValue());
        }
        playerInventory[item] = emptySlot;
        sc.money_Number_Label.setText("" + player.getGold());
        readInventoryName();
    }

    public void buyItemChoice(int item){
        cost = ShopItem[item].getValue() * 3;
        moneyChecker();
        if(player.getGold() > cost){
            player.removeGold(cost);
            itemChecker();
            if(playerInventory[itemSlot] == emptySlot){
                text = "You Bought " + ShopItem[item].getName();
                playerInventory[itemSlot] = ShopItem[item];
            } else {
                text = "You need to clear your Inventory";
            }
            textReader();
            shopChoice();
        }
        sc.money_Number_Label.setText("" + player.getGold());
    }

    public void buyFoodandDrinks(int item){
        cost = FoodandDrinks[item].getValue();
        moneyChecker();
        if(player.getGold() > cost){
            player.removeGold(cost);
            player.useitem(FoodandDrinks[item]);
            barChoice();
        }
        sc.hp_Number_Label.setText("" + player.getHP());
        sc.money_Number_Label.setText("" + player.getGold());

    }

    public void onlyOneChoice(){
        sc.choice_2.setText("");
        sc.choice_3.setText("");
        sc.choice_4.setText("");

        game.select_Position_2 = "";
        game.select_Position_3 = "";
        game.select_Position_4 = "";
    }
    public void startEverything(){
        setMonster();
        shopItemStart();
        inventoryStart();
        setFoodandDrinks();
        setItemDrop();
    }

    public void enteringTheGame() {
        startEverything();
        text = "Hello there, this is a test game!. The point of the game is to find the most legendary sword there is! \nSo lets make it simple... " +
                "you wake up in your house and \neverything else is up to you!, \nbut first what should I call you?";
        textReader();
        response = JOptionPane.showInputDialog("Enter your name here");
        response = response.substring(0,1).toUpperCase() + response.substring(1);
        player.setName(response);
        sc.choice_1.setText("Press me!");
        game.select_Position_1 = "enteringNameForPlayer";
        onlyOneChoice();
    }

    public void enteringNameForPlayer() {
        if (player.getName().equals("Kazuma")){
            text = "Huh so your name is " + player.getName() + ", pretty sure you are a weeb \nbut since you know the reference, \nhere I give you some gold!";
            player.plusGold(50);
            sc.money_Number_Label.setText("" + player.getGold());
        } else {
            text = "Huh so your name is " + player.getName() + ", hmm I th- nvm, ok now you are going to be teleported to your new home";
        }
        textReader();
        sc.choice_1.setText("Ok");
        game.select_Position_1= "homeNew";
        onlyOneChoice();
    }

    public void homeNew(){
        text = "So this is home huh? ok pretty sure this is the same game \nbut in different programming language, \nbut its still cool right?... Anyway lets check around";
        textReader();
        vm.intoTheGame();
        sc.choice_1.setText("Ok");
        game.select_Position_1 = "home";
        onlyOneChoice();
    }

    public void home(){
        sc.mainImage = new ImageIcon(".//images//House.png");
        sc.main_Image_Label.setIcon(sc.mainImage);
        text = "What would you like to do?";
        textReader();
        vm.intoTheGame();
        current_Location = "home";

        sc.choice_1.setText("Get Out");
        sc.choice_2.setText("Table");
        sc.choice_3.setText("Inventory");
        sc.choice_4.setText("");

        game.select_Position_1 = "map";
        game.select_Position_2 = "Table";
        game.select_Position_3 = "Inventory";
        game.select_Position_4 = "";


    }

    public void InvChoice(){
        sc.choice_1.setText("Equip Item");
        sc.choice_2.setText("Remove Item");
        sc.choice_3.setText("Close Inventory");
        sc.choice_4.setText("");

        game.select_Position_1 = "EquipItem";
        game.select_Position_2 = "RemoveItem";
        game.select_Position_3 = current_Location;
        game.select_Position_4 = "";
    }

    public void Inventory(){
        text = "What do you want to do?";

        textReader();
        InvChoice();
    }

    public void EquipItem(){
        equipItem = true;
        sc.choice_1.setForeground(Color.GREEN);
        vm.openInventory();
        readInventoryName();
        InvChoice();

    }

    public void RemoveItem(){
        equipItem = false;
        removeItem = true;
        sc.choice_2.setForeground(Color.GREEN);
        vm.openInventory();
        readInventoryName();
        InvChoice();

    }

    public void Table(){
        if(!table){
            text = "Oh there is some stuff on the table lemme pick it up!";
            playerInventory[0] = lesserPotion;
            playerInventory[1] = woodSword;

            table = true;
        } else {
            text = "You already took what`s on the table you nut";
        }
        textReader();
        sc.choice_1.setText("Go Back");
        game.select_Position_1 = "home";
        onlyOneChoice();
    }

    public void map(){
        vm.openOnlyWorldMap();
    }

    public void mazeChoice(){
        sc.choice_1.setText("Up");
        sc.choice_2.setText("Right");
        sc.choice_3.setText("Left");
        sc.choice_4.setText("Down");

        game.select_Position_1 = "GoUp";
        game.select_Position_2 = "GoRight";
        game.select_Position_3 = "GoLeft";
        game.select_Position_4 = "GoDown";

    }
    public void mazeImage(){
        if(Map[y + 1][x - 1] == 0 && Map[y][x - 1] == 1){
            sc.mainImage = new ImageIcon(".//images//FrontLeft.png");
            sc.main_Image_Label.setIcon(sc.mainImage);
        } else if(Map[y + 1][x + 1] == 0 && Map[y][x + 1] == 1){
            sc.mainImage = new ImageIcon(".//images//FrontRight.png");
            sc.main_Image_Label.setIcon(sc.mainImage);
        } else if (Map[y][x + 1 ] == 0 && Map[y][x - 1] == 0){
            sc.mainImage = new ImageIcon(".//images//LeftRight.png");
            sc.main_Image_Label.setIcon(sc.mainImage);
        } else if (Map[y - 1][x] == 1 && Map[y + 1][x] == 1 && Map[y][x + 1] == 1){
            sc.mainImage = new ImageIcon(".//images//EndlessHall.png");
            sc.main_Image_Label.setIcon(sc.mainImage);
        }
    }

    public void goDown(){
        text = " ";
        textReader();
        mazeImage();
        int y2 = y + 1;
        if (Map[y2][x] == 0) {
            Map[y][x] = 0;
            y++;
            Map[y][x] = 8;
        } else if (Map[y2][x] == 9) {
            Map[y][x] = 0;
            y++;
            Map[y][x] = 8;
            playingMaze = true;
        }
        mazeChoice();
        print(Map);
        mazeReward();

    }

    public void goUp(){
        text = " ";
        textReader();
        mazeImage();
        int y1 = y - 1;
        if (Map[y1][x] == 0) {
            Map[y][x] = 0;
            y--;
            Map[y][x] = 8;
        } else if (Map[y1][x] == 9) {
            Map[y][x] = 0;
            y--;
            Map[y][x] = 8;
            playingMaze = true;
        }
        mazeChoice();
        print(Map);
        mazeReward();
    }

    public void goLeft(){
        text = " ";
        textReader();
        mazeImage();
        int x2 = x - 1;
        if (Map[y][x2] == 0) {
            Map[y][x] = 0;
            x--;
            Map[y][x] = 8;
        } else if (Map[y][x2] == 9) {
            Map[y][x] = 0;
            x--;
            Map[y][x] = 8;
            playingMaze = true;
        }
        mazeChoice();
        print(Map);
        mazeReward();
    }

    public void goRight(){
        text = " ";
        textReader();
        mazeImage();
        int x1 = x + 1;
        if (Map[y][x1] == 0) {
            Map[y][x] = 0;
            x++;
            Map[y][x] = 8;
        } else if (Map[y][x1] == 9) {
            Map[y][x] = 0;
            x++;
            Map[y][x] = 8;
            playingMaze = true;
        }
        mazeChoice();
        print(Map);
        mazeReward();
    }

    public void Maze(){
        vm.intoTheGame();
        if(!afterBattle){
            sc.mainImage = new ImageIcon(".//images//Black.jpeg");
            sc.main_Image_Label.setIcon(sc.mainImage);
            text = "*cough* You are allowed to enter the Maze after you've beaten the arena *cough*";
            onlyOneChoice();
            sc.choice_1.setText("= - =");
            game.select_Position_1 = "map";
            textReader();
        } else if(playingMaze){
            text = "You already done the maze you don't need to do it anymore";
            onlyOneChoice();
            sc.choice_1.setText("= - =");
            game.select_Position_1 = "map";
            textReader();
        }
        else {
            sc.mainImage = new ImageIcon(".//images//EndlessHall.png");
            sc.main_Image_Label.setIcon(sc.mainImage);
            text = " ";
            textReader();
            Map[x][y] = 8;
            print(Map);
            mazeChoice();
        }
    }
    public void mazeReward(){
        if(playingMaze) {
            sc.mainImage = new ImageIcon(".//images//Chunchunmaru.png");
            sc.main_Image_Label.setIcon(sc.mainImage);
            itemChecker();
            playerInventory[itemSlot] = chunchunMaru;
            onlyOneChoice();
            sc.choice_1.setText("Get out");
            game.select_Position_1 = "map";
            text = "OH MY GOD I GOT IT " + playerInventory[itemSlot].getName() + " The legendary sword!";
            textReader();

        }
    }
    public void print(int [][] map){
        for(int[] ints : map){
            for(int x = 0; x < map[0].length; x++){
                sc.main_Text.append(" " +ints[x]);
            }
            sc.main_Text.append("\n");
        }
    }

    public void Town(){
        sc.mainImage = new ImageIcon(".//images//Shop.png");
        sc.main_Image_Label.setIcon(sc.mainImage);
        current_Location = "Town";
        vm.intoTheGame();
        if (!town && player.getName().equals("Kazuma")){
            text = "Hey I know this place !";
        } else if (!town){
            text = "This place looks pretty neat";
            town = true;
        } else {
            text = "Where do you want to go ";
        }
        textReader();

        sc.choice_1.setText("Shop");
        sc.choice_2.setText("Bar");
        sc.choice_3.setText("Go Back");
        sc.choice_4.setText("");

        game.select_Position_1 = "Shop";
        game.select_Position_2 = "Bar";
        game.select_Position_3 = "map";
        game.select_Position_4 = "";

    }

    public void shopChoice(){
        sc.choice_1.setText("Buy Item");
        sc.choice_2.setText("Sell Item");
        sc.choice_3.setText("Go back");
        sc.choice_4.setText("");

        game.select_Position_1 = "BuyItem";
        game.select_Position_2 = "SellItem";
        game.select_Position_3 = "Town";
        game.select_Position_4 = "";
    }

    public void shopBuy(){
        equipItem = false;
        sellingItem = false;
        buyItem = true;
        vm.openInventory();
        shopChoice();
        readShopItemName();
        sc.choice_1.setForeground(Color.green);
    }

    public void shopSell(){
        equipItem = false;
        sellingItem = true;
        removeItem = true;
        sc.choice_2.setForeground(Color.green);
        shopChoice();
        vm.openInventory();
        readInventoryName();

    }

    public void barChoice(){
        sc.choice_1.setText("Eat and Drink");
        sc.choice_2.setText("Talk to the Creepy Guy");
        sc.choice_3.setText("Go back");
        sc.choice_4.setText("");

        game.select_Position_1 = "EaD";
        game.select_Position_2 = "CreepyGuy";
        game.select_Position_3 = "Town";
        game.select_Position_4 = "";
    }

    public void barFoodandDrink(){
        buyFoodandDrink = true;
        vm.openInventory();
        readFoodandDrinksName();
        sc.choice_1.setForeground(Color.green);
        barChoice();
    }

    public void moneyChecker(){
        if(cost > player.getGold()){
            text = "You don't have enough money";
        }
        textReader();
        sc.choice_1.setText("Ok");
        game.select_Position_1 = current_Location;
        onlyOneChoice();
    }

    public void Shop(){
        vm.intoTheGame();
        sc.mainImage = new ImageIcon(".//images//Vanir.png");
        sc.main_Image_Label.setIcon(sc.mainImage);
        if(!shop && player.getName().equals("Kazuma")){
            text = "Hey it seems you know the reference, I'm sorry but Wiz is not here today, so I will give you some gold for some reason...";
            player.plusGold(50);
            sc.money_Number_Label.setText("" + player.getGold());
            shop = true;
        } else {
            text = "What do you want to do ?";
        }

        textReader();
        shopChoice();
    }

    public void Bar(){
        vm.intoTheGame();
        sc.mainImage = new ImageIcon(".//images//Bar.png");
        sc.main_Image_Label.setIcon(sc.mainImage);
        text = "What do you want to do?";
        textReader();
        barChoice();

    }

    public void creepyGuy(){
        vm.intoTheGame();
        sc.mainImage = new ImageIcon(".//images//CreepyGuy.png");
        sc.main_Image_Label.setIcon(sc.mainImage);
        if(talkToCreep){
            text = "I don't want to talk to that guy...";
            sc.choice_1.setText("Ok....");
            game.select_Position_1 = "Bar";
            onlyOneChoice();
        }
        talkToCreep = true;
        sc.map_Button_Panel.add(sc.map_Button_5);
        text = "hehehe... I see you from there... Uhf you look strong. Here ill give you a tip, there is an arena next to the town";
        textReader();
        onlyOneChoice();
        sc.mapImage = new ImageIcon(".//images//mapWithArena.png");
        sc.map_Label.setIcon(sc.mapImage);
        sc.choice_1.setText("Ok....");
        game.select_Position_1 = "Bar";
    }

    public void Arena(){
        arenaMonsterSpawn();
        vm.intoTheGame();
        battle_Location = "Arena";
        sc.mainImage = new ImageIcon(".//images//Arena.png");
        sc.main_Image_Label.setIcon(sc.mainImage);
        text = "How much battle do you want to do ?";
        textReader();

        sc.choice_1.setText("1 || Reward : 20 Gold");
        sc.choice_2.setText("3 || Reward : 75 Gold");
        sc.choice_3.setText("5 || Reward : 150 Gold");
        sc.choice_4.setText("Go Back");

        game.select_Position_1 = "oneRound";
        game.select_Position_2 = "threeRound";
        game.select_Position_3 = "fiveRound";
        game.select_Position_4 = "map";


    }

    public void oneRound(){
        reward = 20;
        Battle();
    }

    public void threeRound(){
        reward = 75;
        Battle();
    }
    public void fiveRound(){
        reward = 150;
        Battle();
    }


    public void Forest(){
        vm.intoTheGame();
        sc.mainImage = new ImageIcon(".//images//Forest.png");
        sc.main_Image_Label.setIcon(sc.mainImage);
        if(!forest){
            text = "This place is weird, but also my game instinct is telling me this is the spot to farm some battles and got some loot";
            forest = true;
        }
        textReader();
        sc.choice_1.setText("Search");
        sc.choice_2.setText("Go Back");
        sc.choice_3.setText("Inventory");
        sc.choice_4.setText("");

        game.select_Position_1 = "Search";
        game.select_Position_2 = "map";
        game.select_Position_3 = "Inventory";
        game.select_Position_4 = "";

        current_Location = "Forest";
    }

    public void Search(){
        randomstuff = rand.nextInt(80);
        if(randomstuff <= 20){
            itemChecker();
            if(playerInventory[itemSlot] == emptySlot){
                playerInventory[itemSlot] = Apple;
                text = "Oh! we got " + playerInventory[itemSlot].getName();
            } else {
                text = "It looks like im out of space";
            } Forest();
        }else if(randomstuff > 21 && randomstuff <= 50){
            itemChecker();
            if(playerInventory[itemSlot] == emptySlot){
                playerInventory[itemSlot] = ironNugget;
                text = "Oh! we got " + playerInventory[itemSlot].getName();
            } else {
                text = "it looks like im out of space";
            } Forest();
        }else if(randomstuff > 51 && randomstuff <= 80 ) {
            battle_Location = "Forest";
            setMonster();
            enemyEncounter = rand.nextInt(monster.length);
            theEnemy = monster[enemyEncounter];
            Battle();
        }
        textReader();
        itemSlot = 0;
    }

    public void itemChecker(){
        itemSlot = 0;
        while(playerInventory[itemSlot] != emptySlot && itemSlot < 7){
            itemSlot++;
        }
    }

    public void hold(){
        text = "Are you ready?! ";
        textReader();
        arenaMonsterSpawn();
        onlyOneChoice();
        sc.choice_1.setText("YES");
        game.select_Position_1 = "Battle";
    }

    public void arenaMonsterSpawn(){
        setMonster();
        enemyEncounter = rand.nextInt(monster.length);
        theEnemy = monster[enemyEncounter];
    }

    public void Battle(){
        vm.inBattle();
        current_Location = "Battle";

        sc.mainImage = new ImageIcon(theEnemy.getFilename());
        sc.main_Image_Label.setIcon(sc.mainImage);

        if(theEnemy.getHP() > 0){
            text = "What do you want to do ? ";
        }

        sc.choice_1.setText("Attack");
        sc.choice_2.setText("Defend");
        sc.choice_3.setText("Inventory");
        sc.choice_4.setText("run");

        game.select_Position_1 = "playerAttack";
        game.select_Position_2 = "playerDefend";
        game.select_Position_3 = "Inventory";
        game.select_Position_4 = "run";

        if (theEnemy.getHP() <= 0){
            randomstuff = rand.nextInt(itemDrop.length);
            tempItem = itemDrop[randomstuff];
            itemChecker();
            playerInventory[itemSlot] = tempItem ;
            text = "You win and received " + playerInventory[itemSlot].getName();
            textReader();
            onlyOneChoice();
            itemSlot = 0;
            sc.choice_1.setText("Yis");
            game.select_Position_1 = "Forest";

            if (battle_Location.equals("Arena")){
                if(reward == 20){
                    battleCount++;
                    if (battleCount < 1) {
                        hold();
                    } else {
                        text = "You finish the " + battleCount + " round challenge, you got " + reward + " gold";
                        player.plusGold(reward);
                        sc.choice_1.setText("YES!!");
                        game.select_Position_1 = "Arena";
                        battleCount = 0;
                        onlyOneChoice();
                        textReader();
                    }
                } else if (reward == 75){
                    battleCount++;
                    if(battleCount  < 3 ){
                        text = "You finished the " + battleCount + " round";
                        sc.choice_1.setText("YOSH!!");
                        game.select_Position_1 = "Hold";
                    } else {
                        text = "You finish the " + battleCount + " round challenge, you got " + reward + " gold";
                        player.plusGold(reward);
                        sc.choice_1.setText("YES!!");
                        game.select_Position_1 = "Arena";
                        battleCount = 0;
                    }
                    onlyOneChoice();
                    textReader();
                } else if (reward == 150) {
                    battleCount ++;
                    if (battleCount < 5){
                        text = "You finished the " + battleCount + " round";
                        sc.choice_1.setText("YOSH!!");
                        game.select_Position_1 = "Hold";
                    } else {
                        text = "You finish the " + battleCount + " round challenge, you got " + reward + " gold, And because you finished the 5 round THE MAZE HAVE BEEN OPENED" ;
                        player.plusGold(reward);
                        sc.choice_1.setText("YES!!");
                        game.select_Position_1 = "Arena";
                        battleCount = 0;
                        afterBattle = true;
                    }
                    onlyOneChoice();
                    textReader();
                }
                sc.money_Number_Label.setText("" + player.getGold());
            }
        }else if (theEnemy.getHP() <= 0 && player.getHP() <= 0){
            text = "Ffffff---";
            textReader();
            sc.window.dispatchEvent(new WindowEvent(sc.window, WindowEvent.WINDOW_CLOSING));

        } else if (player.getHP() <= 0){
            text = "Game Over";
            textReader();
            sc.window.dispatchEvent(new WindowEvent(sc.window, WindowEvent.WINDOW_CLOSING));
        }


        updateStats();
        textReader();
    }

    public void playerDefend(){
        damageDone = rand.nextInt(theEnemy.getAttack());
        damageShield = rand.nextInt(player.getDefense() * 2);
        damageAfterCalculate = damageDone - damageShield;
        if (damageAfterCalculate < 0){
            damageAfterCalculate = 0;
        }

        text = "You receive " + damageAfterCalculate + " damage";
        player.getDamaged(damageAfterCalculate);

        sc.choice_1.setText("Nice");
        game.select_Position_1 = "Battle";
        onlyOneChoice();
        updateStats();
        textReader();
    }


    public void playerAttack(){
        damageDone = rand.nextInt(player.getAttack());
        damageShield = rand.nextInt(theEnemy.getDefense());
        damageAfterCalculate = damageDone - damageShield;
        if (damageAfterCalculate < 0){
            damageAfterCalculate = 0;
        }

        text = "You did " + damageAfterCalculate + " damage";
        theEnemy.getDamaged(damageAfterCalculate);

        sc.choice_1.setText("Nice");
        game.select_Position_1 = "enemyAttack";
        onlyOneChoice();
        updateStats();
        textReader();

    }

    public void enemyAttack(){
        damageDone = rand.nextInt(theEnemy.getAttack());
        damageShield = rand.nextInt(player.getDefense());
        damageAfterCalculate = damageDone - damageShield;
        if (damageAfterCalculate < 0){
            damageAfterCalculate = 0;
        }

        text = "You receive " + damageAfterCalculate + " damage";
        player.getDamaged(damageAfterCalculate);

        sc.choice_1.setText("Ouch");
        game.select_Position_1 = "Battle";
        onlyOneChoice();
        updateStats();
        textReader();
    }

    public void run(){
        if(battle_Location.equals("Arena")){
            text = "You can't run away from arena";
            sc.choice_1.setText("Oh no");
            game.select_Position_1 = "enemyAttack";
        } else {
            randomstuff = rand.nextInt(10);
            if(randomstuff <= 5){
                text = "Heck im too slow";
                sc.choice_1.setText("HECK");
                game.select_Position_1 = "enemyAttack";
            } else if (randomstuff > 6 && randomstuff <= 10){
                text = "I did it";
                sc.choice_1.setText("BEEP BEEP");
                game.select_Position_1 = "Forest";
            }
        }
        onlyOneChoice();
        textReader();
        updateStats();
    }

}
