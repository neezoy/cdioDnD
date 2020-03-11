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
    UserDTO createUser(); //1 for the switch case
    CharacterDTO createCharacter(); //2
    ItemDTO createItem(); //3
    GroupDTO createGroup(); //4

    //add
    CharacterDTO addCharacter(); //5
    ItemDTO addItem();//6
    GroupDTO addGroup(); //7

    //remove
    CharacterDTO removeCharacter(); //8
    ItemDTO removeItem(); //9
    GroupDTO removeGroup(); //10

    //view
    ArrayList<ICharacterDTO> getAllCharacters(); //11
    ArrayList<IGroupDTO> getAllGroups(); //12
    ArrayList<IItemDTO> getAllItems(); //13
    CharacterDTO viewOneCharacter(); //14
    ItemDTO viewOneItem(); //15
    GroupDTO viewOneGroup(); //16

    //edit
    UserDTO editUser(); //17
    CharacterDTO editCharacter(); //18
    ItemDTO editItem(); //19
    GroupDTO editGroup(); //20

    //delete
    UserDTO deleteUser(); //21
    ItemDTO deleteeItem(); //22
    GroupDTO deleteGroup(); //23


}
