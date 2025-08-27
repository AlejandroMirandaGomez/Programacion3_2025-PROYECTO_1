package proyecto_1.presentation.prescribir;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View_Prescribir implements PropertyChangeListener {
    private JPanel panel;
    private JButton button1;
    private JButton button2;

    public JPanel getPanel() {
        return panel;
    }

    Controller_Prescribir controller;
    Model_Prescribir model;

    public void setController(Controller_Prescribir controller) {
        this.controller = controller;
    }

    public void setModel(Model_Prescribir model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
