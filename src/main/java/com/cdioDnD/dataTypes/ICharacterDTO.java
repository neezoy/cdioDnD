package com.cdioDnD.dataTypes;

import java.util.ArrayList;
import java.util.LinkedList;

public interface ICharacterDTO {
//id
    void setID(int id);
    int getID();

//name
    void setName(String name);
    String getName();

    //Location
    void setLocation(String location);
    String getLocation();

    //Strength
    void setStrength(int strength);
    int getStrength();

    //BonusCapacity
    void setBonus(int bonuscapacity);
    int getBonus();


//Items
    ArrayList<IItemDTO> getItemsList();
    void addItem(IItemDTO item);
    void removeItem(IItemDTO item);


//Groups
    ArrayList<IGroupDTO> getGroupList();
    void addGroup(IGroupDTO group);
    void removeGroup(IGroupDTO group);




}
