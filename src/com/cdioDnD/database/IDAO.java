package com.cdioDnD.database;

import com.cdioDnD.dataTypes.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public interface IDAO {
    //First we define functions to create and get rows in our database 'Data' tables.
    boolean createUser(UserDTO user, Connection c) throws SQLException; //should this just be userDTO
    UserDTO getUserFromName(String username, Connection c) throws SQLException;
    UserDTO getUser(int userid, Connection c) throws SQLException;

    boolean createCharacter(CharacterDTO character, Connection c) throws SQLException;
    int getCharacterID(String charactername, Connection c) throws SQLException;
    CharacterDTO getCharacter(int characterid, Connection c) throws SQLException;

    boolean createItem(ItemDTO item, Connection c) throws SQLException;
    int getItemID(String itemname, Connection c) throws SQLException;
    ItemDTO getItem(int itemid, Connection c) throws SQLException;

    boolean createGroup(GroupDTO group, Connection c) throws SQLException;
    int getGroupID(String groupname, Connection c) throws SQLException;
    GroupDTO getGroup(int groupid, Connection c) throws SQLException;
    
    //Now we define functions to create and delete rows in the relational tables.
    boolean addCharacter(UserDTO user, int characterid, Connection c) throws SQLException;
    boolean removeCharacter(int characterid, Connection c) throws SQLException; //Only needs characterid because a character can only be owned by one person.
    ArrayList getCharacterIDs(int userid, Connection c) throws SQLException;

    boolean addItem(int characterid, int itemid, Connection c) throws SQLException;
    boolean addItems(int characterid, int itemid, int amount, Connection c) throws SQLException;
    boolean removeItem(int characterid, int itemid, Connection c) throws SQLException;
    boolean removeItems(int characterid, int itemid, int amount, Connection c) throws SQLException;
    ArrayList getItemIDs(int characterid, Connection c) throws SQLException;

    boolean addToGroup(CharacterDTO character, GroupDTO group, Connection c) throws SQLException;
    boolean removeFromGroup(int characterid, int groupid, Connection c) throws SQLException;
    ArrayList getGroupIDs(int characterid, Connection c) throws SQLException;
    ArrayList getMembers(int groupid, Connection c) throws SQLException;

    //Lastly we define functions which deletes or overwrites data from the database.
    boolean deleteUser(int userid, Connection c) throws SQLException;
    boolean overwriteUser(UserDTO user, Connection c) throws SQLException;
    boolean overwriteCharacter(CharacterDTO character, Connection c) throws SQLException;
    boolean overwriteItem(ItemDTO item, Connection c) throws SQLException;
    boolean deleteItem(int itemid, Connection c) throws SQLException;
    boolean overwriteGroup(GroupDTO group, Connection c) throws SQLException;
    boolean deleteGroup(int groupid, Connection c) throws SQLException;
}
