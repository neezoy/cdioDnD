package com.cdioDnD.database;

import com.cdioDnD.dataTypes.CharacterDTO;
import com.cdioDnD.dataTypes.GroupDTO;
import com.cdioDnD.dataTypes.ItemDTO;
import com.cdioDnD.dataTypes.UserDTO;

import java.sql.*;
import java.util.ArrayList;

public class DAO implements IDAO {


    private Connection c;

    public DAO() throws Exception {
        String url = "jdbc:mysql://localhost:3306/cdio?characterEncoding=latin1";
        String username = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void closeConnection() throws Exception {
        try{
            c.close();
        } catch (Exception e) {
            throw e;
        }

    }

    public void createUser(UserDTO user) throws SQLException {
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
    }

    public UserDTO getUserFromName(String username) throws SQLException {
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
            user.setID(result.getInt("UserID"));
            user.setName(username);
            user.setPassword(result.getString("Password"));
            user.setRole(result.getInt("Roles"));

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return user;
    }

    public UserDTO getUser(int userid) throws SQLException {
        UserDTO user = new UserDTO();
        try {
            String query = "SELECT * FROM User WHERE UserID = " + userid + ";";
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            c.commit();

            if (!result.next()) {
                return null;
            }
            user.setID(userid);
            user.setName(result.getString("Username"));
            user.setPassword(result.getString("Password"));
            user.setRole(result.getInt("Roles"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return user;
    }

    public void createCharacter(CharacterDTO character) throws SQLException {
        try {

            String query = "INSERT INTO user (Cname, Location, Strength, BonusCapacity) VALUES (?, ?, ?,?)";
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
    }

    public int getCharacterID(String charactername) throws SQLException {
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

    public CharacterDTO getCharacter(int characterid) throws SQLException {
        CharacterDTO character = new CharacterDTO();
        try {
            String query = "SELECT * FROM Character WHERE CharacterID = " + characterid + ";";
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            c.commit();

            if (!result.next()) {
                return null;
            }
            character.setID(characterid);
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

    public void createItem(ItemDTO item) throws SQLException {
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
    }

    public int getItemID(String itemname) throws SQLException {
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

    public ItemDTO getItem(int itemid) throws SQLException {
        ItemDTO item = new ItemDTO();
        try {
            String query = "SELECT * FROM Item WHERE ItemID = " + itemid + ";";
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            c.commit();

            if (!result.next()) {
                return null;
            }
            item.setID(itemid);
            item.setName(result.getString("ItemName"));
            item.setWeight(result.getDouble("Weight"));
            item.setDescription(result.getString("Description"));

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return item;
    }

    public void createGroup(GroupDTO group) throws SQLException {
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
    }

    public int getGroupID(String groupname) throws SQLException {
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

    public GroupDTO getGroup(int groupid) throws SQLException {
        GroupDTO item = new GroupDTO();
        try {
            String query = "SELECT * FROM Group WHERE GroupID = " + groupid + ";";
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            c.commit();

            if (!result.next()) {
                return null;
            }
            item.setID(groupid);
            item.setName(result.getString("GroupName"));
            item.setDescription(result.getString("Description"));

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return item;

    }

    public void addCharacter(UserDTO user, CharacterDTO character) throws SQLException {
        try {

            String query = "INSERT INTO CharacterRelation (CharacterID, UserID) VALUES (?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setInt(1, character.getID());
            statement.setInt(2, user.getID());

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }

        user.addCharacter(character);
    }

    public void removeCharacter(int characterid) throws SQLException {
        //TODO: I'm not sure about whether we should remove the character from the UserDTO. We probably should, to keep the data consistent.
        try {

            String query = "DELETE FROM CharacterRelation WHERE CharacterID ='" + characterid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
    }

    public ArrayList getCharacterIDs(int userid) throws SQLException {
        ArrayList characterids = new ArrayList();
        try {
            String query = "SELECT CharacterID FROM CharacterRelation WHERE UserID ='" + userid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            ResultSet result = statement.executeQuery();
            c.commit();
            while (result.next()) {
                characterids.add(result.getInt("CharacterID"));
            }

        } catch (SQLException p) {
            throw p;
        }
        return characterids;
    }

    public void addItem(int characterid, int itemid) throws SQLException {
        //TODO make add and remove items check if the item already exists.
        try {

            String query = "INSERT INTO ItemRelation (ItemID, CharacterID, Amount) VALUES (?, ?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setInt(1, itemid);
            statement.setInt(2, characterid);
            statement.setInt(3, 1);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
    }

    public void addItems(int characterid, int itemid, int amount) throws SQLException {
        try {

            String query = "INSERT INTO ItemRelation (ItemID, CharacterID, Amount) VALUES (?, ?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setInt(1, itemid);
            statement.setInt(2, characterid);
            statement.setInt(3, amount);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
    }

    public void removeItem(int characterid, int itemid) throws SQLException {
        //TODO how do we delete one.
        try {

            String query = "DELETE FROM ItemRelation WHERE ItemID ='" + itemid + "' AND CharacterID ='" + characterid + "' ";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
    }

    public void removeItems(int characterid, int itemid, int amount) throws SQLException {
        try {

            String query = "DELETE FROM ItemRelation WHERE ItemID ='" + itemid + "' AND CharacterID ='" + characterid + "' ";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
    }

    public ArrayList getItemIDs(int characterid) throws SQLException {
        ArrayList itemids = new ArrayList();
        try {
            String query = "SELECT ItemID FROM ItemRelation WHERE CharacterID ='" + characterid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            ResultSet result = statement.executeQuery();
            c.commit();
            while (result.next()) {
                itemids.add(result.getInt("CharacterID"));
            }

        } catch (SQLException p) {
            throw p;
        }
        return itemids;
    }

    public void addToGroup(CharacterDTO character, GroupDTO group) throws SQLException {
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

        group.addCharacter(character);
        character.addGroup(group);
    }

    public void removeFromGroup(int characterid, int groupid) throws SQLException {
        //TODO: I'm not sure about whether we should remove the relation from the DTO. We probably should, to keep the data consistent.
        try {

            String query = "DELETE FROM GroupRelation WHERE CharacterID = '" + characterid + "' AND GroupID = '" + groupid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
    }

    public ArrayList getGroupIDs(int characterid) throws SQLException {
        ArrayList groupids = new ArrayList();
        try {
            String query = "SELECT GroupID FROM GroupRelation WHERE CharacterID ='" + characterid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            ResultSet result = statement.executeQuery();
            c.commit();
            while (result.next()) {
                groupids.add(result.getInt("GroupID"));
            }

        } catch (SQLException p) {
            throw p;
        }
        return groupids;
    }

    public ArrayList getMembers(int groupid) throws SQLException {
        ArrayList characterids = new ArrayList();
        try {
            String query = "SELECT CharacterID FROM GroupRelation WHERE GroupID ='" + groupid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            ResultSet result = statement.executeQuery();
            c.commit();
            while (result.next()) {
                characterids.add(result.getInt("CharacterID"));
            }

        } catch (SQLException p) {
            throw p;
        }
        return characterids;
    }

    public void deleteUser(int userid) throws SQLException {
        try {

            String query = "DELETE FROM User WHERE UserID ='" + userid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
    }

    public void overwriteUser(UserDTO user) throws SQLException {
        try {

            String query = "UPDATE User SET Username = ?, Password = ?, Roles = ? WHERE UserID = '" + user.getID() + "'";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole());
            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
    }

    public void overwriteCharacter(CharacterDTO character) throws SQLException {
        try {

            String query = "UPDATE Character SET Cname = ?, Location = ?, Strength = ?, BonusCapacity = ? WHERE CharacterID = '" + character.getID() + "'";
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
    }

    public void overwriteItem(ItemDTO item) throws SQLException {
        try {

            String query = "UPDATE Item SET ItemName = ?, Weight = ?, Description = ? WHERE ItemID = '" + item.getID() + "'";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getWeight());
            statement.setString(3, item.getDescription());

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
    }

    public void deleteItem(int itemid) throws SQLException {
        try {
            String query = "DELETE FROM Item WHERE ItemID ='" + itemid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
    }

    public void overwriteGroup(GroupDTO group) throws SQLException {
        try {
            String query = "UPDATE Group SET GroupName = ?, Description = ? WHERE GroupID = '" + group.getID() + "'";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, group.getName());
            statement.setString(2, group.getDescription());

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
    }

    public void deleteGroup(int groupid) throws SQLException {
        try {
            String query = "DELETE FROM Group WHERE GroupID ='" + groupid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            throw p;
        }
    }
}