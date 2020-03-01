package com.cdioDnD.UI;
import com.cdioDnD.database.IDAO;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TUI implements ITUI {
    IDAO dao;
    Scanner scanner;
    int menuItem;


    public TUI(IDAO dao) {
        this.dao = dao;
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        scanner = new Scanner(System.in);

        while (true) {
            try {
                scanner = new Scanner(System.in);
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

            } catch (InputMismatchException e) {

                System.err.println("Please try again, input has to be a number");

            }

            System.out.println("\n");
            switch (menuItem) {
                case 1:
                    create();
                    break;

            }
        }

    }

//    @Override
    public void create() {
        while (true) {
            try {
                menuItem = scanner.nextInt();
                System.out.println("You've chosen 'Create': ");
                System.out.println("1 Create User");
                System.out.println("2 Create Character");
                System.out.println("3 Create Item");
                System.out.println("4 Create Group");
                System.out.println("5 Return To Previous Menu");
                System.out.println("Please input the number of your selection here: ");
            } catch (InputMismatchException e) {
                System.err.println("Please try again, input has to be a number");
            }

            System.out.println("\n");

            switch (menuItem) {
                case 5: showMenu();
                    break;

            }
        }
    }






}
