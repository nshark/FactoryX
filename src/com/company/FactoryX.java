package com.company;

public class FactoryX {
    static String buildSet = "";
    GAC gac = new GAC();
    FactoryX(){
        boolean quit = false;
        while(!quit){
            gac.advanceGraphics();

        }
    }
}
