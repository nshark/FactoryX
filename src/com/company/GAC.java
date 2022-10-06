package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class GAC implements MouseMotionListener, MouseListener {
    public Frame frame = new Frame("FactoryX");
    public Panel panel = new Panel();
    public Panel buttonPanel = new Panel();
    public Canvas FactoryFloor = new Canvas();
    public ArrayList<JButton> buttons = new ArrayList<>(List.of(
            new JButton("Conveyor"),
            new JButton("Furnace"),
            new JButton("Assembler"),
            new JButton("Drill")
    ));
    public String[][] Tiles = new String[10][10];
    GAC(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Tiles[i][j] = "";
            }
        }
        frame.add(panel);
        panel.setLayout(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.WEST);
        panel.add(FactoryFloor, BorderLayout.CENTER);
        FactoryFloor.addMouseListener(this);
        FactoryFloor.addMouseMotionListener(this);
        buttonPanel.setLayout(new GridLayout(3,1));
        FactoryFloor.setSize(500,500);
        for(JButton b : buttons){
            b.addActionListener(new ButtonListener(b.getText()));
            buttonPanel.add(b);
        }
        frame.pack();
        frame.setVisible(true);
        frame.requestFocus();
        FactoryFloor.createBufferStrategy(2);
    }
    public void advanceGraphics(){
        Graphics g = FactoryFloor.getBufferStrategy().getDrawGraphics();
        g.clearRect(0,0,500,500);
        int OffsetX = 0;
        int OffsetY = 0;
        for(String[] s : Tiles){
            for (String str : s){
                switch (str) {
                    case "Drill":{
                        g.drawOval(OffsetX + 5, OffsetY + 5, 40, 40);
                        break;
                    }
                    case "Conveyor":
                        break;
                    case "Furnace":
                        break;
                }
                g.drawLine(OffsetX, OffsetY, OffsetX, OffsetY+50);
                g.drawLine(OffsetX, OffsetY, OffsetX+50, OffsetY);
                OffsetX += 50;
                }
            OffsetX = 0;
            OffsetY += 50;
            }
        FactoryFloor.getBufferStrategy().show();
        g.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Tiles[e.getY()/50][e.getX()/50] = FactoryX.buildSet;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}