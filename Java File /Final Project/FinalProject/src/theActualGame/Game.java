package theActualGame;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game {

    Screen sc = new Screen();
    choiceInput ci = new choiceInput();
    visibilityManager vm = new visibilityManager(sc);
    mouseInput mi = new mouseInput();
    Player player = new Player();
    inventoryChoice ic = new inventoryChoice();
    mapChoice mc = new mapChoice();
    Item[] playerInventory;


    Script script = new Script(this,sc,vm,player);

    String select_Position_1,select_Position_2,select_Position_3,select_Position_4;


    public static void main(String[] args){
        new Game();
    }

    Game(){

        sc.createScreen(ci,mi,player,ic,playerInventory,mc,script,mi);
        vm.showTitleScreen();

    }

    public class choiceInput implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String choices = e.getActionCommand();

            switch(choices){
                case "start":
                    vm.titleToMainScreen();
                    script.enteringTheGame();
                    break;
                case "choice_1":
                    script.changeScreen(select_Position_1);
                    break;
                case "choice_2":
                    script.changeScreen(select_Position_2);
                    break;
                case "choice_3":
                    script.changeScreen(select_Position_3);
                    break;
                case "choice_4":
                    script.changeScreen(select_Position_4);
                    break;
            }

        }
    }

    public class inventoryChoice implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String item_Choice = e.getActionCommand();

            if(script.equipItem){
                switch(item_Choice) {
                    case "item_1":
                        script.itemChoice(0);
                        break;
                    case "item_2":
                        script.itemChoice(1);
                        break;
                    case "item_3":
                        script.itemChoice(2);
                        break;
                    case "item_4":
                        script.itemChoice(3);
                        break;
                    case "item_5":
                        script.itemChoice(4);
                        break;
                    case "item_6":
                        script.itemChoice(5);
                        break;
                    case "item_7":
                        script.itemChoice(6);
                        break;
                    case "item_8":
                        script.itemChoice(7);
                        break;
                }
            } else if(script.buyItem){
                switch(item_Choice) {
                    case "item_1":
                        script.buyItemChoice(0);
                        break;
                    case "item_2":
                        script.buyItemChoice(1);
                        break;
                    case "item_3":
                        script.buyItemChoice(2);
                        break;
                    case "item_4":
                        script.buyItemChoice(3);
                        break;
                    case "item_5":
                        script.buyItemChoice(4);
                        break;
                    case "item_6":
                        script.buyItemChoice(5);
                        break;
                    case "item_7":
                        script.buyItemChoice(6);
                        break;
                    case "item_8":
                        script.buyItemChoice(7);
                        break;
                }
            } else if (script.removeItem){
                switch(item_Choice) {
                    case "item_1":
                        script.removeItemChoice(0);
                        break;
                    case "item_2":
                        script.removeItemChoice(1);
                        break;
                    case "item_3":
                        script.removeItemChoice(2);
                        break;
                    case "item_4":
                        script.removeItemChoice(3);
                        break;
                    case "item_5":
                        script.removeItemChoice(4);
                        break;
                    case "item_6":
                        script.removeItemChoice(5);
                        break;
                    case "item_7":
                        script.removeItemChoice(6);
                        break;
                    case "item_8":
                        script.removeItemChoice(7);
                        break;
                }
            } else if (script.buyFoodandDrink){
                switch(item_Choice) {
                    case "item_1":
                        script.buyFoodandDrinks(0);
                        break;
                    case "item_2":
                        script.buyFoodandDrinks(1);
                        break;
                    case "item_3":
                        script.buyFoodandDrinks(2);
                        break;
                    case "item_4":
                        script.buyFoodandDrinks(3);
                        break;
                    case "item_5":
                        script.buyFoodandDrinks(4);
                        break;
                    case "item_6":
                        script.buyFoodandDrinks(5);
                        break;
                    case "item_7":
                        script.buyFoodandDrinks(6);
                        break;
                    case "item_8":
                        script.buyFoodandDrinks(7);
                        break;
                }
            }
        }
    }

    public class mapChoice implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String map_choice = e.getActionCommand();

            switch (map_choice){
                case "Maze":
                    script.Maze();
                    break;
                case "Town":
                    script.Town();
                    break;
                case "Forest":
                    script.Forest();
                    break;
                case "Home":
                    script.home();
                    break;
                case "Arena":
                    script.Arena();
                    break;
            }
        }
    }

    public class mouseInput implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }



}
