package proyecto_1.presentation.prescribir;

import proyecto_1.logic.Medicamento;
import proyecto_1.logic.Paciente;
import proyecto_1.logic.Service;
import proyecto_1.presentation.prescribir.Model_Prescribir;
import proyecto_1.presentation.prescribir.View_Prescribir;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller_Prescribir {
    Model_Prescribir model;
    View_Prescribir view;




    public Controller_Prescribir(View_Prescribir view, Model_Prescribir model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
        getPacientes();
    }

    //--Buscar Paciente--
    public void getPacientes() {
        List<Paciente> pacientes= Service.getInstance().getListaPacientes();
        model.setPacientes(pacientes);
    }
    public void filtrarPacientes(String tipo, String texto) {
        List<Paciente> result =Service.getInstance().filtrarPacientes(tipo, texto);
        model.setPacientes(result);
    }

    //--Buscar Medicamentos--
    public void getMedicamentos(){
        List<Medicamento> medicamentos= Service.getInstance().getListaMedicamentos();
        model.setMedicamentos(medicamentos);
    }
    public void filtrarMedicamentos(String tipo, String texto) {
        List<Medicamento> medicamentos= Service.getInstance().filtrarMedicamentos(tipo, texto);
        model.setMedicamentos(medicamentos);
    }
}
