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

    //add
    int addMenu();
    addCharacterToUser();
    addItemToCharacter();
    addGroupToCharacter();

    //remove
    int removeMenu();
    //removeCharacterFromUser();
    removeItemFromCharacter();
    removeGroupFromCharacter();

    int viewMenu();
    //viewAllCharacters
    //viewAllItems
    //viewAllGroups
    String viewACharacter();
    viewAItem();
    viewAGroup();

    //to be depricated
    int editMenu();

    

    int deleteMenu();
    deleteUser()
    deleteItem();
    deleteGroup();




}
