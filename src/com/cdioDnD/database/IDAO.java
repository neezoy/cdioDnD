package com.cdioDnD.database;

public interface IDAO {
    //First we define functions to create and get rows in our database 'Data' tables.
    void createUser(String username, String Password, int role);
    int getUserID();
    UserDTO getUser();

    void createCharacter(String name, int str, int n);
    int getCharacterID();
    CharacterDTO getCharacter();

    void createItem();
    int getItemID();
    ItemDTO getItem();

    void createGroup();
    int getGroupID();
    GroupDTO getGroup();
    
    //Now we define functions to create and delete rows in the relational tables.
    void addChar(int userid, int characterid);
    void removeChar();
    int[] getCharIDs();

    void addItem();
    void addItems();
    void removeItem();
    void removeItems();
    int[] getItemIDs();

    void addToGroup();
    void removeFromGroup();
    int[] getGroupIDs();
    int[] getMembers();

    //Lastly we define funtions which edit or delete data from the 'Data' tables.

    void deleteUser(int userid);
    void changeUsername(int userid, String username);

}
