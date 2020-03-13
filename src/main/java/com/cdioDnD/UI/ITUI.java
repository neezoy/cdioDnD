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
    //removeGroupFromCharacter();

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
