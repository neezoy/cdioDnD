package com.cdioDnD.dataTypes;

import java.util.ArrayList;
import java.util.LinkedList;

public interface ICharacterDTO {

//name
    void setName(String name);
    String getName();

//Items
    ArrayList<IItemDTO> getItemsList();
    void addItem(String name);
    void removeItem(String name);


//Groups
    ArrayList<IGroupDTO> getGroupList();
    void addGroup(String name);
    void removeGroup(String name);




}
