package com.cdioDnD.database;

import com.cdioDnD.dataTypes.*;
import com.cdioDnD.exception.DALException;

import java.sql.SQLException;
import java.util.ArrayList;


public interface IDAO {
    //First we define functions to create and get rows in our database 'Data' tables.
    void closeConnection() throws Exception;

    void createUser(IUserDTO user) throws SQLException, DALException; //should this just be userDTO

    IUserDTO getUserFromName(String username) throws SQLException;

    UserDTO getUser(int userid) throws SQLException;

    void createCharacter(ICharacterDTO character) throws SQLException;

    int getCharacterID(String charactername) throws SQLException;

    ICharacterDTO getCharacter(int characterid) throws SQLException;

    void createItem(IItemDTO item) throws SQLException;

    int getItemID(String itemname) throws SQLException;

    IItemDTO getItem(int itemid) throws SQLException;

    void createGroup(IGroupDTO group) throws SQLException;

    int getGroupID(String groupname) throws SQLException;

    IGroupDTO getGroup(int groupid) throws SQLException;

    //Now we define functions to create and delete rows in the relational tables.
    void addCharacter(IUserDTO user, ICharacterDTO character) throws SQLException;

    void removeCharacter(int characterid) throws SQLException; //Only needs characterid because a character can only be owned by one person.

    ArrayList getCharacterIDs(int userid) throws SQLException;

    void addItem(int characterid, int itemid) throws SQLException;

    void addItems(int characterid, int itemid, int amount) throws SQLException;

    void removeItem(int characterid, int itemid) throws SQLException;

    void removeItems(int characterid, int itemid, int amount) throws SQLException;

    ArrayList getItemIDs(int characterid) throws SQLException;

    void addToGroup(ICharacterDTO character, IGroupDTO group) throws SQLException;

    void removeFromGroup(int characterid, int groupid) throws SQLException;

    ArrayList getGroupIDs(int characterid) throws SQLException;

    ArrayList getMembers(int groupid) throws SQLException;

    //Lastly we define functions which deletes or overwrites data from the database.
    void deleteUser(int userid) throws SQLException;

    void overwriteUser(UserDTO user) throws SQLException;

    void overwriteCharacter(CharacterDTO character) throws SQLException;

    void overwriteItem(ItemDTO item) throws SQLException;

    void deleteItem(int itemid) throws SQLException;

    void overwriteGroup(GroupDTO group) throws SQLException;

    void deleteGroup(int groupid) throws SQLException;
}
