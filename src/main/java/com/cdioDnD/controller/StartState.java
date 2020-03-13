package com.cdioDnD.controller;

import com.cdioDnD.UI.ITUI;
import com.cdioDnD.UI.TUI;
import com.cdioDnD.database.DAO;
import com.cdioDnD.database.IDAO;

public class StartState implements State {


    @Override
    public void onEnterState(Context context) {
        context.chooseOption(context.tui.showMenu());


    }

    @Override
    public void option1(Context context) {
        context.setState(new CreateState());
    }

    @Override
    public void option2(Context context) {
        context.setState(new RemoveState());
    }

    @Override
    public void option3(Context context) {
        context.setState(new ViewState());
    }

    @Override
    public void option4(Context context) {context.setState(new AddState());}

    @Override
    public void option5(Context context) {System.out.println("Bye!");}

    @Override
    public void option6(Context context) {context.setState(new StartState());}

    @Override
    public void option7(Context context) {context.setState(new StartState());
    }
}



