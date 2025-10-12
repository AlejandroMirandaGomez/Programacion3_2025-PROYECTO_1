package proyecto_1.logic;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlID;


public class Farmaceuta {


    private String id;
    private String nombre;

    public  Farmaceuta(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Farmaceuta(){
        this.id = "";
        this.nombre = "";
    }

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
}
