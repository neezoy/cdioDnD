package com.cdioDnD.UI;


import com.cdioDnD.dataTypes.*;

import java.util.ArrayList;

public interface ITUI {

    //menu
    int showMenu();
    int createMenu();
    int addMenu();
    int removeMenu();
    int viewMenu();
    int editMenu();
    int deleteMenu();

    //create
    void createUser(IUserDTO user); //don't know if this one is correct
    void createCharacter(ICharacterDTO character);
    void createItem(IItemDTO item);
    void createGroup(IGroupDTO group);

    //add
    void addCharacter(ICharacterDTO character);
    void addItem(IItemDTO item);
    void addGroup(IGroupDTO group);

    //remove
    void removeCharacter(ICharacterDTO character);
    void removeItem(IItemDTO item);
    void removeGroup(IGroupDTO group);

    //view
    ArrayList<ICharacterDTO> getAllCharacters();
    ArrayList<IGroupDTO> getAllGroups();
    ArrayList<IItemDTO> getAllItems();
    void viewOneCharacter(ICharacterDTO character);
    void viewOneItem(IItemDTO item);
    void viewOneGroup(IGroupDTO group);

    //edit
    void editUser(IUserDTO user); //don't know if this one is correct
    void editCharacter(ICharacterDTO character);
    void editItem(IItemDTO item);
    void editGroup(IGroupDTO group);

    //delete
    void deleteUser(IUserDTO user); //or this :)
    void deleteeItem(IItemDTO item);
    void deleteGroup(IGroupDTO group);


}
