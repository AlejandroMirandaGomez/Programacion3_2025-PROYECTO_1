package proyecto_1.presentation.prescribir;

import proyecto_1.presentation.AbstractModel;
import java.beans.PropertyChangeListener;
import proyecto_1.logic.Receta;

public class Model_Prescribir extends AbstractModel{
    Receta currentReceta;

    public static final String CURRENT = "current";

    public Model_Prescribir() {currentReceta = new Receta();}

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
    }

    public Receta getCurrentReceta() {
        return currentReceta;
    }

    public void setCurrentReceta(Receta currentReceta) {
        this.currentReceta = currentReceta;
        firePropertyChange(CURRENT);
    }
}
