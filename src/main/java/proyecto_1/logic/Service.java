package proyecto_1.logic;

import proyecto_1.data.Data;

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
        data = new Data();
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
            if(result.getPassword().equals(e.getPassword())){
                return result;
            }
            throw new Exception("Contrasena incorrecta");
        } else {
            throw new Exception("Medico no existe");
        }
    }

    public List<Medico> findAll(){
        return data.getMedicos();
    }

    public List<Medico> filtrarMedicos(String texto){
        List<Medico> list = new ArrayList<>();

        list = data.getMedicos().stream()
                .filter(i -> i.getNombre().toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());

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

    //--Pacientes--
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

    //--Buscar Medicamento--

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
}
