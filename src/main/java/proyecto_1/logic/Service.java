package proyecto_1.logic;

import proyecto_1.data.Data;

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



}
