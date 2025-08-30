package proyecto_1.presentation.despacho;

import proyecto_1.data.Data;
import proyecto_1.logic.Receta;
import proyecto_1.presentation.AbstractModel;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Model_Despacho extends AbstractModel {
    List<Receta> recetas;

    public static final String LIST = "List";

    public Model_Despacho() {
        recetas = new ArrayList<Receta>();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(LIST);
    }

    public List<Receta> getRecetas() { return recetas; }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
        firePropertyChange(LIST);
    }
}
