package com.cdioDnD.dataTypes;

import java.util.ArrayList;

public class UserDTO implements IUserDTO{

    private String username;
    private String password;
    private ArrayList<ICharacterDTO> characterList = new ArrayList<ICharacterDTO>();

    public UserDTO(String username, String password){
        this.username=username;
        this.password=password;
    }

    @Override
    public String getUser() {
        return username;
    }

    @Override
    public ArrayList<ICharacterDTO> getCharacterList() {
        return characterList;
    }

    @Override
    public void addCharactar(ICharacterDTO character) {
        characterList.add(character);


    }

    @Override
    public void deleteCharacter(String name) {

    }

    @Override
    public void setPassword(String password) {

    }
}
