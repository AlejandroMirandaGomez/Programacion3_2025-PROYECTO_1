package proyecto_1.presentation.prescribir;

import proyecto_1.logic.Medicamento;
import proyecto_1.logic.Paciente;
import proyecto_1.logic.Prescripcion;
import proyecto_1.presentation.AbstractModel;
import java.beans.PropertyChangeListener;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;

import proyecto_1.logic.Receta;

public class Model_Prescribir extends AbstractModel{
    Receta currentReceta;
    List<Prescripcion> prescripciones;

    //--Buscar Paciente--
    List<Paciente> pacientes;

    //--Buscar Medicamentos--
    List<Medicamento> medicamentos;


    public static final String CURRENT = "current";
    public static final String PRESCRIPCIONES = "prescripciones";
    public static final String PACIENTES = "pacientes";
    public static final String MEDICAMENTOS = "medicamentos";

    public Model_Prescribir() {
        currentReceta = new Receta();
        prescripciones = new ArrayList<Prescripcion>();

        pacientes= new ArrayList<Paciente>();
        medicamentos=new ArrayList<Medicamento>();



        prescripciones.add(new Prescripcion("151",12,new Medicamento("114","color","dfsdf"),23));
        prescripciones.add(new Prescripcion("151",12,new Medicamento("114","cor","dfsdf"),23));
        prescripciones.add(new Prescripcion("151",12,new Medicamento("114","coltyyor","dfsdf"),23));
        prescripciones.add(new Prescripcion("151",12,new Medicamento("114","cosdor","dfsdf"),23));
        prescripciones.add(new Prescripcion("151",12,new Medicamento("114","cosssor","dfsdf"),23));
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
        firePropertyChange(PRESCRIPCIONES);

        firePropertyChange(PACIENTES);
        firePropertyChange(MEDICAMENTOS);
    }

    public Receta getCurrentReceta() {
        return currentReceta;
    }

    public void setCurrentReceta(Receta currentReceta) {
        this.currentReceta = currentReceta;
        firePropertyChange(CURRENT);
    }

    public List<Prescripcion> getPrescripciones() {
        return prescripciones;
    }

    public void setPrescripciones(List<Prescripcion> prescripciones) {
        this.prescripciones = prescripciones;
        firePropertyChange(PRESCRIPCIONES);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
        firePropertyChange(PACIENTES);
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
        firePropertyChange(MEDICAMENTOS);
    }
}
