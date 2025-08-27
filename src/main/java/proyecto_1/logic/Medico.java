package proyecto_1.logic;

public class Medico {
    private String id;
    private String nombre;
    private String especialidad;
    private String password;

    public  Medico(String id, String nombre, String especialidad, String password) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.password = password;
    }

    public Medico(){
        id = "";
        nombre = "";
        especialidad = "";
        password = "";
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
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
