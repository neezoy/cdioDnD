package com.cdioDnD.UI;

import com.cdioDnD.dataTypes.*;

import java.util.Scanner;


public class TUI implements ITUI {
    Scanner scanner = new Scanner(System.in);

    int menuItem;


    public TUI() {
    }

    @Override
    public int showMenu() {

        while (true) {
            System.out.println("Welcome to DND Forum");
            System.out.println("1 Create");
            System.out.println("2 Remove");
            System.out.println("3 View");
            System.out.println("4 Add");
            System.out.println("5 Terminate Program");
            System.out.println("Please input the number of your selection here: ");
            menuItem = scanner.nextInt();
            System.out.print("\n");

            break;

        }
        return menuItem;

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

        }
        return menuItem;
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

        }
        return menuItem;


    }

    public int addMenu() {
        while (true) {
            System.out.println("You've Chosen 'Add': ");
            System.out.println("1 Add Character to User: ");
            System.out.println("2 Add Item to Character: ");
            System.out.println("3 Add Group to Character: ");
            System.out.println("Please input the number of your selection here: ");
            menuItem = scanner.nextInt();
            System.out.print("\n");

            break;

        }
        return menuItem;


    }


    public int viewMenu() {
        while (true) {
            System.out.println("You've Chosen 'View': ");
            System.out.println("1 View User");
            System.out.println("2 View Item");
            System.out.println("3 View Group");
            System.out.println("4 View Character");
            System.out.println("Please input the number of your selection here: ");
            menuItem = scanner.nextInt();
            System.out.print("\n");

            break;

        }
        return menuItem;

    }

    public IUserDTO createUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a username:");
        String username = sc.nextLine();
        System.out.println("Please enter a password: ");
        String password = sc.nextLine();
        IUserDTO user = new UserDTO(username, password);

        return user;
    }

    public ICharacterDTO createCharacter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter character name: ");
        String name = sc.nextLine();
        System.out.println("Enter strength: ");
        int strength = sc.nextInt();
        System.out.println("Enter capacity: ");
        int bonuscapacity = sc.nextInt();
        ICharacterDTO character = new CharacterDTO(name, strength, bonuscapacity);

        return character;
    }

    public IItemDTO createItem() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Item name: ");
        String name = sc.nextLine();
        System.out.println("Enter description: ");
        String description = sc.next();
        System.out.println("Enter weight: ");
        double weight = sc.nextDouble();
        IItemDTO item = new ItemDTO(name, description, weight);

        return item;
    }

    public IGroupDTO createGroup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter group name: ");
        String name = sc.nextLine();
        System.out.println("Enter description: ");
        String description = sc.next();
        IGroupDTO group = new GroupDTO(name, description);

        return group;
    }


    public String removeUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter user you want to delete: ");
        String name = sc.nextLine();

        return name;
    }

    public String removeCharacter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter character you want to remove: ");
        String name = sc.nextLine();

        return name;
    }

    public String removeItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the item you want to remove: ");
        String name = sc.nextLine();

        return name;
    }

    // need fixing tomorrow.
    /*public String removeGroupFromCharacter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the group you want to remove: ");
        String group = sc.nextLine();
        System.out.println("Enter the character you want the group removed from: ");
        String character =  sc.nextLine();

        return group;
    }
*/
    public String viewACharacter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the character to view: ");
        String character = sc.nextLine();

        return character;
    }

    public void viewACharacterO(ICharacterDTO charac) {
        System.out.println("Character name: " + charac.getName());
        System.out.println("ID: " + charac.getID());
        System.out.println("Location: " + charac.getLocation());
        System.out.println("Bonus: " + charac.getBonus());
        System.out.println("Items count: " + charac.getItemsList().size());

    }

    public String viewAItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the item to view: ");
        String item = sc.nextLine();

        return item;
    }

    public void viewAItemO(IItemDTO item) {
        System.out.println("Item name: " + item.getName());
    }

    public String viewUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the user to view: ");
        String user = sc.nextLine();

        return user;
    }

    public void viewUserO(IUserDTO user) {
        System.out.println("User Name: " + user.getName());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Characters: " + user.getCharacters().size());

    }

    public String viewAGroup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the group to view: ");
        String group = sc.nextLine();

        return group;
    }

    public void viewAGroupO(IGroupDTO grp) {
        System.out.println("Group name: " + grp.getName());
        System.out.println("ID: " + grp.getID());
        System.out.println("Description: " + grp.getDescription());
        if (grp.getCharacters() != null)
        System.out.println("Members: " + grp.getCharacters().size());
    }

    public String[] removeGroupFromCharacter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter character you want to remove: ");
        String name = sc.nextLine();
        System.out.println("Please enter the Group: ");
        String gname = sc.nextLine();
        String[] a = {name, gname};
        return a;
    }

    public String[] addCharacterToUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name of character you want to add: ");
        String characName = sc.nextLine();
        System.out.println("Enter the user: ");
        String uName = sc.nextLine();

        String[] a = {characName, uName};
        return a;
    }

    public String[] addItemToCharacter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name of character you want to add to: ");
        String characName = sc.nextLine();
        System.out.println("Enter the item: ");
        String itemName = sc.nextLine();

        String[] a = {characName, itemName};
        return a;
    }

    public String[] addGroupToCharacter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name of character you want to add: ");
        String characName = sc.nextLine();
        System.out.println("Enter the group: ");
        String grpName = sc.nextLine();

        String[] a = {characName, grpName};
        return a;
    }


}
