package proyecto_1.logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Receta {
    // --- Atributos ---
    private String id;
    private LocalDate fechaDeRetiro;
    private Paciente paciente;
    private Medico medico;
    private List<Prescripcion> prescripciones;

    // --- Constructores ---
    public Receta() {
        this.prescripciones = new ArrayList<>();
    }

    public Receta(String id, LocalDate fechaDeRetiro, Paciente paciente, Medico medico, List<Prescripcion> prescripciones) {
        this.id = id;
        this.fechaDeRetiro = fechaDeRetiro;
        this.paciente = paciente;
        this.medico = medico;
        this.prescripciones = prescripciones != null ? prescripciones : new ArrayList<>();
    }

    // --- Getters y Setters ---
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaDeRetiro() {
        return fechaDeRetiro;
    }

    public void setFechaDeRetiro(LocalDate fechaDeRetiro) {
        this.fechaDeRetiro = fechaDeRetiro;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Prescripcion> getPrescripciones() {
        return prescripciones;
    }

    public void setPrescripciones(List<Prescripcion> prescripciones) {
        this.prescripciones = prescripciones;
    }

    // --- Métodos de utilidad ---
    public void agregarPrescripcion(Prescripcion p) {
        if (p != null) {
            this.prescripciones.add(p);
        }
    }

    public void eliminarPrescripcion(Prescripcion p) {
        this.prescripciones.remove(p);
    }
}