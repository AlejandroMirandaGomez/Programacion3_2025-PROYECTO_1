package proyecto_1.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import proyecto_1.logic.adapters.LocalDateAdapter;

import java.time.LocalDate;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Paciente {
    // --- Atributos ---

    @XmlID
    private String id;
    private String nombre;
    private String telefono;

    @XmlElement(name = "fechaNacimiento")
    @jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate fechaNacimiento;

    // --- Constructores ---
    public Paciente(String id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;

    }
    public Paciente(){
        this.id = "";
        this.nombre = "";
        this.telefono = "";
        this.fechaNacimiento =  LocalDate.now();
    }

    public Paciente(String id, String nombre, String telefono, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    // --- Getters y Setters ---
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // mismo objeto
        if (o == null || getClass() != o.getClass()) return false; // distinto tipo
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id); // compara id
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
