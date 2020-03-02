package com.cdioDnD.dataTypes;

import java.util.ArrayList;

public class CharacterDTO implements ICharacterDTO {

    String name;


    public CharacterDTO(String name){
        this.name = name;
    }


    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<IItemDTO> getItemsList() {
        return null;
    }

    @Override
    public void addItem(String name) {

    }

    @Override
    public void removeItem(String name) {

    }

    @Override
    public ArrayList<IGroupDTO> getGroupList() {
        return null;
    }

    @Override
    public void addGroup(String name) {

    }

    @Override
    public void removeGroup(String name) {

    }
}
