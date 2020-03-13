package com.cdioDnD.database;

import com.cdioDnD.dataTypes.*;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;
import java.util.ArrayList;

public class DAO implements IDAO {


    private Connection c;

    public DAO() {
        String url = "jdbc:mysql://localhost:3306/cdio?characterEncoding=latin1";
        String username = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() throws Exception {
        try{
            c.close();
        } catch (Exception e) {
            throw e;
        }

    }
    @Override
    public void createUser(IUserDTO user) throws SQLException {
        try {
            String query = "INSERT INTO User (Username, Password, Roles) VALUES (?, ?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setString(1, user.getName());
            statement.setString(2,  user.getPassword());
            statement.setInt(3, user.getRole());

            statement.execute();
           //

        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public IUserDTO getUserFromName(String username) throws SQLException {
        IUserDTO user = new UserDTO();
        try {
            String query = "SELECT * FROM User WHERE Username = ?;";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

           //

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
    @Override
    public UserDTO getUser(int userid) throws SQLException {
        UserDTO user = new UserDTO();
        try {
            String query = "SELECT * FROM User WHERE UserID = " + userid + ";";
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet result = statement.executeQuery();



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
    @Override
    public void createCharacter(ICharacterDTO character) throws SQLException {
        try {

            String query = "INSERT INTO cdio.character (CName, Location, Strength, BonusCapacity) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setString(1, character.getName());
            statement.setString(2, character.getLocation());
            statement.setInt(3, character.getStrength());
            statement.setInt(4, character.getBonus());

            statement.execute();



        } catch (SQLException p) {
            throw p;

        }
    }
    @Override
    public int getCharacterID(String charactername) throws SQLException {
        int ID;
        try {
            String query = "SELECT CharacterID FROM cdio.Character WHERE cname = ?";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, charactername);
            ResultSet result = statement.executeQuery();

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
    public ICharacterDTO getCharacter(int characterid) throws SQLException {
        ICharacterDTO character = new CharacterDTO();
        try {
            String query = "SELECT * FROM cdio.Character WHERE CharacterID = " + characterid + ";";
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet result = statement.executeQuery();

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
    @Override
    public void createItem(IItemDTO item) throws SQLException {
        try {

            String query = "INSERT INTO Item (ItemName, Weight, Description) VALUES (?, ?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setString(1, item.getName());
            statement.setDouble(2, item.getWeight());
            statement.setString(3, item.getDescription());

            statement.execute();



        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public int getItemID(String itemname) throws SQLException {
        int ID;
        try {
            String query = "SELECT ItemID FROM Item WHERE ItemName = ?;";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, itemname);
            ResultSet result = statement.executeQuery();



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
    public IItemDTO getItem(int itemid) throws SQLException {
        IItemDTO item = new ItemDTO();
        try {
            String query = "SELECT * FROM Item WHERE ItemID = " + itemid + ";";
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet result = statement.executeQuery();



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
    @Override
    public void createGroup(IGroupDTO group) throws SQLException {
        try {
            String query = "INSERT INTO cdio.Group (GroupName, Description) VALUES (?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setString(1, group.getName());
            statement.setString(2, group.getDescription());

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public int getGroupID(String groupname) throws SQLException {
        int ID;
        try {
            String query = "SELECT GroupID FROM cdio.Group WHERE groupname = ?;";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, groupname);
            ResultSet result = statement.executeQuery();

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
    public IGroupDTO getGroup(int groupid) throws SQLException {
        IGroupDTO group = new GroupDTO();
        try {
            String query = "SELECT * FROM cdio.Group WHERE GroupID = " + groupid;
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet result = statement.executeQuery();



            if (!result.next()) {
                return null;
            }
            group.setID(groupid);
            group.setName(result.getString("GroupName"));
            group.setDescription(result.getString("Description"));

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return group;

    }
    @Override
    public void addCharacter(IUserDTO user, ICharacterDTO character) throws SQLException {
        try {

            String query = "INSERT INTO CharacterRelation (CharacterID, UserID) VALUES (?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setInt(1, character.getID());
            statement.setInt(2, user.getID());

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }

        user.addCharacter(character);
    }
    @Override
    public void removeCharacter(int characterid) throws SQLException {
        //TODO: I'm not sure about whether we should remove the character from the UserDTO. We probably should, to keep the data consistent.
        try {

            String query = "DELETE FROM CharacterRelation WHERE CharacterID ='" + characterid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public ArrayList getCharacterIDs(int userid) throws SQLException {
        ArrayList characterids = new ArrayList();
        try {
            String query = "SELECT CharacterID FROM CharacterRelation WHERE UserID ='" + userid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                characterids.add(result.getInt("CharacterID"));
            }

        } catch (SQLException p) {
            throw p;
        }
        return characterids;
    }
    @Override
    public void addItem(int characterid, int itemid) throws SQLException {
        //TODO make add and remove items check if the item already exists.
        try {

            String query = "INSERT INTO ItemRelation (ItemID, CharacterID, Amount) VALUES (?, ?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setInt(1, itemid);
            statement.setInt(2, characterid);
            statement.setInt(3, 1);

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public void addItems(int characterid, int itemid, int amount) throws SQLException {
        try {

            String query = "INSERT INTO ItemRelation (ItemID, CharacterID, Amount) VALUES (?, ?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setInt(1, itemid);
            statement.setInt(2, characterid);
            statement.setInt(3, amount);

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public void removeItem(int characterid, int itemid) throws SQLException {
        //TODO how do we delete one.
        try {

            String query = "DELETE FROM ItemRelation WHERE ItemID ='" + itemid + "' AND CharacterID ='" + characterid + "' ";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public void removeItems(int characterid, int itemid, int amount) throws SQLException {
        try {

            String query = "DELETE FROM ItemRelation WHERE ItemID ='" + itemid + "' AND CharacterID ='" + characterid + "' ";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public ArrayList getItemIDs(int characterid) throws SQLException {
        ArrayList itemids = new ArrayList();
        try {
            String query = "SELECT ItemID FROM ItemRelation WHERE CharacterID ='" + characterid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                itemids.add(result.getInt("CharacterID"));
            }

        } catch (SQLException p) {
            throw p;
        }
        return itemids;
    }
    @Override
    public void addToGroup(ICharacterDTO character, IGroupDTO group) throws SQLException {
        try {

            String query = "INSERT INTO GroupRelation (GroupID, CharacterID) VALUES (?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setInt(1, group.getID());
            statement.setInt(2, character.getID());

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }

        group.addCharacter(character);
        character.addGroup(group);
    }
    @Override
    public void removeFromGroup(int characterid, int groupid) throws SQLException {
        //TODO: I'm not sure about whether we should remove the relation from the DTO. We probably should, to keep the data consistent.
        try {

            String query = "DELETE FROM GroupRelation WHERE CharacterID = '" + characterid + "' AND GroupID = '" + groupid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public ArrayList getGroupIDs(int characterid) throws SQLException {
        ArrayList groupids = new ArrayList();
        try {
            String query = "SELECT GroupID FROM GroupRelation WHERE CharacterID ='" + characterid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                groupids.add(result.getInt("GroupID"));
            }

        } catch (SQLException p) {
            throw p;
        }
        return groupids;
    }
    @Override
    public ArrayList getMembers(int groupid) throws SQLException {
        ArrayList characterids = new ArrayList();
        try {
            String query = "SELECT CharacterID FROM GroupRelation WHERE GroupID ='" + groupid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                characterids.add(result.getInt("CharacterID"));
            }

        } catch (SQLException p) {
            throw p;
        }
        return characterids;
    }
    @Override
    public void deleteUser(int userid) throws SQLException {
        try {

            String query = "DELETE FROM User WHERE UserID ='" + userid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public void overwriteUser(UserDTO user) throws SQLException {
        try {

            String query = "UPDATE User SET Username = ?, Password = ?, Roles = ? WHERE UserID = '" + user.getID() + "'";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole());
            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public void overwriteCharacter(CharacterDTO character) throws SQLException {
        try {

            String query = "UPDATE Character SET Cname = ?, Location = ?, Strength = ?, BonusCapacity = ? WHERE CharacterID = '" + character.getID() + "'";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, character.getName());
            statement.setString(2, character.getLocation());
            statement.setInt(3, character.getStrength());
            statement.setInt(4, character.getBonus());
            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public void overwriteItem(ItemDTO item) throws SQLException {
        try {

            String query = "UPDATE Item SET ItemName = ?, Weight = ?, Description = ? WHERE ItemID = '" + item.getID() + "'";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getWeight());
            statement.setString(3, item.getDescription());

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public void deleteItem(int itemid) throws SQLException {
        try {
            String query = "DELETE FROM Item WHERE ItemID ='" + itemid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public void overwriteGroup(GroupDTO group) throws SQLException {
        try {
            String query = "UPDATE Group SET GroupName = ?, Description = ? WHERE GroupID = '" + group.getID() + "'";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, group.getName());
            statement.setString(2, group.getDescription());

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
    @Override
    public void deleteGroup(int groupid) throws SQLException {
        try {
            String query = "DELETE FROM Group WHERE GroupID ='" + groupid + "'";
            PreparedStatement statement = c.prepareStatement(query);

            statement.execute();


        } catch (SQLException p) {
            throw p;
        }
    }
}