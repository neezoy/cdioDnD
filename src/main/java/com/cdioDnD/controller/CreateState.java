package com.cdioDnD.controller;

public class CreateState implements State {
    @Override
    public void onEnterState(Context context) {
        context.chooseOption(context.tui.createMenu());
    }

    @Override
    public void option1(Context context) {


    }

    @Override
    public void option2(Context context) {

    }

    @Override
    public void option3(Context context) {

    }

    @Override
    public void option4(Context context) {

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
