package main.java.proyecto_1.presentation.login;

import main.java.proyecto_1.logic.Medico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class View_Login implements PropertyChangeListener{
    private JPanel panel;
    private JTextField idFld;
    private JTextField claveFld;
    private JLabel idLab;
    private JLabel claveLab;
    private JButton LoginButton;
    private JButton loginButton;
    private JButton claveButton;

    public View_Login() {

        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    controller.readLogin(idFld.getText(), claveFld.getText());
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idFld.setText("");
                claveFld.setText("");
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    //MVC
    Controller_Login controller;
    Model_Login model;

    public void setController(Controller_Login controller) {
        this.controller = controller;
    }
    public void setModel(Model_Login model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model_Login.CURRENT:
                JOptionPane.showMessageDialog(panel, "Loggeado con exito", "Informacion", JOptionPane.PLAIN_MESSAGE);
                break;
        }
    }


}
