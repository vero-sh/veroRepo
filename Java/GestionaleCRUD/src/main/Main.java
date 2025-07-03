package main;

import gestionale.*;


import javax.swing.*;
//d

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeManagerSwing().setVisible(true));
    }
}
