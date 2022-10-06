package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    String ButtonName;
    ButtonListener(String ButtonName){
        this.ButtonName = ButtonName;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        FactoryX.buildSet = ButtonName;
    }
}
