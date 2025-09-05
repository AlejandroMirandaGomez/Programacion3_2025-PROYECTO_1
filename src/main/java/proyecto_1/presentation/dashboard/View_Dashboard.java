package proyecto_1.presentation.dashboard;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View_Dashboard implements PropertyChangeListener {
    Controller_Dashboard controller;
    Model_Dashboard model;

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
}
