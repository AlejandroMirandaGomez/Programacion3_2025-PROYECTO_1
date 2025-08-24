package main.java.proyecto_1;

import main.java.proyecto_1.presentation.login.Controller_Login;
import main.java.proyecto_1.presentation.login.Model_Login;
import main.java.proyecto_1.presentation.login.View_Login;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");}
        catch (Exception ex) {};

        View_Login view = new View_Login();
        Model_Login model = new Model_Login();
        Controller_Login controller = new Controller_Login(view, model);

        JFrame window = new JFrame();
        window.setSize(600,300);
        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Personas");
        window.setContentPane(view.getPanel());
        window.setVisible(true);
    }
}