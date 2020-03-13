package com.cdioDnD;

import com.cdioDnD.controller.Context;
import com.cdioDnD.controller.StartState;

import java.util.Scanner;

public class BootStrap {
    public static String rootPassword;



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root password for database: ");
        rootPassword = sc.nextLine();

        Context context = new Context();


    }
}
