package proyecto_1.presentation.medicamentos;

import proyecto_1.logic.Medicamento;
import proyecto_1.logic.Paciente;
import proyecto_1.logic.Service;
import proyecto_1.presentation.medicos.View_Medicos;
import proyecto_1.presentation.pacientes.Model_Pacientes;
import proyecto_1.presentation.pacientes.View_Pacientes;

import java.util.List;

public class Controller_Medicamentos {
    View_Medicamentos view;
    Model_Medicamentos model;

    public Controller_Medicamentos(View_Medicamentos view, Model_Medicamentos model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
        getMedicamentos();
    }

    public void create(Medicamento e) throws Exception{
        Service.getInstance().create(e);
        model.setCurrent(new Medicamento());
        model.setMedicamentos(Service.getInstance().getListaMedicamentos());
    }


    public void clear() {
        model.setCurrent(new Medicamento());
    }

    public void getMedicamentos(){
        List<Medicamento> list = Service.getInstance().getListaMedicamentos();
        model.setMedicamentos(list);
    }

    public void filtrarMedicamentos(String tipo, String texto){
        List<Medicamento> list = Service.getInstance().filtrarMedicamentos(tipo, texto);
        model.setMedicamentos(list);
    }

    public void remove(Medicamento e) throws Exception{
        Service.getInstance().removeMedicamento(e);
        model.setCurrent(new Medicamento());
        model.setMedicamentos(Service.getInstance().getListaMedicamentos());
    }

    public void edit(Medicamento e, Medicamento n) throws Exception{
        e.setNombre(n.getNombre());
        e.setPresentacion(n.getPresentacion());

    }

    public void selectCurrent(Medicamento n){
        model.setCurrent(n);
    }


}
