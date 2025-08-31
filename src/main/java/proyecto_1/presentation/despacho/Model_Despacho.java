package proyecto_1.presentation.despacho;

import proyecto_1.logic.Paciente;
import proyecto_1.logic.Receta;
import proyecto_1.presentation.AbstractModel;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Model_Despacho extends AbstractModel {
    List<Receta> recetas;
    List<Paciente> pacientes;
    private Paciente currentPaciente;

    public static final String RECETAS = "recetas";
    public static final String PACIENTES = "pacientes";

    public Model_Despacho() {
        recetas = new ArrayList<Receta>();
        pacientes = new ArrayList<Paciente>();
        currentPaciente = new Paciente();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(RECETAS);
    }

    public List<Receta> getRecetas() { return recetas; }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
        firePropertyChange(RECETAS);
    }

    public List<Paciente> getPacientes() { return pacientes; }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
        firePropertyChange(PACIENTES);
    }

    public Paciente getCurrentPaciente() { return currentPaciente; }

    public void setCurrentaciente(Paciente paciente) { this.currentPaciente = paciente; }

}
