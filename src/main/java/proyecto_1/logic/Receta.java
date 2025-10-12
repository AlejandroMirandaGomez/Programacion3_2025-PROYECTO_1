package proyecto_1.logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class Receta {
    // --- Atributos ---


    private String id;


    private LocalDate fechaDeRetiro;


    private Paciente paciente;


    private Medico medico;


    private List<Prescripcion> prescripciones;
    private String estado;

    // --- Constructores ---
    public Receta() {
        this.id = UUID.randomUUID().toString();

        this.prescripciones = new ArrayList<>();
        this.estado = "Confeccionada";
    }

    public Receta(LocalDate fechaDeRetiro, Paciente paciente, Medico medico, List<Prescripcion> prescripciones) {
        this.id = UUID.randomUUID().toString();
        this.fechaDeRetiro = fechaDeRetiro;
        this.paciente = paciente;
        this.medico = medico;
        this.prescripciones = prescripciones != null ? prescripciones : new ArrayList<>();
        this.estado = "Confeccionada";
    }

    // --- Getters y Setters ---

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

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

    public Medico getMedico() { return medico; }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Prescripcion> getPrescripciones() {
        return prescripciones;
    }

    public void setPrescripciones(List<Prescripcion> prescripciones) {
        this.prescripciones = prescripciones;
    }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

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