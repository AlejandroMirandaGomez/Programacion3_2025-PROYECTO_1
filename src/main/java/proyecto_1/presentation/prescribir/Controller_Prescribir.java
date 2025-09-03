package proyecto_1.presentation.prescribir;

import proyecto_1.logic.*;
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
        //---Prueba: Pone los valores en las tablas---
        getPacientes();
        getMedicamentos();
    }
    //--Recetas--
    public void clear(){
        model.setCurrentReceta(new Receta());
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
    public void setPaciente(int row){
        Paciente paciente = model.getPacientes().get(row);
        model.marcarPaciente(paciente);
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

    //--Borrar prescripcion--
    public void borrarPrescripcion(int row){
        model.borrarPrescripcion(row);
    }

    //--Guardar prescripcion--
    public void crearPrescripcion(Prescripcion prescripcion){
        model.agregarPrescripcion(prescripcion);
    }

    public void seleccionarMedicamentoParaPrescripcion(int row) {
        Medicamento m = model.getMedicamentos().get(row);
        Prescripcion p = new Prescripcion();
        p.setMedicamento(m);
        model.setCurrentDetalle(p);
        view.abrirGuardarMedicamento();
    }

    public void seleccionarPrescripcionDetalle(int row) {
        Prescripcion p= model.getPrescripciones().get(row);

        model.setCurrentDetalle(p);
        view.abrirDetalle(row);
    }

    //--Detalle--
    public void actualizarPrescripcion(int row,Prescripcion prescripcion){
        model.actualizarPrescripcion(row,prescripcion);
    }

}
