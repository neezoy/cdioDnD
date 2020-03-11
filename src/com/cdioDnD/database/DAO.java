package com.cdioDnD.database;
import com.cdioDnD.dataTypes.*;
import com.sun.xml.internal.ws.resources.UtilMessages;

import java.sql.*;
import java.util.ArrayList;

public class DAO implements IDAO {

    @Override
    public boolean createUser(UserDTO user, Connection c) throws SQLException{
        try {
            String query = "INSERT INTO User (Username, Password, Roles) VALUES (?, ?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole());

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
        return true;
    }

    @Override
    public UserDTO getUserFromName(String username, Connection c) throws SQLException{
        UserDTO user = new UserDTO();
        try {
            String query = "SELECT * FROM User WHERE Username = ?;";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            c.commit();

            if (!result.next()) {
                return null;
            }
            user.setId(result.getInt("UserID"));
            user.setName(username);
            user.setPassword(result.getString("Password"));
            user.setRoles(result.getInt("Roles"));

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return user;
    }

    @Override
    public UserDTO getUser(int userid, Connection c) throws SQLException{
        UserDTO user = new UserDTO();
        try {
            String query = "SELECT * FROM User WHERE UserID = "+userid+";";
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            c.commit();

            if (!result.next()) {
                return null;
            }
            user.setId(userid);
            user.setName(result.getString("Username"));
            user.setPassword(result.getString("Password"));
            user.setRoles(result.getInt("Roles"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return user;
    }

    @Override
    public boolean createCharacter(CharacterDTO character, Connection c) throws SQLException{
        try {

            String query = "INSERT INTO user (Cname, Location, Strength, BonusCapacity) VALUES (?, ?, ?,?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setString(1, character.getName());
            statement.setString(2, character.getLocation());
            statement.setInt(3, character.getStrength());
            statement.setInt(4, character.getBonus);

            statement.execute();
            c.commit();


        } catch (SQLException p) {
            throw p;

        }
        return true;
    }

    @Override
    public int getCharacterID(String charactername, Connection c) throws SQLException{
        int ID;
        try {
            String query = "SELECT CharacterID FROM Character WHERE charactername = ?;";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, charactername);
            ResultSet result = statement.executeQuery();

            c.commit();

            if (!result.next()) {
                return 0;
            }

            ID = result.getInt("CharacterID");

        } catch (SQLException e) {

            e.printStackTrace();
            throw e;
        }
        return ID;
    }

    @Override
    public CharacterDTO getCharacter(int characterid, Connection c) throws SQLException{
        CharacterDTO character = new CharacterDTO();
        try {
            String query = "SELECT * FROM Character WHERE CharacterID = "+characterid+";";
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            c.commit();

            if (!result.next()) {
                return null;
            }
            character.setId(characterid);
            character.setName(result.getString("CName"));
            character.setLocation(result.getString("Location"));
            character.setStrength(result.getInt("Strength"));
            character.setBonus(result.getInt("BonusCapacity"));

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return character;
    }

    @Override
    public boolean createItem(ItemDTO item, Connection c) throws SQLException{
        try {

            String query = "INSERT INTO Item (ItemName, Weight, Description) VALUES (?, ?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setString(1, item.getName());
            statement.setDouble(2, item.getWeight());
            statement.setString(3, item.getDescription());

            statement.execute();
            c.commit();


        } catch (SQLException p) {
            throw p;
        }
        return true;
    }

    @Override
    public int getItemID(String itemname, Connection c) throws SQLException{
        int ID;
        try {
            String query = "SELECT ItemID FROM Item WHERE ItemName = ?;";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, itemname);
            ResultSet result = statement.executeQuery();

            c.commit();

            if (!result.next()) {
                return 0;
            }

            ID = result.getInt("ItemID");

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return ID;
    }

    @Override
    public ItemDTO getItem(int itemid, Connection c) throws SQLException{
        ItemDTO item = new ItemDTO();
        try {
            String query = "SELECT * FROM Item WHERE ItemID = "+itemid+";";
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            c.commit();

            if (!result.next()) {
                return null;
            }
            item.setId(itemid);
            item.setName(result.getString("ItemName"));
            item.setWeight(result.getDouble("Weight"));
            item.setDescription(result.getString("Description"));

        } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
        return item;
    }

    @Override
    public boolean createGroup(GroupDTO group, Connection c) throws SQLException{
        try {
            String query = "INSERT INTO Group (GroupName, Description) VALUES (?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setString(1, group.getName());
            statement.setString(2, group.getDescription());

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
        return true;

    }

    @Override
    public int getGroupID(String groupname, Connection c) throws SQLException{
        int ID;
        try {
            String query = "SELECT GroupID FROM Group WHERE groupID = ?;";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, groupname);
            ResultSet result = statement.executeQuery();

            c.commit();

            if (!result.next()) {
                return 0;
            }

            ID = result.getInt("GroupID");

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return ID;

    }

    @Override
    public GroupDTO getGroup(int groupid, Connection c) throws SQLException{
        GroupDTO item = new GroupDTO();
        try {
            String query = "SELECT * FROM Group WHERE GroupID = "+groupid+";";
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            c.commit();

            if (!result.next()) {
                return null;
            }
            item.setId(groupid);
            item.setName(result.getString("GroupName"));
            item.setDescription(result.getString("Description"));

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return item;

    }

    @Override
    public boolean addCharacter(UserDTO user, int characterid, Connection c) throws SQLException{
        try {

            String query = "INSERT INTO CharacterRelation (CharacterID, UserID) VALUES (?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setInt(1, characterid);
            statement.setInt(2, user.getID());

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }

        user.addCharacter(characterid);
        return true;
    }

    @Override
    public boolean removeCharacter(int characterid, Connection c) throws SQLException{
        //TODO: I'm not sure about whether we should remove the character from the UserDTO. We probably should, to keep the data consistent.
        try {

            String query = "DELETE FROM CharacterRelation WHERE CharacterID ='"+characterid+"'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            return false;
        }

        return true;
    }

    @Override
    public ArrayList getCharacterIDs(int userid, Connection c) throws SQLException{
        ArrayList characterids = new ArrayList();
        try {
            String query = "SELECT CharacterID FROM CharacterRelation WHERE UserID ='"+userid+"'";
            PreparedStatement statement = c.prepareStatement(query);

            ResultSet result = statement.executeQuery();
            c.commit();
            while(result.next()){
                characterids.add(result.getInt("CharacterID"));
            }

        } catch (SQLException p) {
            throw p;
        }
        return characterids;
    }

    @Override
    public boolean addItem(int characterid, int itemid, Connection c) throws SQLException{

    }

    @Override
    public boolean addItems(int characterid, int itemid, int amount, Connection c) throws SQLException{

    }

    @Override
    public boolean removeItem(int characterid, int itemid, Connection c) throws SQLException{

    }

    @Override
    public boolean removeItems(int characterid, int itemid, int amount, Connection c) throws SQLException{

    }

    @Override
    public int[] getItemIDs(int characterid, Connection c) throws SQLException{
        return new int[0];
    }

    @Override
    public boolean addToGroup(CharacterDTO character, GroupDTO group, Connection c) throws SQLException{
        try {

            String query = "INSERT INTO GroupRelation (GroupID, CharacterID) VALUES (?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setInt(1, group.getID());
            statement.setInt(2, character.getID());

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }

        group.addCharacter(character.getID());
        character.addGroup(group.getID());
        return true;
    }

    @Override
    public boolean removeFromGroup(int characterid, int groupid, Connection c) throws SQLException{
        //TODO: I'm not sure about whether we should remove the relation from the DTO. We probably should, to keep the data consistent.
        try {

            String query = "DELETE FROM GroupRelation WHERE CharacterID = '"+characterid+"' AND GroupID = '"+groupid+"'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }

        return true;
    }

    @Override
    public ArrayList getGroupIDs(int characterid, Connection c) throws SQLException{
        ArrayList groupids = new ArrayList();
        try {
            String query = "SELECT GroupID FROM GroupRelation WHERE CharacterID ='"+characterid+"'";
            PreparedStatement statement = c.prepareStatement(query);

            ResultSet result = statement.executeQuery();
            c.commit();
            while(result.next()){
                groupids.add(result.getInt("GroupID"));
            }

        } catch (SQLException p) {
            throw p;
        }
        return groupids;
    }

    @Override
    public ArrayList getMembers(int groupid, Connection c) throws SQLException{
        ArrayList characterids = new ArrayList();
        try {
            String query = "SELECT CharacterID FROM GroupRelation WHERE GroupID ='"+groupid+"'";
            PreparedStatement statement = c.prepareStatement(query);

            ResultSet result = statement.executeQuery();
            c.commit();
            while(result.next()){
                characterids.add(result.getInt("CharacterID"));
            }

        } catch (SQLException p) {
            throw p;
        }
        return characterids;
    }

    @Override
    public boolean deleteUser(int userid, Connection c) throws SQLException{
        try {

            String query = "DELETE FROM User WHERE UserID ='"+userid+"'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }

        return true;
    }

    @Override
    public boolean overwriteUser(UserDTO user, Connection c) throws SQLException{
        try {

            String query = "UPDATE User SET Username = ?, Password = ?, Roles = ? WHERE UserID = '"+user.getID()+"'";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole());
            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }

        return true;
    }

    @Override
    public boolean overwriteCharacter(CharacterDTO character, Connection c) throws SQLException{
        try {

            String query = "UPDATE Character SET Cname = ?, Location = ?, Strength = ?, BonusCapacity = ? WHERE CharacterID = '"+character.getID()+"'";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, character.getName());
            statement.setString(2, character.getLocation());
            statement.setInt(3, character.getStrength());
            statement.setInt(4, character.getBonus());
            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }

        return true;
    }

    @Override
    public boolean overwriteItem(ItemDTO item, Connection c) throws SQLException{
        try {

            String query = "UPDATE Item SET ItemName = ?, Weight = ?, Description = ? WHERE ItemID = '"+item.getID()+"'";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getWeight());
            statement.setString(3,  item.getDescription());

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }

        return true;
    }

    @Override
    public boolean deleteItem(int itemid, Connection c) throws SQLException{
        try {
            String query = "DELETE FROM Item WHERE ItemID ='"+itemid+"'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }

        return true;
    }

    @Override
    public boolean overwriteGroup(GroupDTO group, Connection c) throws SQLException{
        try {
            String query = "UPDATE Group SET GroupName = ?, Description = ? WHERE GroupID = '"+group.getID()+"'";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, group.getName());
            statement.setString(2, group.getDescription());

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }

        return true;
    }

    @Override
    public boolean deleteGroup(int groupid, Connection c) throws SQLException{
        try {
            String query = "DELETE FROM Group WHERE GroupID ='"+groupid+"'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }

        return true;
    }
}