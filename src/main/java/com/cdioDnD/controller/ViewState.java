package com.cdioDnD.controller;

import com.cdioDnD.dataTypes.ICharacterDTO;
import com.cdioDnD.dataTypes.IGroupDTO;
import com.cdioDnD.dataTypes.IItemDTO;
import com.cdioDnD.dataTypes.IUserDTO;

import java.sql.SQLException;

public class ViewState implements State {
    @Override
    public void onEnterState(Context context) throws Exception {
        context.chooseOption(context.tui.viewMenu());
    }

    @Override
    public void option1(Context context) throws Exception {
        String name = context.tui.viewUser();
        try {
            IUserDTO user = context.dao.getUserFromName(name);
            context.tui.viewUserO(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        context.setState(new StartState());

    }

    @Override
    public void option2(Context context) throws Exception {
        String name = context.tui.viewAItem();
        try {
            int id = context.dao.getItemID(name);
            IItemDTO item = context.dao.getItem(id);
            context.tui.viewAItemO(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        context.setState(new StartState());


    }

    @Override
    public void option3(Context context) throws Exception {
        String name = context.tui.viewAGroup();
        try {
            int id = context.dao.getGroupID(name);
            IGroupDTO grp = context.dao.getGroup(id);
            context.tui.viewAGroupO(grp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        context.setState(new StartState());
    }

    @Override
    public void option4(Context context) throws Exception {
        String name = context.tui.viewACharacter();
        try {
            int id = context.dao.getCharacterID(name);
            ICharacterDTO charac = context.dao.getCharacter(id);
            context.tui.viewACharacterO(charac);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        context.setState(new StartState());
    }

    @Override
    public void option5(Context context) throws Exception {
        context.setState(new StartState());
    }

    @Override
    public void option6(Context context) throws Exception {
        context.setState(new StartState());
    }

    @Override
    public void option7(Context context) throws Exception {
        context.setState(new StartState());
    }
}
