package com.cdioDnD.controller;

import com.cdioDnD.dataTypes.ICharacterDTO;
import com.cdioDnD.dataTypes.IUserDTO;

import java.sql.SQLException;

public class RemoveState implements State {
    @Override
    public void onEnterState(Context context) {
        context.chooseOption(context.tui.removeMenu());
    }

    @Override
    public void option1(Context context) {
        String uName = context.tui.removeUser();

        try {
            IUserDTO user = context.dao.getUserFromName(uName);
            int i = user.getID();
            context.dao.deleteUser(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        context.setState(new StartState());
    }

    @Override
    public void option2(Context context) {
        String charName = context.tui.removeCharacter();

        try {
            int id = context.dao.getCharacterID(charName);
            context.dao.removeCharacter(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        context.setState(new StartState());

    }

    @Override
    public void option3(Context context) {
        String itemName = context.tui.removeItem();

        try {
            int id = context.dao.getItemID(itemName);
            context.dao.deleteItem(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        context.setState(new StartState());
    }

    @Override
    public void option4(Context context) {
        String[] a = context.tui.removeGroupFromCharacter();


        try {
            int cid =context.dao.getCharacterID(a[0]);
            int gid = context.dao.getGroupID(a[1]);
        //    context.dao.removeFromGroup(cid, gid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
