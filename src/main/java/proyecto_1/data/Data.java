package proyecto_1.data;

import proyecto_1.logic.Medico;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Medico> medicos;

    public Data(){
        medicos = new ArrayList<>();
        medicos.add(new Medico("111", "Nando", "Dermatologo", "1234"));
    }

    public List<Medico> getMedicos() {
        return medicos;
    }
}
