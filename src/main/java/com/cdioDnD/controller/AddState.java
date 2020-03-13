package com.cdioDnD.controller;

import com.cdioDnD.dataTypes.ICharacterDTO;
import com.cdioDnD.dataTypes.IGroupDTO;
import com.cdioDnD.dataTypes.IUserDTO;

import java.sql.SQLException;

public class AddState implements State {
    @Override
    public void onEnterState(Context context) {
        context.chooseOption(context.tui.addMenu());
    }

    @Override
    public void option1(Context context) {
        String[] a = context.tui.addCharacterToUser();
        String characName = a[0];
        String uName = a[1];

        try {
            int cid = context.dao.getCharacterID(characName);
            ICharacterDTO charac = context.dao.getCharacter(cid);
            IUserDTO user = context.dao.getUserFromName(uName);
            context.dao.addCharacter(user, charac);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        context.setState(new StartState());
    }

    @Override
    public void option2(Context context) {
        String[] a = context.tui.addItemToCharacter();
        String characName = a[0];
        String itemName = a[1];

        try {
            int characID = context.dao.getCharacterID(characName);
            int itemID = context.dao.getItemID(itemName);
            context.dao.addItem(characID, itemID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        context.setState(new StartState());
    }

    @Override
    public void option3(Context context) {
        String a[] = context.tui.addGroupToCharacter();
        String characName = a[0];
        String gName = a[1];
        
        try {
            int cid = context.dao.getCharacterID(characName);
            ICharacterDTO characdto = context.dao.getCharacter(cid);
            int gid = context.dao.getGroupID(gName);
            IGroupDTO grpdto = context.dao.getGroup(gid);
            context.dao.addToGroup(characdto, grpdto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        context.setState(new StartState());
    }

    @Override
    public void option4(Context context) {
        context.setState(new StartState());
    }

    @Override
    public void option5(Context context) {
        context.setState(new StartState());
    }

    @Override
    public void option6(Context context) {
        context.setState(new StartState());
    }

    @Override
    public void option7(Context context) {
        context.setState(new StartState());
    }
}
