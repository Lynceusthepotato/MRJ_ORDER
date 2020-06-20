package theActualGame;

public class visibilityManager {

    Screen sc;

    public visibilityManager(Screen theScreen){
        sc = theScreen;
    }

    public void showTitleScreen() {
        // Show
        sc.title_Panel.setVisible(true);
        sc.start_Button_Panel.setVisible(true);

        // Hide
        sc.main_Text_Panel.setVisible(false);
        sc.choice_Button_Panel.setVisible(false);
        sc.player_Status_Panel.setVisible(false);
        sc.player_Inventory_Panel.setVisible(false);
        sc.map_Image_Panel.setVisible(false);
        sc.map_Button_Panel.setVisible(false);
        sc.main_Image_Panel.setVisible(false);
        sc.enemy_Status_Panel.setVisible(false);
        sc.question_Panel.setVisible(false);
    }

    public void titleToMainScreen(){
        // Show
        sc.main_Text_Panel.setVisible(true);
        sc.choice_Button_Panel.setVisible(true);

        // Hide
        sc.title_Panel.setVisible(false);
        sc.start_Button_Panel.setVisible(false);
        sc.player_Status_Panel.setVisible(false);
        sc.player_Inventory_Panel.setVisible(false);
        sc.map_Image_Panel.setVisible(false);
        sc.map_Button_Panel.setVisible(false);
        sc.main_Image_Panel.setVisible(false);
        sc.enemy_Status_Panel.setVisible(false);
        sc.question_Panel.setVisible(false);

    }

    public void intoTheGame(){
        // Show
        sc.main_Text_Panel.setVisible(true);
        sc.choice_Button_Panel.setVisible(true);
        sc.player_Status_Panel.setVisible(true);
        sc.main_Image_Panel.setVisible(true);


        // Hide
        sc.title_Panel.setVisible(false);
        sc.start_Button_Panel.setVisible(false);
        sc.player_Inventory_Panel.setVisible(false);
        sc.map_Image_Panel.setVisible(false);
        sc.map_Button_Panel.setVisible(false);
        sc.enemy_Status_Panel.setVisible(false);
        sc.question_Panel.setVisible(false);

    }

    public void inBattle(){
        // Show
        sc.main_Text_Panel.setVisible(true);
        sc.choice_Button_Panel.setVisible(true);
        sc.player_Status_Panel.setVisible(true);
        sc.main_Image_Panel.setVisible(true);
        sc.enemy_Status_Panel.setVisible(true);


        // Hide
        sc.title_Panel.setVisible(false);
        sc.start_Button_Panel.setVisible(false);
        sc.player_Inventory_Panel.setVisible(false);
        sc.map_Image_Panel.setVisible(false);
        sc.map_Button_Panel.setVisible(false);
        sc.question_Panel.setVisible(false);
    }

    public void openInventory(){
        // Show
        sc.player_Inventory_Panel.setVisible(true);
        sc.choice_Button_Panel.setVisible(true);
        sc.player_Status_Panel.setVisible(true);
        sc.question_Panel.setVisible(true);


        // Hide
        sc.title_Panel.setVisible(false);
        sc.start_Button_Panel.setVisible(false);
        sc.main_Text_Panel.setVisible(false);
        sc.map_Image_Panel.setVisible(false);
        sc.map_Button_Panel.setVisible(false);
        sc.main_Image_Panel.setVisible(false);
        sc.enemy_Status_Panel.setVisible(false);

    }

    public void openOnlyWorldMap(){
        // Show
        sc.map_Image_Panel.setVisible(true);
        sc.map_Button_Panel.setVisible(true);

        // Hide
        sc.player_Inventory_Panel.setVisible(false);
        sc.choice_Button_Panel.setVisible(false);
        sc.player_Status_Panel.setVisible(false);
        sc.title_Panel.setVisible(false);
        sc.start_Button_Panel.setVisible(false);
        sc.main_Text_Panel.setVisible(false);
        sc.main_Image_Panel.setVisible(false);
        sc.enemy_Status_Panel.setVisible(false);
        sc.question_Panel.setVisible(false);

    }
}
