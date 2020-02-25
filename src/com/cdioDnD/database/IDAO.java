package com.cdioDnD.database;

public interface IDAO {
    //First we define functions to create and get rows in our database 'Data' tables.
    void createUser(String username, String Password, int role);
    int getUserID(String username);
    UserDTO getUser(int userid);

    void createCharacter(String charactername, int str, int n);
    int getCharacterID(String charactername);
    CharacterDTO getCharacter(int characterid);

    void createItem(String itemname, String description, double weight);
    int getItemID(String itemname);
    ItemDTO getItem(int itemid);

    void createGroup(String groupname, String description);
    int getGroupID(String groupname);
    GroupDTO getGroup(int groupid);
    
    //Now we define functions to create and delete rows in the relational tables.
    void addCharacter(int userid, int characterid);
    void removeCharacter(int characterid); //Only needs characterid because a character can only be owned by one person.
    int[] getCharacterIDs(int userid);

    void addItem(int characterid, int itemid);
    void addItems(int characterid, int itemid, int amount);
    void removeItem(int characterid, int itemid);
    void removeItems(int characterid, int itemid, int amount);
    int[] getItemIDs(int characterid);

    void addToGroup(int characterid, int groupid);
    void removeFromGroup(int characterid, int groupid);
    int[] getGroupIDs(int characterid);
    int[] getMembers(int groupid);
    //TODO: Do we need delete functions and editing functions for each variable, or would this be done in a complete overwrite function which changes all the desired variables?
}
