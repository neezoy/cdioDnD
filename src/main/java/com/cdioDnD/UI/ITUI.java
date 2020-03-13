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
    String[] removeGroupFromCharacter();

    //add
    int addMenu();
    String[] addCharacterToUser();
    String[] addItemToCharacter();
    String[] addGroupToCharacter();

    int viewMenu();

    String viewACharacter();
    void viewACharacterO(ICharacterDTO charc);
    String viewAItem();
    void viewAItemO(IItemDTO item);
    String viewUser();
    void viewUserO(IUserDTO user);
    String viewAGroup();
    void viewAGroupO(IGroupDTO grp);


}
