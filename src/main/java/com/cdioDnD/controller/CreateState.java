package com.cdioDnD.controller;

import com.cdioDnD.dataTypes.*;

import java.sql.SQLException;

public class CreateState implements State {
    @Override
    public void onEnterState(Context context) {
        context.chooseOption(context.tui.createMenu());
    }

    @Override
    public void option1(Context context) {
        IUserDTO user = context.tui.createUser();
        try {
            context.dao.createUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void option2(Context context) {
        ICharacterDTO charac = context.tui.createCharacter();
        try {
            context.dao.createCharacter(charac);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void option3(Context context) {
        IItemDTO item = context.tui.createItem();
        try {
            context.dao.createItem(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void option4(Context context) {
        IGroupDTO grp = context.tui.createGroup();
        try {
            context.dao.createGroup(grp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void option5(Context context) {


    }

    @Override
    public void option6(Context context) {

    }

    @Override
    public void option7(Context context) {

    }
}
