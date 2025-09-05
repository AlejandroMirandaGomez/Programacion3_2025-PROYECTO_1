package proyecto_1.presentation.historico;

import proyecto_1.logic.Paciente;
import proyecto_1.logic.Receta;
import proyecto_1.presentation.AbstractModel;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Model_Historico extends AbstractModel {
    List<Receta> recetas;
    List<Paciente> pacientes;
    private Paciente currentPaciente;
    private Receta currentReceta;
    private String currentEstado;

    public static final String RECETAS = "recetas";
    public static final String PACIENTES = "pacientes";
    public static final String CURRENT_PACIENTE = "currentPaciente";
    public static final String CURRENT_RECETA = "currentReceta";
    public static final String CURRENT_ESTADO = "currentEstado";

    public Model_Historico() {
        recetas = new ArrayList<Receta>();
        pacientes = new ArrayList<Paciente>();
        currentPaciente = new Paciente();
        currentReceta = new Receta();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(RECETAS);
        firePropertyChange(PACIENTES);
        firePropertyChange(CURRENT_PACIENTE);
        //firePropertyChange(CURRENT_RECETA);
        firePropertyChange(CURRENT_ESTADO);

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

    public void setCurrentaciente(Paciente paciente) {
        this.currentPaciente = paciente;
        firePropertyChange(CURRENT_PACIENTE);
    }

    public String getCurrentEstado() { return currentEstado; }

    public void setCurrentEstado(String currentEstado) {
        this.currentEstado = currentEstado;
        firePropertyChange(CURRENT_ESTADO);
    }

    public Receta getCurrentReceta() { return currentReceta; }

    public void setCurrentReceta(Receta currentReceta) {
        this.currentReceta = currentReceta;
        firePropertyChange(CURRENT_RECETA);
    }

    public void setEstado_of_CurrentReceta(String newEstado) {
        this.currentReceta.setEstado(newEstado);
        firePropertyChange(RECETAS);
    }

}
