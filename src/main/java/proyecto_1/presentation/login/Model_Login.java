package main.java.proyecto_1.presentation.login;

import main.java.proyecto_1.presentation.AbstractModel;
import main.java.proyecto_1.logic.Medico;

import java.beans.PropertyChangeListener;

public class Model_Login extends AbstractModel{
    Medico currentMed;

    public static final String CURRENT = "current";

    public Model_Login(){ currentMed = new Medico() ;}

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        //firePropertyChange(CURRENT);
    }

    public Medico getCurrentMed() {
        return currentMed;
    }

    public void setCurrentMedico(Medico currentMed) {
        this.currentMed = currentMed;
        firePropertyChange(CURRENT);
    }
}
