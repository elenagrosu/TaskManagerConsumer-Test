package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a model class to create an Listner for button press
 * */

public class QuitFromButton extends JPanel implements Runnable{
    static JFrame f=new JFrame("Exit button");
    JButton b=new JButton("Exit");

    QuitFromButton(){
        b.setBounds(50,20,95,30);
        f.add(b);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProductionManager.exit=1;
                f.setVisible(false);
                System.out.println("\n\n--------------------------------------Start Consuming after exit(1)----------------------------------------------------\n\n");


                System.exit(1);
            }
        });
        f.setSize(200,100);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setAlwaysOnTop(true);
    }

    @Override
    public void run() {
        while (true) {}
    }
}