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

    //--Detalle Medicamento--
    Prescripcion currentDetalle;


    public static final String CURRENT = "currentReceta";
    public static final String PRESCRIPCIONES = "prescripciones";
    public static final String PACIENTES = "pacientes";
    public static final String MEDICAMENTOS = "medicamentos";
    public static final String CURRENTDETALLE = "currentDetalle";

    public Model_Prescribir() {
        currentReceta = new Receta();
        prescripciones = new ArrayList<Prescripcion>();

        pacientes= new ArrayList<Paciente>();
        medicamentos=new ArrayList<Medicamento>();

        currentDetalle=new Prescripcion();


        /*
        prescripciones.add(new Prescripcion("Tomar una al dia",14,new Medicamento("111","Acetaminofen","Pastilla"),500));
        prescripciones.add(new Prescripcion("Tomar una en mañana",6,new Medicamento("112","Panadol","Pastilla"),450));
        prescripciones.add(new Prescripcion("Tomar una en noche",8,new Medicamento("113","Paracetamol","Pastilla"),350));
        prescripciones.add(new Prescripcion("Tomar dos al dia",1,new Medicamento("114","Ibrupofeno","Pastilla"),230));
        prescripciones.add(new Prescripcion("Tomar cada dos dias",7,new Medicamento("115","Crema de rosas","Crema"),25));*/
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
        firePropertyChange(PRESCRIPCIONES);

        firePropertyChange(PACIENTES);
        firePropertyChange(MEDICAMENTOS);

        firePropertyChange(CURRENTDETALLE);
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
        currentReceta.setPrescripciones(prescripciones);

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

    public Prescripcion getCurrentDetalle() {
        return currentDetalle;
    }

    public void setCurrentDetalle(Prescripcion currentDetalle) {
        this.currentDetalle = currentDetalle;
        firePropertyChange(CURRENTDETALLE);
    }

    public void borrarPrescripcion(int row){
        prescripciones.remove(row);
        currentReceta.setPrescripciones(prescripciones);
        firePropertyChange(PRESCRIPCIONES);
    }

    public void agregarPrescripcion(Prescripcion prescripcion){
        prescripciones.add(prescripcion);
        currentReceta.setPrescripciones(prescripciones);
        firePropertyChange(PRESCRIPCIONES);
    }
    public void actualizarPrescripcion(int row,Prescripcion prescripcion){
        prescripciones.set(row,prescripcion);
        currentReceta.setPrescripciones(prescripciones);
        firePropertyChange(PRESCRIPCIONES);
    }

    public void marcarPaciente(Paciente paciente){
        currentReceta.setPaciente(paciente);
        firePropertyChange(CURRENT);
    }
}
