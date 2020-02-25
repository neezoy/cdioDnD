package com.cdioDnD.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IDAO {
    //First we define functions to create and get rows in our database 'Data' tables.
    void createUser(UserDTO user, Connection c); //should this just be userDTO
    int getUserID(String username, Connection c);
    UserDTO getUser(int userid, Connection c);

    void createCharacter(CharacterDTO character, Connection c);
    int getCharacterID(String charactername, Connection c);
    CharacterDTO getCharacter(int characterid, Connection c);

    void createItem(ItemDTO item, Connection c);
    int getItemID(String itemname, Connection c);
    ItemDTO getItem(int itemid, Connection c);

    void createGroup(GroupDTO group, Connection c);
    int getGroupID(String groupname, Connection c);
    GroupDTO getGroup(int groupid, Connection c);
    
    //Now we define functions to create and delete rows in the relational tables.
    void addCharacter(int userid, int characterid, Connection c);
    void removeCharacter(int characterid, Connection c); //Only needs characterid because a character can only be owned by one person.
    int[] getCharacterIDs(int userid, Connection c);

    void addItem(int characterid, int itemid, Connection c);
    void addItems(int characterid, int itemid, int amount, Connection c);
    void removeItem(int characterid, int itemid, Connection c);
    void removeItems(int characterid, int itemid, int amount, Connection c);
    int[] getItemIDs(int characterid, Connection c);

    void addToGroup(int characterid, int groupid, Connection c);
    void removeFromGroup(int characterid, int groupid, Connection c);
    int[] getGroupIDs(int characterid, Connection c);
    int[] getMembers(int groupid, Connection c);

    //Lastly we define functions which deletes or overwrites data from the database.
    void deleteUser(int userid, Connection c);
    void overwriteUser(UserDTO user, Connection c);
    void overwriteCharacter(CharacterDTO character, Connection c);
    void overwriteItem(ItemDTO item, Connection c);
    void deleteItem(int itemid, Connection c);
    void overwriteGroup(GroupDTO group, Connection c);
    void deleteGroup(int groupid, Connection c);
}
