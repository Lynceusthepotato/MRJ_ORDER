package theActualGame;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Screen {

    JFrame window;
    Container con;

    JPanel title_Panel, start_Button_Panel, main_Text_Panel, choice_Button_Panel, player_Status_Panel, player_Inventory_Panel,
            map_Image_Panel, map_Button_Panel, main_Image_Panel, enemy_Status_Panel, question_Panel;
    JLabel title_Label, hp_Label, hp_Number_Label, weapon_Label, weapon_Name_Label,
            player_Attack_Label, player_Attack_Number_Label, armour_Label, armour_Name_Label,money_Label,
            money_Number_Label, map_Label, main_Image_Label, enemy_Name_Label, enemy_Hp_Label, enemy_Hp_Number_label, colored_text;
    JButton start_Button, choice_1, choice_2, choice_3, choice_4,
            item_Button_1, item_Button_2, item_Button_3, item_Button_4,
            item_Button_5, item_Button_6, item_Button_7, item_Button_8,
            map_Button_1, map_Button_2, map_Button_3, map_Button_4, map_Button_5;
    JTextArea main_Text, opt_Text;
    ImageIcon mapImage, mainImage;

    Font title_Font = new Font("Times New Roman", Font.PLAIN,50);
    Font normal_Font = new Font("Times New Roman", Font.PLAIN, 25);

    public void createScreen(Game.choiceInput ci, Game.mouseInput mi, Player player, Game.inventoryChoice ic, Item[] playerInventory, Game.mapChoice mc, Script script, Game.mouseInput mouseInput){

        // Window
        window = new JFrame();
        window.setSize(1280, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        con = window.getContentPane();
        window.addMouseListener(mi);

        // Border
        Border whiteline = BorderFactory.createLineBorder(Color.WHITE);

        // Title Screen
        title_Panel = new JPanel();
        title_Panel.setBounds(100,100,1080,100);
        title_Panel.setBackground(Color.BLACK);

        title_Label = new JLabel("CHUNCHUNMARU");
        title_Label.setForeground(Color.WHITE);
        title_Label.setFont(title_Font);

        start_Button_Panel = new JPanel();
        start_Button_Panel.setBounds(550,450,200,200);
        start_Button_Panel.setBackground(Color.BLACK);

        start_Button = new JButton("START");
        start_Button.setBackground(Color.black);
        start_Button.setForeground(Color.white);
        start_Button.setFont(normal_Font);
        start_Button.setBorderPainted(false);

        start_Button.addActionListener(ci);
        start_Button.setActionCommand("start");

        title_Panel.add(title_Label);
        start_Button_Panel.add(start_Button);

        con.add(title_Panel);
        con.add(start_Button_Panel);

        // Main Screen
        main_Text_Panel = new JPanel();
        main_Text_Panel.setBounds(50,450,600,250);
        main_Text_Panel.setBackground(Color.BLACK);
        con.add(main_Text_Panel);

        main_Text = new JTextArea("Welcome to the world");
        main_Text.setBounds(50,450,600,250);
        main_Text.setBackground(Color.BLACK);
        main_Text.setForeground(Color.WHITE);
        main_Text.setFont(normal_Font);
        main_Text.setLineWrap(true);
        main_Text_Panel.add(main_Text);

        // Status
        player_Status_Panel = new JPanel();
        player_Status_Panel.setBounds(875,100,350,300);
        player_Status_Panel.setBackground(Color.BLACK);
        player_Status_Panel.setLayout(new GridLayout(6,2));
        con.add(player_Status_Panel);

        hp_Label = new JLabel("HP :");
        hp_Label.setForeground(Color.WHITE);
        hp_Label.setFont(normal_Font);
        player_Status_Panel.add(hp_Label);

        hp_Number_Label = new JLabel("" + player.getHP());
        hp_Number_Label.setForeground(Color.WHITE);
        hp_Number_Label.setFont(normal_Font);
        player_Status_Panel.add(hp_Number_Label);

        weapon_Label = new JLabel("Weapon : ");
        weapon_Label.setForeground(Color.WHITE);
        weapon_Label.setFont(normal_Font);
        player_Status_Panel.add(weapon_Label);

        weapon_Name_Label = new JLabel(player.weapon_Equipped.getName());
        weapon_Name_Label.setForeground(Color.WHITE);
        weapon_Name_Label.setFont(normal_Font);
        player_Status_Panel.add(weapon_Name_Label);

        player_Attack_Label = new JLabel("Attack : ");
        player_Attack_Label.setForeground(Color.WHITE);
        player_Attack_Label.setFont(normal_Font);
        player_Status_Panel.add(player_Attack_Label);

        player_Attack_Number_Label = new JLabel("" + player.getAttack());
        player_Attack_Number_Label.setForeground(Color.WHITE);
        player_Attack_Number_Label.setFont(normal_Font);
        player_Status_Panel.add(player_Attack_Number_Label);

        armour_Label = new JLabel("Armour : ");
        armour_Label.setForeground(Color.WHITE);
        armour_Label.setFont(normal_Font);
        player_Status_Panel.add(armour_Label);

        armour_Name_Label = new JLabel(player.Armor_Equipped.getName());
        armour_Name_Label.setForeground(Color.WHITE);
        armour_Name_Label.setFont(normal_Font);
        player_Status_Panel.add(armour_Name_Label);

        money_Label = new JLabel("Money :");
        money_Label.setForeground(Color.WHITE);
        money_Label.setFont(normal_Font);
        player_Status_Panel.add(money_Label);

        money_Number_Label = new JLabel("" + player.getGold());
        money_Number_Label.setForeground(Color.WHITE);
        money_Number_Label.setFont(normal_Font);
        player_Status_Panel.add(money_Number_Label);

        player_Status_Panel.setBorder(whiteline);

        // Enemy Status On Battle
        enemy_Status_Panel = new JPanel();
        enemy_Status_Panel.setBounds(50,25,800,50);
        enemy_Status_Panel.setBackground(Color.BLACK);
        enemy_Status_Panel.setLayout(new GridLayout(1,3));
        con.add(enemy_Status_Panel);

        enemy_Name_Label = new JLabel("" + script.theEnemy.getName());
        enemy_Name_Label.setForeground(Color.WHITE);
        enemy_Name_Label.setFont(normal_Font);
        enemy_Status_Panel.add(enemy_Name_Label);

        enemy_Hp_Label = new JLabel("HP : ");
        enemy_Hp_Label.setForeground(Color.WHITE);
        enemy_Hp_Label.setFont(normal_Font);
        enemy_Status_Panel.add(enemy_Hp_Label);

        enemy_Hp_Number_label = new JLabel("" + script.theEnemy.getHP());
        enemy_Hp_Number_label.setForeground(Color.WHITE);
        enemy_Hp_Number_label.setFont(normal_Font);
        enemy_Status_Panel.add(enemy_Hp_Number_label);

        enemy_Status_Panel.setBorder(whiteline);

        // Choice Button
        choice_Button_Panel = new JPanel();
        choice_Button_Panel.setBounds(875,450,350,200);
        choice_Button_Panel.setBackground(Color.BLACK);
        choice_Button_Panel.setLayout(new GridLayout(4,1));
        con.add(choice_Button_Panel);

        choice_1 = new JButton();
        choice_1.setBackground(Color.BLACK);
        choice_1.setForeground(Color.BLACK);
        choice_1.setFont(normal_Font);
        choice_1.addActionListener(ci);
        choice_1.setOpaque(true);
        choice_1.setActionCommand("choice_1");
        choice_Button_Panel.add(choice_1);

        choice_2 = new JButton();
        choice_2.setBackground(Color.BLACK);
        choice_2.setForeground(Color.BLACK);
        choice_2.setFont(normal_Font);
        choice_2.addActionListener(ci);
        choice_2.setOpaque(true);
        choice_2.setActionCommand("choice_2");
        choice_Button_Panel.add(choice_2);

        choice_3 = new JButton();
        choice_3.setBackground(Color.BLACK);
        choice_3.setForeground(Color.BLACK);
        choice_3.setFont(normal_Font);
        choice_3.addActionListener(ci);
        choice_3.setOpaque(true);
        choice_3.setActionCommand("choice_3");
        choice_Button_Panel.add(choice_3);

        choice_4 = new JButton();
        choice_4.setBackground(Color.BLACK);
        choice_4.setForeground(Color.BLACK);
        choice_4.setFont(normal_Font);
        choice_4.addActionListener(ci);
        choice_4.setOpaque(true);
        choice_4.setActionCommand("choice_4");
        choice_Button_Panel.add(choice_4);

        // Inventory
        colored_text = new JLabel("Gold");
        colored_text.setFont(normal_Font);
        colored_text.setForeground(Color.YELLOW);


        player_Inventory_Panel = new JPanel();
        player_Inventory_Panel.setBounds(100,450,600,200);
        player_Inventory_Panel.setBackground(Color.BLACK);
        player_Inventory_Panel.setLayout(new GridLayout(4,2));
        player_Inventory_Panel.setBorder(whiteline);
        con.add(player_Inventory_Panel);

        item_Button_1 = new JButton("1");
        item_Button_1.setBackground(Color.BLACK);
        item_Button_1.setForeground(Color.WHITE);
        item_Button_1.setFont(normal_Font);
        item_Button_1.setOpaque(true);
        item_Button_1.setBorderPainted(true);
        item_Button_1.setBorder(whiteline);
        item_Button_1.addActionListener(ic);
        item_Button_1.setActionCommand("item_1");
        player_Inventory_Panel.add(item_Button_1);

        item_Button_2 = new JButton("2");
        item_Button_2.setBackground(Color.BLACK);
        item_Button_2.setForeground(Color.WHITE);
        item_Button_2.setFont(normal_Font);
        item_Button_2.setOpaque(true);
        item_Button_2.setBorderPainted(true);
        item_Button_2.setBorder(whiteline);
        item_Button_2.addActionListener(ic);
        item_Button_2.setActionCommand("item_2");
        player_Inventory_Panel.add(item_Button_2);

        item_Button_3 = new JButton("3");
        item_Button_3.setBackground(Color.BLACK);
        item_Button_3.setForeground(Color.WHITE);
        item_Button_3.setFont(normal_Font);
        item_Button_3.setOpaque(true);
        item_Button_3.setBorderPainted(true);
        item_Button_3.setBorder(whiteline);
        item_Button_3.addActionListener(ic);
        item_Button_3.setActionCommand("item_3");
        player_Inventory_Panel.add(item_Button_3);

        item_Button_4 = new JButton("4");
        item_Button_4.setBackground(Color.BLACK);
        item_Button_4.setForeground(Color.WHITE);
        item_Button_4.setFont(normal_Font);
        item_Button_4.setOpaque(true);
        item_Button_4.setBorderPainted(true);
        item_Button_4.setBorder(whiteline);
        item_Button_4.addActionListener(ic);
        item_Button_4.setActionCommand("item_4");
        player_Inventory_Panel.add(item_Button_4);

        item_Button_5 = new JButton("5");
        item_Button_5.setBackground(Color.BLACK);
        item_Button_5.setForeground(Color.WHITE);
        item_Button_5.setFont(normal_Font);
        item_Button_5.setOpaque(true);
        item_Button_5.setBorderPainted(true);
        item_Button_5.setBorder(whiteline);
        item_Button_5.addActionListener(ic);
        item_Button_5.setActionCommand("item_5");
        player_Inventory_Panel.add(item_Button_5);

        item_Button_6 = new JButton("6");
        item_Button_6.setBackground(Color.BLACK);
        item_Button_6.setForeground(Color.WHITE);
        item_Button_6.setFont(normal_Font);
        item_Button_6.setOpaque(true);
        item_Button_6.setBorderPainted(true);
        item_Button_6.setBorder(whiteline);
        item_Button_6.addActionListener(ic);
        item_Button_6.setActionCommand("item_6");
        player_Inventory_Panel.add(item_Button_6);

        item_Button_7 = new JButton("7");
        item_Button_7.setBackground(Color.BLACK);
        item_Button_7.setForeground(Color.WHITE);
        item_Button_7.setFont(normal_Font);
        item_Button_7.setOpaque(true);
        item_Button_7.setBorderPainted(true);
        item_Button_7.setBorder(whiteline);
        item_Button_7.addActionListener(ic);
        item_Button_7.setActionCommand("item_7");
        player_Inventory_Panel.add(item_Button_7);

        item_Button_8 = new JButton("8");
        item_Button_8.setBackground(Color.BLACK);
        item_Button_8.setForeground(Color.WHITE);
        item_Button_8.setFont(normal_Font);
        item_Button_8.setOpaque(true);
        item_Button_8.setBorderPainted(true);
        item_Button_8.setBorder(whiteline);
        item_Button_8.addActionListener(ic);
        item_Button_8.setActionCommand("item_8");
        player_Inventory_Panel.add(item_Button_8);

        // Question
        question_Panel = new JPanel();
        question_Panel.setBounds(50,100,600,250);
        question_Panel.setBackground(Color.BLACK);
        con.add(question_Panel);

        opt_Text = new JTextArea("Welcome to the world");
        opt_Text.setBounds(50,100,600,250);
        opt_Text.setBackground(Color.BLACK);
        opt_Text.setForeground(Color.WHITE);
        opt_Text.setFont(normal_Font);
        opt_Text.setLineWrap(true);
        question_Panel.add(opt_Text);

        // Main Image
        main_Image_Panel = new JPanel();
        main_Image_Panel.setBounds(50,100, 740, 320);
        main_Image_Panel.setBackground(Color.BLACK);

        main_Image_Label = new JLabel();
        mainImage = new ImageIcon();

        main_Image_Label.setIcon(mainImage);
        main_Image_Panel.add(main_Image_Label);
        con.add(main_Image_Panel);

        // Map
        map_Image_Panel = new JPanel();
        map_Image_Panel.setBounds(0,0 ,1280,730);
        map_Image_Panel.setBackground(Color.BLACK);

        map_Label = new JLabel();
        mapImage = new ImageIcon(".//images//mapTry.png");

        map_Label.setIcon(mapImage);
        map_Image_Panel.add(map_Label);
        con.add(map_Image_Panel);

        map_Button_Panel = new JPanel();
        map_Button_Panel.setBounds(0,0,1280,720);
        map_Button_Panel.setBackground(Color.BLACK);
        map_Button_Panel.setLayout(null);


        map_Button_1 = new JButton("Maze");
        map_Button_1.setBounds(300,300,100, 50);
        map_Button_1.setFont(normal_Font);
        map_Button_1.setBackground(Color.BLACK);
        map_Button_1.setForeground(Color.WHITE);
        map_Button_1.setOpaque(true);
        map_Button_1.setBorderPainted(true);
        map_Button_1.setBorder(whiteline);
        map_Button_1.addActionListener(mc);
        map_Button_1.setActionCommand("Maze");
        map_Button_Panel.add(map_Button_1);

        map_Button_2 = new JButton("Town");
        map_Button_2.setBounds(500,500,100,50);
        map_Button_2.setFont(normal_Font);
        map_Button_2.setBackground(Color.BLACK);
        map_Button_2.setForeground(Color.WHITE);
        map_Button_2.setOpaque(true);
        map_Button_2.setBorderPainted(true);
        map_Button_2.setBorder(whiteline);
        map_Button_2.addActionListener(mc);
        map_Button_2.setActionCommand("Town");
        map_Button_Panel.add(map_Button_2);

        map_Button_3 = new JButton("Forest");
        map_Button_3.setBounds(1000,400,100,50);
        map_Button_3.setFont(normal_Font);
        map_Button_3.setBackground(Color.BLACK);
        map_Button_3.setForeground(Color.WHITE);
        map_Button_3.setOpaque(true);
        map_Button_3.setBorderPainted(true);
        map_Button_3.setBorder(whiteline);
        map_Button_3.addActionListener(mc);
        map_Button_3.setActionCommand("Forest");
        map_Button_Panel.add(map_Button_3);

        map_Button_4 = new JButton("Home");
        map_Button_4.setBounds(300,600,100,50);
        map_Button_4.setFont(normal_Font);
        map_Button_4.setBackground(Color.BLACK);
        map_Button_4.setForeground(Color.WHITE);
        map_Button_4.setOpaque(true);
        map_Button_4.setBorderPainted(true);
        map_Button_4.setBorder(whiteline);
        map_Button_4.addActionListener(mc);
        map_Button_4.setActionCommand("Home");
        map_Button_Panel.add(map_Button_4);

        map_Button_5 = new JButton("Arena");
        map_Button_5.setBounds(750, 450, 100, 50);
        map_Button_5.setFont(normal_Font);
        map_Button_5.setBackground(Color.BLACK);
        map_Button_5.setForeground(Color.WHITE);
        map_Button_5.setOpaque(true);
        map_Button_5.setBorderPainted(true);
        map_Button_5.setBorder(whiteline);
        map_Button_5.addActionListener(mc);
        map_Button_5.setActionCommand("Arena");

        con.add(map_Button_Panel);
        window.setVisible(true);
    }
}
