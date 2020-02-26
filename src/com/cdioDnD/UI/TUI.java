package com.cdioDnD.UI;
import com.cdioDnD.database.IDAO;

import javax.swing.*;
import java.util.Scanner;

public class TUI implements ITUI {
    IDAO dao;
    Scanner scanner;

    public TUI(IDAO dao) {
        this.dao = dao;
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
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
        while (true) {
            try {
                int menuItem = scanner.nextInt();

            } catch (Exception e) {
                System.err.println("Please try again, input has to be a number");

            }

            System.out.println("\n");
        }

        switch (menuItem) {
            case 1:

        }
    }

    @Override
    public void createUser() {
        System.out.println("Please ");
    }

}
