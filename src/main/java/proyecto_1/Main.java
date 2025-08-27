package proyecto_1;

import proyecto_1.presentation.acercaDe.Controller_AcercaDe;
import proyecto_1.presentation.acercaDe.Model_AcercaDe;
import proyecto_1.presentation.acercaDe.View_AcercaDe;
import proyecto_1.presentation.login.Controller_Login;
import proyecto_1.presentation.login.Model_Login;
import proyecto_1.presentation.login.View_Login;

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

        // Acerca De
        View_AcercaDe view_acercaDe = new View_AcercaDe();
        Model_AcercaDe model_acercaDe = new Model_AcercaDe();
        Controller_AcercaDe controller_acercaDe = new Controller_AcercaDe(view_acercaDe, model_acercaDe);
        // *********************************************

        JFrame window = new JFrame();
        JTabbedPane tabbedPane = new JTabbedPane();

        window.setSize(600,300);
        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Estevan");
        window.setContentPane(tabbedPane);
        window.setVisible(true);

        tabbedPane.addTab("Acerca De", view_acercaDe.getPanel());
        tabbedPane.addTab("Login", view.getPanel());
    }
}