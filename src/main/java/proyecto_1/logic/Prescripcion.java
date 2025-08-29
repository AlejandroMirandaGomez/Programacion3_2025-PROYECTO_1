package proyecto_1.logic;

public class Prescripcion {
    // --- Atributos ---
    private String indicaciones;
    private int duracion; // en días
    private Medicamento medicamento;

    // --- Constructores ---
    public Prescripcion() {
    }

    public Prescripcion(String indicaciones, int duracion, Medicamento medicamento) {
        this.indicaciones = indicaciones;
        this.duracion = duracion;
        this.medicamento = medicamento;
    }

    // --- Getters y Setters ---
    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
}
