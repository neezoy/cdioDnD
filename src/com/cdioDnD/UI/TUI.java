package com.cdioDnD.UI;
import com.cdioDnD.database.IDAO;
import com.sun.org.apache.xerces.internal.impl.xs.models.XSCMUniOp;

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
        System.out.println("1 Create A User");
        System.out.println("2 Terminate Program");

        System.out.println("Please input your selection here: ");
        int menuItem = scanner.nextInt();
        System.out.println("\n");

        switch (menuItem) {
            case 1:

        }
    }

    //@Override
    //public void createUser() {
        //System.out.println("Please ");
    //}

}
