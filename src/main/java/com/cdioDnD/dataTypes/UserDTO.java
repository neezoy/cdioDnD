package com.cdioDnD.dataTypes;

import java.util.ArrayList;

public class UserDTO implements IUserDTO{

    String username;
    String password;

    public UserDTO(String username, String password){
        this.username=username;
        this.password=password;
    }

    @Override
    public String getUser() {
        return null;
    }

    @Override
    public ArrayList<ICharacterDTO> getCharacterList() {
        return null;
    }

    @Override
    public void addCharactar(ICharacterDTO character) {

    }

    @Override
    public void deleteCharacter(String name) {

    }

    @Override
    public void setPassword(String password) {

    }
}
