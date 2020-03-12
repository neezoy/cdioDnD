package com.cdioDnD.UI;
import com.cdioDnD.dataTypes.ICharacterDTO;
import com.cdioDnD.dataTypes.IUserDTO;
import com.cdioDnD.dataTypes.UserDTO;
import com.cdioDnD.database.IDAO;

import java.util.Scanner;


public class TUI implements ITUI {
    Scanner scanner;
    int menuItem;


    public TUI() {
    }

    @Override
    public int showMenu() {

        while (true) {
//                scanner = new Scanner(System.in);
                System.out.println("Welcome to DND Forum");
                System.out.println("1 Create");
                System.out.println("2 Remove");
                System.out.println("3 View");
                System.out.println("4 Terminate Program");

                System.out.println("Please input the number of your selection here: ");
                menuItem = scanner.nextInt();
                System.out.print("\n");

                break;

        } return menuItem;

    }

//    @Override
    public int createMenu() {
        while (true) {
                System.out.println("You've chosen 'Create': ");
                System.out.println("1 Create User");
                System.out.println("2 Create Character");
                System.out.println("3 Create Item");
                System.out.println("4 Create Group");
                System.out.println("5 Return To Previous Menu");
                System.out.println("Please input the number of your selection here: ");
                menuItem = scanner.nextInt();
                System.out.print("\n");

                break;

        } return menuItem;
    }




    public int removeMenu() {
        while (true) {
                System.out.println("You've Chosen 'Remove': ");
                System.out.println("1 Remove User");
                System.out.println("2 Remove Character");
                System.out.println("3 Remove Item");
                System.out.println("4 Remove Group From Character");
                System.out.println("5 Return To Previous Menu");
                System.out.println("Please input the number of your selection here: ");
                menuItem = scanner.nextInt();
                System.out.print("\n");

                break;

        } return menuItem;


    }



    public int viewMenu() {
        while (true) {
                System.out.println("You've Chosen 'View': ");
                System.out.println("1 View User");
                System.out.println("2 View Item");
                System.out.println("3 View Groups");
                System.out.println("4 View Character");
                System.out.println("Please input the number of your selection here: ");
                menuItem = scanner.nextInt();
                System.out.print("\n");

                break;

        } return menuItem;

    }

    public IUserDTO createUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a username:");
        String username = sc.nextLine();
        System.out.println("Please enter a password: ");
        String password = sc.nextLine();
        return new UserDTO(username,password);
    }

    public ICharacterDTO createCharacter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter character name: ");
        String name = sc.nextLine();
        System.out.println("Enter strength: ");
        int strength = sc.nextInt();
        System.out.println("Enter capacity: ");
        int bonuscapacity = sc.nextInt();

        return new CharacterDTO(name, strength, bonuscapacity);
    }








}
