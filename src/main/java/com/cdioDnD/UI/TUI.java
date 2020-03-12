package com.cdioDnD.UI;
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
                System.out.println("2 Add");
                System.out.println("3 Remove");
                System.out.println("4 View");
                System.out.println("5 Edit");
                System.out.println("6 Delete");
                System.out.println("7 Terminate Program");

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

    public int addMenu() {
        while (true) {
                System.out.println("You've Chosen 'Add': ");
                System.out.println("2 Add Character To User");
                System.out.println("3 Add Item To Character");
                System.out.println("4 Add Group To Character");
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
                System.out.println("1 Remove Character From User");
                System.out.println("2 Remove Item From Character");
                System.out.println("3 Remove Group From Character");
                System.out.println("4 Return To Previous Menu");
                System.out.println("Please input the number of your selection here: ");
                menuItem = scanner.nextInt();
                System.out.print("\n");

                break;

        } return menuItem;

    }

    public int viewMenu() {
        while (true) {
                System.out.println("You've Chosen 'View': ");
                System.out.println("1 View All Characters");
                System.out.println("2 View All Items");
                System.out.println("3 View All Groups");
                System.out.println("4 View One Character");
                System.out.println("5 View One Item");
                System.out.println("6 View One Group");
                System.out.println("7 Return To Previous Menu");
                System.out.println("Please input the number of your selection here: ");
                menuItem = scanner.nextInt();
                System.out.print("\n");

                break;

        } return menuItem;

    }

    public int editMenu() {
        while (true) {
            System.out.println("You've chosen 'Edit': ");
            System.out.println("1 Edit User");
            System.out.println("2 Edit Character");
            System.out.println("3 Edit Item");
            System.out.println("4 Edit Group");
            System.out.println("5 Return To Previous Menu");
            System.out.println("Please input the number of your selection here: ");
            menuItem = scanner.nextInt();
            System.out.print("\n");

            break;

        } return menuItem;
    }



    public int deleteMenu() {
        while (true) {
            System.out.println("You've Chosen 'Delete': ");
            System.out.println("1 Delete User");
            System.out.println("2 Delete Item");
            System.out.println("3 Delete Group");
            System.out.println("4 Return To Previous Menu");
            System.out.println("Please input the number of your selection here: ");
            menuItem = scanner.nextInt();
            System.out.print("\n");

            break;

        } return menuItem;

    }




}
