

package com.mycompany.laba2;


public class Laba2 {

       public static void main(String[] args) {
        
        GUI gui = new GUI(new Mediator());
        
        gui.setVisible(true);
        gui.setTitle("Лабораторная работа №1 Евграфов Павел");
        gui.setLocationRelativeTo(null);
        
    }
}
