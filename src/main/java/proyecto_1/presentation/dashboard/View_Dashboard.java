package proyecto_1.presentation.dashboard;


import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View_Dashboard implements PropertyChangeListener {
    Controller_Dashboard controller;
    Model_Dashboard model;
    private JPanel panel;

    public void setController(Controller_Dashboard controller) {
        this.controller = controller;
    }
    public void setModel(Model_Dashboard model) {
        this.model = model;
        model.addPropertyChangeListener((PropertyChangeListener) this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public JPanel getPanel() {
        return panel;
    }

}
