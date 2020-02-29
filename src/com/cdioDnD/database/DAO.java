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
            String query = "INSERT INTO User (Username, Password, Roles) VALUES (?, ?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole());

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            return false;
        }
        return true;
    }

    @Override
    public UserDTO getUserFromName(String username, Connection c) {
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
            return null;
        }
        return user;
    }

    @Override
    public UserDTO getUser(int userid, Connection c) {
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
            return null;
        }
        return user;
    }

    @Override
    public boolean createCharacter(CharacterDTO character, Connection c) {
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
            return false;
        }
        return true;
    }

    @Override
    public int getCharacterID(String charactername, Connection c) {
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
            return 0;
        }
        return ID;
    }

    @Override
    public CharacterDTO getCharacter(int characterid, Connection c) {
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
            return null;
        }
        return character;
    }

    @Override
    public boolean createItem(ItemDTO item, Connection c) {
        try {

            String query = "INSERT INTO Item (ItemName, Weight, Description) VALUES (?, ?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setString(1, item.getName());
            statement.setDouble(2, item.getWeight());
            statement.setString(3, item.getDescription());

            statement.execute();
            c.commit();


        } catch (SQLException p) {
            return false;
        }
        return true;
    }

    @Override
    public int getItemID(String itemname, Connection c) {
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
            return 0;
        }
        return ID;
    }

    @Override
    public ItemDTO getItem(int itemid, Connection c) {
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
        return null;
    }
        return item;
    }

    @Override
    public boolean createGroup(GroupDTO group, Connection c) {
        try {
            String query = "INSERT INTO Group (GroupName, Description) VALUES (?, ?)";
            PreparedStatement statement = c.prepareStatement(query);

            statement.setString(1, group.getGroupName());
            statement.setString(2, group.getDescription());

            statement.execute();
            c.commit();

        } catch (SQLException p) {
            return false;
        }
        return true;

    }

    @Override
    public int getGroupID(String groupname, Connection c) {
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
            return 0;
        }
        return ID;

    }

    @Override
    public GroupDTO getGroup(int groupid, Connection c) {
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
            return null;
        }
        return item;

    }

    @Override
    public boolean addCharacter(int UserDTO, int CharacterDTO, Connection c) {

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