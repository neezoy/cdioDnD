package com.cdioDnD.controller;

import com.cdioDnD.UI.ITUI;
import com.cdioDnD.UI.TUI;
import com.cdioDnD.database.DAO;
import com.cdioDnD.database.IDAO;
import exception.PasswordException;

public class Context {
    private State currentState;
    ITUI tui = new TUI();
    IDAO dao = new DAO();

    public Context() throws Exception {
        setState(new StartState());
    }

    public void setState(State state) throws Exception {
        this.currentState = state;
        currentState.onEnterState(this);
    }

    public State getState(){
        return currentState;
    }




    public void chooseOption(int choice) throws Exception {
        switch(choice){
            case 1:
                currentState.option1(this);
                break;
            case 2:
                currentState.option2(this);
                break;
            case 3:
                currentState.option3(this);
                break;
            case 4:
                currentState.option4(this);
                break;
            case 5:
                currentState.option5(this);
                break;
            case 6:
                currentState.option6(this);
                break;
            case 7:
                currentState.option7(this);
                break;

        }
    }

}
