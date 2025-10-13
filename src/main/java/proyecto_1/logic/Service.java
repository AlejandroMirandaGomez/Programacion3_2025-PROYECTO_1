package proyecto_1.logic;

import proyecto_1.data.*;

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
    private PacienteDao pacienteDao;
    private MedicamentoDao medicamentoDao;
    private MedicoDao medicoDao;
    private UsuarioDao usuarioDao;
    private FarmaceutaDao farmaceutaDao;

    private Service(){

        data =  new Data();
        pacienteDao = new PacienteDao();
        medicamentoDao = new MedicamentoDao();
        medicoDao = new MedicoDao();
        usuarioDao = new UsuarioDao();
        farmaceutaDao = new FarmaceutaDao();
    }

    public void stop(){
        try {
            Database.instance().close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Medicos

    public void create(Medico e) throws Exception {
//        Medico result = data.getMedicos().stream()
//                .filter(i -> i.getId().equals(e.getId()))
//                .findFirst()
//                .orElse(null);
//        if (result == null) {
//            data.getMedicos().add(e);
//        } else {
//            throw new Exception("Medico ya existe");
//        }
        medicoDao.create(e);
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
        //return data.getMedicos();
        return medicoDao.findAll();
    }

    public List<Medico> filtrarMedicos(String tipo, String texto) {
        List<Medico> list = new ArrayList<>();

        switch (tipo) {
            case "Id":
//                list = data.getMedicos().stream()
//                        .filter(m -> m.getId().toLowerCase().contains(texto.toLowerCase()))
//                        .collect(Collectors.toList());
                list = medicoDao.searchById(texto);
                break;
            case "Nombre":
//                list = data.getMedicos().stream()
//                        .filter(m -> m.getNombre().toLowerCase().contains(texto.toLowerCase()))
//                        .collect(Collectors.toList());
                list = medicoDao.searchByName(texto);
                break;


        }
        return list;
    }

    public void removeMedico(Medico e) throws Exception{
//        Medico result = data.getMedicos().stream()
//                .filter(i -> i.getId().equals(e.getId()))
//                .findFirst()
//                .orElse(null);
//
//        if (result != null) {
//            data.getMedicos().remove(result);
//        }else {
//            throw new Exception("Medico no existe");
//        }

        medicoDao.remove(e);


    }

    public void update(Medico e)throws Exception{
        medicoDao.update(e);
    }
    //Farmaceutas

    public void create(Farmaceuta e) throws Exception {
        farmaceutaDao.create(e);
        /*
        Farmaceuta result = data.getFarmaceutas().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            data.getFarmaceutas().add(e);
        } else {
            throw new Exception("Farmaceuta ya existe");
        }

         */
    }

    public List<Farmaceuta> findAllFarmaceutas(){
        return farmaceutaDao.findAll();
    }

    public List<Farmaceuta> filtrarFarmaceutas(String tipo, String texto) {
        List<Farmaceuta> list = new ArrayList<>();

        switch (tipo) {
            case "Id":
                list = farmaceutaDao.searchById(texto);
                break;
            case "Nombre":
                list = farmaceutaDao.searchByName(texto);
                break;


        }
        return list;
    }

    public void update(Farmaceuta e) throws Exception {
        farmaceutaDao.update(e);
    }

    public void removeFarmaceuta(Farmaceuta e) throws Exception {
        farmaceutaDao.delete(e);
        /*Farmaceuta result = data.getFarmaceutas().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);

        if (result != null) {
            data.getFarmaceutas().remove(result);
        } else {
            throw new Exception("Farmaceuta no existe");
        }

         */
    }

    //--Pacientes--

    public void create(Paciente e) throws Exception {
        pacienteDao.create(e);

    }

    public List<Paciente> getListaPacientes() {
        return pacienteDao.findAll();
    }

    public void update(Paciente e) throws Exception {
        pacienteDao.update(e);
    }

    public List<Paciente> filtrarPacientes(String tipo, String texto) {
        List<Paciente> result=new ArrayList<Paciente>();

        switch (tipo){
            case "Id":
                result = pacienteDao.searchById(texto);
                break;
            case "Nombre":
                result = pacienteDao.searchByName(texto);
                break;
            case "Telefono":
                result = pacienteDao.findByPhone(texto);
                break;
        }

        return result;
    }

    public void removePaciente(Paciente e) throws Exception {
        pacienteDao.delete(e);
    }

    //--Medicamento--

    public void create(Medicamento e) throws Exception {
        medicamentoDao.create(e);
        /*
        Medicamento result = data.getMedicamentos().stream()
                .filter(i -> i.getCodigo().equals(e.getCodigo()))
                .findFirst()
                .orElse(null);

        if (result == null) {
            data.getMedicamentos().add(e);
        } else {
            throw new Exception("Medicamento ya existe");
        }
        */

    }
    public void update(Medicamento e) throws Exception {
        medicamentoDao.update(e);
    }

    public List<Medicamento> getListaMedicamentos() {
        //return data.getMedicamentos();
        return medicamentoDao.findAll();
    }
    public List<Medicamento> filtrarMedicamentos(String tipo, String texto) {
        List<Medicamento> result=new ArrayList<Medicamento>();

        switch (tipo){
            case "Codigo":
                result = medicamentoDao.searchById(texto);
                break;
            case "Nombre":
                result = medicamentoDao.searchByName(texto);
                break;
            case "Presentacion":
                result = medicamentoDao.findByForm(texto);
                break;
        }

        return result;
    }

    public void removeMedicamento(Medicamento e) throws Exception {
        medicamentoDao.delete(e);
        /*
        Medicamento result = data.getMedicamentos().stream()
                .filter(i -> i.getCodigo().equals(e.getCodigo()))
                .findFirst()
                .orElse(null);

        if (result != null) {
            data.getMedicamentos().remove(result);
        } else {
            throw new Exception("Medicamento no existe");
        }

         */
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
//        Usuario result = data.getUsuarios().stream()
//                .filter(i -> i.getId().equals(e.getId()))
//                .findFirst()
//                .orElse(null);
//
//        if (result != null) {
//            return result;
//        } else {
//            throw new Exception("Usuario no existe");
//        }
        return usuarioDao.read(e.getId());


    }


    public void create(Usuario e) throws Exception {
//        Usuario result = data.getUsuarios().stream()
//                .filter(i -> i.getId().equals(e.getId()))
//                .findFirst()
//                .orElse(null);
//
//        if (result == null) {
//            data.getUsuarios().add(e);
//        } else {
//            throw new Exception("Usuario ya existe");
//        }
        usuarioDao.create(e);
    }

    public List<Usuario> getListaUsuarios() {
        return usuarioDao.findAll();
    }

    public void update(Usuario e) throws Exception {
        usuarioDao.update(e);
    }






}
