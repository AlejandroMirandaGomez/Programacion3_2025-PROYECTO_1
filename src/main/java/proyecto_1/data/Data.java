package proyecto_1.data;

import proyecto_1.logic.Medicamento;
import proyecto_1.logic.Medico;
import proyecto_1.logic.Paciente;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<Medicamento> medicamentos;

    public Data(){
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();
        medicamentos = new ArrayList<>();


        pacientes.add(new Paciente("dfs","fsdf","fgdfg"));

        medicos.add(new Medico("111", "Nando", "Dermatologo", "1234"));
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }
}
