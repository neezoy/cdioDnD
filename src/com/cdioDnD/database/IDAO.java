package com.cdioDnD.database;

import java.sql.Connection;
import java.util.ArrayList;


public interface IDAO {
    //First we define functions to create and get rows in our database 'Data' tables.
    boolean createUser(UserDTO user, Connection c); //should this just be userDTO
    UserDTO getUserFromName(String username, Connection c);
    UserDTO getUser(int userid, Connection c);

    boolean createCharacter(CharacterDTO character, Connection c);
    int getCharacterID(String charactername, Connection c);
    CharacterDTO getCharacter(int characterid, Connection c);

    boolean createItem(ItemDTO item, Connection c);
    int getItemID(String itemname, Connection c);
    ItemDTO getItem(int itemid, Connection c);

    boolean createGroup(GroupDTO group, Connection c);
    int getGroupID(String groupname, Connection c);
    GroupDTO getGroup(int groupid, Connection c);
    
    //Now we define functions to create and delete rows in the relational tables.
    boolean addCharacter(UserDTO user, int characterid, Connection c);
    boolean removeCharacter(int characterid, Connection c); //Only needs characterid because a character can only be owned by one person.
    ArrayList getCharacterIDs(int userid, Connection c);

    boolean addItem(int characterid, int itemid, Connection c);
    boolean addItems(int characterid, int itemid, int amount, Connection c);
    boolean removeItem(int characterid, int itemid, Connection c);
    boolean removeItems(int characterid, int itemid, int amount, Connection c);
    int[] getItemIDs(int characterid, Connection c);

    boolean addToGroup(CharacterDTO character, GroupDTO group, Connection c);
    boolean removeFromGroup(int characterid, int groupid, Connection c);
    ArrayList getGroupIDs(int characterid, Connection c);
    ArrayList getMembers(int groupid, Connection c);

    //Lastly we define functions which deletes or overwrites data from the database.
    boolean deleteUser(int userid, Connection c);
    boolean overwriteUser(UserDTO user, Connection c);
    boolean overwriteCharacter(CharacterDTO character, Connection c);
    boolean overwriteItem(ItemDTO item, Connection c);
    boolean deleteItem(int itemid, Connection c);
    boolean overwriteGroup(GroupDTO group, Connection c);
    boolean deleteGroup(int groupid, Connection c);
}
