package com.cdioDnD.controller;

import exception.PasswordException;

public interface State {

    public void onEnterState(Context context);
    public void option1(Context context) throws PasswordException;
    public void option2(Context context);
    public void option3(Context context);
    public void option4(Context context);
    public void option5(Context context);
    public void option6(Context context);
    public void option7(Context context);


}
