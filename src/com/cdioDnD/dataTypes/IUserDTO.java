package com.cdioDnD.dataTypes;

import java.util.ArrayList;

public interface IUserDTO {

    String getUser();
    ArrayList<ICharacterDTO> getCharacterList();
    void addCharactar(ICharacterDTO character);
    void deleteCharacter(String name);
    void setPassword(String password);

}
