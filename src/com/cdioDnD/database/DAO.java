package com.cdioDnD.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO implements IDAO {
    @Override
    public boolean createUser(UserDTO user, Connection c) {
        try {

            String query = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getrole());

            statement.execute();
            c.commit();


        } catch (SQLException p) {
            return false;
        }
        return true;
    }

    @Override
    public int getUserID(String username, Connection c) {
        return 0;
    }

    @Override
    public UserDTO getUser(int userid, Connection c) {
        return null;
    }

    @Override
    public boolean createCharacter(CharacterDTO character, Connection c) {

    }

    @Override
    public int getCharacterID(String charactername, Connection c) {
        return 0;
    }

    @Override
    public CharacterDTO getCharacter(int characterid, Connection c) {
        return null;
    }

    @Override
    public boolean createItem(ItemDTO item, Connection c) {

    }

    @Override
    public int getItemID(String itemname, Connection c) {
        return 0;
    }

    @Override
    public ItemDTO getItem(int itemid, Connection c) {
        return null;
    }

    @Override
    public boolean createGroup(GroupDTO group, Connection c) {

    }

    @Override
    public int getGroupID(String groupname, Connection c) {
        return 0;
    }

    @Override
    public GroupDTO getGroup(int groupid, Connection c) {
        return null;
    }

    @Override
    public boolean addCharacter(int userid, int characterid, Connection c) {

    }

    @Override
    public boolean removeCharacter(int characterid, Connection c) {

    }

    @Override
    public int[] getCharacterIDs(int userid, Connection c) {
        return new int[0];
    }

    @Override
    public boolean addItem(int characterid, int itemid, Connection c) {

    }

    @Override
    public boolean addItems(int characterid, int itemid, int amount, Connection c) {

    }

    @Override
    public boolean removeItem(int characterid, int itemid, Connection c) {

    }

    @Override
    public boolean removeItems(int characterid, int itemid, int amount, Connection c) {

    }

    @Override
    public int[] getItemIDs(int characterid, Connection c) {
        return new int[0];
    }

    @Override
    public boolean addToGroup(int characterid, int groupid, Connection c) {

    }

    @Override
    public boolean removeFromGroup(int characterid, int groupid, Connection c) {

    }

    @Override
    public int[] getGroupIDs(int characterid, Connection c) {
        return new int[0];
    }

    @Override
    public int[] getMembers(int groupid, Connection c) {
        return new int[0];
    }

    @Override
    public boolean deleteUser(int userid, Connection c) {

    }

    @Override
    public boolean overwriteUser(UserDTO user, Connection c) {

    }

    @Override
    public boolean overwriteCharacter(CharacterDTO character, Connection c) {

    }

    @Override
    public boolean overwriteItem(ItemDTO item, Connection c) {

    }

    @Override
    public boolean deleteItem(int itemid, Connection c) {

    }

    @Override
    public boolean overwriteGroup(GroupDTO group, Connection c) {

    }

    @Override
    public boolean deleteGroup(int groupid, Connection c) {

    }
}