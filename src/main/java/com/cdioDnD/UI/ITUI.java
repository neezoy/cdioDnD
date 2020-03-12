package com.cdioDnD.UI;


import com.cdioDnD.dataTypes.*;


public interface ITUI {

    //menu
    int showMenu();
    //create
    int createMenu();
    IUserDTO createUser();
    ICharacterDTO createCharacter();
    IItemDTO createItem();
    IGroupDTO createGroup();

    //remove
    int removeMenu();
    removeUser();
    removeCharacter();
    removeItem();
    removeGroupFromCharacter();

    int viewMenu();
    String viewACharacter();
    viewAItem();
    viewUser();
    viewAGroup();






}
