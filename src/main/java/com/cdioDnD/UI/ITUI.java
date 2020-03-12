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

    String removeUser();

    String removeCharacter();

    String removeItem();

    String removeGroupFromCharacter();

    int viewMenu();

    String viewACharacter();

    String viewAItem();

    String viewUser();

    String viewAGroup();


}
