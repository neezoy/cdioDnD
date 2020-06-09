package com.cdioDnD;

import com.cdioDnD.dataTypes.*;
import com.cdioDnD.database.DAO;

import java.sql.SQLException;
import java.util.Scanner;

public class BootStrap {
    public static String rootPassword;


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root password for database: ");
        rootPassword = sc.nextLine();
        DAO dao = new DAO();

        // Context context = new Context();


        // CharacterDTO characterDTO = new CharacterDTO("Heyyeye", 5, 10);
        // characterDTO.setLocation("Narnia");
        // dao.addCharacter(dao.getUser(102), dao.getCharacter(1003));
        // dao.approveUser(dao.getUser(103), true);
        // IUserDTO user = dao.getUser(103);
        // user.setName("Woooooooooow");

        //ICharacterDTO character = dao.getCharacter(1003);
        //character.setLocation("wow");



        SessionDTO iSessionDTO = new SessionDTO("2020-03-20 08:30:00", "Narnia", 8);

        // dao.overwriteCharacter(character);
        // dao.approveCharacter(dao.getCharacter(1003), true);

        dao.closeConnection();


    }
}
