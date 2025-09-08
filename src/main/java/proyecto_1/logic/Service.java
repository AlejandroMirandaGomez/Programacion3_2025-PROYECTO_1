package proyecto_1.logic;

import proyecto_1.data.Data;

import proyecto_1.data.XmlPersister;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private static  Service Instance;

    public static Service getInstance(){
        if(Instance==null){
            Instance = new Service();
        }
        return Instance;
    }

    private Data data;


    private Service(){
        try{
            data= XmlPersister.instance().load();
        }
        catch(Exception e){
            data =  new Data();
        }
    }

    public void stop(){
        try {
            XmlPersister.instance().store(data);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Medicos

    public void create(Medico e) throws Exception {
        Medico result = data.getMedicos().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            data.getMedicos().add(e);
        } else {
            throw new Exception("Medico ya existe");
        }
    }

    public Medico read(Medico e) throws Exception {
        Medico result = data.getMedicos().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);

        if (result != null) {
            return result;
        } else {
            throw new Exception("Medico no existe");
        }
    }

    public Medico read(String e) throws Exception {
        Medico result = data.getMedicos().stream()
                .filter(i -> i.getId().equals(e))
                .findFirst()
                .orElse(null);

        if (result != null) {
            return result;
        } else {
            throw new Exception("Medico no existe");
        }
    }

    public List<Medico> findAll(){
        return data.getMedicos();
    }

    public List<Medico> filtrarMedicos(String tipo, String texto) {
        List<Medico> list = new ArrayList<>();

        switch (tipo) {
            case "Id":
                list = data.getMedicos().stream()
                        .filter(m -> m.getId().toLowerCase().contains(texto.toLowerCase()))
                        .collect(Collectors.toList());
                break;
            case "Nombre":
                list = data.getMedicos().stream()
                        .filter(m -> m.getNombre().toLowerCase().contains(texto.toLowerCase()))
                        .collect(Collectors.toList());
                break;


        }
        return list;
    }

    public void removeMedico(Medico e) throws Exception{
        Medico result = data.getMedicos().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);

        if (result != null) {
            data.getMedicos().remove(result);
        }else {
            throw new Exception("Medico no existe");
        }


    }
    //Farmaceutas

    public void create(Farmaceuta e) throws Exception {
        Farmaceuta result = data.getFarmaceutas().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            data.getFarmaceutas().add(e);
        } else {
            throw new Exception("Farmaceuta ya existe");
        }
    }

    public List<Farmaceuta> findAllFarmaceutas(){
        return data.getFarmaceutas();
    }

    public List<Farmaceuta> filtrarFarmaceutas(String tipo, String texto) {
        List<Farmaceuta> list = new ArrayList<>();

        switch (tipo) {
            case "Id":
                list = data.getFarmaceutas().stream()
                        .filter(m -> m.getId().toLowerCase().contains(texto.toLowerCase()))
                        .collect(Collectors.toList());
                break;
            case "Nombre":
                list = data.getFarmaceutas().stream()
                        .filter(m -> m.getNombre().toLowerCase().contains(texto.toLowerCase()))
                        .collect(Collectors.toList());
                break;


        }
        return list;
    }

    public void removeFarmaceuta(Farmaceuta e) throws Exception {
        Farmaceuta result = data.getFarmaceutas().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);

        if (result != null) {
            data.getFarmaceutas().remove(result);
        } else {
            throw new Exception("Farmaceuta no existe");
        }
    }

    //--Pacientes--

    public void create(Paciente e) throws Exception {
        Paciente result = data.getPacientes().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            data.getPacientes().add(e);
        } else {
            throw new Exception("Paciente ya existe");
        }
    }

    public List<Paciente> getListaPacientes() {
        return data.getPacientes();
    }

    public List<Paciente> filtrarPacientes(String tipo, String texto) {
        List<Paciente> result=new ArrayList<Paciente>();

        switch (tipo){
            case "Id":
                result = data.getPacientes().stream()
                        .filter(m -> m.getId().toLowerCase().contains(texto.toLowerCase()))
                        .collect(Collectors.toList());
                break;
            case "Nombre":
                result = data.getPacientes().stream()
                        .filter(m -> m.getNombre().toLowerCase().contains(texto.toLowerCase()))
                        .collect(Collectors.toList());
                break;
            case "Telefono":
                result = data.getPacientes().stream()
                        .filter(m -> m.getTelefono().toLowerCase().contains(texto.toLowerCase()))
                        .collect(Collectors.toList());
                break;
            case "Fecha de Nacimiento":
                result = data.getPacientes().stream()
                        .filter(m -> m.getFechaNacimiento().toString().contains(texto))
                        .collect(Collectors.toList());
                break;
        }

        return result;
    }

    public void removePaciente(Paciente e) throws Exception {
        Paciente result = data.getPacientes().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);

        if (result != null) {
            data.getPacientes().remove(result);
        } else {
            throw new Exception("Paciente no existe");
        }
    }

    //--Medicamento--

    public void create(Medicamento e) throws Exception {
        Medicamento result = data.getMedicamentos().stream()
                .filter(i -> i.getCodigo().equals(e.getCodigo()))
                .findFirst()
                .orElse(null);

        if (result == null) {
            data.getMedicamentos().add(e);
        } else {
            throw new Exception("Medicamento ya existe");
        }
    }

    public List<Medicamento> getListaMedicamentos() {
        return data.getMedicamentos();
    }
    public List<Medicamento> filtrarMedicamentos(String tipo, String texto) {
        List<Medicamento> result=new ArrayList<Medicamento>();

        switch (tipo){
            case "Codigo":
                result = data.getMedicamentos().stream()
                        .filter(m -> m.getCodigo().toLowerCase().contains(texto.toLowerCase()))
                        .collect(Collectors.toList());
                break;
            case "Nombre":
                result = data.getMedicamentos().stream()
                        .filter(m -> m.getNombre().toLowerCase().contains(texto.toLowerCase()))
                        .collect(Collectors.toList());
                break;
            case "Presentacion":
                result = data.getMedicamentos().stream()
                        .filter(m -> m.getPresentacion().toLowerCase().contains(texto.toLowerCase()))
                        .collect(Collectors.toList());
                break;
        }

        return result;
    }

    public void removeMedicamento(Medicamento e) throws Exception {
        Medicamento result = data.getMedicamentos().stream()
                .filter(i -> i.getCodigo().equals(e.getCodigo()))
                .findFirst()
                .orElse(null);

        if (result != null) {
            data.getMedicamentos().remove(result);
        } else {
            throw new Exception("Medicamento no existe");
        }
    }

    //--Recetas--

    public List<Receta> getListaRecetas() {
        return data.getRecetas();
    }
    public List<Receta> filtrarRecetas(String tipo, String texto) {
        List<Receta> result=new ArrayList<Receta>();

        switch (tipo){
            case "ID_PACIENTE":
                result = data.getRecetas().stream()
                        .filter(r -> r.getPaciente().getId().toLowerCase().contains(texto.toLowerCase()))
                        .collect(Collectors.toList());
                break;
            case "ESTADO":
                result = data.getRecetas().stream()
                        .filter(r -> r.getEstado().toLowerCase().contains(texto.toLowerCase()))
                        .collect(Collectors.toList());
                break;
        }

        return result;
    }

    public List<Receta> filtrarRecetas(String tipo, String texto1, String texto2){
        List<Receta> result = new ArrayList<Receta>();
        switch (tipo) {
            case "ID_PACIENTE_Y_ESTADO":
                result = data.getRecetas().stream()
                        .filter(r -> r.getPaciente().getId().toLowerCase().contains(texto1.toLowerCase()))
                        .collect(Collectors.toList()).stream().filter(r -> r.getEstado().toLowerCase().contains(texto2.toLowerCase()))
                        .collect(Collectors.toList());
                break;
        }

        return result;
    }
    public void create(Receta e) throws Exception {
        data.getRecetas().add(e);
    }

    public Medico getUsuario() throws Exception{
        String id = Sesion.getUsuario().getId();

        return Service.getInstance().read(id);
    }




    // Usuarios

    public Usuario read(Usuario e) throws Exception {
        Usuario result = data.getUsuarios().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);

        if (result != null) {
            return result;
        } else {
            throw new Exception("Usuario no existe");
        }
    }


    public void create(Usuario e) throws Exception {
        Usuario result = data.getUsuarios().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);

        if (result == null) {
            data.getUsuarios().add(e);
        } else {
            throw new Exception("Usuario ya existe");
        }
    }

    public List<Usuario> getListaUsuarios() {
        return data.getUsuarios();
    }






}
